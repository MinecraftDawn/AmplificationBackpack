package amplificationBackpack.file;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

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

            return byteOutStream.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static ItemStack Str2Item(String str) {
        try {
            ByteArrayInputStream byteInStream = new ByteArrayInputStream(str.getBytes());
            BukkitObjectInputStream inStream = new BukkitObjectInputStream(byteInStream);

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
