package theshinobi.cards.basic;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theshinobi.cards.ShinobiCard;
import theshinobi.character.MyCharacter;
import theshinobi.powers.EvasionPower;
import theshinobi.util.CardStats;

public class Hide extends ShinobiCard {
  public static final String ID = makeID("Hide");
  private static final CardStats INFO =
      new CardStats(
          MyCharacter.Meta.CARD_COLOR, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF, 1);

  private static final int MAGIC = 50;
  private static final int UPG_MAGIC = 25;

  public Hide() {
    super(ID, INFO);

    setMagic(MAGIC, UPG_MAGIC);
  }

  @Override
  public void use(AbstractPlayer player, AbstractMonster monster) {
    addToBot(new ApplyPowerAction(player, player, new EvasionPower(player, magicNumber)));
  }

  @Override
  public AbstractCard makeCopy() {
    return new Hide();
  }
}
