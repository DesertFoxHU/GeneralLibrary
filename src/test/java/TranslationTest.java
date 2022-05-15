import me.desertfox.gl.translation.DefaultLocales;
import me.desertfox.gl.translation.Translatable;
import me.desertfox.gl.translation.TranslationSource;
import me.desertfox.gl.translation.Translator;
import org.bukkit.configuration.file.YamlConfiguration;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TranslationTest {

    public enum Messages {
        WELCOME_MESSAGE,
        EXIT_MESSAGE,
    }

    @Test
    public void test(){
        YamlConfiguration eng_yaml = Translator.generateTemplate(Messages.class);
        eng_yaml.set(Messages.WELCOME_MESSAGE.toString(), "Test in english");

        YamlConfiguration hun_yaml = new YamlConfiguration();
        hun_yaml.set(Messages.WELCOME_MESSAGE.toString(), "Test in hungarian");

        List<TranslationSource<?>> sources = new ArrayList<>();
        sources.add(new TranslationSource<>(DefaultLocales.ENG, eng_yaml));
        sources.add(new TranslationSource<>(DefaultLocales.HUN, hun_yaml));

        Translator.Init(sources);
        System.out.println(new Translatable(DefaultLocales.ENG, Messages.WELCOME_MESSAGE).fetchMessage().finish());
        System.out.println(new Translatable(DefaultLocales.HUN, Messages.WELCOME_MESSAGE).fetchMessage().finish());

        Translator.prefix = "[Test] ";
        System.out.println(new Translatable(DefaultLocales.ENG, Messages.WELCOME_MESSAGE).includePrefix(true).fetchMessage().finish());

        //w Manifold:
        /*Player player = Bukkit.getPlayer("TestPlayer");
        player.sendTranslation(DefaultLocales.ENG, Messages.WELCOME_MESSAGE);
        player.sendTranslation(DefaultLocales.HUN, Messages.WELCOME_MESSAGE, true);*/
    }

    @Test
    public void preferenceTest(){
        YamlConfiguration eng_yaml = new YamlConfiguration();
        List<TranslationSource<?>> sources = new ArrayList<>();
        sources.add(new TranslationSource<>(DefaultLocales.ENG, eng_yaml));

        HashMap<String, Enum<?>> langPreference = new HashMap<>();
        langPreference.put("TestPlayerName", DefaultLocales.ENG);

        Translator.Init(sources, DefaultLocales.ENG, langPreference);
        //INIT END

        //Bukkit.getPlayer("TestPlayerName").sendMessage(new Translatable(Messages.WELCOME_MESSAGE).useLangReference("TestPlayerName").fetchMessage().finish());
    }

}
