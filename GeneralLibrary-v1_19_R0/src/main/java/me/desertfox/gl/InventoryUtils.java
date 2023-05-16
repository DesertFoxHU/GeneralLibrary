package me.desertfox.gl;

import manifold.ext.rt.api.This;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import GeneralLibrary.extensions.org.bukkit.Inventory.InventoryExtensions;

import java.util.Arrays;
import java.util.List;

/**
 * If you have Manifold you can also use<br>
 * {@link InventoryExtensions}
 */
public class InventoryUtils {

    /**
     * Fills an inventory's all corners with the specified item
     * @param inventory
     * @param fillerItem
     */
    public static void fillEdges(Inventory inventory, ItemStack fillerItem){
        int numberOfRows = inventory.getSize()/9;
        for(int i = 0; i < numberOfRows; i++){
            inventory.setItem(i * 9, fillerItem);
            inventory.setItem((i+1)*9-1, fillerItem);
        }

        for(int i = 0; i < 8; i++){
            inventory.setItem(i, fillerItem);
            inventory.setItem((numberOfRows-1)*9+i, fillerItem);
        }
    }

    /**
     * Fills an inventory's empty slots with the specified item
     * @param inventory
     * @param fillerItem
     */
    public static void fillEmptySlots(Inventory inventory, ItemStack fillerItem, int... except){
        List<Integer> exceptions = Arrays.stream(except).boxed().toList();
        for(int i = 0; i < inventory.getSize(); i++){
            if(exceptions.contains(i)) continue;
            if(inventory.getItem(i) == null) inventory.setItem(i, fillerItem);
        }
    }

}
