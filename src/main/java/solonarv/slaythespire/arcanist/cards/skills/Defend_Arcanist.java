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

public class Defend_Arcanist extends CustomCard {

    public static final String ID = "arcanist:Defend_Arcanist";
    public static final String NAME;
    public static final String DESCRIPTION;
    public static String UPGRADED_DESCRIPTION;
    private static final String IMG_PATH = "cards/skills/defend.png";
    private static final AbstractCard.CardType TYPE = CardType.SKILL;
    private static final AbstractCard.CardRarity RARITY = CardRarity.BASIC;
    private static final AbstractCard.CardTarget TARGET = CardTarget.SELF;

    private static final CardStrings cardStrings;

    private static final int COST = 1;
    private static final int BLOCK = 5;
    private static final int UPGRADE_BLOCK_BONUS = 3;
    public Defend_Arcanist() {
        super(ID, NAME, ArcanistMod.resourcePath(IMG_PATH), COST, DESCRIPTION, TYPE, AbstractCardEnum.ARCANIST, RARITY, TARGET);
        baseBlock = BLOCK;
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
