package me.desertfox.gl.timedaction;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Call {@link TimedAction#init(JavaPlugin)} for initialize
 */
public class TimedAction {

    private static HashMap<Player, ActionData<Double, Double, AbstractTimedAction>> actions = new HashMap<>();

    public static void init(JavaPlugin plugin){
        new BukkitRunnable(){

            @Override
            public void run() {

                Iterator<Player> playerIterator = actions.keySet().iterator();
                while(playerIterator.hasNext()){
                    Player player = playerIterator.next();
                    ActionData<Double, Double, AbstractTimedAction> data = actions.get(player);

                    data.t -= 0.1;
                    if(data.t <= 0){
                        data.u.onCompleted(player);
                        playerIterator.remove();
                    }
                    else {
                        data.u.onTick(player, data.t, data.s);
                    }
                }

            }

        }.runTaskTimer(plugin, 0, 2 /*0.1 sec*/);
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

    public static void cancelAction(Player player){
        if(!actions.containsKey(player)) return;

        ActionData<Double, Double, AbstractTimedAction> data = actions.get(player);
        data.u.onCancelled(player);
        actions.remove(player);
    }

}
