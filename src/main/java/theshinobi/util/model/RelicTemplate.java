package theshinobi.util.model;

import static theshinobi.ShinobiMod.makeID;

import com.megacrit.cardcrawl.relics.AbstractRelic;
import theshinobi.character.MyCharacter;
import theshinobi.relics.ShinobiRelic;

public class RelicTemplate extends ShinobiRelic {
  private static final String NAME = "RelicNameHere";
  public static final String ID = makeID(NAME);
  private static final RelicTier RARITY = RelicTier.COMMON;
  private static final LandingSound SOUND = LandingSound.CLINK;

  public RelicTemplate() {
    super(ID, NAME, MyCharacter.Meta.CARD_COLOR, RARITY, SOUND);
  }

  @Override
  public AbstractRelic makeCopy() {
    return new RelicTemplate();
  }

  @Override
  public String getUpdatedDescription() {
    return DESCRIPTIONS[0] + DESCRIPTIONS[1];
  }
}
