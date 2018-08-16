package amplificationBackpack.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryClose implements Listener {

    @EventHandler
    public void onInventoryInteract(InventoryCloseEvent e) {
        if (!e.getInventory().getName().equals("擴增背包")) return;

        Player p = (Player) e.getPlayer();


    }
}
