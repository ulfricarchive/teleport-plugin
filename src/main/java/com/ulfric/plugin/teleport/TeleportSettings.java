package com.ulfric.plugin.teleport;

import com.ulfric.commons.value.Bean;

public class TeleportSettings extends Bean { // TODO add default config

	private Long tickDelay;
	private Boolean allowMovement;

	public Long getTickDelay() {
		return tickDelay;
	}

	public void setTickDelay(Long tickDelay) {
		this.tickDelay = tickDelay;
	}

	public Boolean getAllowMovement() {
		return allowMovement;
	}

	public void setAllowMovement(Boolean allowMovement) {
		this.allowMovement = allowMovement;
	}

}