package epicsquid.traverse.world.surfacebuilder;

import java.util.Random;
import java.util.function.DoubleFunction;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class BeachSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	protected int seaLevel;
	private DoubleFunction<BlockState> sand;

	protected final BlockState WATER = Blocks.WATER.getDefaultState();

	public BeachSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> function, int seaLevel, DoubleFunction<BlockState> sand) {
		super(function);
		this.seaLevel = seaLevel;
		this.sand = sand;
	}

	@Override
	public void buildSurface(Random rand, IChunk chunk, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		int localX = x & 15;
		int localZ = z & 15;

		BlockState chosenSand = sand.apply(noise);
		int thickness = (int) (noise / 3.0D + 3.0D + rand.nextDouble() * 0.25D);

		int run = 0;
		boolean beach = false;
		boolean underwater = false;

		BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(localX, 0, localZ);

		for (int y = startHeight; y >= 0; --y) {
			pos.setPos(localX, y, localZ);
			BlockState chunkBlock = chunk.getBlockState(pos);

			if (chunkBlock == STONE && y < 255) {
				BlockState toSet = STONE;

				if (chunk.getBlockState(pos.up()).isAir()) {
					beach = y < seaLevel + 3;
					toSet = beach ? chosenSand : config.getTop();
				} else if (chunk.getBlockState(pos.up()) == WATER || run < thickness && underwater) {
					underwater = true;

					if (y > seaLevel - 3) {
						beach = true;
						toSet = chosenSand;
					} else {
						toSet = config.getUnderWaterMaterial();
					}
				} else if (y > seaLevel - 3) {
					if (beach) {
						toSet = chosenSand;
					} else if (run < thickness) {
						toSet = config.getUnder();
					}
				}

				chunk.setBlockState(pos, toSet, false);
				run++;

			} else {
				run = 0;
				beach = false;
				underwater = false;
			}
		}
	}
}
