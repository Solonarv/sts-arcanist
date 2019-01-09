package solonarv.slaythespire.arcanist.cards.attacks;

import basemod.abstracts.CustomCard;
import basemod.helpers.BaseModCardTags;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import solonarv.slaythespire.arcanist.ArcanistMod;
import solonarv.slaythespire.arcanist.patches.AbstractCardEnum;

public class Strike_Arcanist extends CustomCard {

    public static final String ID = "arcanist:Strike_Arcanist";
    public static final String NAME;
    public static final String DESCRIPTION;
    public static String UPGRADED_DESCRIPTION;
    private static final String IMG_PATH = "cards/attacks/strike.png";
    private static final AbstractCard.CardType TYPE = CardType.ATTACK;
    private static final AbstractCard.CardRarity RARITY = CardRarity.BASIC;
    private static final AbstractCard.CardTarget TARGET = CardTarget.ENEMY;

    private static final CardStrings cardStrings;

    private static final int COST = 1;
    private static final int DAMAGE = 6;
    private static final int UPGRADE_DAMAGE_BONUS = 3;

    public Strike_Arcanist() {
        super(ID, NAME, ArcanistMod.resourcePath(IMG_PATH), COST, DESCRIPTION, TYPE, AbstractCardEnum.ARCANIST, RARITY, TARGET);
        baseDamage = DAMAGE;
        tags.add(BaseModCardTags.BASIC_STRIKE);
        tags.add(CardTags.STRIKE);
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeDamage(UPGRADE_DAMAGE_BONUS);
        }
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        AbstractDungeon.actionManager.addToBottom(new DamageAction(monster, new DamageInfo(player, damage, damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
        UPGRADED_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    }
}
