package theshinobi.cards.basic;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theshinobi.cards.ShinobiCard;
import theshinobi.character.MyCharacter;
import theshinobi.powers.EvasionPower;
import theshinobi.util.CardStats;

public class Slink extends ShinobiCard {
  public static final String ID = makeID("Slink");
  private static final CardStats INFO =
      new CardStats(
          MyCharacter.Meta.CARD_COLOR, CardType.ATTACK, CardRarity.BASIC, CardTarget.ENEMY, 1);
  private static final int DAMAGE = 6;
  private static final int UPG_DAMAGE = 3;
  private static final int MAGIC = 10;
  private static final int UPG_MAGIC = 5;

  public Slink() {
    super(ID, INFO);

    setDamage(DAMAGE, UPG_DAMAGE);
    setMagic(MAGIC, UPG_MAGIC);
  }

  @Override
  public void use(AbstractPlayer player, AbstractMonster monster) {
    addToBot(
        new DamageAction(
            monster,
            new DamageInfo(player, damage, DamageInfo.DamageType.NORMAL),
            AbstractGameAction.AttackEffect.SLASH_DIAGONAL,
            Settings.FAST_MODE));
    addToBot(new ApplyPowerAction(player, player, new EvasionPower(player, magicNumber)));
  }

  @Override
  public AbstractCard makeCopy() {
    return new Slink();
  }
}
