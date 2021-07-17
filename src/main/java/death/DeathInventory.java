package death;

import itemgenerator.Generator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class DeathInventory implements Listener {

    public static Inventory DeathInv(Player p) {
        Inventory inv = Bukkit.createInventory(null ,54, "Death's Inventory");

        for(int i = 0; i < inv.getSize(); i++) {

            inv.setItem(i, Generator.getItem(Material.BLACK_STAINED_GLASS_PANE, 1, " "));

            if (i == 21) {
                for (i = 21; i < 23; i++) {
                    inv.clear(i);
                }
            }

            if (i == 30) {
                for (i = 30; i < 32; i++) {
                    inv.clear(i);
                }
            }

            inv.setItem(21, Generator.getItem(Material.LEGACY_BOOK, 1, ChatColor.YELLOW + "Towny Respawn Selector"));
            inv.setItem(22, Generator.getItem(Material.LEGACY_BOOK, 1, ChatColor.YELLOW + "Wilderness Respawn Selector"));
            inv.setItem(23, Generator.getItem(Material.LEGACY_BOOK, 1, ChatColor.YELLOW + "Get Items Back!"));

            inv.setItem(30, Generator.skullgenerator("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmM4ZWExZjUxZjI1M2ZmNTE0MmNhMTFhZTQ1MTkzYTRhZDhjM2FiNWU5YzZlZWM4YmE3YTRmY2I3YmFjNDAifX19", ChatColor.RED + "Coming Soon"));
            inv.setItem(31, Generator.skullgenerator("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmM4ZWExZjUxZjI1M2ZmNTE0MmNhMTFhZTQ1MTkzYTRhZDhjM2FiNWU5YzZlZWM4YmE3YTRmY2I3YmFjNDAifX19", ChatColor.RED + "Coming Soon"));
            inv.setItem(32, Generator.skullgenerator("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmM4ZWExZjUxZjI1M2ZmNTE0MmNhMTFhZTQ1MTkzYTRhZDhjM2FiNWU5YzZlZWM4YmE3YTRmY2I3YmFjNDAifX19", ChatColor.RED + "Coming Soon"));


        }
        return inv;
    }

    public static Inventory TownyRespawn(Player p) {
        Inventory inv = Bukkit.createInventory(null ,54, "Towny Respawn");

        for(int i = 0; i < inv.getSize(); i++) {

            inv.setItem(i, Generator.getItem(Material.BLACK_STAINED_GLASS_PANE, 1, " "));

            if (i == 10) {
                for (i = 10; i < 16; i++) {
                    inv.clear(i);
                }
            }

            if (i == 19) {
                for (i = 19; i < 25; i++) {
                    inv.clear(i);
                }
            }

            if (i == 28) {
                for (i = 28; i < 34; i++) {
                    inv.clear(i);
                }
            }

            if (i == 37) {
                for (i = 37; i < 43; i++) {
                    inv.clear(i);
                }
            }
        }
        return inv;
    }

    public static Inventory WildernessRespawn(Player p) {
        Inventory inv = Bukkit.createInventory(null ,54, "Wilderness Respawn");

        for(int i = 0; i < inv.getSize(); i++) {

            inv.setItem(i, Generator.getItem(Material.BLACK_STAINED_GLASS_PANE, 1, " "));

            if (i == 10) {
                for (i = 10; i < 16; i++) {
                    inv.clear(i);
                }
            }

            if (i == 19) {
                for (i = 19; i < 25; i++) {
                    inv.clear(i);
                }
            }

            if (i == 28) {
                for (i = 28; i < 34; i++) {
                    inv.clear(i);
                }
            }

            if (i == 37) {
                for (i = 37; i < 43; i++) {
                    inv.clear(i);
                }
            }
        }
        return inv;
    }

    @EventHandler
    public void onInventory(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        int rawslot = event.getRawSlot();


        if(event.getView().getTitle().equalsIgnoreCase("Death's Inventory")) {
            event.setCancelled(true);

            DeathInventoryInteract.TownyRespawn(p, rawslot);
            DeathInventoryInteract.WildernessRespawn(p, rawslot);
            DeathInventoryInteract.GetItemsBack(p, rawslot);
        }

        if(event.getView().getTitle().equalsIgnoreCase("Towny Respawn")) {
            event.setCancelled(true);
        }

        if(event.getView().getTitle().equalsIgnoreCase("Wilderness Respawn")) {
            event.setCancelled(true);
        }
    }
}
