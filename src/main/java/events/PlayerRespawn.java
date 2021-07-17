package events;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import death.DeathEvents;
import locationmanager.LocationManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn implements Listener {

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player p = event.getPlayer();

        MultiverseCore core = (MultiverseCore) Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");
        MVWorldManager worldManager = core.getMVWorldManager();

        if(p.getWorld() == Bukkit.getWorld("nether") || p.getWorld() == Bukkit.getWorld("end") || p.getWorld() == worldManager.getMVWorlds()) {
            event.setRespawnLocation(LocationManager.gravestone(p, "death.", "world"));
        }

        event.setRespawnLocation(LocationManager.gravestone(p, "death.", "world"));
        p.sendTitle(ChatColor.RED + "" + ChatColor.BOLD + "You died", ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Welcome in Deaths Chamber", 40, 20, 20);
        PlayerBreak.getIndeathchamber().put(p, p.getUniqueId());
        DeathEvents.DeathMessages(p);
        DeathEvents.MakeGhost(p);
    }
}
