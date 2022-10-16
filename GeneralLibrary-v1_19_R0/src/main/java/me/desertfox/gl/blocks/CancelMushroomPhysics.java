package me.desertfox.gl.blocks;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;

public class CancelMushroomPhysics implements Listener {

    @EventHandler
    public void onMushroomUpdate(BlockPhysicsEvent e){
        if(isMushroom(e.getBlock())){
            e.setCancelled(true);
            e.getBlock().getState().update(true, false);
        }
    }

    public static boolean isMushroom(Block block){
        Material material = block.getType();
        if(material == Material.RED_MUSHROOM_BLOCK || material == Material.BROWN_MUSHROOM_BLOCK || material == Material.MUSHROOM_STEM) return true;
        else return false;
    }

}
