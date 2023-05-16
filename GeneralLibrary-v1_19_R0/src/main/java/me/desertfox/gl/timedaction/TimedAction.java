package me.desertfox.gl.timedaction;

import jline.internal.Nullable;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Call {@link TimedAction#init(JavaPlugin)} to initialize
 */
public class TimedAction {

    private static boolean started = false;
    private static HashMap<Player, ActionData<Double, Double, AbstractTimedAction>> actions = new HashMap<>();

    public static void init(JavaPlugin plugin){
        if(started){
            plugin.getLogger().info("§cTimedAction has been already started!");
            return;
        }

        new BukkitRunnable(){

            @Override
            public void run() {

                Iterator<Player> playerIterator = actions.keySet().iterator();
                while(playerIterator.hasNext()){
                    Player player = playerIterator.next();
                    ActionData<Double, Double, AbstractTimedAction> data = actions.get(player);

                    data.u.onTick(player, data.t, data.s);

                    if(data.t <= 0){
                        data.u.onCompleted(player);
                        playerIterator.remove();
                    }

                    data.t -= 0.1;
                }

            }

        }.runTaskTimer(plugin, 0, 2 /*0.1 sec*/);
        started = true;
    }

    /**
     * This cancels the player's any other action
     * @param player
     * @param action
     * @param duration
     */
    public static void startAction(Player player, AbstractTimedAction action, double duration){
        if(actions.containsKey(player)){
           cancelAction(player);
        }

        ActionData<Double, Double, AbstractTimedAction> data = new ActionData<>(duration /*timer*/, duration, action);
        action.onStart(player);
        actions.put(player, data);
    }

    public static @Nullable AbstractTimedAction hasTimedAction(Player player){
        if(!actions.containsKey(player)) return null;

        return actions.get(player).u;
    }

    @Deprecated
    public static void cancelAction(Player player){
        if(!actions.containsKey(player)) return;

        ActionData<Double, Double, AbstractTimedAction> data = actions.get(player);
        data.u.onCancelled(player);
        actions.remove(player);
    }

    /**
     *
     * @param player
     * @param event
     */
    public static void cancelAction(Player player, Class<? extends Event> event){
        if(!actions.containsKey(player)) return;

        ActionData<Double, Double, AbstractTimedAction> data = actions.get(player);
        if(!data.u.cancelOnEvents().contains(event)) return;

        data.u.onCancelled(player);
        actions.remove(player);
    }

    public static boolean isStarted() {
        return started;
    }
}
