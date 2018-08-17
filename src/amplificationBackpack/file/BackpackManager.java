package amplificationBackpack.file;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BackpackManager {

    private static YMLManager yml = YMLManager.getInstance();

    private static YamlConfiguration data = yml.data;



    public static void setBackpack(Player p, Inventory inv) {
        ItemStack item;

        data.set(yml.str2DotStr(p.getUniqueId().toString(), "名稱"), "擴增背包");
        data.set(yml.str2DotStr(p.getUniqueId().toString(), "格數"), inv.getSize());

        for (int i = 0; i < inv.getSize(); i++) {
            item = inv.getItem(i);

            data.set(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i), "Item"), SwitchItemStr.Item2Str(item));
            data.set(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i), "Name"), "");
            data.set(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i), "耐久"), "");
        }

        yml.saveData();
    }

    public static Inventory getBackpack(Player p) {
        if(! data.isSet(p.getUniqueId().toString())){
            Inventory inv = Bukkit.createInventory(null,54,"擴增背包");

            return inv;
        }

        Inventory inv = Bukkit.createInventory(null,54,"擴增背包");

        int size = data.getInt(yml.str2DotStr(p.getUniqueId().toString(),"格數"));

        String str;

        for (int i = 0; i < size; i++) {
            str = data.getString(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i), "Item"));
            inv.setItem(i,SwitchItemStr.Str2Item(str));
        }

        return inv;
    }
}
