package epicsquid.traverse.biome;

<<<<<<< HEAD
import epicsquid.traverse.world.feature.ModFeatures;
=======
import com.google.common.collect.ImmutableList;
import epicsquid.traverse.blocks.ModBlocks;
import net.minecraft.block.Block;
>>>>>>> 37ae567... Disable features, fix incorrect translation key.
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;

public class TraverseDefaultBiomeFeatures {

<<<<<<< HEAD
=======
  public static final BlockClusterFeatureConfig LUSH_FLOWER_CONFIG;
  public static final TreeFeatureConfig RED_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.DARK_OAK_LOG, ModBlocks.RED_AUTUMNAL_LEAVES);
  public static final TreeFeatureConfig ORANGE_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.OAK_LOG, ModBlocks.ORANGE_AUTUMNAL_LEAVES);
  public static final TreeFeatureConfig YELLOW_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.BIRCH_LOG, ModBlocks.YELLOW_AUTUMNAL_LEAVES);
  public static final TreeFeatureConfig BROWN_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.DARK_OAK_LOG, ModBlocks.BROWN_AUTUMNAL_LEAVES);
  public static final TreeFeatureConfig FIR_TREE_CONFIG = new TreeFeatureConfig.Builder(
      new SimpleBlockStateProvider(ModBlocks.FIR_LOG.getDefaultState()),
      new SimpleBlockStateProvider(ModBlocks.FIR_LEAVES.getDefaultState()),
      new SpruceFoliagePlacer(2, 1)
  ).baseHeight(15).heightRandA(15).trunkHeight(1).trunkHeightRandom(4).trunkTopOffsetRandom(2).ignoreVines().build();

  public static final TreeFeatureConfig TALL_SWAMP_TREE_CONFIG = new TreeFeatureConfig.Builder(
      new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
      new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
      new BlobFoliagePlacer(3, 0)
  ).baseHeight(7).heightRandA(3).foliageHeight(3).maxWaterDepth(1).decorators(ImmutableList.of(new LeaveVineTreeDecorator())).build();

  /*  public static final FallenLogFeatureConfig FALLEN_OAK_TREE = new FallenLogFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState())).baseLength(4).lengthRandom(3).build();*/

  private static TreeFeatureConfig oakLike(Block trunk, Block leaves) {
    return new TreeFeatureConfig.Builder(
        new SimpleBlockStateProvider(trunk.getDefaultState()),
        new SimpleBlockStateProvider(leaves.getDefaultState()),
        new BlobFoliagePlacer(2, 0)
    ).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().build();
  }

  static {
    WeightedBlockStateProvider provider = new WeightedBlockStateProvider();

    provider.func_227407_a_(Blocks.POPPY.getDefaultState(), 12);
    provider.func_227407_a_(Blocks.AZURE_BLUET.getDefaultState(), 12);
    provider.func_227407_a_(Blocks.OXEYE_DAISY.getDefaultState(), 12);
    provider.func_227407_a_(Blocks.DANDELION.getDefaultState(), 8);
    provider.func_227407_a_(Blocks.ORANGE_TULIP.getDefaultState(), 1);
    provider.func_227407_a_(Blocks.PINK_TULIP.getDefaultState(), 1);
    provider.func_227407_a_(Blocks.RED_TULIP.getDefaultState(), 1);
    provider.func_227407_a_(Blocks.WHITE_TULIP.getDefaultState(), 1);

    BlockClusterFeatureConfig.Builder lushGrassBuilder = new BlockClusterFeatureConfig.Builder(provider, new SimpleBlockPlacer());
    LUSH_FLOWER_CONFIG = lushGrassBuilder.tries(64).func_227317_b_().build();
  }

