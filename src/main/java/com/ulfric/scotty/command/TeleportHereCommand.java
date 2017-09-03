package com.ulfric.scotty.command;

import org.bukkit.entity.Player;

import com.ulfric.andrew.Alias;
import com.ulfric.andrew.Context;
import com.ulfric.andrew.Permission;
import com.ulfric.andrew.Sync;
import com.ulfric.commons.naming.Name;
import com.ulfric.servix.services.locale.TellService;
import com.ulfric.servix.services.teleport.TeleportService;

@Sync
@Name("here")
@Alias("h")
@Permission("teleport.here")
public class TeleportHereCommand extends TeleportCommand {

	@Override
	public void run(Context context) {
		Player player = (Player) context.getSender();
		TeleportService.get().teleport(target, player.getLocation());
		TellService.sendMessage(player, "teleport-here", details()); // TODO add delay to details
	}

}
