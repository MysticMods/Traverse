package epicsquid.traverse.world.surfacebuilder;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.DoubleFunction;

public class BeachSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
  private static final BlockState STONE = Blocks.STONE.getDefaultState();
  private final BlockState WATER;
  private int seaLevel;
  private DoubleFunction<BlockState> sand;

  public BeachSurfaceBuilder(Codec<SurfaceBuilderConfig> codec, int seaLevel, DoubleFunction<BlockState> sand) {
    super(codec);
    this.WATER = Blocks.WATER.getDefaultState();
    this.seaLevel = seaLevel;
    this.sand = sand;
  }

  public void buildSurface(Random rand, IChunk chunk, Biome biome, int x, int z, int height, double noiseVal, BlockState var9, BlockState var10, int var11, long seed, SurfaceBuilderConfig config) {
    int localX = x & 15;
    int localZ = z & 15;
    BlockState chosenSand = this.sand.apply(noiseVal);
    int thickness = (int) (noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
    int run = 0;
    boolean beach = false;
    boolean underwater = false;
    Mutable pos = new Mutable(localX, 0, localZ);

    for (int y = height; y >= 0; --y) {
      pos.move(localX, y, localZ);
      BlockState chunkBlock = chunk.getBlockState(pos);
      if (chunkBlock == STONE && y < 255) {
        BlockState toSet = STONE;
        if (chunk.getBlockState(pos.up()).isAir()) {
          beach = y < this.seaLevel + 3;
          toSet = beach ? chosenSand : config.getTop();
        } else if (chunk.getBlockState(pos.up()) == this.WATER || run < thickness && underwater) {
          underwater = true;
          if (y > this.seaLevel - 3) {
            beach = true;
            toSet = chosenSand;
          } else {
            toSet = config.getUnderWaterMaterial();
          }
        } else if (y > this.seaLevel - 3) {
          if (beach) {
            toSet = chosenSand;
          } else if (run < thickness) {
            toSet = config.getUnder();
          }
        }

        chunk.setBlockState(pos, toSet, false);
        ++run;
      } else {
        run = 0;
        beach = false;
        underwater = false;
      }
    }
  }
}

