package com.ulfric.plugin.teleport;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityTeleportEvent;

import java.time.Duration;

public class TeleportPendingEvent extends EntityTeleportEvent {

	private static final HandlerList HANDLERS = new HandlerList();

	public static HandlerList getHandlerList() {
		return HANDLERS;
	}

	private Duration delay;

	public TeleportPendingEvent(Entity what, Location to, Duration delay) {
		super(what, what.getLocation(), to);
	}

	public void setDelay(Duration delay) {
		this.delay = delay;
	}

	public Duration getDelay() {
		return delay;
	}

	@Override
	public HandlerList getHandlers() {
		return HANDLERS;
	}

}