package com.ulfric.plugin.teleport.command;

import com.ulfric.commons.naming.Name;
import com.ulfric.plugin.commands.Alias;
import com.ulfric.plugin.commands.permissions.Permission;
import com.ulfric.plugin.teleport.TeleportService;

@Name("here")
@Alias("h")
@Permission("teleport.here")
public class TeleportHereCommand extends TeleportCommand {

	@Override
	public void run() {
		TeleportService.get().teleport(target, player().getLocation());
		tell("teleport-here"); // TODO add delay to details
	}

}
