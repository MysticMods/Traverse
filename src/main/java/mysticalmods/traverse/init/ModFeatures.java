package mysticalmods.traverse.init;

import com.google.common.collect.ImmutableList;
import com.tterrag.registrate.util.entry.RegistryEntry;
import mysticalmods.traverse.Traverse;
import mysticalmods.traverse.world.SupplierBlockStateProvider;
import mysticalmods.traverse.world.placer.FallenTrunkPlacer;
import mysticalmods.traverse.world.placer.NoneFoliagePlacer;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.TrunkPlacerType;

import static mysticalmods.traverse.Traverse.REGISTRATE;

@SuppressWarnings("unchecked")
public class ModFeatures {
  public static final TrunkPlacerType<FallenTrunkPlacer> FALLEN_TRUNK_PLACER = Registry.register(Registry.TRUNK_REPLACER, "fallen_trunk_placer", new TrunkPlacerType<>(FallenTrunkPlacer.CODEC));
  public static final RegistryEntry<FoliagePlacerType<NoneFoliagePlacer>> NONE_FOLIAGE_PLACER = REGISTRATE.simple("none_foliage_placer", FoliagePlacerType.class, () -> new FoliagePlacerType<>(NoneFoliagePlacer.CODEC));

  public static final RegistryEntry<BlockStateProviderType<SupplierBlockStateProvider>> SUPPLIER_STATE_PROVIDER = REGISTRATE.simple("supplier_state_provider", BlockStateProviderType.class, () -> new BlockStateProviderType<>(SupplierBlockStateProvider.CODEC));

