package solonarv.slaythespire.arcanist.character;

import basemod.BaseMod;
import basemod.abstracts.CustomPlayer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.events.beyond.SpireHeart;
import com.megacrit.cardcrawl.events.city.Vampires;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import solonarv.slaythespire.arcanist.ArcanistMod;
import solonarv.slaythespire.arcanist.patches.AbstractCardEnum;

import java.util.ArrayList;

public class ArcanistCharacter extends CustomPlayer {

    @SpireEnum
    public static AbstractPlayer.PlayerClass ARCANIST_CLASS;

    public static ArcanistCharacter INSTANCE;

    private static String NAME = "The Arcanist";
    private static String DESCRIPTION = "A mage that calls up barriers to boost her attacks and dampen enemies'.";
    private static final int MAX_HP = 60;
    private static final int MAX_ENERGY = 3;
    private static final int ORB_SLOTS = 1;
    private static final int STARTING_GOLD = 99;
    private static final int HAND_SIZE = 10;

    public static final String[] ORB_TEXTURES = {};

    public static final String ORB_VFX = "images/character/orb/vfx.png";

    public static final String SHOULDER_2 = "images/character/shoulder2.png";
    public static final String SHOULDER = "images/character/shoulder.png";
    public static final String CORPSE = "images/character/corpse.png";

    private static final String CHAR_SELECT_BUTTON = "character/arcanist/char_select_button.png";
    private static final String CHAR_SELECT_PORTRAIT = "character/arcanist/char_select_portrait.png";

    private ArcanistCharacter(String name, AbstractPlayer.PlayerClass cls) {
        super(name, cls, ORB_TEXTURES, ORB_VFX, (String) null, (String) null);

        dialogX = drawX + 0.0F * Settings.scale;
        dialogY = drawY + 220.0F * Settings.scale;

        initializeClass(null, SHOULDER_2, SHOULDER, CORPSE, getLoadout(),
                20f, -10f, 220f, 290f, new EnergyManager(MAX_ENERGY));
    }

    public static void register() {
        BaseMod.addCharacter(new ArcanistCharacter(NAME, ARCANIST_CLASS), ArcanistMod.resourcePath(CHAR_SELECT_BUTTON), ArcanistMod.resourcePath(CHAR_SELECT_PORTRAIT), ARCANIST_CLASS);
    }

    @Override
    public ArrayList<String> getStartingDeck() {
        ArrayList<String> deck = new ArrayList<>();
        return deck;
    }

    @Override
    public ArrayList<String> getStartingRelics() {
        ArrayList<String> relics = new ArrayList<>();
        return relics;
    }

    @Override
    public CharSelectInfo getLoadout() {
        return new CharSelectInfo(NAME, DESCRIPTION, MAX_HP, MAX_HP, ORB_SLOTS, STARTING_GOLD, HAND_SIZE, this, getStartingRelics(), getStartingDeck(), false);
    }

    @Override
    public String getTitle(PlayerClass playerClass) {
        return "Arcanist";
    }

    @Override
    public AbstractCard.CardColor getCardColor() {
        return AbstractCardEnum.ARCANIST;
    }

    @Override
    public Color getCardRenderColor() {
        return Color.BLUE;
    }

    @Override
    public AbstractCard getStartCardForEvent() {
        return null;
    }

    @Override
    public Color getCardTrailColor() {
        return Color.SKY.cpy();
    }

    @Override
    public int getAscensionMaxHPLoss() {
        return 5;
    }

    @Override
    public BitmapFont getEnergyNumFont() {
        return FontHelper.energyNumFontBlue;
    }

    @Override
    public void doCharSelectScreenSelectEffect() {
        CardCrawlGame.sound.playA("ATTACK_MAGIC_BEAM_SHORT", MathUtils.random(-0.2F, 0.2F));
        CardCrawlGame.screenShake.shake(ScreenShake.ShakeIntensity.MED, ScreenShake.ShakeDur.SHORT, false);
    }

    @Override
    public String getCustomModeCharacterButtonSoundKey() {
        return "ATTACK_MAGIC_BEAM_SHORT";
    }

    @Override
    public String getLocalizedCharacterName() {
        return NAME;
    }

    @Override
    public AbstractPlayer newInstance() {
        return new ArcanistCharacter(NAME, ARCANIST_CLASS);
    }

    @Override
    public String getSpireHeartText() {
        return SpireHeart.DESCRIPTIONS[10];
    }

    @Override
    public Color getSlashAttackColor() {
        return Color.SKY;
    }

    @Override
    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[0];
    }

    @Override
    public String getVampireText() {
        return Vampires.DESCRIPTIONS[1];
    }
}
