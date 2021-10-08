package me.desertfox.gl.hologram;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

public class HologramLine {

    private int index;
    private ArmorStand armorStand;
    private String line;

    public HologramLine(Location location, int index, String line) {
        this.index = index;
        this.line = line;
        this.armorStand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setCollidable(false);
        armorStand.setCustomName(line);
        armorStand.setCustomNameVisible(true);
        armorStand.setMarker(true);
    }

    public void remove(){
        armorStand.remove();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArmorStand getArmorStand() {
        return armorStand;
    }

    public void setArmorStand(ArmorStand armorStand) {
        this.armorStand = armorStand;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
        armorStand.setCustomName(line);
    }
}
