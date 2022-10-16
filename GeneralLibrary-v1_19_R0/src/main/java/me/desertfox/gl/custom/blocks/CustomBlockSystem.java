package me.desertfox.gl.custom.blocks;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * CustomBlockSystem is not supporting a lot of necessary features for<br>
 * custom blocks, because those are not supported by the default spigot API.<br>
 * But in the other hand, this system tries to give you a small starting framework to work with<br>
 * <br>
 * Don't forget to initialize with {@link CustomBlockSystem#start(JavaPlugin)}<br>
 *
 * This doesn't support:<br>
 * - Placing custom blocks with items<br>
 * - Block Breaking and any interaction with them<br>
 * - Serialization or functions for custom blocks<br>
 * <br>
 * What it does then?
 * - Disabling physics update for mushroom blocks, so they don't lose their texture when placing something next to them<br>
 * - Gives a nice starting point and ability to register your own blocks<br>
 */
public class CustomBlockSystem {

    private static boolean started = false;
    public static List<CustomBlock> registry = new ArrayList<>();

    public static void start(JavaPlugin plugin){
        if(started){
            plugin.getLogger().info("§cCustom Block System has been already started!");
            return;
        }

        Bukkit.getPluginManager().registerEvents(new CancelMushroomPhysics(), plugin);
        started = true;
    }

    public static void register(CustomBlock... blocks){
        registry.addAll(Arrays.asList(blocks));
    }

    public static void register(List<CustomBlock> list){
        registry.addAll(list);
    }

    public static @Nullable CustomBlock getCustomBlock(Enum<?> type){
        return registry.stream().filter(x -> x.getType() == type).findAny().orElse(null);
    }

    public static boolean isStarted() {
        return started;
    }
}
