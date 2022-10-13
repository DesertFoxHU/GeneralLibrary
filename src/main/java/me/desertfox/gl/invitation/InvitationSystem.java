package me.desertfox.gl.invitation;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * InvitationSystem made for handle invitations between 2 members,<br>
 * more specifically the sender and receiver<br>
 * <br>
 * Don't forget to start the system with {@link InvitationSystem#start(JavaPlugin)}<br>
 * <br>
 * You also need to determine when a player accepted or declined the request<br>
 * You can store these requests in your way and it recommended too to determine multiple types of invitations<br>
 */
public class InvitationSystem {

    private static JavaPlugin plugin = null;
    public static boolean isStarted = false;
    private static List<AbstractInvitation> requests = new ArrayList<>();

    public static void start(JavaPlugin plugin){
        InvitationSystem.plugin = plugin;
        new BukkitRunnable(){
            @Override
            public void run() {
                Iterator<AbstractInvitation> invites = requests.iterator();
                while(invites.hasNext()){
                    AbstractInvitation invite = invites.next();
                    invite.setRemainedTime(invite.getRemainedTime()-0.5);
                    if(invite.getRemainedTime() <= 0){
                        invite.endRequest();
                        invites.remove();
                    }
                }
            }
        }.runTaskTimer(plugin, 0, 10);
        isStarted = true;
    }

    public static void sendInviteRequest(AbstractInvitation handler){
        if(!isStarted){
            plugin.getLogger().info("§4InvitationSystem was not initialized, but this plugin tried to use it's functions.");
            return;
        }

        if(!handler.getSender().isOnline()){
            plugin.getLogger().info("§4You can't send an invite request from an offline player");
            return;
        }

        if(!handler.getReceiver().isOnline()){
            handler.handleErrors(InvitationError.RECEIVER_OFFLINE);
            return;
        }

        handler.start();
        requests.add(handler);
    }

    public static List<AbstractInvitation> getRequests() {return new ArrayList<>(requests);}
}
