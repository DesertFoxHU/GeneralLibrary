package me.desertfox.gl;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * If you have Manifold you can also use<br>
 * {@link GeneralLibrary.extensions.org.bukkit.inventory.Inventory.InventoryExtensions}
 */
public class InventoryUtils {

    /**
     * Fills an inventory's all corners with the specified item
     * @param inventory
     * @param fillerItem
     */
    public static void fillCorners(Inventory inventory, ItemStack fillerItem){
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
    public static void fillEmptySlots(Inventory inventory, ItemStack fillerItem){
        for(int i = 0; i < inventory.getSize(); i++){
            if(inventory.getItem(i) == null) inventory.setItem(i, fillerItem);
        }
    }

}
