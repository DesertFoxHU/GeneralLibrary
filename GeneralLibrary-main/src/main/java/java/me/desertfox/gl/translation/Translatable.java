package java.me.desertfox.gl.translation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.Objects;

public class Translatable {

    private String message;
    public boolean includePrefix = false;
    public Enum<?> languageKey = Translator.defaultLocale;
    public String messageKey;

    public Translatable(Enum<?> messageKey) {
        this.messageKey = messageKey.toString();
    }

    public Translatable(String messageKey) {
        this.messageKey = messageKey;
    }

    /**
     * @param languageKey {@link DefaultLocales} can be used
     * @param messageKey
     */
    public Translatable(Enum<?> languageKey, Enum<?> messageKey) {
        this.languageKey = languageKey;
        this.messageKey = messageKey.toString();
    }

    /**
     * @param languageKey {@link DefaultLocales} can be used
     * @param messageKey
     */
    public Translatable(Enum<?> languageKey, String messageKey) {
        this.languageKey = languageKey;
        this.messageKey = messageKey;
    }

    /**
     * Prefix can be changed with {@link Translator#prefix}
     * @param includePrefix
     * @return
     */
    public Translatable includePrefix(boolean includePrefix){
        this.includePrefix = includePrefix;
        return this;
    }

    /**
     * Call this before {@link Translatable#fetchMessage()}
     * @param playerName
     * @return
     */
    public Translatable useLangReference(String playerName){
        if(Translator.getLangPreference() == null){
            Bukkit.getLogger().info("§cNULL: Translator.langPreference is null");
            return this;
        }

        if(!Translator.getLangPreference().containsKey(playerName)){
            return this;
        }

        languageKey = Translator.getLangPreference().get(playerName);
        return this;
    }

    /**
     * Searches a message with the provided language and messageKey<br>
     * Changing the {@link Translatable#languageKey} or {@link Translatable#messageKey} after this will do nothing
     * @return
     */
    public Translatable fetchMessage(){
        Objects.requireNonNull(Translator.localeProvider, "§cNULL: Translator.Init have never been called!");
        if(Translator.getTranslationSource(languageKey) == null){
            Bukkit.getLogger().info("§eWARN: Non-existent language identifier: " + languageKey + "!");
            Bukkit.getLogger().info("§eThis can mean lot of things: Translator not initialized or the corresponding language source file doesn't exist");
            return this;
        }

        YamlConfiguration yaml = Translator.getTranslationSource(languageKey).source;
        message = yaml.getString(messageKey, null);
        if(message == null){
            Bukkit.getLogger().info("§eWARN: This language source's doesn't contains this message type: " + messageKey + " languageKey: " + languageKey);
            message = "NOT_DEFINED";
        }

        return this;
    }

    public String finish() {
        String finalMessage = includePrefix ? Translator.prefix + message : message;
        return ChatColor.translateAlternateColorCodes('&', finalMessage);
    }
}
