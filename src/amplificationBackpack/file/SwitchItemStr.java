package amplificationBackpack.file;

import io.netty.handler.codec.base64.Base64;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SwitchItemStr {
    public static String Item2Str(ItemStack item) {
        try {
            ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
            BukkitObjectOutputStream outStream = new BukkitObjectOutputStream(byteOutStream);

            outStream.writeObject(item);

            byteOutStream.close();
            outStream.close();

            char[] chars = Base64Coder.encode(byteOutStream.toByteArray());

            String str = new String(chars);

            return str;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ItemStack Str2Item(String str) {
        try {
            char[] chars = str.toCharArray();
            byte[] bytes = Base64Coder.decode(chars);

            ByteArrayInputStream byteInStream = new ByteArrayInputStream(bytes);
            BukkitObjectInputStream inStream = new BukkitObjectInputStream(byteInStream);

            ItemStack item = (ItemStack) inStream.readObject();

            byteInStream.close();
            inStream.close();

            return item;

        } catch (IOException e) {
            e.printStackTrace();
            return new ItemStack(Material.STAINED_CLAY, 1);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new ItemStack(Material.STONE, 1);
        }
    }

    public static byte[] Item2Byte2(ItemStack item) {
        try {
            ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
            BukkitObjectOutputStream outStream = new BukkitObjectOutputStream(byteOutStream);

            outStream.writeObject(item);

            byteOutStream.close();
            outStream.close();

            return byteOutStream.toByteArray();
//            return byteOutStream.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ItemStack byte2Item2(byte[] bytes) {
        try {
            ByteArrayInputStream byteInStream = new ByteArrayInputStream(bytes);
            BukkitObjectInputStream inStream = new BukkitObjectInputStream(byteInStream);

            ItemStack item = (ItemStack) inStream.readObject();

            byteInStream.close();
            inStream.close();

            return item;

        } catch (IOException e) {
            e.printStackTrace();
            return new ItemStack(Material.STAINED_CLAY, 1);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new ItemStack(Material.STONE, 1);
        }
    }

    public static void test(Player p){

    }

}
