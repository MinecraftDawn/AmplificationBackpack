package amplificationBackpack.file;

import amplificationBackpack.AmplificationBackpack;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class YMLManager {

    private Plugin plugin;

    private static YMLManager instance;

    private File file;

    public YamlConfiguration data;

    //建構子(Constructor)
    private YMLManager() {
        plugin = AmplificationBackpack.plugin;

        file = new File(plugin.getDataFolder(), "Backpack.yml");

        if (!file.exists()) {
            plugin.saveResource("Backpack.yml", false);
        }

        data = new YamlConfiguration();

        loadData();
        saveData();

    }

    public static YMLManager getInstance() {
        if (instance == null) {
            instance = new YMLManager();
        }
        return instance;
    }

    public Boolean loadData() {
        try {
            data.load(file);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean saveData() {
        try {
            data.save(file);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String str2DotStr(String... args) {
        String str = "";

        if (args.length > 1) {
            for (int i = 0; i < args.length - 1; i++) {
                str += args[i] + ".";
            }
        }

        str += args[args.length - 1];

        return str;
    }

}
