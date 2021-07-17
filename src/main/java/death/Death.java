package death;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public class Death {

    public static void spawnDeath(Location loc) {
        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.SKELETON, ChatColor.BLACK + "" + ChatColor.BOLD + "DEATH");
        npc.spawn(new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), 0));
    }

}
