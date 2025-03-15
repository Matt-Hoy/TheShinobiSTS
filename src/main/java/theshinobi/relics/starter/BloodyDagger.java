package theshinobi.relics.starter;

import static theshinobi.ShinobiMod.makeID;

import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import theshinobi.character.MyCharacter;
import theshinobi.relics.ShinobiRelic;

public class BloodyDagger extends ShinobiRelic {
  private static final String NAME = "BloodyDagger";
  public static final String ID = makeID(NAME);
  private static final RelicTier RARITY = RelicTier.STARTER;
  private static final LandingSound SOUND = LandingSound.CLINK;

  public BloodyDagger() {
    super(ID, NAME, MyCharacter.Meta.CARD_COLOR, RARITY, SOUND);
  }

  @Override
  public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target) {
    if (target != AbstractDungeon.player
        && info.output > 0
        && info.type == DamageInfo.DamageType.NORMAL) {
      int heal = info.output / 2;
      addToBot(new HealAction(AbstractDungeon.player, AbstractDungeon.player, heal));
    }
  }

  @Override
  public AbstractRelic makeCopy() {
    return new BloodyDagger();
  }

  @Override
  public String getUpdatedDescription() {
    return DESCRIPTIONS[0];
  }
}
