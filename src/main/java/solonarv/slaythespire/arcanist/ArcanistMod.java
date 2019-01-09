package solonarv.slaythespire.arcanist;

import basemod.BaseMod;
import basemod.interfaces.EditCharactersSubscriber;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.helpers.CardHelper;
import solonarv.slaythespire.arcanist.character.ArcanistCharacter;
import solonarv.slaythespire.arcanist.patches.AbstractCardEnum;

@SpireInitializer
public class ArcanistMod implements EditCharactersSubscriber {
    public static final ArcanistMod INSTANCE = new ArcanistMod();

    private static final Color ARCANIST_COLOR = CardHelper.getColor(0.6f, 0.8f, 1.0f);
    private static final String ATTACK_CARD = "512/bg_attack_arcanist.png";
    private static final String SKILL_CARD = "512/bg_skill_arcanist.png";
    private static final String POWER_CARD = "512/bg_power_arcanist.png";
    private static final String ENERGY_ORB = "512/energy_orb_arcanist.png";
    private static final String ENERGY_ORB_SMALL = "512/energy_orb_arcanist_small.png";

    private static final String ATTACK_CARD_PORTRAIT = "1024/bg_attack_arcanist.png";
    private static final String SKILL_CARD_PORTRAIT = "1024/bg_skill_arcanist.png";
    private static final String POWER_CARD_PORTRAIT = "1024/bg_power_arcanist.png";
    private static final String ENERGY_ORB_PORTRAIT = "1024/energy_orb_arcanist.png";


    public static void initialize() {
        BaseMod.subscribe(INSTANCE);
        BaseMod.addColor(AbstractCardEnum.ARCANIST,
                ARCANIST_COLOR, ARCANIST_COLOR, ARCANIST_COLOR, ARCANIST_COLOR, ARCANIST_COLOR, ARCANIST_COLOR, ARCANIST_COLOR,
                resourcePath(ATTACK_CARD), resourcePath(SKILL_CARD), resourcePath(POWER_CARD),
                resourcePath(ENERGY_ORB),
                resourcePath(ATTACK_CARD_PORTRAIT), resourcePath(SKILL_CARD_PORTRAIT), resourcePath(POWER_CARD_PORTRAIT),
                resourcePath(ENERGY_ORB_PORTRAIT), resourcePath(ENERGY_ORB_SMALL));
    }

    public static String resourcePath(String path) {
        return "images/character/arcanist/" + path;
    }

    @Override
    public void receiveEditCharacters() {
        ArcanistCharacter.register();
    }
}
