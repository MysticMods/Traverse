package epicsquid.traverse.world.placer;

import com.mojang.serialization.Codec;
import epicsquid.traverse.init.ModFeatures;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import noobanidus.libs.noobutil.world.gen.placer.AbstractNoneFoliagePlacer;

public class NoneFoliagePlacer extends AbstractNoneFoliagePlacer {
  public static final Codec<NoneFoliagePlacer> CODEC = codecBuilder(NoneFoliagePlacer::new);

  public NoneFoliagePlacer() {
    super();
  }

  private NoneFoliagePlacer(FeatureSpread p_i241999_1_, FeatureSpread p_i241999_2_) {
    super(p_i241999_1_, p_i241999_2_);
  }

  @Override
  protected FoliagePlacerType<?> func_230371_a_() {
    return ModFeatures.NONE_FOLIAGE_PLACER.get();
  }
}
