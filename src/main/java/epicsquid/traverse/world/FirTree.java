package epicsquid.traverse.world;

import epicsquid.traverse.world.feature.FirTreeFeature;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class FirTree extends Tree {

  @Nullable
  @Override
  public AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
    return new FirTreeFeature(NoFeatureConfig::deserialize, true);
  }
}
