package amplificationBackpack.commands;

import amplificationBackpack.file.BackpackManager;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * 打開擴增背包
 */
public class CmdAmplificationBackpack implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;

        Player p = (Player) sender;

        if (args.length == 0) {
            p.openInventory(BackpackManager.getBackpack(p));
            return true;
        }else if(args.length == 1){
            ItemStack item1 = p.getItemInHand().clone();
            ItemStack item2 = new ItemStack(item1.getType(),1);
            item1.setAmount(1);

            if(item1.equals(item2)){
                p.sendMessage("符合唷");
            }else{
                p.sendMessage("不符合XXXXX");
                p.sendMessage(item1.getType().toString() + "" + item1.getAmount());
            }

            p.getInventory().addItem(new ItemStack(Material.getMaterial(item1.getType().toString())));

            p.sendMessage(Material.matchMaterial(item1.getType().toString())+"");


        }
        return true;
    }
}
