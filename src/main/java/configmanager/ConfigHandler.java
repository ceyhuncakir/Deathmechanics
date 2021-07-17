package configmanager;

import main.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigHandler {

    private static File file;
    private static FileConfiguration chestconfigFile;

    public static void setup(Main main) {
        file = new File(main.getDataFolder(), "graveyard.yml");

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        chestconfigFile = YamlConfiguration.loadConfiguration(file);
    }

    public static void saveConfig() {
        try{
            chestconfigFile.save(file);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static FileConfiguration getConfig() {
        return chestconfigFile;
    }

    public static void reload() {
        chestconfigFile = YamlConfiguration.loadConfiguration(file);
    }
}
