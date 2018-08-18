package amplificationBackpack.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CmdSortBackpack implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) return true;

        Player p = (Player) sender;

        ItemStack[] item = new ItemStack[36];

        Inventory inv = p.getInventory();

        for (int i = 9; i < 36; i++) {
            item[i] = inv.getItem(i);
            inv.setItem(i, new ItemStack(Material.AIR, 1));
        }

        for (int i = 9; i < 36; i++) {
            if (item[i] != null) {
                inv.addItem(item[i]);
            }
        }


        return true;
    }
}
