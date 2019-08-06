package amplificationBackpack;

import amplificationBackpack.Events.InventoryClose;
import amplificationBackpack.commands.CmdAmplificationBackpack;
import amplificationBackpack.commands.CmdSortBackpack;
import amplificationBackpack.file.BackpackManager;
import amplificationBackpack.file.YMLManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author MinecraftDawn
 * 主要的Class，負責註冊事件、設定指令、關閉伺服器時的動作
 */
public class AmplificationBackpack extends JavaPlugin {

    //將此插件主Class給其他Class使用
    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        Bukkit.getPluginCommand("amplificationbackpack").setExecutor((CommandExecutor) new CmdAmplificationBackpack());
        Bukkit.getPluginCommand("sortBackpack").setExecutor((CommandExecutor) new CmdSortBackpack());
        Bukkit.getPluginManager().registerEvents(new InventoryClose(), this);
    }

    //若伺服器關閉時，玩家尚未關閉擴增背包，則強制將其關閉。
    @Override
    public void onDisable() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getOpenInventory().getTitle().equals("擴增背包")) {

                YMLManager yml = YMLManager.getInstance();
                BackpackManager.setBackpack(p, p.getOpenInventory().getTopInventory());

                p.getOpenInventory().close();
            }
        }
    }


}
