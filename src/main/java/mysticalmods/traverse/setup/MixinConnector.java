package mysticalmods.traverse.setup;

import mysticalmods.traverse.Traverse;
import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.connect.IMixinConnector;

public class MixinConnector implements IMixinConnector {
  @Override
  public void connect() {
    Traverse.LOG.debug("Traverse: Loading mixins!");
    Mixins.addConfiguration("traverse.mixins.json");
  }
}
