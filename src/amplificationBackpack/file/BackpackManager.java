package amplificationBackpack.file;

import com.meowj.langutils.lang.LanguageHelper;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BackpackManager {

    private static YMLManager yml = YMLManager.getInstance();

    private static YamlConfiguration data = yml.data;


    public static void setBackpack(Player p, Inventory inv) {
        ItemStack item;

        data.set(yml.str2DotStr(p.getUniqueId().toString(), "名稱"), "擴增背包");
        data.set(yml.str2DotStr(p.getUniqueId().toString(), "格數"), inv.getSize());

        for (int i = 0; i < inv.getSize(); i++) {
            item = inv.getItem(i);

            Map<Enchantment, Integer> ench = item.getEnchantments();
            List<String> enchName = new ArrayList<>();

            data.set(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i), "Item"), SwitchItemStr.Item2Str(item));

            if (item == null) {
                data.set(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i), "Name"), null);
                data.set(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i), "數量"), null);
                data.set(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i), "耐久"), null);
                data.set(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i), "附魔"), enchName);
                continue;
            }

            data.set(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i), "Name"), LanguageHelper.getItemDisplayName(item, "zh_tw"));
            data.set(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i), "數量"), item.getAmount());
            data.set(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i), "耐久"), item.getType().getMaxDurability());

            for (Map.Entry<Enchantment, Integer> e : ench.entrySet()) {
                enchName.add(LanguageHelper.getEnchantmentDisplayName(e, "zh_tw"));
            }
            data.set(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i), "附魔"), enchName);
        }

        yml.saveData();
    }

    public static Inventory getBackpack(Player p) {

        if (!data.isSet(p.getUniqueId().toString())) {
            Inventory inv = Bukkit.createInventory(null, 54, "擴增背包");

            return inv;
        }

        Inventory inv = Bukkit.createInventory(null, 54, "擴增背包");

        int size = data.getInt(yml.str2DotStr(p.getUniqueId().toString(), "格數"));

        String str;

        for (int i = 0; i < size; i++) {
            str = data.getString(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i), "Item"));
            inv.setItem(i, SwitchItemStr.Str2Item(str));
        }

        return inv;
    }

}
