package com.ulfric.plugin.teleport.command;

import org.bukkit.entity.Player;

import com.ulfric.commons.naming.Name;
import com.ulfric.plugin.commands.Alias;
import com.ulfric.plugin.commands.Context;
import com.ulfric.plugin.commands.Permission;
import com.ulfric.plugin.commands.Sync;
import com.ulfric.plugin.locale.TellService;
import com.ulfric.plugin.teleport.TeleportService;

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
