package amplificationBackpack;

import amplificationBackpack.commands.CmdSortBackpack;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
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
        Bukkit.getPluginCommand("sortBackpack").setExecutor((CommandExecutor) new CmdSortBackpack());
    }

    //若伺服器關閉時，玩家尚未關閉擴增背包，則強制將其關閉。
    @Override
    public void onDisable() {
    }


}
