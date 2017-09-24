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
