package mysticalmods.traverse.world.placer;

import com.mojang.serialization.Codec;
import mysticalmods.traverse.init.ModFeatures;
import net.minecraft.world.gen.trunkplacer.TrunkPlacerType;
import noobanidus.libs.noobutil.world.gen.placer.AbstractFallenTrunkPlacer;

public class FallenTrunkPlacer extends AbstractFallenTrunkPlacer {
  public static final Codec<FallenTrunkPlacer> CODEC = codecBuilder(FallenTrunkPlacer::new);

  public FallenTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
    super(baseHeight, firstRandomHeight, secondRandomHeight);
  }

  @Override
  protected TrunkPlacerType<?> func_230381_a_() {
    return ModFeatures.FALLEN_TRUNK_PLACER;
  }
}
