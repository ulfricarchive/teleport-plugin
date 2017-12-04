package com.ulfric.plugin.teleport.command;

import com.ulfric.commons.naming.Name;
import com.ulfric.plugin.commands.Alias;
import com.ulfric.plugin.commands.permissions.Permission;
import com.ulfric.plugin.teleport.TeleportService;

@Name("now")
@Alias("force")
@Permission("teleport.here.now")
public class TeleportHereNowCommand extends TeleportHereCommand {

	@Override
	public void run() {
		TeleportService.get().teleport(target, player().getLocation()).run();
		tell("teleport-here-now");
	}

}
