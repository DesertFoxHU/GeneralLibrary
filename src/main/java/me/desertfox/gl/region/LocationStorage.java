package me.desertfox.gl.region;

import org.bukkit.Location;

public class LocationStorage {

    private Location loc1;
    private Location loc2;

    public Cuboid getAsCuboid(){
        return new Cuboid(loc1, loc2);
    }

    public Location getLoc1() {
        return loc1;
    }

    public void setLoc1(Location loc1) {
        this.loc1 = loc1;
    }

    public Location getLoc2() {
        return loc2;
    }

    public void setLoc2(Location loc2) {
        this.loc2 = loc2;
    }
}
