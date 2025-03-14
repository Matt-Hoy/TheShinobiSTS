package theshinobi.util.model;

import static theshinobi.ShinobiMod.makeID;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theshinobi.powers.ShinobiPower;

public class PowerTemplate extends ShinobiPower {
  public static final String POWER_ID = makeID("PowerNameHere");
  private static final AbstractPower.PowerType TYPE = PowerType.BUFF;
  private static final boolean TURN_BASED = false;

  public PowerTemplate(AbstractCreature owner, int amount) {
    super(POWER_ID, TYPE, TURN_BASED, owner, amount);
  }

  public void updateDescription() {
    description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
  }
}
