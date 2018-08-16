package amplificationBackpack.commands;

import amplificationBackpack.file.SwitchItemStr;
import amplificationBackpack.file.YMLManager;
import io.netty.handler.codec.base64.Base64;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.nio.charset.StandardCharsets;

public class CmdAmplificationBackpack implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        YMLManager yml = YMLManager.getInstance();
        Player p = (Player) sender;

        if(args.length == 0) {
            yml.setBackpack(p,p.getItemInHand());

            String s = yml.data.getString(p.getUniqueId().toString()+".物品."+Integer.toString(0)+".Item");
            p.sendMessage(s);

            ItemStack item = SwitchItemStr.Str2Item(s);
//            byte[] bytes = SwitchItemStr.Item2Str(p.getItemInHand());
//            String s = new String(bytes);
//            p.sendMessage(s);
//
//            char[] chars = Base64Coder.encode(bytes);
//
//            s = new String(chars);
//            chars = s.toCharArray();
//
//
//            bytes = Base64Coder.decode(chars);
//            s = new String(bytes);
//            p.sendMessage(s);


            p.getInventory().addItem(item);




//            p.sendMessage(yml.data.getString(p.getUniqueId().toString()+".物品."+Integer.toString(0)+".Item"));
//            item = SwitchItemStr.byte2Item(yml.data.getString(p.getUniqueId().toString()+".物品."+Integer.toString(0)+".Item").getBytes(StandardCharsets.UTF_8));

        }
        return false;
    }
}
