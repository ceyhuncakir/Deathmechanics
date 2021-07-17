package main;

import commands.Graveyard;
import configmanager.ConfigHandler;
import death.DeathEvents;
import death.DeathInventory;
import events.PlayerBreak;
import events.PlayerDeath;
import events.PlayerInteract;
import events.PlayerRespawn;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
        getServer().getPluginManager().registerEvents(new PlayerBreak(), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawn(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new DeathEvents(), this);
        getServer().getPluginManager().registerEvents(new DeathInventory(), this);

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Graveyard 1.0.0 has been enabled");
        getCommand("graveyard").setExecutor(new Graveyard());

        ConfigHandler.setup(Main.getPlugin());
        ConfigHandler.saveConfig();
    }

    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Graveyard 1.0.0 has been enabled");
    }

    public static Main getPlugin() {
        return Main.getPlugin(Main.class);
    }
}
