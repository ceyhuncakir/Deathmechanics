package events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.HashMap;
import java.util.UUID;

public class PlayerBreak implements Listener {

    private static HashMap<Player, UUID> indeathchamber = new HashMap<>();

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player p = event.getPlayer();

        if(p.getInventory().getItemInMainHand().equals(PlayerInteract.getGraveyardSetter())) {
            event.setCancelled(true);
        }

        if(p.getInventory().getItemInMainHand().equals(PlayerInteract.getDeathSetter())) {
            event.setCancelled(true);
        }

        if(indeathchamber.containsKey(p)) {
            event.setCancelled(true);
            p.sendMessage(ChatColor.BLACK + "" + ChatColor.BOLD + "[DEATH]" + ChatColor.GRAY + " » " + "stop touching my stuff..");
        }
    }

    public static HashMap<Player, UUID> getIndeathchamber() {
        return indeathchamber;
    }
}
