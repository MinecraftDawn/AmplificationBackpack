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

/**
 * 處理背包檔案格式\
 */
public class BackpackManager {

    private static YMLManager yml = YMLManager.getInstance();

    private static YamlConfiguration data = yml.data;

    //設定Backpack.yml檔案內容，並儲存
    public static void setBackpack(Player p, Inventory inv) {
        ItemStack item;

        //設定背包大小
        data.set(yml.str2DotStr(p.getUniqueId().toString(), "名稱"), "擴增背包");
        data.set(yml.str2DotStr(p.getUniqueId().toString(), "格數"), inv.getSize());


        Map<Enchantment, Integer> ench;
        List<String> enchName;

        for (int i = 0; i < inv.getSize(); i++) {
            item = inv.getItem(i);

            //若取得附魔失敗，則表示該物品沒有附魔
            try {
                ench = item.getEnchantments();
            } catch (Exception e) {
                ench = null;
            }

            enchName = new ArrayList<>();

            //若該位置為空，清除檔案內容
            if (item == null) {
                data.set(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i)), null);

                continue;
            }

            //設定物品資料
            data.set(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i), "Item"), SwitchItemStr.Item2Str(item));
            data.set(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i), "Name"), LanguageHelper.getItemDisplayName(item, "zh_tw"));
            data.set(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i), "數量"), item.getAmount());
            data.set(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i), "耐久"), item.getType().getMaxDurability());

            //設定附魔資料
            for (Map.Entry<Enchantment, Integer> e : ench.entrySet()) {
                enchName.add(LanguageHelper.getEnchantmentDisplayName(e, "zh_tw"));
            }
            data.set(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i), "附魔"), enchName);

        }

        yml.saveData();
    }

    //取得背包物品
    public static Inventory getBackpack(Player p) {

        //若檔案內無該玩家物品，則創立空背包
        if (!data.isSet(p.getUniqueId().toString())) {
            Inventory inv = Bukkit.createInventory(null, 54, "擴增背包");

            return inv;
        }

        Inventory inv = Bukkit.createInventory(null, 54, "擴增背包");

        int size = data.getInt(yml.str2DotStr(p.getUniqueId().toString(), "格數"));

        String str;

        for (int i = 0; i < size; i++) {
            //若該資料不存在，則跳過
            if (!data.isSet(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i)))) {
                continue;
            }

            //將文字轉換成物品，並放入儲存欄位
            str = data.getString(yml.str2DotStr(p.getUniqueId().toString(), "物品", Integer.toString(i), "Item"));
            inv.setItem(i, SwitchItemStr.Str2Item(str));
        }

        return inv;
    }

}
