package me.desertfox.gl.translation;

import me.desertfox.gl.events.PlayerLanguageChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.HashMap;
import java.util.List;

public class Translator {

    public static List<TranslationSource<?>> localeProvider;
    public static Enum<?> defaultLocale = DefaultLocales.ENG;
    public static String prefix = "";
    /**
     * Key: PlayerName<br>
     * Value: LanguageKey
     */
    private static HashMap<String, Enum<?>> langPreference = new HashMap<>();

    /**
     * Enum should contain language names like:<br>
     * - EN<br>
     * - HU<br>
     * - RO<br>
     * - EGY<br>
     * etc.
     * @param localeProvider
     */
    public static void Init(List<TranslationSource<?>> localeProvider){
        Translator.localeProvider = localeProvider;
    }

    /**
     * Enum should contain language names like:<br>
     * - EN<br>
     * - HU<br>
     * - RO<br>
     * - EGY<br>
     * etc.
     * @param localeProvider
     */
    public static void Init(List<TranslationSource<?>> localeProvider, Enum<?> defaultLocale, String prefix, HashMap<String, Enum<?>> langPreference){
        Translator.localeProvider = localeProvider;
        Translator.defaultLocale = defaultLocale;
        Translator.prefix = prefix;
        Translator.langPreference = langPreference;
    }

    public static HashMap<String, Enum<?>> getLangPreference() { return langPreference; }

    public static void setLangPreference(HashMap<String, Enum<?>> langPreference){
        Translator.langPreference = langPreference;
    }

    public static void setPlayerLangPreference(String playerName, Enum<?> lang){
        PlayerLanguageChangeEvent event = new PlayerLanguageChangeEvent(playerName, langPreference.getOrDefault(playerName, defaultLocale), lang);
        Bukkit.getPluginManager().callEvent(event);

        if(event.isCancelled) return;

        lang = event.getNewLanguage();

        if(langPreference.containsKey(playerName)){
            langPreference.replace(playerName, lang);
        }
        else {
            langPreference.put(playerName, lang);
        }
    }

    /**
     * Generates an empty template for language sources<br>
     * @param messageKeys should be Enum.class
     * @return
     * @param <T>
     */
    public static <T> YamlConfiguration generateTemplate(Class<?> messageKeys){
        YamlConfiguration config = new YamlConfiguration();
        for(Object val : messageKeys.getEnumConstants()){
            config.set(val.toString(), "");
        }
        return config;
    }

    public static <E> TranslationSource<?> getTranslationSource(E e){
        for(TranslationSource<?> v : localeProvider){
            if(v.languageKey == e) return v;
        }
        return null;
    }

}
