package me.desertfox.gl;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Commands {

    public static HashMap<Player, LocationStorage> locationStorage = new HashMap<>();

    /**
     * Sets the first location of a region
     * @param player
     * @param location
     * @return Only returns SUCCESS<br>
     */
    public static Response<ResponseType, Object> setLocation1(Player player, Location location){
        if(!locationStorage.containsKey(player)){
            locationStorage.put(player, new LocationStorage());
        }

        LocationStorage ls = locationStorage.get(player);
        ls.setLoc1(location);
        return new Response<>(ResponseType.SUCCESS, null);
    }

    /**
     * Sets the first location of a region
     * @param player
     * @param location
     * @return Only returns SUCCESS<br>
     */
    public static Response<ResponseType, Object> setLocation2(Player player, Location location){
        if(!locationStorage.containsKey(player)){
            locationStorage.put(player, new LocationStorage());
        }

        getSavedLocation(null);

        LocationStorage ls = locationStorage.get(player);
        ls.setLoc2(location);
        return new Response<>(ResponseType.SUCCESS, null);
    }

    /**
     * Returns the set locations of the region
     * @param player
     * @return NOTEXIST = the player not exist in locationStorage<br>
     */
    public static Response<ResponseType, LocationStorage> getSavedLocation(Player player){
        if(!locationStorage.containsKey(player)){
            return new Response<>(ResponseType.NOTEXIST, null);
        }

        LocationStorage ls = locationStorage.get(player);
        locationStorage.remove(player);
        return new Response<>(ResponseType.SUCCESS, ls);
    }

}
