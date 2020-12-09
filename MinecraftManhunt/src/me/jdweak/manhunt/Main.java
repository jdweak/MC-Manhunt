package me.jdweak.manhunt;

import org.bukkit.plugin.java.JavaPlugin;

import me.jdweak.manhunt.commands.AddHunterCommand;
import me.jdweak.manhunt.commands.AddRunnerCommand;
import me.jdweak.manhunt.events.Events;


public class Main extends JavaPlugin{
	
	private static Main instance;
	
	public static Main getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(new Events(), this);
		getCommand("setHunter").setExecutor(new AddHunterCommand());
		getCommand("setRunner").setExecutor(new AddRunnerCommand());		
		System.out.println("plugin enabled with updates");
	}
	
	
}