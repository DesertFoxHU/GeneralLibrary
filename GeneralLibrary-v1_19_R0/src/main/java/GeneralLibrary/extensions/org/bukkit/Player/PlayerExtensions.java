package GeneralLibrary.extensions.org.bukkit.Player;

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
    player.sendMessage(message.useLangReference(player.getName()).finish());
  }

  public static void sendRawTranslation(@This Player player, Translatable message){
    player.sendMessage(message.useLangReference(player.getName()).finish());
  }

  public static void sendTranslation(@This Player player, Enum<?> messageKey){
    player.sendMessage(new Translatable(messageKey).useLangReference(player.getName()).fetchMessage().finish());
  }

  public static void sendTranslation(@This Player player, Enum<?> languageKey, Enum<?> messageKey){
    player.sendMessage(new Translatable(languageKey, messageKey).useLangReference(player.getName()).fetchMessage().finish());
  }

  public static void sendTranslation(@This Player player, String messageKey, boolean includePrefix){
    player.sendMessage(new Translatable(messageKey).useLangReference(player.getName()).fetchMessage().includePrefix(includePrefix).finish());
  }

  public static void sendTranslation(@This Player player, Enum<?> messageKey, boolean includePrefix){
    player.sendMessage(new Translatable(messageKey).useLangReference(player.getName()).fetchMessage().includePrefix(includePrefix).finish());
  }

  public static void sendTranslation(@This Player player, Enum<?> languageKey, Enum<?> messageKey, boolean includePrefix){
    player.sendMessage(new Translatable(languageKey, messageKey).useLangReference(player.getName()).fetchMessage().includePrefix(includePrefix).finish());
  }

  public static void sendTranslation(@This Player player, Enum<?> languageKey, String messageKey, boolean includePrefix){
    player.sendMessage(new Translatable(languageKey, messageKey).useLangReference(player.getName()).fetchMessage().includePrefix(includePrefix).finish());
  }

}