  /* Shrubs */
  public static final ConfiguredFeature<?, ?> OAK_SHRUB = register("oak_shrub", Feature.TREE.withConfiguration(ModFeatureConfig.OAK_SHRUB_CONFIG));
  public static final ConfiguredFeature<?, ?> ARID_SHRUBS = register("arid_shrubs", OAK_SHRUB.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.5F, 1))));
  public static final ConfiguredFeature<?, ?> DESERT_SHRUBS = register("desert_shrubs", OAK_SHRUB.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));

  /* Autumnal Trees */
  public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> RED_AUTUMNAL_TREE = (ConfiguredFeature<BaseTreeFeatureConfig, ?>) register("red_autumnal_tree", Feature.TREE.withConfiguration(ModFeatureConfig.RED_AUTUMNAL_TREE_CONFIG));
  public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ORANGE_AUTUMNAL_TREE = (ConfiguredFeature<BaseTreeFeatureConfig, ?>) register("orange_autumnal_tree", Feature.TREE.withConfiguration(ModFeatureConfig.ORANGE_AUTUMNAL_TREE_CONFIG));
  public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> YELLOW_AUTUMNAL_TREE = (ConfiguredFeature<BaseTreeFeatureConfig, ?>) register("yellow_autumnal_tree", Feature.TREE.withConfiguration(ModFeatureConfig.YELLOW_AUTUMNAL_TREE_CONFIG));
  public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BROWN_AUTUMNAL_TREE = (ConfiguredFeature<BaseTreeFeatureConfig, ?>) register("brown_autumnal_tree", Feature.TREE.withConfiguration(ModFeatureConfig.BROWN_AUTUMNAL_TREE_CONFIG));
  public static final ConfiguredFeature<?, ?> AUTUMNAL_TREES = register("autumnal_trees",
      Feature.RANDOM_SELECTOR.withConfiguration(
          new MultipleRandomFeatureConfig(
              ImmutableList.of(
                  RED_AUTUMNAL_TREE.withChance(0.25F),
                  ORANGE_AUTUMNAL_TREE.withChance(0.25F),
                  YELLOW_AUTUMNAL_TREE.withChance(0.25F),
                  BROWN_AUTUMNAL_TREE.withChance(0.25F)
              ), Features.OAK
          )
      ).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
          .withPlacement(Placement.COUNT_EXTRA.configure(
              new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

  /* Low Ores */
  public static final ConfiguredFeature<?, ?> LOW_DIRT = register("low_dirt", ((Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, Blocks.DIRT.getDefaultState(), 33)).range(70)).square()).func_242731_b(10));
  public static final ConfiguredFeature<?, ?> LOW_GRAVEL = register("low_gravel", ((Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, Blocks.GRAVEL.getDefaultState(), 33)).range(70)).square()).func_242731_b(8));
  public static final ConfiguredFeature<?, ?> LOW_GRANITE = register("low_granite", ((Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, Blocks.GRANITE.getDefaultState(), 33)).range(70)).square()).func_242731_b(10));
  public static final ConfiguredFeature<?, ?> LOW_DIORITE = register("low_diorite", ((Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, Blocks.DIORITE.getDefaultState(), 33)).range(70)).square()).func_242731_b(10));
  public static final ConfiguredFeature<?, ?> LOW_ANDESITE = register("low_andesite", ((Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, Blocks.ANDESITE.getDefaultState(), 33)).range(70)).square()).func_242731_b(10));

  /* Fir Trees */
  public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FIR_TREE = (ConfiguredFeature<BaseTreeFeatureConfig, ?>) register("fir_tree", Feature.TREE.withConfiguration(ModFeatureConfig.FIR_TREE_CONFIG));
  public static final ConfiguredFeature<?, ?> CONIFEROUS_TREES = register("coniferous_trees", FIR_TREE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(7, 0.1F, 1))));

  /* Swamp Trees */
  public static final ConfiguredFeature<?, ?> TALL_SWAMP_TREE = register("tall_swamp_tree", Feature.TREE.withConfiguration(ModFeatureConfig.TALL_SWAMP_TREE_CONFIG));
  public static final ConfiguredFeature<?, ?> LUSH_SWAMP_TREES = register("lush_swamp_trees", TALL_SWAMP_TREE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));

  /* Lush Vegetation */
  public static final ConfiguredFeature<?, ?> LUSH_FLOWERS = register("lush_flowers", Feature.FLOWER.withConfiguration(ModFeatureConfig.LUSH_FLOWER_CONFIG).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(10));
  public static final ConfiguredFeature<?, ?> MEADOW_GRASS = register("meadow_grass", Feature.RANDOM_PATCH.withConfiguration(Features.Configs.GRASS_PATCH_CONFIG).withPlacement(Features.Placements.HEIGHTMAP_SPREAD_DOUBLE_PLACEMENT).func_242731_b(15));
  public static final ConfiguredFeature<?, ?> MEADOW_TREES = register("meadow_trees", Features.OAK_BEES_005.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.2F, 1))));
  public static final ConfiguredFeature<?, ?> ROLLING_HILLS_GRASS = register("rolling_hills_grass", Feature.RANDOM_PATCH.withConfiguration(Features.Configs.GRASS_PATCH_CONFIG).withPlacement(Features.Placements.HEIGHTMAP_SPREAD_DOUBLE_PLACEMENT).func_242731_b(3));
  public static final ConfiguredFeature<?, ?> ROLLING_HILLS_TREES = register("rolling_hills_trees", Features.OAK_BEES_005.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.2F, 1))));

  /* Mini Jungle */
  public static final ConfiguredFeature<?, ?> MINI_JUNGLE_SEAGRASS = register("mini_jungle_seagrass", Features.SEAGRASS_SWAMP.withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
  public static final ConfiguredFeature<?, ?> MINI_JUNGLE_TREES = register("mini_jungle_trees", Feature.RANDOM_SELECTOR.withConfiguration(
      new MultipleRandomFeatureConfig(
          ImmutableList.of(Features.FANCY_OAK.withChance(0.1F)),
          Features.JUNGLE_TREE
      ))
      .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
      .withPlacement(Placement.COUNT_EXTRA.configure(
          new AtSurfaceWithExtraConfig(50, 0.1F, 1))));

  /* Rocky Edge */
  public static final ConfiguredFeature<?, ?> ROCKY_EDGE_BOULDER = register("rocky_edge_boulder", Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(Blocks.COBBLESTONE.getDefaultState())).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242732_c(2));

  /* Woodlands */
  public static final ConfiguredFeature<?, ?> WOODLANDS_TREES = register("woodlands_trees", Feature.RANDOM_SELECTOR.withConfiguration(
      new MultipleRandomFeatureConfig(
          ImmutableList.of(
              Feature.TREE.withConfiguration(ModFeatureConfig.OAK_SHRUB_CONFIG).withChance(0.2F),
              Feature.TREE.withConfiguration(ModFeatureConfig.FALLEN_OAK_TREE_CONFIG).withChance(0.3F)
          ), Features.OAK))
      .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
      .withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(7))));

  private static ConfiguredFeature<?, ?> register(String id, ConfiguredFeature<?, ?> feature) {
    return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(Traverse.MODID, id), feature);
  }

  public static void load() {
  }
}
