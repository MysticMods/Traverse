package epicsquid.traverse.world.surfacebuilder;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class SandWithPatchesSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	private final double threshold;

	public SandWithPatchesSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> function, double threshold) {
		super(function);
		this.threshold = threshold;
	}

	@Override
	public void buildSurface(Random random, IChunk chunk, Biome biome, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		if (noise > threshold) {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunk, biome, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
		} else {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunk, biome, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, SurfaceBuilder.SAND_CONFIG);
		}
	}
}
