package amplificationBackpack;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class AmplificationBackpack extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginCommand("bp").setExecutor((CommandExecutor) new AmplificationBackpack());
    }
}
