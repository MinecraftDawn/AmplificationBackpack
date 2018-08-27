package amplificationBackpack.file;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 在物品及字串之中轉換
 */
public class SwitchItemStr {

    /**
     * 將物品轉換為字串
     * @param item Minecraft內的物品
     * @return 回傳出一個編碼且壓縮後的字串
     */
    //將物品轉換為字串形式
    public static String Item2Str(ItemStack item) {
        try {
            //建立ByteArray、GZIP、BukkitObject三個輸出檔案流，並將物品寫出
            ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteOutStream);
            BukkitObjectOutputStream outStream = new BukkitObjectOutputStream(gzipOutputStream);

            outStream.writeObject(item);

            byteOutStream.close();
            outStream.close();

            //將ByteArray以Base64編碼後轉換為CharArray型態
            char[] chars = Base64Coder.encode(byteOutStream.toByteArray());

            //將CharArray轉換為String型態
            String str = new String(chars);

            return str;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 將字串轉換為物品
     * @param str 由Item2Str方法得到的字串
     * @return 回傳一個物品物件
     */
    //將字串轉換為Item形式
    public static ItemStack Str2Item(String str) {
        try {
            //將String轉換為CharArray型態
            char[] chars = str.toCharArray();
            //將CharArray以Base64解碼後轉換為ByteArray型態
            byte[] bytes = Base64Coder.decode(chars);

            //建立ByteArray、GZIP、BukkitObject三個輸入檔案流，並將物品寫入
            ByteArrayInputStream byteInStream = new ByteArrayInputStream(bytes);
            GZIPInputStream gzipInputStream = new GZIPInputStream(byteInStream);
            BukkitObjectInputStream inStream = new BukkitObjectInputStream(gzipInputStream);

            //將檔案流以ItemStack方是讀入
            ItemStack item = (ItemStack) inStream.readObject();

            byteInStream.close();
            inStream.close();

            return item;

        } catch (IOException e) {
            e.printStackTrace();
            return new ItemStack(Material.AIR, 1);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new ItemStack(Material.AIR, 1);
        }
    }

}
