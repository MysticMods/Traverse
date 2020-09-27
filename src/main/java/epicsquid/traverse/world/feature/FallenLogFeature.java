package epicsquid.traverse.world.feature;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class FallenLogFeature extends AbstractTreeFeature<FallenLogFeatureConfig> {
  public FallenLogFeature(Function<Dynamic<?>, FallenLogFeatureConfig> function) {
    super(function);
  }

  @Override
  protected boolean func_225557_a_(IWorldGenerationReader world, Random rand, BlockPos origin, Set<BlockPos> logs, Set<BlockPos> leaves, MutableBoundingBox box, FallenLogFeatureConfig config) {
    // Total log length
    int length = rand.nextInt(config.lengthRandom) + config.baseLength;

    // Axis
    Direction.Axis axis = rand.nextBoolean() ? Direction.Axis.X : Direction.Axis.Z;
    Direction direction = Direction.getFacingFromAxisDirection(axis, rand.nextBoolean() ? Direction.AxisDirection.POSITIVE : Direction.AxisDirection.NEGATIVE);

    BlockPos below = origin.down();
    if (!isSoilOrFarm(world, below, null)) {
      return false;
    }

    BlockPos.Mutable pos = new BlockPos.Mutable(origin);

    int air = 0;
    for (int i = 0; i < length; i++) {
      pos.move(direction);

      if (!world.hasBlockState(pos.move(Direction.DOWN), BlockState::isSolid)) {
        air++;
      }

      if (!isAirOrLeaves(world, pos.move(Direction.UP))) {
        return false;
      }
    }

    // No floating logs
    if (air * 2 > length) {
      return false;
    }

    pos.setPos(origin);
    for (int i = 0; i < length; i++) {
      pos.move(direction);

      BlockState log = config.trunkProvider.getBlockState(rand, pos);

      if (isAirOrLeaves(world, pos) || func_214587_a(world, pos) || isWater(world, pos)) {
        func_227217_a_(world, pos, log.with(LogBlock.AXIS, axis), box);
        logs.add(pos.toImmutable());
      }

      pos.move(Direction.DOWN);

      if (isSoilOrFarm(world, pos, null)) {
        func_227217_a_(world, pos, Blocks.DIRT.getDefaultState(), box);
      }

      pos.move(Direction.UP);
    }

    return true;
  }
}
