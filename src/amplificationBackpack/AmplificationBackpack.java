package amplificationBackpack;

import amplificationBackpack.Events.InventoryCloseEvent;
import amplificationBackpack.commands.CmdAmplificationBackpack;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AmplificationBackpack extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginCommand("bp").setExecutor((CommandExecutor) new CmdAmplificationBackpack());
        Bukkit.getPluginManager().registerEvents(new InventoryCloseEvent(),this);
    }

    @Override
    public void onDisable() {
        for(Player p :Bukkit.getOnlinePlayers()){
            if(p.getOpenInventory().getTitle().equals("擴增背包")){
                p.getOpenInventory().close();
            }
        }
    }
}
