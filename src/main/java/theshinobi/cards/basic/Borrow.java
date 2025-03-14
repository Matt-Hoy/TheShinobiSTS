package theshinobi.cards.basic;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theshinobi.cards.ShinobiCard;
import theshinobi.character.MyCharacter;
import theshinobi.util.CardStats;

public class Borrow extends ShinobiCard {
  public static final String ID = makeID("Borrow");
  private static final CardStats INFO =
      new CardStats(
          MyCharacter.Meta.CARD_COLOR, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY, 1);
  private static final int DAMAGE = 6;
  private static final int UPG_DAMAGE = 3;
  private static final int MAGIC = 1;
  private static final int UPG_MAGIC = 1;

  public Borrow() {
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
            AbstractGameAction.AttackEffect.BLUNT_LIGHT));
    addToBot(new GainGoldAction(magicNumber));
  }

  @Override
  public AbstractCard makeCopy() {
    return new Borrow();
  }
}
