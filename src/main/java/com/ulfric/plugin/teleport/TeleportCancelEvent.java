package com.ulfric.plugin.teleport;

import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;

public class TeleportCancelEvent extends EntityEvent {

	private static final HandlerList HANDLERS = new HandlerList();

	public static HandlerList getHandlerList() {
		return HANDLERS;
	}

	public TeleportCancelEvent(Entity what) {
		super(what);
	}

	@Override
	public HandlerList getHandlers() {
		return HANDLERS;
	}

}