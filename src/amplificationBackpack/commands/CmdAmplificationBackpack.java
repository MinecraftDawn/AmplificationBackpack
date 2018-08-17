package amplificationBackpack.commands;

import amplificationBackpack.file.BackpackManager;
import amplificationBackpack.file.YMLManager;
import com.meowj.langutils.lang.LanguageHelper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CmdAmplificationBackpack implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if (args.length == 0) {
            p.openInventory(BackpackManager.getBackpack(p));
        } else if (args.length == 1) {
            ItemStack item = p.getItemInHand();
            p.sendMessage(LanguageHelper.getItemDisplayName(item, "zh_tw"));
        }
        return false;
    }
}
