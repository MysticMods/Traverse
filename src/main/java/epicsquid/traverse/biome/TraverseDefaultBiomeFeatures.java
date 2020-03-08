package epicsquid.traverse.biome;

import com.google.common.collect.ImmutableList;
import epicsquid.traverse.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.placement.*;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;

public class TraverseDefaultBiomeFeatures {

	public static final BlockClusterFeatureConfig LUSH_FLOWER_CONFIG;
	public static final TreeFeatureConfig RED_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.DARK_OAK_LOG, ModBlocks.RED_AUTUMNAL_LEAVES);
	public static final TreeFeatureConfig ORANGE_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.OAK_LOG, ModBlocks.ORANGE_AUTUMNAL_LEAVES);
	public static final TreeFeatureConfig YELLOW_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.BIRCH_LOG, ModBlocks.YELLOW_AUTUMNAL_LEAVES);
	public static final TreeFeatureConfig BROWN_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.DARK_OAK_LOG, ModBlocks.BROWN_AUTUMNAL_LEAVES);
	public static final TreeFeatureConfig FIR_TREE_CONFIG = new TreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(ModBlocks.FIR_LOG.getDefaultState()),
					new SimpleBlockStateProvider(ModBlocks.FIR_LEAVES.getDefaultState()),
					new SpruceFoliagePlacer(2, 1)
	).baseHeight(15).heightRandA(2).foliageHeight(3).ignoreVines().build();

	public static final TreeFeatureConfig TALL_SWAMP_TREE_CONFIG = new TreeFeatureConfig.Builder (
					new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
					new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
					new BlobFoliagePlacer(3, 0)
	).baseHeight(7).heightRandA(3).foliageHeight(3).maxWaterDepth(1).decorators(ImmutableList.of(new LeaveVineTreeDecorator())).build();

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

	public static void addShrubs(Biome biome, int count) {
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.JUNGLE_GROUND_BUSH.withConfiguration(new TreeFeatureConfig.Builder(
						new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()), new BlobFoliagePlacer(2, 0)).build())
						.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.5F, count))));
	}

	public static void addAutumnalWoodsTrees(Biome biome) {
		biome.addFeature(
						GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(
										ImmutableList.of(
														Feature.NORMAL_TREE.withConfiguration(RED_AUTUMNAL_TREE_CONFIG).func_227227_a_(0.25F),
														Feature.NORMAL_TREE.withConfiguration(ORANGE_AUTUMNAL_TREE_CONFIG).func_227227_a_(0.25F),
														Feature.NORMAL_TREE.withConfiguration(YELLOW_AUTUMNAL_TREE_CONFIG).func_227227_a_(0.25F),
														Feature.NORMAL_TREE.withConfiguration(BROWN_AUTUMNAL_TREE_CONFIG).func_227227_a_(0.25F)
										),
										Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG)))
										.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	}

	public static void addCliffsMineables(Biome biome) {
		biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.DIRT.getDefaultState(), 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 70))));
		biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GRAVEL.getDefaultState(), 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 70))));
		biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GRANITE.getDefaultState(), 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 70))));
		biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.DIORITE.getDefaultState(), 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 70))));
		biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.ANDESITE.getDefaultState(), 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 70))));
	}

	public static void addConiferousForestTrees(Biome biome) {
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(FIR_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(7, 0.1F, 1))));
	}

	public static void addDesertShrublandFeatures(Biome biome) {
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.JUNGLE_GROUND_BUSH.withConfiguration(new TreeFeatureConfig.Builder(
						new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()), new BlobFoliagePlacer(2, 0)).build())
						.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.JUNGLE_GROUND_BUSH.withConfiguration(new TreeFeatureConfig.Builder(
						new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()), new BlobFoliagePlacer(2, 0)).build())
						.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));
	}

	public static void addRollingHillsVegetation(Biome biome) {
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(LUSH_FLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(5))));
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG));
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(2, 0.2F, 1))));
	}

	public static void addLushSwampVegetation(Biome biome) {
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(TALL_SWAMP_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DefaultBiomeFeatures.BLUE_ORCHID_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(1))));
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(5))));
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.DEAD_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.LILY_PAD_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(4))));
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(8, 0.25F))));
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.RED_MUSHROOM_CONFIG).withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE.configure(new HeightWithChanceConfig(8, 0.125F))));
	}

	public static void addMeadowVegetation(Biome biome) {
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(15))));
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(LUSH_FLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(10))));
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.2F, 1))));
	}

	public static void addMiniJungleVegetation(Biome biome) {
		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(
						ImmutableList.of( Feature.FANCY_TREE.withConfiguration(
										DefaultBiomeFeatures.FANCY_TREE_CONFIG).func_227227_a_(0.1F)),
						Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.JUNGLE_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(50, 0.1F, 1))));

		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.BLUE_ORCHID_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(4))));
	}

	public static void addRockyEdgeFeatures(Biome biome) {
		biome.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig(Blocks.COBBLESTONE.getDefaultState(), 1)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(5))));
	}

	public static void addWoodlandsTrees(Biome biome, int count) {
//		biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(ModFeatures.OAK_SHRUB.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_227227_a_(0.2f), ModFeatures.FALLEN_OAK_TREE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).func_227227_a_(0.3f), Feature.NORMAL_TREE.withConfiguration(TreeFeatureConfig.).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(count, 0.1f, 1)))))));
	}
}
