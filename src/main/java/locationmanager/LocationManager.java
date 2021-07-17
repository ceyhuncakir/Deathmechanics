package locationmanager;

import configmanager.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class LocationManager {

    private static int wildernesscount = 0;

    public static void addLocation(String death, String location, double x, double y, double z, float yaw, float pitch) {
        ConfigHandler.getConfig().set("graveyard." + death + location + ".x", x);
        ConfigHandler.getConfig().set("graveyard." + death + location + ".y", y);
        ConfigHandler.getConfig().set("graveyard." + death + location + ".z", z);
        ConfigHandler.getConfig().set("graveyard." + death + location + ".yaw", yaw);
        ConfigHandler.getConfig().set("graveyard." + death + location + ".pitch", pitch);
        ConfigHandler.saveConfig();
        ConfigHandler.reload();
    }

    public static void addTownLocation(String town, String location, double x, double y, double z, float yaw, float pitch) {
        ConfigHandler.getConfig().set("graveyard." + "towns." + town + location + ".x", x);
        ConfigHandler.getConfig().set("graveyard." + "towns." + town + location + ".y", y);
        ConfigHandler.getConfig().set("graveyard." + "towns." + town + location + ".z", z);
        ConfigHandler.getConfig().set("graveyard." + "towns." + town + location + ".yaw", yaw);
        ConfigHandler.getConfig().set("graveyard." + "towns." + town + location + ".pitch", pitch);
        ConfigHandler.saveConfig();
        ConfigHandler.reload();
    }

    public static void addWildernessLocation(Player p, double x, double y, double z, float yaw, float pitch) {
        String wilderness = "Wilderness " + wildernesscount;

        ConfigHandler.getConfig().set("graveyard." + "wildernesses." + wilderness + ".x", x);
        ConfigHandler.getConfig().set("graveyard." + "wildernesses." + wilderness + ".y", y);
        ConfigHandler.getConfig().set("graveyard." + "wildernesses." + wilderness + ".z", z);
        ConfigHandler.getConfig().set("graveyard." + "wildernesses." + wilderness + ".yaw", yaw);
        ConfigHandler.getConfig().set("graveyard." + "wildernesses." + wilderness + ".pitch", pitch);
        ConfigHandler.saveConfig();
        ConfigHandler.reload();
        p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[GRAVEYARD]" + ChatColor.GRAY + " » " + ChatColor.GREEN + "you set the wilderness " + LocationManager.getWildernesscount() + " location on: " + ChatColor.GRAY + "x: " + ChatColor.YELLOW + x + ChatColor.GRAY + " y: " + ChatColor.YELLOW + y + ChatColor.GRAY + " z: " + ChatColor.YELLOW + z);
        wildernesscount++;
    }


    public static Location gravestone(Player p, String death, String world){
        double x = ConfigHandler.getConfig().getDouble("graveyard." + death + ".location" + ".x");
        double y = ConfigHandler.getConfig().getDouble("graveyard." + death + ".location"+ ".y");
        double z = ConfigHandler.getConfig().getDouble("graveyard." + death + ".location" + ".z");
        float yaw = (float) ConfigHandler.getConfig().getDouble("graveyard." + death + ".location"+ ".yaw");
        float pitch = (float) ConfigHandler.getConfig().getDouble("graveyard." + death + ".location" + ".pitch");

        Location loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);

        System.out.println(loc);
        return loc;
    }

    public static int getWildernesscount() {
        return wildernesscount;
    }
}
