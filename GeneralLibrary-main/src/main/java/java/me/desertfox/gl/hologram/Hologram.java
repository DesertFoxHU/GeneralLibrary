package java.me.desertfox.gl.hologram;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Hologram uses server-sided entities, which can cause huge lags<br>
 * This class not meant for large amount of holograms<br>
 */
public class Hologram {

    private List<HologramLine> lines = new ArrayList<>();

    private Location location;
    private double yStep = 0.3f;

    private Location currentY;

    public Hologram(Location location) {
        this.location = location;
        currentY = location.clone();
    }

    /**
     * @param location
     * @param yStep Y difference between the lines
     */
    public Hologram(Location location, double yStep) {
        this.location = location;
        this.yStep = yStep;
        currentY = location.clone();
    }

    public void remove(){
        for(HologramLine line : lines){
            line.remove();
        }
    }

    public void addLine(String line){
        int index = lines.size();
        currentY = currentY.add(0, -yStep, 0);
        lines.add(new HologramLine(currentY, index, line));
    }

    public void setLine(int index, String line){
        if(getLine(index) == null){
            currentY = location.clone().add(0, -(yStep * index), 0);
            lines.add(new HologramLine(currentY, index, line));
        }
        else {
            getLine(index).setLine(line);
        }
    }

    public void removeLine(int index){
        getLine(index).remove();
    }

    public HologramLine getLine(int index){
        try{
            return lines.get(index);
        }
        catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    public String getStringLine(int index){
        return getLine(index).getLine();
    }
}
