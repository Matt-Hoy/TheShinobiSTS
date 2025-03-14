package theshinobi.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch2;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.vfx.combat.BlockedWordEffect;
import theshinobi.powers.EvasionPower;

// Edited to clone functionality in the saiyajin DodgeChancePatch which did it more cleanly.
@SpirePatch2(clz = AbstractPlayer.class, method = "damage")
public class EvasionPatch {
  public static SpireReturn<Void> Prefix(AbstractPlayer player, DamageInfo info) {
    if (AbstractDungeon.player.hasPower(EvasionPower.POWER_ID)) {
      EvasionPower evasionPower =
          (EvasionPower) AbstractDungeon.player.getPower(EvasionPower.POWER_ID);
      if (info.type == DamageInfo.DamageType.NORMAL
          && info.output > 0
          && AbstractDungeon.cardRandomRng.random(99) < evasionPower.amount) {
        evasionPower.decrementEvasion();
        int damage = 0;
        if (info.owner == player) {
          for (AbstractRelic relic : player.relics) {
            relic.onAttack(info, damage, player);
          }
        }
        if (info.owner != null) {
          for (AbstractPower power : info.owner.powers) {
            power.onAttack(info, damage, player);
          }
          for (AbstractPower power : player.powers) {
            damage = power.onAttacked(info, damage);
          }
          for (AbstractRelic relic : player.relics) {
            damage = relic.onAttacked(info, damage);
          }
        }
        AbstractDungeon.effectList.add(
            new BlockedWordEffect(player, player.hb.cX, player.hb.cY, "Evaded!"));
        return SpireReturn.Return(null);
      }
      return SpireReturn.Continue();
    } else {
      return SpireReturn.Continue();
    }
  }
}
