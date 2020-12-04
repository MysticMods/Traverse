package epicsquid.traverse.biomebuilder;

import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;

import java.util.function.Consumer;

public enum DefaultFeature {
  LAND_CARVERS("land_carvers", DefaultBiomeFeatures::withCavesAndCanyons),
  OCEAN_CARVERS("ocean_carvers", DefaultBiomeFeatures::withOceanCavesAndCanyons),
  DEFAULT_UNDERGROUND_STRUCTURES("default_underground_structures", DefaultBiomeFeatures::withStrongholdAndMineshaft),
  OCEAN_STRUCTURES("ocean_structures", DefaultBiomeFeatures::withOceanStructures),
  BADLANDS_UNDERGROUND_STRUCTURES("badlands_underground_structures", DefaultBiomeFeatures::withBadlandsStructures),
  LAKES("lakes", DefaultBiomeFeatures::withLavaAndWaterLakes),
  DESERT_LAKES("desert_lakes", DefaultBiomeFeatures::withLavaLakes),
  DUNGEONS("dungeons", DefaultBiomeFeatures::withMonsterRoom),
  MINEABLES("mineables", DefaultBiomeFeatures::withCommonOverworldBlocks),
  ORES("ores", DefaultBiomeFeatures::withOverworldOres),
  EXTRA_GOLD("extra_gold", DefaultBiomeFeatures::withExtraGoldOre),
  EMERALD_ORE("emerald_ore", DefaultBiomeFeatures::withEmeraldOre),
  INFECTED_STONE("infected_stone", DefaultBiomeFeatures::withInfestedStone),
  DISKS("disks", DefaultBiomeFeatures::withDisks),
  CLAY("clay", DefaultBiomeFeatures::withClayDisks),
  MOSSY_ROCKS("mossy_rocks", DefaultBiomeFeatures::withForestRocks),
  LARGE_FERNS("large_ferns", DefaultBiomeFeatures::withLargeFern),
  SWEET_BERRY_BUSHES("sweet_berry_bushes", DefaultBiomeFeatures::withChanceBerries),
  SWEET_BERRY_BUSHES_SNOWY("sweet_berry_bushes_snowy", DefaultBiomeFeatures::withSparseBerries),
  BAMBOO("bamboo", DefaultBiomeFeatures::withLightBambooVegetation),
  BAMBOO_JUNGLE_TREES("bamboo jungle trees", DefaultBiomeFeatures::withBambooVegetation),
  TAIGA_TREES("taiga_trees", DefaultBiomeFeatures::withTaigaVegetation),
  WATER_BIOME_OAK_TREES("water_biome_oak_trees", DefaultBiomeFeatures::withTreesInWater),
  BIRCH_TREES("birch_trees", DefaultBiomeFeatures::withBirchTrees),
  FOREST_TREES("forest_trees", DefaultBiomeFeatures::withForestBirchTrees),
  TALL_BIRCH_TREES("tall_birch_trees", DefaultBiomeFeatures::withTallBirches),
  SAVANNA_TREES("savannah_trees", DefaultBiomeFeatures::withSavannaTrees),
  EXTRA_SAVANNA_TREES("extra_savannah_trees", DefaultBiomeFeatures::withShatteredSavannaTrees),
  MOUNTAIN_TREES("mountain_trees", DefaultBiomeFeatures::withMountainTrees),
  EXTRA_MOUNTAIN_TREES("extra_mountain_trees", DefaultBiomeFeatures::withMountainEdgeTrees),
  JUNGLE_TREES("jungle_trees", DefaultBiomeFeatures::withJungleTrees),
  JUNGLE_EDGE_TREES("jungle_edge_trees", DefaultBiomeFeatures::withJungleEdgeTrees),
  BADLANDS_PLATEAU_TREES("badlands_plateau_trees", DefaultBiomeFeatures::withBadlandsOakTrees),
  SNOWY_SPRUCE_TREES("snowy_spruce_trees", DefaultBiomeFeatures::withSnowySpruces),
  JUNGLE_GRASS("jungle_grass", DefaultBiomeFeatures::withJungleGrass),
  SAVANNA_TALL_GRASS("savanna_tall_grass", DefaultBiomeFeatures::withTallGrass),
  SHATTERED_SAVANNA_TALL_GRASS("shattered_savannah_tall_grass", DefaultBiomeFeatures::withNormalGrassPatch),
  SAVANNA_GRASS("savannah_grass", DefaultBiomeFeatures::withSavannaGrass),
  BADLANDS_GRASS("badlands_grass", DefaultBiomeFeatures::withBadlandsGrassAndBush),
  FOREST_FLOWERS("forrest_flowers", DefaultBiomeFeatures::withAllForestFlowerGeneration),
  FOREST_GRASS("forrest_grass", DefaultBiomeFeatures::withForestGrass),
  SWAMP_FEATURES("swamp_features", DefaultBiomeFeatures::withSwampVegetation),
  MUSHROOM_FIELDS_FEATURES("mushroom_fields_features", DefaultBiomeFeatures::withMushroomBiomeVegetation),
  PLAINS_FEATURES("plains_features", DefaultBiomeFeatures::withPlainGrassVegetation),
  DESERT_DEAD_BUSHES("desert_dead_bushes", DefaultBiomeFeatures::withDesertDeadBushes),
  GIANT_TAIGA_GRASS("giant_taiga_grass", DefaultBiomeFeatures::withGiantTaigaGrassVegetation),
  DEFAULT_FLOWERS("default_flowers", DefaultBiomeFeatures::withDefaultFlowers),
  EXTRA_DEFAULT_FLOWERS("extra_default_flowers", DefaultBiomeFeatures::withWarmFlowers),
  DEFAULT_GRASS("default_grass", DefaultBiomeFeatures::withBadlandsGrass),
  TAIGA_GRASS("taiga_grass", DefaultBiomeFeatures::withTaigaGrassVegetation),
  PLAINS_TALL_GRASS("plains_tall_grass", DefaultBiomeFeatures::withNoiseTallGrass),
  DEFAULT_MUSHROOMS("default_mushrooms", DefaultBiomeFeatures::withNormalMushroomGeneration),
  DEFAULT_VEGETATION("default_vegetation", DefaultBiomeFeatures::withSugarCaneAndPumpkins),
  BADLANDS_VEGETATION("badlands_vegetation", DefaultBiomeFeatures::withBadlandsVegetation),
  JUNGLE_VEGETATION("jungle_vegetation", DefaultBiomeFeatures::withMelonPatchesAndVines),
  DESERT_VEGETATION("desert_vegetation", DefaultBiomeFeatures::withDesertVegetation),
  SWAMP_VEGETATION("swamp_vegetation", DefaultBiomeFeatures::withSwampSugarcaneAndPumpkin),
  DESERT_FEATURES("desert_features", DefaultBiomeFeatures::withDesertWells),
  FOSSILS("fossils", DefaultBiomeFeatures::withFossils),
  KELP("kelp", DefaultBiomeFeatures::withColdKelp),
  SEAGRASS_ON_STONE("seagrass_on_stone", DefaultBiomeFeatures::withSimpleSeagrass),
  LESS_KELP("less_kelp", DefaultBiomeFeatures::withWarmKelp),
  SPRINGS("springs", DefaultBiomeFeatures::withLavaAndWaterSprings),
  ICEBERGS("icebergs", DefaultBiomeFeatures::withIcebergs),
  BLUE_ICE("blue_ice", DefaultBiomeFeatures::withBlueIce),
  FROZEN_TOP_LAYER("frozen_top_layer", DefaultBiomeFeatures::withFrozenTopLayer);

  private final String name;
  private Consumer<BiomeGenerationSettings.Builder> function;

  DefaultFeature(String name, Consumer<BiomeGenerationSettings.Builder> function) {
    this.name = name;
    this.function = function;
  }

  public String getName() {
    return this.name;
  }

  public void add(BiomeGenerationSettings.Builder genBuilder) {
    this.function.accept(genBuilder);
  }
}
