package me.desertfox.gl;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.World;

public class BlockLocation {

    public static BlockLocation create(Location location){
        return new BlockLocation(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    @Getter private final int X;
    @Getter private final int Y;
    @Getter private final int Z;

    public BlockLocation(int x, int y, int z) {
        X = x;
        Y = y;
        Z = z;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj.getClass() != BlockLocation.class) return false;

        BlockLocation other = (BlockLocation) obj;
        return X == other.X && Y == other.Y && Z == other.Z;
    }

    public Location toLocation(World world){
        return new Location(world, X, Y, Z);
    }
}
