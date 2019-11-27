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

        for (int i = 9; i < 36; i++) {
            ItemStack itemStack = inv.getItem(i);
            if (itemStack == null) continue;

            inv.setItem(i, new ItemStack(Material.AIR, 1));
            inv.addItem(itemStack);
        }

//        Collections.sort(items, new Comparator<ItemStack>() {
//            @Override
//            public int compare(ItemStack o1, ItemStack o2) {
//                if (o1.getDurability() + 0.0001 * o1.getType().getId() < o2.getDurability() + 0.0001 * o2.getType().getId()) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            }
//        });


        return true;
    }
}

