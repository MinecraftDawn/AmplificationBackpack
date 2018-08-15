package amplificationBackpack;

import amplificationBackpack.Events.InventoryCloseEvent;
import amplificationBackpack.commands.CmdAmplificationBackpack;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class AmplificationBackpack extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginCommand("bp").setExecutor((CommandExecutor) new CmdAmplificationBackpack());
        Bukkit.getPluginManager().registerEvents(new InventoryCloseEvent(),this);
    }
}
