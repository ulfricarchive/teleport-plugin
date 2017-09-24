package com.ulfric.plugin.teleport;

import com.ulfric.plugin.Plugin;
import com.ulfric.plugin.teleport.command.TeleportCommand;
import com.ulfric.plugin.teleport.command.TeleportHereCommand;
import com.ulfric.plugin.teleport.command.TeleportHereNowCommand;

public class TeleportPlugin extends Plugin {

	public TeleportPlugin() {
		install(Teleport.class);

		install(TeleportCommand.class);
		install(TeleportHereCommand.class);
		install(TeleportHereNowCommand.class);
	}

}