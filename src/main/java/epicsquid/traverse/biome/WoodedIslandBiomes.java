package epicsquid.traverse.biome;

import epicsquid.traverse.biomebuilder.DefaultFeature;
import epicsquid.traverse.init.ModSurfaceBuilders;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class WoodedIslandBiomes {
  static final Biome WOODED_ISLAND = TraverseBiomes.BIOME_TEMPLATE.builder()
      .surfaceBuilder(ModSurfaceBuilders.CONFIGURED_WOODED_ISLAND)
      .addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.FOREST_FLOWERS, DefaultFeature.DEFAULT_FLOWERS, DefaultFeature.FOREST_GRASS, DefaultFeature.FOREST_TREES, DefaultFeature.LESS_KELP)
      .addStructureFeature(StructureFeatures.RUINED_PORTAL)
      .addDefaultSpawnEntries()
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.WOLF, 5, 4, 4))
      .category(Biome.Category.FOREST)
      .depth(0.1F)
      .scale(0.6F)
      .temperature(0.8F)
      .downfall(0.8F)
      .build();
}
