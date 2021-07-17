package death;

import events.PlayerDeath;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DeathInventoryInteract {

    public static void TownyRespawn(Player p, int rawslot) {
        if(rawslot == 21) {
            p.openInventory(DeathInventory.TownyRespawn(p));
        }
    }

    public static void WildernessRespawn(Player p, int rawslot) {
        if(rawslot == 22) {
            p.openInventory(DeathInventory.WildernessRespawn(p));
        }
    }

    public static void GetItemsBack(Player p, int rawslot) {
        if(rawslot == 23) {
            if(PlayerDeath.getItems().containsKey(p)){
                p.getInventory().clear();
                for(ItemStack stack : PlayerDeath.getItems().get(p.getPlayer())){
                    if(stack != null){
                        p.getInventory().addItem(stack);
                        p.sendMessage(ChatColor.BLACK + "" + ChatColor.BOLD + "[DEATH]" + ChatColor.GRAY + " » " + "You got what your wished for..");
                    }
                }

                PlayerDeath.getItems().remove(p);
            }
        }
    }
}
