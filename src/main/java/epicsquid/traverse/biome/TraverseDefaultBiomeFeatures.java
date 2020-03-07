package epicsquid.traverse.biome;

import com.google.common.collect.ImmutableList;
import epicsquid.traverse.RegistryManager;
import epicsquid.traverse.blocks.ModBlocks;
import epicsquid.traverse.world.feature.ModFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.*;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.treedecorator.CocoaTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;

public class TraverseDefaultBiomeFeatures {
  public static void addShrubs(Biome biome, int count) {
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.OAK_SHRUB.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.5F, count))));
  }

  public static void addAutumnalWoodsTrees(Biome biome) {
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(
        new Feature[]{ModFeatures.RED_AUTUMNAL_TREE, ModFeatures.BROWN_AUTUMNAL_TREE, ModFeatures.ORANGE_AUTUMNAL_TREE, ModFeatures.YELLOW_AUTUMNAL_TREE},
        new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG.NO_FEATURE_CONFIG},
        new float[]{0.25F, 0.25F, 0.25F, 0.25F},
        Feature.NORMAL_TREE, DecoratedFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(10, 0.1F, 1)));
  }

  public static void addCliffsMineables(Biome biome) {
    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.DIRT.getDefaultState(), 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 70))));
    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GRAVEL.getDefaultState(), 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 70))));
    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GRANITE.getDefaultState(), 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 70))));
    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.DIORITE.getDefaultState(), 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 70))));
    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.ANDESITE.getDefaultState(), 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 70))));
  }

  public static void addConiferousForestTrees(Biome biome) {
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.FIR_TREE.withConfiguration().withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(7, 0.1F, 1))));
  }

  public static void addDesertShrublandFeatures(Biome biome) {
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(ModFeatures.OAK_SHRUB, DecoratedFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(2, 0.1F, 1)));
  }

  public static void addRollingHillsVegetation(Biome biome) {
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.LUSH_FLOWER.withConfiguration(DecoratedFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(5))));
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG));
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(2, 0.2F, 1))));
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
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(), new MultipleRandomFeatureConfig(
        new Feature[]{Feature.FANCY_TREE},
        new IFeatureConfig[]{DecoratedFeatureConfig.NO_FEATURE_CONFIG},
        new float[]{0.1F},
        ModFeatures.MINI_JUNGLE_TREE, DecoratedFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(50, 0.1F, 1)));
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.LILY_PAD_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(4))));
  }

  public static void addRockyEdgeFeatures(Biome biome) {
    biome.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig(Blocks.COBBLESTONE.getDefaultState(), 1)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(5))));
  }

  public static void addWoodlandsTrees(Biome biome, int count) {
    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(ModFeatures.OAK_SHRUB.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_227227_a_(0.2f), ModFeatures.FALLEN_OAK_TREE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_227227_a_(0.3f), Feature.NORMAL_TREE.withConfiguration(TreeFeatureConfig.).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(count, 0.1f, 1)))))));
  }
}
