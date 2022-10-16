package java.me.desertfox.gl.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerLanguageChangeEvent extends Event implements Cancellable {

    private String player;
    private Enum<?> oldLanguage;
    private Enum<?> newLanguage;

    public PlayerLanguageChangeEvent(String player, Enum<?> oldLanguage, Enum<?> newLanguage){
        this.player = player;
        this.oldLanguage = oldLanguage;
        this.newLanguage = newLanguage;
    }

    public void setNewLanguage(Enum<?> newLanguage) {
        this.newLanguage = newLanguage;
    }

    public String getPlayerName() {
        return player;
    }

    public Enum<?> getOldLanguage() {
        return oldLanguage;
    }

    public Enum<?> getNewLanguage() {
        return newLanguage;
    }

    public boolean isCancelled;
    public static HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean arg0) {
        this.isCancelled = arg0;
    }
}
