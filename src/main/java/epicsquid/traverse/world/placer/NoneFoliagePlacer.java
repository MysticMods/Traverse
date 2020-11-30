package epicsquid.traverse.world.placer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import epicsquid.traverse.init.ModFeatures;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;

import java.util.Random;
import java.util.Set;

public class NoneFoliagePlacer extends FoliagePlacer {
  public static final Codec<NoneFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) -> func_242830_b(instance).apply(instance, (uniformIntDistribution, uniformIntDistribution2) -> new NoneFoliagePlacer()));

  public NoneFoliagePlacer() {
    super(FeatureSpread.func_242253_a(0, 0), FeatureSpread.func_242253_a(0, 0));
  }

  @Override
  protected FoliagePlacerType<?> func_230371_a_() {
    return ModFeatures.NONE_FOLIAGE_PLACER.get();
  }

  @Override
  protected void func_230372_a_(IWorldGenerationReader p_230372_1_, Random p_230372_2_, BaseTreeFeatureConfig p_230372_3_, int p_230372_4_, Foliage p_230372_5_, int p_230372_6_, int p_230372_7_, Set<BlockPos> p_230372_8_, int p_230372_9_, MutableBoundingBox p_230372_10_) {

  }

  @Override
  public int func_230374_a_(Random p_230374_1_, int p_230374_2_, BaseTreeFeatureConfig p_230374_3_) {
    return 0;
  }

  @Override
  protected boolean func_230373_a_(Random p_230373_1_, int p_230373_2_, int p_230373_3_, int p_230373_4_, int p_230373_5_, boolean p_230373_6_) {
    return false;
  }
}
