package epicsquid.traverse.init;

import com.google.common.collect.ImmutableList;
import com.tterrag.registrate.util.entry.RegistryEntry;
import epicsquid.traverse.world.SupplierBlockStateProvider;
import epicsquid.traverse.world.placer.FallenTrunkPlacer;
import epicsquid.traverse.world.placer.NoneFoliagePlacer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BushFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class ModFeatureConfig {
  public static final BaseTreeFeatureConfig RED_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.DARK_OAK_LOG, ModBlocks.RED_AUTUMNAL_LEAVES, 4);
  public static final BaseTreeFeatureConfig ORANGE_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.OAK_LOG, ModBlocks.ORANGE_AUTUMNAL_LEAVES, 4);
  public static final BaseTreeFeatureConfig YELLOW_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.BIRCH_LOG, ModBlocks.YELLOW_AUTUMNAL_LEAVES, 6);
  public static final BaseTreeFeatureConfig BROWN_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.OAK_LOG, ModBlocks.BROWN_AUTUMNAL_LEAVES, 4);
  public static final BaseTreeFeatureConfig FIR_TREE_CONFIG = new BaseTreeFeatureConfig.Builder(
      new SupplierBlockStateProvider(ModBlocks.FIR_LOG.getId()),
      new SupplierBlockStateProvider(ModBlocks.FIR_LEAVES.getId()),
      new SpruceFoliagePlacer(FeatureSpread.func_242253_a(2, 1), FeatureSpread.func_242253_a(0, 2), FeatureSpread.func_242253_a(5, 3)),
      new StraightTrunkPlacer(15, 15, 4),
      new TwoLayerFeature(2, 0, 2)
  ).setIgnoreVines().build();
  public static final BaseTreeFeatureConfig TALL_SWAMP_TREE_CONFIG = new BaseTreeFeatureConfig.Builder(
      new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
      new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
      new BlobFoliagePlacer(FeatureSpread.func_242253_a(3, 0), FeatureSpread.func_242253_a(0, 0), 3),
      new StraightTrunkPlacer(7, 3, 0),
      new TwoLayerFeature(1, 0, 1)
  ).setMaxWaterDepth(1).setDecorators(ImmutableList.of(new LeaveVineTreeDecorator())).build();
  public static final BaseTreeFeatureConfig OAK_SHRUB_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()), new BushFoliagePlacer(FeatureSpread.func_242253_a(2, 0), FeatureSpread.func_242253_a(1, 0), 2), new StraightTrunkPlacer(1, 0, 0), new TwoLayerFeature(0, 0, 0))).func_236702_a_(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build();
  public static final BaseTreeFeatureConfig FALLEN_OAK_TREE_CONFIG = new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()), new NoneFoliagePlacer(), new FallenTrunkPlacer(3, 2, 0), new TwoLayerFeature(0, 0, 0)).build();
  public static final BlockClusterFeatureConfig LUSH_FLOWER_CONFIG;

  private static BaseTreeFeatureConfig oakLike(Block trunk, RegistryEntry<? extends Block> leaves, int height) {
    return new BaseTreeFeatureConfig.Builder(
        new SimpleBlockStateProvider(trunk.getDefaultState()),
        new SupplierBlockStateProvider(leaves.getId()),
        new BlobFoliagePlacer(FeatureSpread.func_242253_a(2, 0), FeatureSpread.func_242253_a(0, 0), 3),
        new StraightTrunkPlacer(height, 2, 0),
        new TwoLayerFeature(1, 0, 1)
    ).setIgnoreVines().build();
  }

  private static BaseTreeFeatureConfig oakLike(RegistryEntry<? extends Block> trunk, RegistryEntry<? extends Block> leaves, int height) {
    return new BaseTreeFeatureConfig.Builder(
        new SupplierBlockStateProvider(trunk.getId()),
        new SupplierBlockStateProvider(leaves.getId()),
        new BlobFoliagePlacer(FeatureSpread.func_242253_a(2, 0), FeatureSpread.func_242253_a(0, 0), 3),
        new StraightTrunkPlacer(height, 2, 0),
        new TwoLayerFeature(1, 0, 1)
    ).setIgnoreVines().build();
  }

  static {
    { // Lush Flower Config
      WeightedBlockStateProvider flowers = new WeightedBlockStateProvider();

      flowers.addWeightedBlockstate(Blocks.POPPY.getDefaultState(), 12);
      flowers.addWeightedBlockstate(Blocks.AZURE_BLUET.getDefaultState(), 12);
      flowers.addWeightedBlockstate(Blocks.OXEYE_DAISY.getDefaultState(), 12);
      flowers.addWeightedBlockstate(Blocks.DANDELION.getDefaultState(), 8);
      flowers.addWeightedBlockstate(Blocks.ORANGE_TULIP.getDefaultState(), 1);
      flowers.addWeightedBlockstate(Blocks.PINK_TULIP.getDefaultState(), 1);
      flowers.addWeightedBlockstate(Blocks.RED_TULIP.getDefaultState(), 1);
      flowers.addWeightedBlockstate(Blocks.WHITE_TULIP.getDefaultState(), 1);

      LUSH_FLOWER_CONFIG = new BlockClusterFeatureConfig.Builder(flowers, new SimpleBlockPlacer()).tries(64).func_227317_b_().build();
    }
  }

}
