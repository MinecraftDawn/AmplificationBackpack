package amplificationBackpack.Events;

import amplificationBackpack.file.BackpackManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

/**
 * 背包關閉的事件
 */
public class InventoryClose implements Listener {

    @EventHandler
    public void onInventoryInteract(InventoryCloseEvent e) {
        if (!e.getInventory().getName().equals("擴增背包")) return;

        Player p = (Player) e.getPlayer();

        Inventory inv = e.getInventory();

        //當玩家關閉擴增背包時，將擴增背包資料儲存於檔案內
        BackpackManager.setBackpack(p, inv);
    }
}
