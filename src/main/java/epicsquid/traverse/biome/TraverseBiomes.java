package epicsquid.traverse.biome;

import epicsquid.traverse.Traverse;
import epicsquid.traverse.biomebuilder.BiomeTemplate;
import epicsquid.traverse.biomebuilder.TerraformBiomeBuilder;
import epicsquid.traverse.biomebuilder.TerraformSlimeSpawnBiomes;
import epicsquid.traverse.config.ConfigManager;
import epicsquid.traverse.init.ModSurfaceBuilders;
import epicsquid.traverse.villager.TraverseVillagerTypes;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashMap;
import java.util.Map;

import static epicsquid.traverse.biomebuilder.DefaultFeature.*;

@Mod.EventBusSubscriber(modid = Traverse.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TraverseBiomes {

  private static int getSkyColor(float temperature) {
    float f = temperature / 3.0F;
    f = MathHelper.clamp(f, -1.0F, 1.0F);
    return MathHelper.hsvToRGB(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
  }

  private static final Map<ResourceLocation, Biome> BIOMES = new HashMap<>();

  static final BiomeTemplate BIOME_TEMPLATE = new BiomeTemplate(TerraformBiomeBuilder.create()
      .surfaceBuilder(ModSurfaceBuilders.CONFIGURED_DEFAULT_GRASS)
      .addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, DUNGEONS, MINEABLES, ORES, DISKS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, SPRINGS, FROZEN_TOP_LAYER)
      .addStructureFeature(StructureFeatures.STRONGHOLD)
      .addStructureFeature(StructureFeatures.MINESHAFT)
      .precipitation(Biome.RainType.RAIN)
      .effects(createDefaultBiomeAmbience()));

  public static BiomeAmbience.Builder createDefaultBiomeAmbience() {
    return new BiomeAmbience.Builder()
        .setWaterColor(0x3F76E4)
        .setWaterFogColor(0x50533)
        .withSkyColor(getSkyColor(0.2F))
        .setFogColor(0xC0D8FF);
  }

  public static final RegistryKey<Biome> ARID_HIGHLANDS = add("arid_highlands", AridHighlandsBiomes.ARID_HIGHLANDS);
  public static final RegistryKey<Biome> AUTUMNAL_WOODS = add("autumnal_woods", AutumnalWoodsBiomes.AUTUMNAL_WOODS);
  public static final RegistryKey<Biome> AUTUMNAL_WOODED_HILLS = add("autumnal_wooded_hills", AutumnalWoodsBiomes.AUTUMNAL_WOODED_HILLS);
  public static final RegistryKey<Biome> CLIFFS = add("cliffs", CliffsBiomes.CLIFFS);
  public static final RegistryKey<Biome> SNOWY_CLIFFS = add("snowy_cliffs", CliffsBiomes.SNOWY_CLIFFS);
  public static final RegistryKey<Biome> CONIFEROUS_FOREST = add("coniferous_forest", ConiferousForestBiomes.CONIFEROUS_FOREST);
  public static final RegistryKey<Biome> CONIFEROUS_WOODED_HILLS = add("coniferous_wooded_hills", ConiferousForestBiomes.CONIFEROUS_WOOODED_HILLS);
  public static final RegistryKey<Biome> DESERT_SHRUBLAND = add("desert_shrubland", DesertShrublandBiomes.DESERT_SHRUBLAND);
  public static final RegistryKey<Biome> HIGH_CONIFEROUS_FOREST = add("high_coniferous_forest", ConiferousForestBiomes.HIGH_CONIFEROUS_FOREST);
  public static final RegistryKey<Biome> LUSH_SWAMP = add("lush_swamp", LushSwampBiomes.LUSH_SWAMP);
  public static final RegistryKey<Biome> MEADOW = add("meadow", MeadowBiomes.MEADOW);
  public static final RegistryKey<Biome> MINI_JUNGLE = add("mini_jungle", MiniJungleBiomes.MINI_JUNGLE);
  public static final RegistryKey<Biome> PLAINS_PLATEAU = add("plains_plateau", PlainsPlateauBiomes.PLAINS_PLATEAU);
  public static final RegistryKey<Biome> ROCKY_EDGE = add("rocky_edge", PlainsPlateauBiomes.ROCKY_EDGE);
  public static final RegistryKey<Biome> ROLLING_HILLS = add("rolling_hills", RollingHillsBiomes.ROLLING_HILLS);
  public static final RegistryKey<Biome> SNOWY_CONIFEROUS_FOREST = add("snowy_coniferous_forest", ConiferousForestBiomes.SNOWY_CONIFEROUS_FOREST);
  public static final RegistryKey<Biome> SNOWY_CONIFEROUS_WOODED_HILLS = add("snowy_coniferous_wooded_hills", ConiferousForestBiomes.SNOWY_CONIFEROUS_WOOODED_HILLS);
  public static final RegistryKey<Biome> SNOWY_HIGH_CONIFEROUS_FOREST = add("snowy_high_coniferous_forest", ConiferousForestBiomes.SNOWY_HIGH_CONIFEROUS_FOREST);
  public static final RegistryKey<Biome> WOODED_ISLAND = add("wooded_island", WoodedIslandBiomes.WOODED_ISLAND);
  public static final RegistryKey<Biome> WOODED_PLATEAU = add("wooded_plateau", PlainsPlateauBiomes.WOODED_PLATEAU);
  public static final RegistryKey<Biome> WOODLANDS = add("woodlands", WoodlandsBiomes.WOODLANDS);

  private static RegistryKey<Biome> add(String name, Biome biome) {
    ResourceLocation id = new ResourceLocation(Traverse.MODID, name);
    biome.setRegistryName(id);
    BIOMES.put(id, biome);
    return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, id);
  }

  @SubscribeEvent
  public static void onBiomeRegister(RegistryEvent.Register<Biome> event) {
    IForgeRegistry<Biome> biomeRegistry = event.getRegistry();
    BIOMES.values().forEach(biomeRegistry::register);

    registerBiome(ARID_HIGHLANDS, (int) ConfigManager.ARID_HIGHLANDS.weight(), BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(AUTUMNAL_WOODED_HILLS, 0, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(AUTUMNAL_WOODS, (int) ConfigManager.AUTUMNAL_WOODS.weight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
    registerBiome(CLIFFS, (int) ConfigManager.CLIFFS.weight(), BiomeManager.BiomeType.WARM, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.MOUNTAIN);
    registerBiome(SNOWY_CLIFFS, (int) ConfigManager.SNOWY_CLIFFS.weight(), BiomeManager.BiomeType.ICY, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.MOUNTAIN);
    registerBiome(CONIFEROUS_FOREST, (int) ConfigManager.CONIFEROUS_FOREST.weight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(CONIFEROUS_WOODED_HILLS, 0, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(DESERT_SHRUBLAND, (int) ConfigManager.DESERT_SHRUBLAND.weight(), BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.OVERWORLD);
    registerBiome(HIGH_CONIFEROUS_FOREST, (int) ConfigManager.HIGH_CONIFEROUS_FOREST.weight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
    registerBiome(LUSH_SWAMP, 0, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.WET, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.OVERWORLD);
    registerBiome(MEADOW, (int) ConfigManager.MEADOW.weight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.WET, BiomeDictionary.Type.OVERWORLD);
    registerBiome(MINI_JUNGLE, (int) ConfigManager.MINI_JUNGLE.weight(), BiomeManager.BiomeType.WARM, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.WET, BiomeDictionary.Type.OVERWORLD);
    registerBiome(PLAINS_PLATEAU, (int) ConfigManager.PLAINS_PLATEAU.weight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(ROCKY_EDGE, 0, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.HOT, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
    registerBiome(ROLLING_HILLS, (int) ConfigManager.ROLLING_HILLS.weight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(SNOWY_CONIFEROUS_FOREST, (int) ConfigManager.SNOWY_CONIFEROUS_FOREST.weight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(SNOWY_CONIFEROUS_WOODED_HILLS, 0, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(SNOWY_HIGH_CONIFEROUS_FOREST, (int) ConfigManager.SNOWY_HIGH_CONIFEROUS_FOREST.weight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(WOODED_PLATEAU, 0, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(WOODLANDS, (int) ConfigManager.WOODLANDS.weight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
    registerBiome(WOODED_ISLAND, 0, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
    TerraformSlimeSpawnBiomes.addSlimeSpawnBiome(LUSH_SWAMP);

    if (ConfigManager.WOODED_ISLAND.shouldSpawn()) {
      BiomeVariants.addReplacement(Biomes.DEEP_COLD_OCEAN, WOODED_ISLAND, 0.1, BiomeVariants.VariantType.BIOME);
      BiomeVariants.addReplacement(Biomes.DEEP_LUKEWARM_OCEAN, WOODED_ISLAND, 0.1, BiomeVariants.VariantType.BIOME);
      BiomeVariants.addReplacement(Biomes.DEEP_OCEAN, WOODED_ISLAND, 0.1, BiomeVariants.VariantType.BIOME);
    }
    if (ConfigManager.LUSH_SWAMP.shouldSpawn()) {
      BiomeVariants.addReplacement(Biomes.SWAMP, LUSH_SWAMP, 0.2, BiomeVariants.VariantType.BIOME);
    }
    if (ConfigManager.MINI_JUNGLE.shouldSpawn()) {
      BiomeVariants.addReplacement(Biomes.JUNGLE, MINI_JUNGLE, 0.15, BiomeVariants.VariantType.BIOME);
    }
    if (ConfigManager.MEADOW.shouldSpawn()) {
      BiomeVariants.addReplacement(Biomes.PLAINS, MEADOW, 0.2, BiomeVariants.VariantType.BIOME);
    }

    BiomeVariants.addReplacement(AUTUMNAL_WOODS, AUTUMNAL_WOODED_HILLS, 1, BiomeVariants.VariantType.HILLS);
    BiomeVariants.addReplacement(CONIFEROUS_FOREST, CONIFEROUS_WOODED_HILLS, 1, BiomeVariants.VariantType.HILLS);
    BiomeVariants.addReplacement(SNOWY_CONIFEROUS_FOREST, SNOWY_CONIFEROUS_WOODED_HILLS, 1, BiomeVariants.VariantType.HILLS);
    BiomeVariants.addReplacement(PLAINS_PLATEAU, WOODED_PLATEAU, 1, BiomeVariants.VariantType.HILLS);
    BiomeVariants.addReplacement(PLAINS_PLATEAU, PLAINS_PLATEAU, 1, BiomeVariants.VariantType.RIVER);
    BiomeVariants.addReplacement(PLAINS_PLATEAU, ROCKY_EDGE, 1, BiomeVariants.VariantType.EDGE);
    BiomeVariants.addReplacement(CLIFFS, ROLLING_HILLS, 1, BiomeVariants.VariantType.CENTER);
    BiomeVariants.addReplacement(SNOWY_CLIFFS, Biomes.SNOWY_TAIGA_HILLS, 1, BiomeVariants.VariantType.CENTER);
    BiomeVariants.addReplacement(WOODED_ISLAND, WOODED_ISLAND, 1, BiomeVariants.VariantType.SHORE);

    TraverseVillagerTypes.register();
  }

  private static void registerBiome(RegistryKey<Biome> key, int weight, BiomeManager.BiomeType type, BiomeDictionary.Type... types) {
    if (weight > 0) {
      BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, weight));
    }
    BiomeDictionary.addTypes(key, types);
  }
}
