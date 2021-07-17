package commands;

import death.Death;
import itemgenerator.Generator;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Graveyard implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        Location ploc = p.getLocation();

        if(p != null) {
            if(command.getName().equalsIgnoreCase("graveyard")) {
                if(args[0].equalsIgnoreCase("setup")) {
                    p.getInventory().setItem(0, Generator.getItem(Material.WOODEN_AXE, 1, ChatColor.RED + "Graveyard region setter"));
                    p.getInventory().setItem(1, Generator.getItem(Material.DIAMOND_AXE, 1, ChatColor.RED + "Death setter"));
                }

                if(args[0].equalsIgnoreCase("set")) {
                    if(args[1].equalsIgnoreCase("death")) {
                        Death.spawnDeath(ploc);
                    }
                }
            }
        }
        return false;
    }
}
