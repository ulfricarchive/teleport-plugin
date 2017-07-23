package com.ulfric.scotty;

import com.ulfric.dragoon.application.Container;
import com.ulfric.scotty.command.TeleportCommand;
import com.ulfric.scotty.command.TeleportHereCommand;
import com.ulfric.scotty.command.TeleportHereNowCommand;

public class ScottyContainer extends Container {

	public ScottyContainer() {
		install(Teleport.class);

		install(TeleportCommand.class);
		install(TeleportHereCommand.class);
		install(TeleportHereNowCommand.class);
	}

}