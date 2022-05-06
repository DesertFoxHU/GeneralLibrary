package GeneralLibrary.extensions.org.bukkit.Location;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import me.desertfox.gl.Formatter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

@Extension
public class LocationExtensions {

  /**
   * See {@link Formatter#formatDouble(double, int)}
   * @param location
   * @param length coordinates max length
   * @return
   */
  public static Location formatLocation(@This Location location, int length){
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
  public static String toStringYawPitch(@This Location loc){
    return loc.getWorld().getName() + " " + loc.getX() + " " + loc.getY() + " " + loc.getZ() + " " + loc.getYaw() + " " + loc.getPitch();
  }

  /**
   * <b>world x y z</b>
   * @param loc
   * @return
   */
  public static String toString(@This Location loc){
    return loc.getWorld().getName() + " " + loc.getX() + " " + loc.getY() + " " + loc.getZ();
  }

  /**
   * <b>x y z</b>
   * @param loc
   * @return
   */
  public static String toStringNoWorld(@This Location loc){
    return loc.getX() + " " + loc.getY() + " " + loc.getZ();
  }

}