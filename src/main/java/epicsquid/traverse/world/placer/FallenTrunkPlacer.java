package epicsquid.traverse.world.placer;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import epicsquid.traverse.init.ModFeatures;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.TrunkPlacerType;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class FallenTrunkPlacer extends StraightTrunkPlacer {
  public static final Codec<FallenTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) -> func_236915_a_(instance).apply(instance, FallenTrunkPlacer::new));

  public FallenTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
    super(baseHeight, firstRandomHeight, secondRandomHeight);
  }

  @Override
  protected TrunkPlacerType<?> func_230381_a_() {
    return ModFeatures.FALLEN_TRUNK_PLACER;
  }

  @Override
  public List<FoliagePlacer.Foliage> func_230382_a_(IWorldGenerationReader world, Random random, int trunkHeight, BlockPos pos, Set<BlockPos> set, MutableBoundingBox blockBox, BaseTreeFeatureConfig treeFeatureConfig) {
    func_236909_a_(world, pos.down());

    // Axis
    Direction.Axis axis = random.nextBoolean() ? Direction.Axis.X : Direction.Axis.Z;
    Direction direction = Direction.getFacingFromAxisDirection(axis, random.nextBoolean() ? Direction.AxisDirection.POSITIVE : Direction.AxisDirection.NEGATIVE);

    for (int i = 0; i < trunkHeight; ++i) {
      placeTrunkBlock(world, random, pos.offset(direction, i), set, blockBox, treeFeatureConfig, axis);
    }

    return ImmutableList.of(new FoliagePlacer.Foliage(pos, 0, false));
  }

  protected static boolean placeTrunkBlock(IWorldGenerationReader modifiableTestableWorld, Random random, BlockPos blockPos, Set<BlockPos> set, MutableBoundingBox blockBox, BaseTreeFeatureConfig treeFeatureConfig, Direction.Axis axis) {
    if (TreeFeature.isReplaceableAt(modifiableTestableWorld, blockPos)) {
      func_236913_a_(modifiableTestableWorld, blockPos, treeFeatureConfig.trunkProvider.getBlockState(random, blockPos).with(RotatedPillarBlock.AXIS, axis), blockBox);
      set.add(blockPos.toImmutable());
      return true;
    } else {
      return false;
    }
  }
}
