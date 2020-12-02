package epicsquid.traverse.biome;

import epicsquid.traverse.biomebuilder.TerraformBiomeBuilder;
import epicsquid.traverse.init.ModFeatures;
import epicsquid.traverse.init.ModSurfaceBuilders;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

import static epicsquid.traverse.biomebuilder.DefaultFeature.*;

public class CliffsBiomes {
  static final Biome CLIFFS = TerraformBiomeBuilder.create()
      .surfaceBuilder(ModSurfaceBuilders.CONFIGURED_DEFAULT_STONE)
      .addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, DUNGEONS, LAKES, EMERALD_ORE, ORES, DISKS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, SPRINGS, FROZEN_TOP_LAYER, DEFAULT_GRASS, DEFAULT_FLOWERS)
      .addStructureFeature(StructureFeatures.STRONGHOLD)
      .addStructureFeature(StructureFeatures.MINESHAFT)
      .addStructureFeature(StructureFeatures.RUINED_PORTAL_MOUNTAIN)
      .addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.LOW_DIRT)
      .addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.LOW_GRAVEL)
      .addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.LOW_GRANITE)
      .addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.LOW_DIORITE)
      .addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.LOW_ANDESITE)
      .precipitation(Biome.RainType.RAIN)
      .addDefaultSpawnEntries()
      .category(Biome.Category.PLAINS)
      .effects(TraverseBiomes.createDefaultBiomeAmbience()
          .setWaterColor(0x3F76E4)
          .setWaterFogColor(0x50533))
      .depth(3.6F)
      .scale(0.2F)
      .temperature(0.3F)
      .downfall(0.4F)
      .build();
}
