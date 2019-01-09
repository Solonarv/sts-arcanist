package solonarv.slaythespire.arcanist.cards.skills;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import solonarv.slaythespire.arcanist.ArcanistMod;
import solonarv.slaythespire.arcanist.patches.AbstractCardEnum;

public class Insulate extends CustomCard {
    public static final String ID = "arcanist:Isolate";
    public static final String NAME;
    public static final String DESCRIPTION;
    public static String UPGRADED_DESCRIPTION;
    private static final String IMG_PATH = "cards/skills/isolate.png";
    private static final AbstractCard.CardType TYPE = CardType.SKILL;
    private static final AbstractCard.CardRarity RARITY = CardRarity.BASIC;
    private static final AbstractCard.CardTarget TARGET = CardTarget.SELF;

    private static final CardStrings cardStrings;

    private static final int COST = 1;
    private static final int BLOCK = 4;
    private static final int UPGRADE_BLOCK_BONUS = 3;
    private static final int REDUCTION_LAYER_COUNT = 1;

    public Insulate() {
        super(ID, NAME, ArcanistMod.resourcePath(IMG_PATH), COST, DESCRIPTION, TYPE, AbstractCardEnum.ARCANIST, RARITY, TARGET);
        block = baseBlock = BLOCK;
        magicNumber = baseMagicNumber = REDUCTION_LAYER_COUNT;
    }

    @Override
    public void upgrade() {
        if (!upgraded){
            upgradeName();
            upgradeBlock(UPGRADE_BLOCK_BONUS);
        }
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster _m) {
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(player, player, block));
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
        UPGRADED_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    }
}
