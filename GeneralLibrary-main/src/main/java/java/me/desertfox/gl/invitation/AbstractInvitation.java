package java.me.desertfox.gl.invitation;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

public abstract class AbstractInvitation {

    private Player sender;
    private Player receiver;
    private double remainedTime;
    /**
     * Determine if this invitation is expired (or ended)
     */
    private boolean isEnded = false;

    public AbstractInvitation(@NonNull Player sender, @NonNull Player receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    protected final void start(){
        remainedTime = getRemovalTime();
        sendRequest();
    }

    public void sendRequest(){
        TextComponent defaultText = new TextComponent("§7Somebody invited you to test something! You have " + remainedTime + " to accept or decline!");
        TextComponent t1 = new TextComponent("§7[§2§lAccept§7]");
        t1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/test accept"));

        TextComponent t2 = new TextComponent("§7[§4§lDecline§7]");
        t2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/test decline"));

        defaultText.addExtra(t1);
        defaultText.addExtra(t2);

        receiver.spigot().sendMessage(defaultText);
    }

    /**
     * Called when expired<br>
     * When this called you can remove from your storage this invitation<br>
     */
    public void endRequest(){
        isEnded = true;
    }

    /**
     * You need to call this manually<br>
     * I leave this here, so you don't need a workaround for this
     */
    public void onAccept(){

    }

    /**
     * You need to call this manually<br>
     * I leave this here, so you don't need a workaround for this
     */
    public void onDecline(){

    }

    public void handleErrors(InvitationError error){
        if(error == InvitationError.RECEIVER_OFFLINE){
            sender.sendMessage("§cThe player is offline");
        }
    }

    /**
     * This request will be deleted after this period of time (in seconds)
     * @return
     */
    public abstract double getRemovalTime();

    public Player getSender() {
        return sender;
    }

    public Player getReceiver() {
        return receiver;
    }

    public double getRemainedTime() {
        return remainedTime;
    }

    public void setRemainedTime(double remainedTime) {
        this.remainedTime = remainedTime;
    }

    public boolean isEnded() {
        return isEnded;
    }
}
