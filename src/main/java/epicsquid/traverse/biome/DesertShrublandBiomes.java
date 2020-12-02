package epicsquid.traverse.biome;

import epicsquid.traverse.biomebuilder.DefaultFeature;
import epicsquid.traverse.init.ModFeatures;
import epicsquid.traverse.init.ModSurfaceBuilders;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class DesertShrublandBiomes {
  static final Biome DESERT_SHRUBLAND = TraverseBiomes.BIOME_TEMPLATE.builder()
      .surfaceBuilder(ModSurfaceBuilders.CONFIGURED_DESERT_SHRUBLAND)
      .addDefaultFeatures(DefaultFeature.DESERT_LAKES, DefaultFeature.DESERT_DEAD_BUSHES, DefaultFeature.DESERT_VEGETATION, DefaultFeature.DESERT_FEATURES, DefaultFeature.DEFAULT_FLOWERS, DefaultFeature.DEFAULT_GRASS)
      .addStructureFeature(StructureFeatures.VILLAGE_DESERT)
      .addStructureFeature(StructureFeatures.PILLAGER_OUTPOST)
      .addStructureFeature(StructureFeatures.RUINED_PORTAL_DESERT)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.DESERT_SHRUBS)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.DESERT_SHRUBS)
      .precipitation(Biome.RainType.NONE)
      .addDefaultAmbientSpawnEntries()
      .addDefaultMonsterSpawnEntries()
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.RABBIT, 4, 2, 3))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.HUSK, 80, 4, 4))
      .category(Biome.Category.DESERT)
      .depth(0.125F)
      .scale(0.125F)
      .temperature(2.0F)
      .downfall(0.0F)
      .playerSpawnFriendly()
      .build();
}
