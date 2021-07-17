package death;

import main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class DeathEvents implements Listener {

    private static HashMap<Player, UUID> ghostlist = new HashMap<>();


    @EventHandler
    public void onDeathInteract(PlayerInteractEntityEvent event){
        Player p = event.getPlayer();
        Entity entity = event.getRightClicked();

        if(entity.getCustomName() == null) { return; }

        if(event.getHand().equals(EquipmentSlot.HAND)) {
            if (((LivingEntity)entity).getCustomName().equalsIgnoreCase(ChatColor.BLACK + "" + ChatColor.BOLD + "DEATH")) {
                p.openInventory(DeathInventory.DeathInv(p));
            }
        }
    }

    public static void DeathMessages(Player p) {
        new BukkitRunnable() {
            int timer = 0;
            @Override
            public void run() {

                if(timer == 0) {
                    p.sendMessage(ChatColor.BLACK + "" + ChatColor.BOLD + "[DEATH]" + ChatColor.GRAY + " » " + "Ahh... " + p.getName() + " i was expecting you..");
                }

                if(timer == 3) {
                    p.sendMessage(ChatColor.BLACK + "" + ChatColor.BOLD + "[DEATH]" + ChatColor.GRAY + " » " + "If you wish to claim your items from me.. you need to pay a certain price for it..");
                    this.cancel();
                }



                timer++;
            }
        }.runTaskTimer(Main.getPlugin(), 0, 20L);
    }

    public static void MakeGhost(Player p) {
        if(!ghostlist.containsKey(p)) {
            for(Player deadpeople : Bukkit.getOnlinePlayers()) {
                deadpeople.hidePlayer(Main.getPlugin(), p);
            }
            ghostlist.put(p, p.getUniqueId());
        }
    }
}
