package com.ulfric.scotty;

import com.ulfric.plugin.Plugin;
import com.ulfric.scotty.command.TeleportCommand;
import com.ulfric.scotty.command.TeleportHereCommand;
import com.ulfric.scotty.command.TeleportHereNowCommand;

public class Scotty extends Plugin {

	public Scotty() {
		install(Teleport.class);

		install(TeleportCommand.class);
		install(TeleportHereCommand.class);
		install(TeleportHereNowCommand.class);
	}

}