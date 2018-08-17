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

    public YamlConfiguration data;

    //建構子(Constructor)，設定Backpack.yml檔案
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

    //單例模式，只產生一個實例
    public static YMLManager getInstance() {
        if (instance == null) {
            synchronized (YMLManager.class){
                instance = new YMLManager();
            }

        }
        return instance;
    }

    //讀取Backpack.yml檔案內容
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

    //儲存Backpack.yml檔案內容
    public Boolean saveData() {
        try {
            data.save(file);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //將每個args之間插入"."，以符合yml索引方式
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
