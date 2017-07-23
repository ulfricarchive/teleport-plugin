package com.ulfric.scotty.command;

import org.bukkit.entity.Player;

import com.ulfric.andrew.Alias;
import com.ulfric.andrew.Command;
import com.ulfric.andrew.Context;
import com.ulfric.andrew.Permission;
import com.ulfric.andrew.Sync;
import com.ulfric.andrew.argument.Argument;
import com.ulfric.commons.naming.Name;
import com.ulfric.servix.services.teleport.TeleportService;

import java.util.Collections;
import java.util.Map;

@Sync
@Name("teleport")
@Alias({"tp", "tele"})
@Permission("scotty.teleport")
public class TeleportCommand implements Command {

	@Argument
	protected Player target;

	@Override
	public void run(Context context) {
		Player player = (Player) context.getSender().handle();
		TeleportService service = TeleportService.get();
		if (service == null) {
			// TODO fail message
			return;
		}
		service.teleport(player, target.getLocation());
		context.getSender().sendMessage("scotty-teleport-to", details());
	}

	protected Map<String, String> details() {
		return Collections.singletonMap("target", target.getName());
	}

}
