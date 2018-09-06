package amplificationBackpack.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 整理包包
 */
public class CmdSortBackpack implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) return true;

        Player p = (Player) sender;

        Inventory inv = p.getInventory();

        List<ItemStack> items = new ArrayList<>();

        for (int i = 9; i < 36; i++) {
            if (inv.getItem(i) != null) {
                items.add(inv.getItem(i));
                Bukkit.broadcastMessage(inv.getItem(i).getDurability() + "");
            }
            inv.setItem(i, new ItemStack(Material.AIR, 1));
        }

        Collections.sort(items, new Comparator<ItemStack>() {
            @Override
            public int compare(ItemStack o1, ItemStack o2) {
                if (o1.getDurability() + 0.0001 * o1.getTypeId() < o2.getDurability() + 0.0001 * o2.getTypeId()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for (ItemStack item : items) {
            inv.addItem(item);
        }

        return true;
    }
}

