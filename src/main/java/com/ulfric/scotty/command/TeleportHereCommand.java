package com.ulfric.scotty.command;

import org.bukkit.entity.Player;

import com.ulfric.andrew.Alias;
import com.ulfric.andrew.Context;
import com.ulfric.andrew.Permission;
import com.ulfric.andrew.Sync;
import com.ulfric.commons.naming.Name;
import com.ulfric.servix.services.teleport.TeleportService;

@Sync
@Name("here")
@Alias("h")
@Permission("scotty.teleport.here")
public class TeleportHereCommand extends TeleportCommand {

	@Override
	public void run(Context context) {
		Player player = (Player) context.getSender().handle();
		TeleportService service = TeleportService.get();
		if (service == null) {
			// TODO fail message
			return;
		}
		service.teleport(target, player.getLocation());
		context.getSender().sendMessage("scotty-teleport-here", details()); // TODO add delay to details
	}

}
