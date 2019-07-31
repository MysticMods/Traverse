package epicsquid.traverse.world.feature;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class FallenLogFeature extends AbstractTreeFeature<NoFeatureConfig> {

	private final BlockState log;
	private final int minLength, variance;

	public FallenLogFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> function, boolean doBlockNofityOnPlace, BlockState log) {
		this(function, doBlockNofityOnPlace, log, 5, 8);
	}

	public FallenLogFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> function, boolean doBlockNofityOnPlace, BlockState log, int minLength, int variance) {
		super(function, doBlockNofityOnPlace);
		this.log = log;
		this.minLength = minLength;
		this.variance = variance;
	}

	@Override
	protected boolean place(Set<BlockPos> blocks, IWorldGenerationReader world, Random rand, BlockPos origin, MutableBoundingBox box) {
		// Total log length
		int length = rand.nextInt(variance) + minLength;

		// Axis
		Direction.Axis axis = rand.nextBoolean() ? Direction.Axis.X : Direction.Axis.Z;
		Direction direction = Direction.getFacingFromAxisDirection(axis, rand.nextBoolean() ? Direction.AxisDirection.POSITIVE : Direction.AxisDirection.NEGATIVE);

		BlockPos below = origin.down();
		if (!isDirtOrGrassBlock(world, below)) {
			return false;
		}

		BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(origin);

		int air = 0;
		for (int i = 0; i < length; i++) {
			pos.offset(direction);

			if (!world.hasBlockState(pos.offset(Direction.DOWN), BlockState::func_215691_g)) {
				air++;
			}

			if (!isAirOrLeaves(world, pos.offset(Direction.UP))) {
				return false;
			}
		}

		// No floating logs
		if (air * 2 > length) {
			return false;
		}

		pos.setPos(origin);
		for (int i = 0; i < length; i++) {
			pos.offset(direction);

			setLogState(blocks, world, pos, log.with(LogBlock.AXIS, axis), box);

			pos.offset(Direction.DOWN);

			if (isDirtOrGrassBlock(world, pos)) {
				setLogState(blocks, world, pos, Blocks.DIRT.getDefaultState(), box);
			}

			pos.offset(Direction.UP);
		}

		return true;
	}
}
