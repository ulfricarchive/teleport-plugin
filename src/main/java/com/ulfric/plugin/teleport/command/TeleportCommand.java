package com.ulfric.plugin.teleport.command;

import org.bukkit.entity.Player;

import com.ulfric.commons.naming.Name;
import com.ulfric.plugin.commands.Alias;
import com.ulfric.plugin.commands.Command;
import com.ulfric.plugin.commands.Permission;
import com.ulfric.plugin.commands.argument.Argument;
import com.ulfric.plugin.teleport.TeleportService;

@Name("teleport")
@Alias({"tp", "tele"})
@Permission("teleport.to")
public class TeleportCommand extends Command {

	@Argument
	protected Player target;

	@Override
	public void run() {
		TeleportService.get().teleport(player(), target.getLocation());
		tell("teleport-to");
	}

}
