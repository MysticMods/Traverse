package epicsquid.traverse.world;

import epicsquid.traverse.world.feature.FirTreeFeature;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class FirTree extends Tree {

  @Nullable
  @Override
  protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
    return new FirTreeFeature(TreeFeatureConfig::deserialize, true);
  }
}
