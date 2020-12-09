package me.jdweak.manhunt.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.jdweak.manhunt.events.Events;

public class AddHunterCommand implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player)sender;
		Events.hunters.add(player);
		Bukkit.getServer().broadcastMessage(player.getName() + " is now a hunter");
		return false;
	}

}
