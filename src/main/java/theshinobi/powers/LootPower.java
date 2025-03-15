package theshinobi.powers;

import static theshinobi.ShinobiMod.makeID;

import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.RainingGoldEffect;

public class LootPower extends ShinobiPower {
  public static final String POWER_ID = makeID("Loot");
  private static final PowerType TYPE = PowerType.DEBUFF;
  private static final boolean TURN_BASED = false;

  public LootPower(AbstractCreature owner, int amount) {
    super(POWER_ID, TYPE, TURN_BASED, owner, amount);
  }

  @Override
  public void onDeath() {
    addToBot(new GainGoldAction(amount));

    AbstractDungeon.effectList.add(new RainingGoldEffect(amount, true));
  }

  @Override
  public void atEndOfRound() {
    addToBot(new RemoveSpecificPowerAction(owner, AbstractDungeon.player, LootPower.POWER_ID));
  }

  public void updateDescription() {
    description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
  }
}
