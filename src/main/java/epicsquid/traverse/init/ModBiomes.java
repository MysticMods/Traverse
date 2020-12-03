package epicsquid.traverse.init;

import epicsquid.traverse.Traverse;
import epicsquid.traverse.biome.variants.BiomeVariants;
import epicsquid.traverse.biomebuilder.TerraformSlimeSpawnBiomes;
import epicsquid.traverse.config.ConfigManager;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Traverse.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBiomes {
  public static RegistryKey<Biome> ARID_HIGHLANDS;
  public static RegistryKey<Biome> AUTUMNAL_WOODED_HILLS;
  public static RegistryKey<Biome> AUTUMNAL_WOODS;
  public static RegistryKey<Biome> CLIFFS;
  public static RegistryKey<Biome> CONIFEROUS_FOREST;
  public static RegistryKey<Biome> CONIFEROUS_WOODED_HILLS;
  public static RegistryKey<Biome> DESERT_SHRUBLAND;
  public static RegistryKey<Biome> HIGH_CONIFEROUS_FOREST;
  public static RegistryKey<Biome> LUSH_SWAMP;
  public static RegistryKey<Biome> MEADOW;
  public static RegistryKey<Biome> MINI_JUNGLE;
  public static RegistryKey<Biome> PLAINS_PLATEAU;
  public static RegistryKey<Biome> ROCKY_EDGE;
  public static RegistryKey<Biome> ROLLING_HILLS;
  public static RegistryKey<Biome> SNOWY_CONIFEROUS_FOREST;
  public static RegistryKey<Biome> SNOWY_CONIFEROUS_WOODED_HILLS;
  public static RegistryKey<Biome> SNOWY_HIGH_CONIFEROUS_FOREST;
  public static RegistryKey<Biome> WOODED_ISLAND;
  public static RegistryKey<Biome> WOODED_PLATEAU;
  public static RegistryKey<Biome> WOODLANDS;

  public static void load() {
  }

  @SubscribeEvent
  public static void registerBiomes(RegistryEvent.Register<Biome> event) {
    registerBiome(ARID_HIGHLANDS= k("arid_highlands"), ConfigManager.ARID_HIGHLANDS.getWeight(), BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(AUTUMNAL_WOODED_HILLS= k("autumnal_wooded_hills"), ConfigManager.AUTUMNAL_WOODED_HILLS.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(AUTUMNAL_WOODS=k("autumnal_woods"), ConfigManager.AUTUMNAL_WOODS.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
    registerBiome(CLIFFS=k("cliffs"), ConfigManager.CLIFFS.getWeight(), BiomeManager.BiomeType.WARM, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.MOUNTAIN);
    registerBiome(CONIFEROUS_FOREST=k("coniferous_forest"), ConfigManager.CONIFEROUS_FOREST.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(CONIFEROUS_WOODED_HILLS=k("coniferous_wooded_hills"), ConfigManager.CONIFEROUS_WOODLAND_HILLS.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(DESERT_SHRUBLAND=k("desert_shrubland"), ConfigManager.DESERT_SHRUBLAND.getWeight(), BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.OVERWORLD);
    registerBiome(HIGH_CONIFEROUS_FOREST=k("high_coniferous_forest"), ConfigManager.HIGH_CONIFEROUS_FOREST.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
    registerBiome(LUSH_SWAMP=k("lush_swamp"), ConfigManager.LUSH_SWAMP.getWeight(), BiomeManager.BiomeType.WARM, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.WET, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.OVERWORLD);
    registerBiome(MEADOW=k("meadow"), ConfigManager.MEADOW.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.WET, BiomeDictionary.Type.OVERWORLD);
    registerBiome(MINI_JUNGLE=k("mini_jungle"), ConfigManager.MINI_JUNGLE.getWeight(), BiomeManager.BiomeType.WARM, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.WET, BiomeDictionary.Type.OVERWORLD);
    registerBiome(PLAINS_PLATEAU=k("plains_plateau"), ConfigManager.PLAINS_PLATEAU.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(ROCKY_EDGE=k("rocky_edge"), ConfigManager.ROCK_EDGE.getWeight(), BiomeManager.BiomeType.WARM, BiomeDictionary.Type.HOT, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
    registerBiome(ROLLING_HILLS=k("rolling_hills"), ConfigManager.ROLLING_HILLS.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(SNOWY_CONIFEROUS_FOREST=k("snowy_coniferous_forest"), ConfigManager.SNOWY_CONIFEROUS_FOREST.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(SNOWY_CONIFEROUS_WOODED_HILLS=k("snowy_coniferous_wooded_hills"), ConfigManager.SNOWY_CONIFEROUS_WOODED_HILLS.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(SNOWY_HIGH_CONIFEROUS_FOREST=k("snowy_high_coniferous_forest"), ConfigManager.SNOWY_HIGH_CONIFEROUS_FOREST.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(WOODED_PLATEAU=k("wooded_plateau"), ConfigManager.WOODED_PLATEAU.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(WOODLANDS=k("woodlands"), ConfigManager.WOODLANDS.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
    registerBiome(WOODED_ISLAND=k("wooded_island"), ConfigManager.WOODED_ISLAND.getWeight(), BiomeManager.BiomeType.WARM, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
    TerraformSlimeSpawnBiomes.addSlimeSpawnBiome(LUSH_SWAMP);
    BiomeVariants.addReplacement(Biomes.DEEP_OCEAN, WOODED_ISLAND, 0.1);
    BiomeVariants.addReplacement(Biomes.SWAMP, LUSH_SWAMP, 0.2);
    BiomeVariants.addReplacement(Biomes.PLAINS, MEADOW, 0.15);
    BiomeVariants.addReplacement(Biomes.JUNGLE, MINI_JUNGLE, 0.15);
  }

  private static RegistryKey<Biome> k(String name) {
    return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Traverse.MODID, name));
  }

  private static void registerBiome(RegistryKey<Biome> key, int weight, BiomeManager.BiomeType type, BiomeDictionary.Type... types) {
    if (weight > 0) {
      BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, weight));
      BiomeDictionary.addTypes(key, types);
    }
  }

  static {

  }
}
