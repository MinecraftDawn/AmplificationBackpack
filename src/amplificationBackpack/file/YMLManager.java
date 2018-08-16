package amplificationBackpack.file;

import amplificationBackpack.AmplificationBackpack;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class YMLManager {

    private Plugin plugin;

    private static YMLManager instance;

    private File file;

    private YamlConfiguration data;

    //建構子(Constructor)
    private YMLManager(){
        plugin = AmplificationBackpack.plugin;

        file = new File(plugin.getDataFolder(),"Backpack.yml");

        data = new YamlConfiguration();

        loadData();

    }

    public static YMLManager getInstance(){
        if(instance == null){
            instance = new YMLManager();
        }
        return instance;
    }

    private Boolean loadData(){
        try {
            data.load(file);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        return  false;
    }

    private Boolean saveData(){
        try {
            data.save(file);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
