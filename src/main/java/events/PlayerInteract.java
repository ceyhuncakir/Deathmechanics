package events;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;
import itemgenerator.Generator;
import locationmanager.LocationManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onPlayerClick(PlayerInteractEvent event) throws NotRegisteredException {
        Player p = event.getPlayer();
        EquipmentSlot e = event.getHand();

        double x = event.getPlayer().getLocation().getX();
        double y = event.getPlayer().getLocation().getY() + 1;
        double z = event.getPlayer().getLocation().getZ();
        float yaw = event.getPlayer().getLocation().getYaw();

        if (p.getItemInHand().hasItemMeta()) {
                assert e != null;
                if (e.equals(EquipmentSlot.HAND)) {
                    if (event.getPlayer().getInventory().getItemInMainHand().equals(getDeathSetter())) {
                        if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
                            LocationManager.addLocation(".death", ".location", x, y, z, yaw, 0);
                            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[GRAVEYARD]" + ChatColor.GRAY + " » " + ChatColor.GREEN + "you set the death location on: " + ChatColor.GRAY + "x: " + ChatColor.YELLOW + x + ChatColor.GRAY + " y: " + ChatColor.YELLOW + y + ChatColor.GRAY + " z: " + ChatColor.YELLOW + z);
                        }
                    }

                    if (event.getPlayer().getInventory().getItemInMainHand().equals(getGraveyardSetter())) {
                        if (event.getAction() == Action.LEFT_CLICK_BLOCK) {

                            LocationManager.addWildernessLocation(p, x, y, z, yaw, 0);
                        }
                    }
                    if (event.getPlayer().getInventory().getItemInMainHand().equals(getGraveyardSetter())) {
                        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                            TownBlock block = TownyAPI.getInstance().getTownBlock(event.getClickedBlock().getLocation());

                            if (block == null) {
                                return;
                            }
                            Town town = block.getTown();
                            if (block.hasTown()) {
                                LocationManager.addTownLocation(town.getName(), "location.", x, y, z, yaw, 0);
                                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[GRAVEYARD]" + ChatColor.GRAY + " » " + ChatColor.GREEN + "you set the town location on: " + ChatColor.GRAY + "x: " + ChatColor.YELLOW + x + ChatColor.GRAY + " y: " + ChatColor.YELLOW + y + ChatColor.GRAY + " z: " + ChatColor.YELLOW + z);
                            }
                        }
                    }
                }
            }
       }


    public static ItemStack getGraveyardSetter() { return Generator.getItem(Material.WOODEN_AXE, 1, ChatColor.RED + "Graveyard region setter"); }
    public static ItemStack getDeathSetter() { return Generator.getItem(Material.DIAMOND_AXE, 1, ChatColor.RED + "Death setter"); }

}
