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
@Name("now")
@Alias("force")
@Permission("teleport.here.now")
public class TeleportHereNowCommand extends TeleportHereCommand {

	@Override
	public void run(Context context) {
		Player player = (Player) context.getSender();
		TeleportService.get().teleport(target, player.getLocation()).run();
		TellService.sendMessage(player, "teleport-here-now", details()); // TODO add delay to details
	}

}
