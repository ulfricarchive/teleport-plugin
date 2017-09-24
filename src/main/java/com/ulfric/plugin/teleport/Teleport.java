package com.ulfric.plugin.teleport;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import com.ulfric.dragoon.conf4j.Settings;
import com.ulfric.dragoon.extension.inject.Inject;
import com.ulfric.plugin.tasks.Scheduler;
import com.ulfric.plugin.tasks.Task;
import com.ulfric.plugin.tasks.time.Tick;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Teleport implements TeleportService { // TODO thread safety

	private final Map<UUID, Task> tasks = new HashMap<>();

	@Inject
	private Scheduler scheduler;

	@Settings
	private TeleportSettings settings;

	@Override
	public Class<TeleportService> getService() {
		return TeleportService.class;
	}

	@Override
	public Task teleport(Entity entity, Location location) {
		Long tickDelayPossiblyNull = settings.getTickDelay();
		long tickDelay = tickDelayPossiblyNull == null ? 0 : tickDelayPossiblyNull;

		Duration when = tickDelayPossiblyNull > 0 ? Duration.of(tickDelay, Tick.INSTANCE) : Duration.ZERO;

		return teleport(entity, location, when);
	}

	@Override
	public Task teleport(Entity entity, Location location, Duration when) {
		TeleportPendingEvent event = new TeleportPendingEvent(entity, location, when);
		Bukkit.getPluginManager().callEvent(event); // TODO helper for calling events?
		when = event.getDelay();

		if (when == null || when.equals(Duration.ZERO)) {
			return schedule(entity, scheduler.runOnMainThread(() -> entity.teleport(location))); // TODO cleanup
		}

		return schedule(entity, scheduler.runOnMainThreadLater(() -> entity.teleport(location), when));
	}

	private Task schedule(Entity entity, Task task) {
		task.onExit(() -> tasks.remove(entity.getUniqueId(), task));

		Task old = tasks.put(entity.getUniqueId(), task);
		if (old != null) {
			old.cancel();
		}

		return task;
	}

	@Override
	public Task getPending(Entity entity) {
		return tasks.get(entity.getUniqueId());
	}

}