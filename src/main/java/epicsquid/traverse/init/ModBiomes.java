package epicsquid.traverse.init;

import epicsquid.traverse.Traverse;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Traverse.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBiomes {
  public static void load() {
  }

  @SubscribeEvent
  public static void registerBiomes(RegistryEvent.Register<Biome> event) {
/*    registerBiome(ARID_HIGHLANDS.get(), ConfigManager.ARID_HIGHLANDS.getWeight(), false, BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(AUTUMNAL_WOODED_HILLS.get(), ConfigManager.AUTUMNAL_WOODED_HILLS.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(AUTUMNAL_WOODS.get(), ConfigManager.AUTUMNAL_WOODS.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
    registerBiome(CONIFEROUS_FOREST.get(), ConfigManager.CONIFEROUS_FOREST.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(CONIFEROUS_WOODLAND_HILLS.get(), ConfigManager.CONIFEROUS_WOODLAND_HILLS.getWeight(), false, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(DESERT_SHRUBLAND.get(), ConfigManager.DESERT_SHRUBLAND.getWeight(), false, BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.OVERWORLD);
    registerBiome(HIGH_CONIFEROUS_FOREST.get(), ConfigManager.HIGH_CONIFEROUS_FOREST.getWeight(), false, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
    registerBiome(LUSH_SWAMP.get(), ConfigManager.LUSH_SWAMP.getWeight(), false, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.WET, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.OVERWORLD);
    registerBiome(MEADOW.get(), ConfigManager.MEADOW.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.WET, BiomeDictionary.Type.OVERWORLD);
    registerBiome(MINI_JUNGLE.get(), ConfigManager.MINI_JUNGLE.getWeight(), true, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.WET, BiomeDictionary.Type.OVERWORLD);
    registerBiome(PLAINS_PLATEAU.get(), ConfigManager.PLAINS_PLATEAU.getWeight(), false, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(ROCKY_EDGE.get(), ConfigManager.ROCK_EDGE.getWeight(), false, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.HOT, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
    registerBiome(ROLLING_HILLS.get(), ConfigManager.ROLLING_HILLS.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(SNOWY_CONIFEROUS_FOREST.get(), ConfigManager.SNOWY_CONIFEROUS_FOREST.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(SNOWY_CONIFEROUS_WOODED_HILLS.get(), ConfigManager.SNOWY_CONIFEROUS_WOODED_HILLS.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(SNOWY_HIGH_CONIFEROUS_FOREST.get(), ConfigManager.SNOWY_HIGH_CONIFEROUS_FOREST.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(WOODED_PLATEAU.get(), ConfigManager.WOODED_PLATEAU.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(WOODLANDS.get(), ConfigManager.WOODLANDS.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);*/
  }

/*  private static void registerBiome(Biome biome, int weight, boolean spawn, BiomeManager.BiomeType type, BiomeDictionary.Type... types) {
    if (weight > 0) {
      BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(biome, weight));
      if (spawn) {
        BiomeManager.addSpawnBiome(biome);
      }
      BiomeDictionary.addTypes(biome, types);
    }
  }*/
}
