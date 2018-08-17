package amplificationBackpack.Events;

import amplificationBackpack.file.BackpackManager;
import amplificationBackpack.file.YMLManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class InventoryClose implements Listener {

    private YMLManager yml = YMLManager.getInstance();

    @EventHandler
    public void onInventoryInteract(InventoryCloseEvent e) {
        if (!e.getInventory().getName().equals("擴增背包")) return;

        Player p = (Player) e.getPlayer();

        Inventory inv = e.getInventory();

        BackpackManager.setBackpack(p,inv);
    }
}
