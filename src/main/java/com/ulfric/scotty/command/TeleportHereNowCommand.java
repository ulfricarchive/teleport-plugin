package com.ulfric.scotty.command;

import org.bukkit.entity.Player;

import com.ulfric.andrew.Alias;
import com.ulfric.andrew.Context;
import com.ulfric.andrew.Permission;
import com.ulfric.andrew.Sync;
import com.ulfric.commons.naming.Name;
import com.ulfric.servix.services.teleport.TeleportService;

@Sync
@Name("now")
@Alias("force")
@Permission("scotty.teleport.here.now")
public class TeleportHereNowCommand extends TeleportHereCommand {

	@Override
	public void run(Context context) {
		Player player = (Player) context.getSender().handle();
		TeleportService service = TeleportService.get();
		if (service == null) {
			// TODO fail message
			return;
		}
		service.teleport(target, player.getLocation()).run();
		context.getSender().sendMessage("scotty-teleport-here-now", details()); // TODO add delay to details
	}

}
