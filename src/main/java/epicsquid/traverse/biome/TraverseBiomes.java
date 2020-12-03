package epicsquid.traverse.biome;

import epicsquid.traverse.Traverse;
import epicsquid.traverse.biomebuilder.BiomeTemplate;
import epicsquid.traverse.biomebuilder.TerraformBiomeBuilder;
import epicsquid.traverse.init.ModSurfaceBuilders;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
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

  protected static final RegistryKey<Biome> ARID_HIGHLANDS = add("arid_highlands", AridHighlandsBiomes.ARID_HIGHLANDS);
  protected static final RegistryKey<Biome> AUTUMNAL_WOODS = add("autumnal_woods", AutumnalWoodsBiomes.AUTUMNAL_WOODS);
  protected static final RegistryKey<Biome> AUTUMNAL_WOODED_HILLS = add("autumnal_wooded_hills", AutumnalWoodsBiomes.AUTUMNAL_WOODED_HILLS);
  protected static final RegistryKey<Biome> CLIFFS = add("cliffs", CliffsBiomes.CLIFFS);
  protected static final RegistryKey<Biome> CONIFEROUS_FOREST = add("coniferous_forest", ConiferousForestBiomes.CONIFEROUS_FOREST);
  protected static final RegistryKey<Biome> CONIFEROUS_WOODED_HILLS = add("coniferous_wooded_hills", ConiferousForestBiomes.CONIFEROUS_WOOODED_HILLS);
  protected static final RegistryKey<Biome> DESERT_SHRUBLAND = add("desert_shrubland", DesertShrublandBiomes.DESERT_SHRUBLAND);
  protected static final RegistryKey<Biome> HIGH_CONIFEROUS_FOREST = add("high_coniferous_forest", ConiferousForestBiomes.HIGH_CONIFEROUS_FOREST);
  protected static final RegistryKey<Biome> LUSH_SWAMP = add("lush_swamp", LushSwampBiomes.LUSH_SWAMP);
  protected static final RegistryKey<Biome> MEADOW = add("meadow", MeadowBiomes.MEADOW);
  protected static final RegistryKey<Biome> MINI_JUNGLE = add("mini_jungle", MiniJungleBiomes.MINI_JUNGLE);
  protected static final RegistryKey<Biome> PLAINS_PLATEAU = add("plains_plateau", PlainsPlateauBiomes.PLAINS_PLATEAU);
  protected static final RegistryKey<Biome> ROCKY_EDGE = add("rocky_edge", PlainsPlateauBiomes.ROCKY_EDGE);
  protected static final RegistryKey<Biome> ROLLING_HILLS = add("rolling_hills", RollingHillsBiomes.ROLLING_HILLS);
  protected static final RegistryKey<Biome> SNOWY_CONIFEROUS_FOREST = add("snowy_coniferous_forest", ConiferousForestBiomes.SNOWY_CONIFEROUS_FOREST);
  protected static final RegistryKey<Biome> SNOWY_CONIFEROUS_WOODED_HILLS = add("snowy_coniferous_wooded_hills", ConiferousForestBiomes.SNOWY_CONIFEROUS_WOOODED_HILLS);
  protected static final RegistryKey<Biome> SNOWY_HIGH_CONIFEROUS_FOREST = add("snowy_high_coniferous_forest", ConiferousForestBiomes.SNOWY_HIGH_CONIFEROUS_FOREST);
  protected static final RegistryKey<Biome> WOODED_ISLAND = add("wooded_island", WoodedIslandBiomes.WOODED_ISLAND);
  protected static final RegistryKey<Biome> WOODED_PLATEAU = add("wooded_plateau", PlainsPlateauBiomes.WOODED_PLATEAU);
  protected static final RegistryKey<Biome> WOODLANDS = add("woodlands", WoodlandsBiomes.WOODLANDS);

  private static RegistryKey<Biome> add(String name, Biome biome) {
    ResourceLocation id = new ResourceLocation(Traverse.MODID, name);
    biome.setRegistryName(id);
    BIOMES.put(id, biome);
    return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, id);
  }

  @SubscribeEvent(priority = EventPriority.LOW)
  public static void onBiomeRegister (RegistryEvent.Register<Biome> event) {
    IForgeRegistry<Biome> biomeRegistry = event.getRegistry();
    BIOMES.values().forEach(biomeRegistry::register);
  }

  public static void register() {
    /*		TerraformSlimeSpawnBiomes.addSlimeSpawnBiome(LUSH_SWAMP);*/
  }

}
