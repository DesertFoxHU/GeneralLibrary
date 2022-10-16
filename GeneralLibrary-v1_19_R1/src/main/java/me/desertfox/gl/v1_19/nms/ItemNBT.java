package me.desertfox.gl.v1_19.nms;

import net.minecraft.nbt.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.craftbukkit.v1_19_R1.inventory.CraftItemStack;

/**
 * nmsCopy.v() -> getOrCreateTag();
 * CompoundTag -> NBTTagCompound
 * getTag() -> u()
 * contains() -> e()
 * getString() -> l()
 * setTag() -> c()
 * remove() -> r()
 * putString() -> a()
 */
public class ItemNBT {

    public static String getNBT(ItemStack thiz, String key) {
        NBTTagCompound tag = CraftItemStack.asNMSCopy(thiz).u();
        if (tag != null && tag.e(key)) {
            return tag.l(key);
        }
        return null;
    }

    public static boolean hasNBT(ItemStack thiz, String key) {
        if (thiz != null && thiz.getType() != Material.AIR) {
            final NBTTagCompound tag = CraftItemStack.asNMSCopy(thiz).u();
            return tag != null && tag.e(key);
        }
        return false;
    }

    public static ItemStack removeNBT(ItemStack thiz, String key){
        net.minecraft.world.item.ItemStack nmsCopy = CraftItemStack.asNMSCopy(thiz);
        NBTTagCompound tag = nmsCopy.u();
        if (tag == null) {
            nmsCopy.c(new NBTTagCompound());
            tag = nmsCopy.u();
        }
        if (tag.e(key)) {
            tag.r(key);
        }
        nmsCopy.c(tag);
        return CraftItemStack.asBukkitCopy(nmsCopy);
    }

    public static ItemStack addNBT(ItemStack thiz, String key, Object value){
        net.minecraft.world.item.ItemStack nmsCopy = CraftItemStack.asNMSCopy(thiz);
        NBTTagCompound tag = nmsCopy.v();
        if (tag == null) {
            nmsCopy.c(new NBTTagCompound());
            tag = nmsCopy.u();
        }
        if (!tag.e(key)) {
            tag.a(key, value.toString());
        }
        else {
            tag.a(key, getNBT(thiz, key) + "," + value.toString());
        }
        nmsCopy.c(tag);
        return CraftItemStack.asBukkitCopy(nmsCopy);
    }

    public static ItemStack setNBT(ItemStack thiz, String key, Object value){
        net.minecraft.world.item.ItemStack nmsCopy = CraftItemStack.asNMSCopy(thiz);
        if (nmsCopy == null) {
            return null;
        }
        NBTTagCompound tag = nmsCopy.u();
        if (tag == null) {
            nmsCopy.c(new NBTTagCompound());
            tag = nmsCopy.u();
        }
        tag.a(key, value.toString());
        nmsCopy.c(tag);
        return CraftItemStack.asBukkitCopy(nmsCopy);
    }

    public static ItemStack removeNBTValue(ItemStack thiz, String key, String value){
        net.minecraft.world.item.ItemStack nmsCopy = CraftItemStack.asNMSCopy(thiz);
        NBTTagCompound tag = nmsCopy.v();
        if (tag == null) {
            nmsCopy.c(new NBTTagCompound());
            tag = nmsCopy.u();
        }
        if (tag.e(key)) {
            final String nbt = getNBT(thiz, key);
            if (nbt.contains(value)) {
                String s3 = nbt;
                if (s3.contains(value + ",") && !s3.equalsIgnoreCase(value)) {
                    s3 = nbt.replace(value + ",", "");
                }
                else if (s3.equalsIgnoreCase(value)) {
                    s3 = "null";
                }
                else if (s3.contains("," + value) && !s3.contains("," + value + ",")) {
                    s3 = nbt.replace("," + value, "");
                }
                else if (s3.contains("," + value + ",")) {
                    s3 = s3.replace("," + value + ",", "");
                }
                if (s3.equalsIgnoreCase("null")) {
                    tag.r(key); //remove
                }
                else {
                    tag.a(key, s3);
                }
            }
        }
        nmsCopy.c(tag);
        return CraftItemStack.asBukkitCopy(nmsCopy);
    }

    public static List<String> getKeys(ItemStack thiz){
        List<String> keys = new ArrayList<>();
        NBTTagCompound tag = CraftItemStack.asNMSCopy(thiz).u();
        if (tag == null) {
            return keys;
        }
        keys = new ArrayList<>(tag.d()); //getAllKeys
        return keys;
    }

    //                    Enum variants

    public static String getNBT(ItemStack thiz, Enum<?> key) {
        return getNBT(thiz, key.toString());
    }

    public static boolean hasNBT(ItemStack thiz, Enum<?> key) {
        return hasNBT(thiz, key.toString());
    }

    public static ItemStack removeNBT(ItemStack thiz, Enum<?> key){
        return removeNBT(thiz, key.toString());
    }

    public static ItemStack addNBT(ItemStack thiz, Enum<?> key, Object value){
        return addNBT(thiz, key.toString(), value);
    }

    public static ItemStack setNBT(ItemStack thiz, Enum<?> key, Object value){
        return setNBT(thiz, key.toString(), value);
    }

    public static ItemStack removeNBTValue(ItemStack thiz, Enum<?> key, String value){
        return removeNBTValue(thiz, key.toString(), value);
    }

}
