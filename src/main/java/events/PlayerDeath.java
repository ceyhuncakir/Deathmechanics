package events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class PlayerDeath implements Listener {

    private static HashMap<Player , ItemStack[]> items = new HashMap<Player , ItemStack[]>();

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        ItemStack[] content = event.getEntity().getInventory().getContents();
        items.put(event.getEntity(), content);
        event.getEntity().getInventory().clear();
    }

    public static HashMap<Player, ItemStack[]> getItems() {
        return items;
    }
}
