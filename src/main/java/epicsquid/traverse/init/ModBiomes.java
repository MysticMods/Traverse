package epicsquid.traverse.init;

import epicsquid.traverse.Traverse;
import epicsquid.traverse.config.ConfigManager;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Traverse.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBiomes {
  public static void load() {
  }

  @SubscribeEvent
  public static void registerBiomes(RegistryEvent.Register<Biome> event) {
    registerBiome("arid_highlands", ConfigManager.ARID_HIGHLANDS.getWeight(), BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome("autumnal_wooded_hills", ConfigManager.AUTUMNAL_WOODED_HILLS.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome("autumnal_woods", ConfigManager.AUTUMNAL_WOODS.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
    registerBiome("coniferous_forest", ConfigManager.CONIFEROUS_FOREST.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
    registerBiome("coniferous_wooded_hills", ConfigManager.CONIFEROUS_WOODLAND_HILLS.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
    registerBiome("desert_shrubland", ConfigManager.DESERT_SHRUBLAND.getWeight(), BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.OVERWORLD);
    registerBiome("high_coniferous_forest", ConfigManager.HIGH_CONIFEROUS_FOREST.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
    registerBiome("lush_swamp", ConfigManager.LUSH_SWAMP.getWeight(), BiomeManager.BiomeType.WARM, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.WET, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.OVERWORLD);
    registerBiome("meadow", ConfigManager.MEADOW.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.WET, BiomeDictionary.Type.OVERWORLD);
    registerBiome("mini_jungle", ConfigManager.MINI_JUNGLE.getWeight(), BiomeManager.BiomeType.WARM, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.WET, BiomeDictionary.Type.OVERWORLD);
    registerBiome("plains_plateau", ConfigManager.PLAINS_PLATEAU.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome("rocky_edge", ConfigManager.ROCK_EDGE.getWeight(), BiomeManager.BiomeType.WARM, BiomeDictionary.Type.HOT, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
    registerBiome("rolling_hills", ConfigManager.ROLLING_HILLS.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome("snowy_coniferous_forest", ConfigManager.SNOWY_CONIFEROUS_FOREST.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
    registerBiome("snowy_coniferous_wooded_hills", ConfigManager.SNOWY_CONIFEROUS_WOODED_HILLS.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome("snowy_high_coniferous_forest", ConfigManager.SNOWY_HIGH_CONIFEROUS_FOREST.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome("wooded_plateau", ConfigManager.WOODED_PLATEAU.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome("woodlands", ConfigManager.WOODLANDS.getWeight(), BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
  }

  private static void registerBiome(String name, int weight, BiomeManager.BiomeType type, BiomeDictionary.Type... types) {
    if (weight > 0) {
      RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Traverse.MODID, name));
      BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, weight));
      BiomeDictionary.addTypes(key, types);
    }
  }
}
