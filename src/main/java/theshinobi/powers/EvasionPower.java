package theshinobi.powers;

import static theshinobi.ShinobiMod.makeID;

import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class EvasionPower extends ShinobiPower {
  public static final String POWER_ID = makeID("Evasion");
  private static final PowerType TYPE = PowerType.BUFF;
  private static final boolean TURN_BASED = false;

  public EvasionPower(AbstractCreature owner, int amount) {
    super(POWER_ID, TYPE, TURN_BASED, owner, amount);
  }

  public void decrementEvasion() {
    if (amount > 10) {
      amount -= 10;
    } else {
      addToBot(new RemoveSpecificPowerAction(owner, owner, EvasionPower.POWER_ID));
    }
  }

  @Override
  public void atEndOfRound() {
    addToBot(new RemoveSpecificPowerAction(owner, owner, EvasionPower.POWER_ID));
  }

  public void updateDescription() {
    description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
  }
}
