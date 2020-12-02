package epicsquid.traverse.biome;

import epicsquid.traverse.biomebuilder.BiomeTemplate;
import epicsquid.traverse.biomebuilder.DefaultFeature;
import epicsquid.traverse.biomebuilder.TerraformBiomeBuilder;
import epicsquid.traverse.init.ModFeatures;
import epicsquid.traverse.init.ModSurfaceBuilders;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

import static epicsquid.traverse.biomebuilder.DefaultFeature.*;

public class LushSwampBiomes {
  static final BiomeTemplate BIOME_TEMPLATE_NO_DISKS = new BiomeTemplate(TerraformBiomeBuilder.create()
      .surfaceBuilder(ModSurfaceBuilders.CONFIGURED_DEFAULT_GRASS)
      .addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, DUNGEONS, MINEABLES, ORES, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, SPRINGS, FROZEN_TOP_LAYER)
      .addStructureFeature(StructureFeatures.STRONGHOLD)
      .addStructureFeature(StructureFeatures.MINESHAFT)
      .precipitation(Biome.RainType.RAIN)
      .effects(TraverseBiomes.createDefaultBiomeAmbience()));

  static final Biome LUSH_SWAMP = BIOME_TEMPLATE_NO_DISKS.builder()
      .surfaceBuilder(ModSurfaceBuilders.CONFIGURED_GRASSY_SWAMP)
      .addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.SWAMP_VEGETATION, DefaultFeature.FOSSILS)
      .addStructureFeature(StructureFeatures.SWAMP_HUT)
      .addStructureFeature(StructureFeatures.RUINED_PORTAL_SWAMP)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SEAGRASS_SWAMP)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.LUSH_SWAMP_TREES)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FLOWER_SWAMP)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_NORMAL)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_WATERLILLY)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.BROWN_MUSHROOM_SWAMP)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.RED_MUSHROOM_SWAMP)
      .addDefaultSpawnEntries()
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SLIME, 1, 1, 1))
      .category(Biome.Category.SWAMP)
      .depth(-0.2F)
      .scale(0.1F)
      .temperature(0.8F)
      .downfall(0.9F)
      .effects(TraverseBiomes.createDefaultBiomeAmbience()
          .withGrassColor(0x7FE03E)
          .withFoliageColor(0x58EA33)
          .setWaterColor(0x617B64)
          .setWaterFogColor(0x232317))
      .build();
}
