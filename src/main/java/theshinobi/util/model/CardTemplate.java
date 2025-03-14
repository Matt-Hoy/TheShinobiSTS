package theshinobi.util.model;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theshinobi.cards.ShinobiCard;
import theshinobi.character.MyCharacter;
import theshinobi.util.CardStats;

/*
"${modID}:ExampleCard": {
  "NAME": "Name",
  "DESCRIPTION": "Description. NL Second line.",
  "UPGRADE_DESCRIPTION": "This will automatically be used if the card is upgraded. Remove it if unneeded.",
  "EXTENDED_DESCRIPTION": [
    "You can put more text in here.",
    "If you need to use it for stuff.",
    "Blizzard is a good example for this."
  ]
},
 */

public class CardTemplate extends ShinobiCard {
  public static final String ID = makeID("CardNameHere");
  private static final CardStats INFO =
      new CardStats(
          MyCharacter.Meta.CARD_COLOR, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY, 1);
  private static final int DAMAGE = 4;
  private static final int UPG_DAMAGE = 3;
  private static final int BLOCK = 7;
  private static final int UPG_BLOCK = 1;
  private static final int MAGIC = 0;
  private static final int UPG_MAGIC = 1;

  public CardTemplate() {
    super(ID, INFO);

    setDamage(DAMAGE, UPG_DAMAGE);
    setBlock(BLOCK, UPG_BLOCK);
    setMagic(MAGIC, UPG_MAGIC);
    setCostUpgrade(0);
  }

  @Override
  public void use(AbstractPlayer player, AbstractMonster monster) {}

  @Override
  public AbstractCard makeCopy() {
    return new CardTemplate();
  }
}
