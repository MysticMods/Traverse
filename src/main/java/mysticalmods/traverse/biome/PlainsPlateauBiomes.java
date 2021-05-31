package mysticalmods.traverse.biome;

import mysticalmods.traverse.biomebuilder.BiomeTemplate;
import mysticalmods.traverse.biomebuilder.DefaultFeature;
import mysticalmods.traverse.init.ModFeatures;
import mysticalmods.traverse.init.ModSurfaceBuilders;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class PlainsPlateauBiomes {
  private static final BiomeTemplate PLATEAU_TEMPLATE = new BiomeTemplate(TraverseBiomes.BIOME_TEMPLATE.builder()
      .addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.EMERALD_ORE)
      .addDefaultSpawnEntries()
      .depth(1.6F)
      .scale(0F)
      .temperature(0.8F)
      .downfall(0.2F)
  );

  static final Biome PLAINS_PLATEAU = PLATEAU_TEMPLATE.builder()
      .addDefaultFeatures(DefaultFeature.PLAINS_TALL_GRASS, DefaultFeature.PLAINS_FEATURES)
      .addStructureFeature(StructureFeatures.VILLAGE_PLAINS)
      .addStructureFeature(StructureFeatures.RUINED_PORTAL)
      .category(Biome.Category.PLAINS)
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.RABBIT, 3, 2, 3))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.HORSE, 5, 2, 6))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.DONKEY, 1, 1, 3))
      .build();

  static final Biome ROCKY_EDGE = PLATEAU_TEMPLATE.builder()
      .surfaceBuilder(ModSurfaceBuilders.CONFIGURED_DEFAULT_STONE)
      .addDefaultFeatures(DefaultFeature.PLAINS_TALL_GRASS)
      .addStructureFeature(StructureFeatures.RUINED_PORTAL_MOUNTAIN)
      .addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, ModFeatures.ROCKY_EDGE_BOULDER)
      .category(Biome.Category.PLAINS)
      .depth(0.9F)
      .build();

  static final Biome WOODED_PLATEAU = PLATEAU_TEMPLATE.builder()
      .addDefaultFeatures(DefaultFeature.FOREST_TREES, DefaultFeature.FOREST_GRASS, DefaultFeature.FOREST_FLOWERS)
      .addStructureFeature(StructureFeatures.RUINED_PORTAL)
      .category(Biome.Category.FOREST)
      .build();
}
