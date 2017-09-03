package com.ulfric.scotty.command;

import org.bukkit.entity.Player;

import com.ulfric.andrew.Alias;
import com.ulfric.andrew.Command;
import com.ulfric.andrew.Context;
import com.ulfric.andrew.Permission;
import com.ulfric.andrew.Sync;
import com.ulfric.andrew.argument.Argument;
import com.ulfric.commons.naming.Name;
import com.ulfric.i18n.content.Details;
import com.ulfric.servix.services.locale.TellService;
import com.ulfric.servix.services.teleport.TeleportService;

@Sync
@Name("teleport")
@Alias({"tp", "tele"})
@Permission("teleport.to")
public class TeleportCommand implements Command {

	@Argument
	protected Player target;

	@Override
	public void run(Context context) {
		Player player = (Player) context.getSender();
		TeleportService.get().teleport(target, player.getLocation());
		TellService.sendMessage(player, "teleport-to", details());
	}

	protected Details details() {
		return Details.of("target", target);
	}

}
