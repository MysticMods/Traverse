package epicsquid.traverse.world;

import java.util.Random;

import javax.annotation.Nullable;

import epicsquid.traverse.world.feature.FirTreeFeature;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class FirTree extends Tree {

	@Nullable
	@Override
	public AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
		return new FirTreeFeature(NoFeatureConfig::deserialize, true);
	}
}
