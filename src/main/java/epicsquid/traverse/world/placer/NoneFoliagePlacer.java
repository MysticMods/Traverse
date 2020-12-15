package epicsquid.traverse.world.placer;

import com.mojang.serialization.Codec;
import epicsquid.traverse.init.ModFeatures;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import noobanidus.libs.noobutil.world.gen.placer.AbstractNoneFoliagePlacer;

public class NoneFoliagePlacer extends AbstractNoneFoliagePlacer {
  public static Codec<NoneFoliagePlacer> CODEC = codecBuilder(NoneFoliagePlacer::new);

  private NoneFoliagePlacer(FeatureSpread a, FeatureSpread b) {
    super(a, b);
  }

  public NoneFoliagePlacer() {
    super();
  }

  @Override
  protected FoliagePlacerType<?> func_230371_a_() {
    return ModFeatures.NONE_FOLIAGE_PLACER.get();
  }
}
