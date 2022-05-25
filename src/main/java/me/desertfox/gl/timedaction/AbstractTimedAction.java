package me.desertfox.gl.timedaction;

import me.desertfox.gl.Formatter;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public abstract class AbstractTimedAction {

    public String BRACKET_COLOR = "§7";
    public String ELAPSED_SYMBOL_COLOR = "§a";
    public String REMAINING_SYMBOL_COLOR = "§7";
    public String TIME_COLOR = "§7";

    /**
     * Sends a message to the player's actionbar<br>
     * The message should look like this:<br>
     * '[██████████] 0.0s'<br>
     * <br>
     * One block symbol represent 10% percentage
     * @param player
     * @param remainingTime
     * @param startDuration
     */
    public void sendTimeInfo(Player player, double remainingTime, double startDuration){
        double percentage = (startDuration-remainingTime)/startDuration*100;
        int blockPercentage = (int)(percentage/10);

        int remainBlocks = 10 - blockPercentage;
        String formatTime = BRACKET_COLOR + "[" + ELAPSED_SYMBOL_COLOR +
                "█".repeat(Math.max(0, blockPercentage)) +
                REMAINING_SYMBOL_COLOR +
                "█".repeat(Math.max(0, remainBlocks)) +
                BRACKET_COLOR + "] " +
                TIME_COLOR + Formatter.formatDouble(remainingTime, 1) + "s";

        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(formatTime));
    }

    /**
     * Called every 0.1 sec
     * @param player
     * @param remainingTime
     * @param startDuration The starting time
     */
    public void onTick(Player player, double remainingTime, double startDuration){
        sendTimeInfo(player, remainingTime, startDuration);
    }

    public void onStart(Player player){
        //Do nothing
    }

    public void onCancelled(Player player){
        //Do nothing
    }

    abstract void onCompleted(Player player);

}
