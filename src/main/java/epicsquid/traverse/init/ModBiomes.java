package epicsquid.traverse.init;

import com.tterrag.registrate.util.entry.RegistryEntry;
import epicsquid.traverse.Traverse;
import epicsquid.traverse.biome.*;
import epicsquid.traverse.config.ConfigManager;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import static epicsquid.traverse.Traverse.REGISTRATE;
import static epicsquid.traverse.Traverse.RECIPES;

@Mod.EventBusSubscriber(modid = Traverse.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBiomes {
    public static final RegistryEntry<AridHighlandsBiome> ARID_HIGHLANDS = REGISTRATE.biome("arid_highlands", AridHighlandsBiome::new).register();
    public static final RegistryEntry<AutumnalWoodedHillsBiome> AUTUMNAL_WOODED_HILLS = REGISTRATE.biome("autumnal_wooded_hills", AutumnalWoodedHillsBiome::new).register();
    public static final RegistryEntry<AutumnalWoodsBiome> AUTUMNAL_WOODS = REGISTRATE.biome("autumnal_woods", AutumnalWoodsBiome::new).register();
    public static final RegistryEntry<ConiferousForestBiome> CONIFEROUS_FOREST = REGISTRATE.biome("coniferous_forest", ConiferousForestBiome::new).register();
    // TODO -> _biome
    public static final RegistryEntry<ConiferousWoodedHillsBiome> CONIFEROUS_WOODLAND_HILLS = REGISTRATE.biome("coniferous_woodland_hills", ConiferousWoodedHillsBiome::new).register();
    public static final RegistryEntry<DesertShrublandBiome> DESERT_SHRUBLAND = REGISTRATE.biome("desert_shrubland", DesertShrublandBiome::new).register();
    public static final RegistryEntry<HighConiferousForestBiome> HIGH_CONIFEROUS_FOREST = REGISTRATE.biome("high_coniferous_forest", HighConiferousForestBiome::new).register();
    public static final RegistryEntry<LushSwampBiome> LUSH_SWAMP = REGISTRATE.biome("lush_swamp", LushSwampBiome::new).register();
    public static final RegistryEntry<MeadowBiome> MEADOW = REGISTRATE.biome("meadow", MeadowBiome::new).register();
    public static final RegistryEntry<MiniJungleBiome> MINI_JUNGLE = REGISTRATE.biome("mini_jungle", MiniJungleBiome::new).register();
    public static final RegistryEntry<PlainsPlateauBiome> PLAINS_PLATEAU = REGISTRATE.biome("plains_plateau", PlainsPlateauBiome::new).register();
    public static final RegistryEntry<RockyEdgeBiome> ROCKY_EDGE = REGISTRATE.biome("rocky_edge", RockyEdgeBiome::new).register();
    public static final RegistryEntry<RollingHillsBiome> ROLLING_HILLS = REGISTRATE.biome("rolling_hills", RollingHillsBiome::new).register();
    public static final RegistryEntry<SnowyConiferousForestBiome> SNOWY_CONIFEROUS_FOREST = REGISTRATE.biome("snowy_coniferous_forest", SnowyConiferousForestBiome::new).register();
    public static final RegistryEntry<SnowyConiferousWoodedHillsBiome> SNOWY_CONIFEROUS_WOODED_HILLS = REGISTRATE.biome("snowy_coniferous_wooded_hills", SnowyConiferousWoodedHillsBiome::new).register();
    public static final RegistryEntry<SnowyHighConiferousForestBiome> SNOWY_HIGH_CONIFEROUS_FOREST = REGISTRATE.biome("snowy_high_coniferous_forest", SnowyHighConiferousForestBiome::new).register();
    public static final RegistryEntry<WoodedPlateauBiome> WOODED_PLATEAU = REGISTRATE.biome("wooded_plateau", WoodedPlateauBiome::new).register();
    public static final RegistryEntry<WoodlandsBiome> WOODLANDS = REGISTRATE.biome("woodlands", WoodlandsBiome::new).register();

  public static void load () {

  }

  @SubscribeEvent
  public static void registerBiomes(RegistryEvent.Register<Biome> event) {
    registerBiome(ARID_HIGHLANDS.get(), ConfigManager.ARID_HIGHLANDS.getWeight(), false, BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
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
    registerBiome(WOODLANDS.get(), ConfigManager.WOODLANDS.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
  }

  private static void registerBiome(Biome biome, int weight, boolean spawn, BiomeManager.BiomeType type, BiomeDictionary.Type... types) {
    if (weight > 0) {
      BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(biome, weight));
      if (spawn) {
        BiomeManager.addSpawnBiome(biome);
      }
      BiomeDictionary.addTypes(biome, types);
    }
  }
}
