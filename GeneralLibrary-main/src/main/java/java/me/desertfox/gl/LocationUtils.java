package java.me.desertfox.gl;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationUtils {

    /**
     * See {@link Formatter#formatDouble(double, int)}
     * @param location
     * @param length coordinates max length
     * @return
     */
    public static Location formatLocation(Location location, int length){
        return new Location(
                location.getWorld(),
                Formatter.formatDouble(location.getX(), length),
                Formatter.formatDouble(location.getY(), length),
                Formatter.formatDouble(location.getZ(), length)
                );
    }

    /**
     * <b>world x y z yaw pitch</b>
     * @param loc
     * @return
     */
    public static String toStringYawPitch(Location loc){
        return loc.getWorld().getName() + " " + loc.getX() + " " + loc.getY() + " " + loc.getZ() + " " + loc.getYaw() + " " + loc.getPitch();
    }

    /**
     * <b>world x y z</b>
     * @param loc
     * @return
     */
    public static String toString(Location loc){
        return loc.getWorld().getName() + " " + loc.getX() + " " + loc.getY() + " " + loc.getZ();
    }

    /**
     * <b>x y z</b>
     * @param loc
     * @return
     */
    public static String toStringNoWorld(Location loc){
        return loc.getX() + " " + loc.getY() + " " + loc.getZ();
    }

    public static Location fromStringDoubleYawPitch(String input){
        if(input == null || input.length() == 0) return null;

        String[] splitted = input.split(" ");

        double X = Double.parseDouble(splitted[1]);
        double Y = Double.parseDouble(splitted[2]);
        double Z = Double.parseDouble(splitted[3]);
        if(splitted.length > 4) {
            float yaw = Float.parseFloat(splitted[4]);
            float pitch = Float.parseFloat(splitted[5]);
            return new Location(Bukkit.getWorld(splitted[0]), X, Y, Z, yaw, pitch);
        }

        return new Location(Bukkit.getWorld(splitted[0]), X, Y, Z);
    }

    public static Location fromStringDoubleYawPitch(World world, String input){
        if(input == null || input.length() == 0) return null;

        String[] splitted = input.split(" ");

        double X = Double.parseDouble(splitted[0]);
        double Y = Double.parseDouble(splitted[1]);
        double Z = Double.parseDouble(splitted[2]);
        if(splitted.length > 3) {
            float yaw = Float.parseFloat(splitted[5]);
            float pitch = Float.parseFloat(splitted[4]);
            return new Location(world, X, Y, Z, yaw, pitch);
        }

        return new Location(world, X, Y, Z);
    }

    public static Location fromStringDouble(String input){
        if(input == null || input.length() == 0) return null;

        String[] splitted = input.split(" ");

        double X = Double.parseDouble(splitted[1]);
        double Y = Double.parseDouble(splitted[2]);
        double Z = Double.parseDouble(splitted[3]);

        return new Location(Bukkit.getWorld(splitted[0]), X, Y, Z);
    }

    public static Location fromStringDouble(World world, String input){
        if(input == null || input.length() == 0) return null;

        String[] splitted = input.split(" ");

        double X = Double.parseDouble(splitted[0]);
        double Y = Double.parseDouble(splitted[1]);
        double Z = Double.parseDouble(splitted[2]);

        return new Location(world, X, Y, Z);
    }

}
