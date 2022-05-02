package me.desertfox.gl.translation;

import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;

public class Translator {

    public static List<TranslationSource<?>> localeProvider;
    public static Enum<?> defaultLocale = DefaultLocales.ENG;
    public static String prefix = "";

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
    public static void Init(List<TranslationSource<?>> localeProvider, Enum<?> defaultLocale){
        Translator.localeProvider = localeProvider;
        Translator.defaultLocale = defaultLocale;
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
    public static void Init(List<TranslationSource<?>> localeProvider, Enum<?> defaultLocale, String prefix){
        Translator.localeProvider = localeProvider;
        Translator.defaultLocale = defaultLocale;
        Translator.prefix = prefix;
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
