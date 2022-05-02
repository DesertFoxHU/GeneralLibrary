package GeneralLibrary.extensions.org.bukkit.entity.Player;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import me.desertfox.gl.translation.Translatable;
import me.desertfox.gl.translation.Translator;
import org.bukkit.entity.Player;

import java.util.List;

@Extension
public class PlayerExtensions {

  /**
   * Don't use this<br>
   * <br>
   * You must initialize first with {@link Translator#Init(List)}
   * @param player
   * @param message
   */
  @Deprecated
  public static void sendTranslatedMessage(@This Player player, Translatable message){
    player.sendMessage(message.finish());
  }

}