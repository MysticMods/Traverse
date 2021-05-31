package mysticalmods.traverse.biome;

import mysticalmods.traverse.biomebuilder.BiomeTemplate;
import mysticalmods.traverse.biomebuilder.DefaultFeature;
import mysticalmods.traverse.init.ModFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class ConiferousForestBiomes {
  private static final BiomeTemplate CONIFEROUS_FOREST_TEMPLATE = new BiomeTemplate(TraverseBiomes.BIOME_TEMPLATE.builder()
      .addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.FOREST_FLOWERS, DefaultFeature.FOREST_GRASS)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.CONIFEROUS_TREES)
      .addStructureFeature(StructureFeatures.PILLAGER_OUTPOST)
      .addStructureFeature(StructureFeatures.RUINED_PORTAL)
      .category(Biome.Category.FOREST)
      .addDefaultSpawnEntries()
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.WOLF, 5, 4, 4))
      .effects(TraverseBiomes.createDefaultBiomeAmbience()
          .withGrassColor(0x338235)
          .withFoliageColor(0x338235)
      )
      .temperature(0.6F)
      .downfall(0.9F)
  );

  static final Biome CONIFEROUS_FOREST = CONIFEROUS_FOREST_TEMPLATE.builder()
      .depth(0.4F)
      .scale(0.4F)
      .playerSpawnFriendly()
      .build();

  static final Biome CONIFEROUS_WOOODED_HILLS = CONIFEROUS_FOREST_TEMPLATE.builder()
      .depth(1F)
      .scale(0.3F)
      .build();

  static final Biome HIGH_CONIFEROUS_FOREST = CONIFEROUS_FOREST_TEMPLATE.builder()
      .depth(1.6F)
      .scale(0.4F)
      .temperature(0.3F)
      .build();

  private static final BiomeTemplate SNOWY_CONIFEROUS_FOREST_TEMPLATE = new BiomeTemplate(CONIFEROUS_FOREST_TEMPLATE.builder()
      .addDefaultFeature(DefaultFeature.SWEET_BERRY_BUSHES_SNOWY)
      .precipitation(Biome.RainType.SNOW)
      .category(Biome.Category.TAIGA)
      .effects(TraverseBiomes.createDefaultBiomeAmbience()
          .withGrassColor(0x338251)
          .withFoliageColor(0x338251)
      )
      .temperature(-0.5F)
  );

  static final Biome SNOWY_CONIFEROUS_FOREST = SNOWY_CONIFEROUS_FOREST_TEMPLATE.builder()
      .depth(0.4F)
      .scale(0.4F)
      .playerSpawnFriendly()
      .build();

  static final Biome SNOWY_CONIFEROUS_WOOODED_HILLS = SNOWY_CONIFEROUS_FOREST_TEMPLATE.builder()
      .depth(1F)
      .scale(0.3F)
      .build();

  static final Biome SNOWY_HIGH_CONIFEROUS_FOREST = SNOWY_CONIFEROUS_FOREST_TEMPLATE.builder()
      .depth(1.6F)
      .scale(0.4F)
      .temperature(-0.6F)
      .build();
}
