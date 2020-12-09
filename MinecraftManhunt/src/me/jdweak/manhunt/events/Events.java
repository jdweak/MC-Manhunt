package me.jdweak.manhunt.events;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Events implements Listener{
	
	public static ArrayList<Player> hunters = new ArrayList<Player>();
	public static ArrayList<Player> runners = new ArrayList<Player>();
	
	@EventHandler
	public void playerClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		ItemStack item = event.getPlayer().getInventory().getItemInHand();
		Action action = event.getAction();
		if(item.getType() == Material.COMPASS) {
			if(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)){
				player.setCompassTarget(runners.get(0).getLocation());
				player.sendMessage("now tracking " + runners.get(0).getName());
			} else if(action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK)) {
				player.setCompassTarget(runners.get(1).getLocation());
				player.sendMessage("now tracking " + runners.get(1).getName());
			}
		}
	}
	
	@EventHandler
	public void playerRespawnEvent(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		
		if(hunters.contains(player)) {
			ItemStack compass = new ItemStack(Material.COMPASS);
			player.getInventory().addItem(compass);
		}		
	}
	
	@EventHandler
	public void playerDeathEvent(PlayerDeathEvent event) {
		Player player = event.getEntity();
		Inventory inventory = player.getInventory();
		if(inventory.contains(Material.COMPASS)) {
			inventory.remove(Material.COMPASS);
		}
	}

}
