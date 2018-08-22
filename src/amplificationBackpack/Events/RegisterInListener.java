package amplificationBackpack.Events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

public class RegisterInListener implements Listener {
    public RegisterInListener(Plugin plugin){
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        Bukkit.broadcastMessage("註冊成功！");
    }
}
