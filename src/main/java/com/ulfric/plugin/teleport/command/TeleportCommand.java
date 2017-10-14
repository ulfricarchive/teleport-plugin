package com.ulfric.plugin.teleport.command;

import org.bukkit.entity.Player;

import com.ulfric.commons.naming.Name;
import com.ulfric.i18n.content.Details;
import com.ulfric.plugin.commands.Alias;
import com.ulfric.plugin.commands.Command;
import com.ulfric.plugin.commands.Context;
import com.ulfric.plugin.commands.Permission;
import com.ulfric.plugin.commands.argument.Argument;
import com.ulfric.plugin.locale.TellService;
import com.ulfric.plugin.teleport.TeleportService;

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
