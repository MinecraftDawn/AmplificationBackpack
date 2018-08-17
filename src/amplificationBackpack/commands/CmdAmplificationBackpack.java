package amplificationBackpack.commands;

import amplificationBackpack.file.BackpackManager;
import amplificationBackpack.file.YMLManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdAmplificationBackpack implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        YMLManager yml = YMLManager.getInstance();
        Player p = (Player) sender;

        if (args.length == 0) {
            p.openInventory(BackpackManager.getBackpack(p));
        }
        return false;
    }
}