>>>>>>> 37ae567... Disable features, fix incorrect translation key.
  public static void addShrubs(Biome biome, int count) {
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(ModFeatures.OAK_SHRUB, DecoratedFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(0, 0.5F, count)));
  }

  public static void addAutumnalWoodsTrees(Biome biome) {
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(
        new Feature[]{ModFeatures.RED_AUTUMNAL_TREE, ModFeatures.BROWN_AUTUMNAL_TREE, ModFeatures.ORANGE_AUTUMNAL_TREE, ModFeatures.YELLOW_AUTUMNAL_TREE},
        new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG.NO_FEATURE_CONFIG},
        new float[]{0.25F, 0.25F, 0.25F, 0.25F},
        Feature.NORMAL_TREE, DecoratedFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(10, 0.1F, 1)));
  }

  public static void addCliffsMineables(Biome biome) {
    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.DIRT.getDefaultState(), 33), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 70)));
    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GRAVEL.getDefaultState(), 33), Placement.COUNT_RANGE, new CountRangeConfig(8, 0, 0, 70)));
    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GRANITE.getDefaultState(), 33), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 70)));
    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.DIORITE.getDefaultState(), 33), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 70)));
    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.ANDESITE.getDefaultState(), 33), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 70)));
  }

  public static void addConiferousForestTrees(Biome biome) {
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(ModFeatures.FIR_TREE, DecoratedFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(7, 0.1F, 1)));
  }

  public static void addDesertShrublandFeatures(Biome biome) {
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(ModFeatures.OAK_SHRUB, DecoratedFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(2, 0.1F, 1)));
  }

  public static void addRollingHillsVegetation(Biome biome) {
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(ModFeatures.LUSH_FLOWER, DecoratedFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(5)));
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.GRASS, new GrassFeatureConfig(Blocks.GRASS.getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(15)));
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.NORMAL_TREE, DecoratedFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(2, 0.2F, 1)));
  }

  public static void addLushSwampVegetation(Biome biome) {
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome
        .createDecoratedFeature(ModFeatures.TALL_SWAMP_TREE, DecoratedFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(2, 0.1F, 1)));
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.SWAMP_FLOWER, DecoratedFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(1)));
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.GRASS, new GrassFeatureConfig(Blocks.GRASS.getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(5)));
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.DEAD_BUSH, DecoratedFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(1)));
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.WATERLILY, DecoratedFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(4)));
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(Blocks.BROWN_MUSHROOM.getDefaultState()), Placement.COUNT_CHANCE_HEIGHTMAP, new HeightWithChanceConfig(8, 0.25F)));
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(Blocks.RED_MUSHROOM.getDefaultState()), Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE, new HeightWithChanceConfig(8, 0.125F)));
  }

  public static void addMeadowVegetation(Biome biome) {
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.GRASS, new GrassFeatureConfig(Blocks.GRASS.getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(15)));
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(ModFeatures.LUSH_FLOWER, DecoratedFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(10)));
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.NORMAL_TREE, DecoratedFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(0, 0.2F, 1)));
  }

  public static void addMiniJungleVegetation(Biome biome) {
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(
        new Feature[]{Feature.FANCY_TREE},
        new IFeatureConfig[]{DecoratedFeatureConfig.NO_FEATURE_CONFIG},
        new float[]{0.1F},
        ModFeatures.MINI_JUNGLE_TREE, DecoratedFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(50, 0.1F, 1)));
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.WATERLILY, DecoratedFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(4)));
  }

  public static void addRockyEdgeFeatures(Biome biome) {
    biome.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(Feature.FOREST_ROCK, new BlockBlobConfig(Blocks.COBBLESTONE.getDefaultState(), 1), Placement.CHANCE_HEIGHTMAP, new ChanceConfig(5)));
  }

  public static void addWoodlandsTrees(Biome biome, int count) {
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(
        new Feature[]{ModFeatures.OAK_SHRUB, ModFeatures.FALLEN_OAK_TREE},
        new IFeatureConfig[]{DecoratedFeatureConfig.NO_FEATURE_CONFIG, DecoratedFeatureConfig.NO_FEATURE_CONFIG},
        new float[]{0.2F, 0.3F},
        Feature.NORMAL_TREE, DecoratedFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_HEIGHTMAP, new FrequencyConfig(count)));
  }
}
