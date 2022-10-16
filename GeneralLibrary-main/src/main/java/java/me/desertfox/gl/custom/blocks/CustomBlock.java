package java.me.desertfox.gl.custom.blocks;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.MultipleFacing;

public class CustomBlock {

    /**
     * Wrapper for available materials
     */
    public enum MaterialWrapper {
        BROWN_MUSHROOM_BLOCK(Material.BROWN_MUSHROOM_BLOCK),
        RED_MUSHROOM_BLOCK(Material.RED_MUSHROOM_BLOCK),
        MUSHROOM_STEM(Material.MUSHROOM_STEM);

        public final Material material;

        MaterialWrapper(Material material) {
            this.material = material;
        }
    }

    private final Enum<?> type;
    private final MaterialWrapper materialWrapper;
    private final MultipleFacing facing;

    public CustomBlock(Enum<?> type, MaterialWrapper materialWrapper, MultipleFacing facing) {
        this.type = type;
        this.materialWrapper = materialWrapper;
        this.facing = facing;
    }

    public void place(Location location){
        Block block = location.getBlock();
        block.setType(materialWrapper.material);
        block.setBlockData(facing);
    }

    public Enum<?> getType() {
        return type;
    }

    public MaterialWrapper getMaterialWrapper() {
        return materialWrapper;
    }

    public MultipleFacing getFacing() {
        return facing;
    }
}
