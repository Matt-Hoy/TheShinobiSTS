package theshinobi.cards.basic;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theshinobi.cards.ShinobiCard;
import theshinobi.character.MyCharacter;
import theshinobi.powers.LootPower;
import theshinobi.util.CardStats;

public class Loot extends ShinobiCard {
  public static final String ID = makeID("Loot");
  private static final CardStats INFO =
      new CardStats(
          MyCharacter.Meta.CARD_COLOR, CardType.SKILL, CardRarity.BASIC, CardTarget.ENEMY, 1);
  private static final int MAGIC = 25;

  public Loot() {
    super(ID, INFO);

    setMagic(MAGIC);
    setCostUpgrade(0);
  }

  @Override
  public void use(AbstractPlayer player, AbstractMonster monster) {
    addToBot(new ApplyPowerAction(monster, player, new LootPower(monster, magicNumber)));
  }

  @Override
  public AbstractCard makeCopy() {
    return new Loot();
  }
}
