package amplificationBackpack.Events;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class RegisterInListener implements Listener {
    public RegisterInListener(Plugin plugin){
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }
}
