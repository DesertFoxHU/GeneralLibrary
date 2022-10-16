package me.desertfox.gl;

import me.desertfox.gl.invitation.InvitationSystem;
import me.desertfox.gl.timedaction.TimedAction;
import org.bukkit.plugin.java.JavaPlugin;

public class GeneralLibrary {

    private static boolean started = false;

    public static void initAll(JavaPlugin plugin){
        if(started){
           plugin.getLogger().info("§cGeneralLibrary has been already initialized!");
           return;
        }

        started = true;
        InvitationSystem.start(plugin);
        TimedAction.init(plugin);
    }

    public static boolean isStarted() {
        return started;
    }
}
