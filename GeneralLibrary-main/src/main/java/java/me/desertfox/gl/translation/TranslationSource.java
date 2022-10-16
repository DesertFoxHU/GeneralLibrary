package java.me.desertfox.gl.translation;

import org.bukkit.configuration.file.YamlConfiguration;

public class TranslationSource<E> {

    public E languageKey;
    public YamlConfiguration source;

    public TranslationSource(E languageKey, YamlConfiguration source) {
        this.languageKey = languageKey;
        this.source = source;
    }
}
