package epicsquid.traverse.world.surfacebuilder;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class SandWithPatchesSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

  private final double threshold;

  public SandWithPatchesSurfaceBuilder(Codec<SurfaceBuilderConfig> codec, double threshold) {
    super(codec);
    this.threshold = threshold;
  }

  @Override
  public void buildSurface(Random random, IChunk chunk, Biome biome, int int_1, int int_2, int int_3, double noise, BlockState blockState_1, BlockState blockState_2, int int_4, long long_1, SurfaceBuilderConfig config) {
    if (noise > threshold) {
      SurfaceBuilder.DEFAULT.buildSurface(random, chunk, biome, int_1, int_2, int_3, noise, blockState_1, blockState_2, int_4, long_1, config);
    } else {
      SurfaceBuilder.DEFAULT.buildSurface(random, chunk, biome, int_1, int_2, int_3, noise, blockState_1, blockState_2, int_4, long_1, SurfaceBuilder.SAND_CONFIG);
    }
  }
}

