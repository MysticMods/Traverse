package mysticalmods.traverse.biome;

import mysticalmods.traverse.biomebuilder.BiomeTemplate;
import mysticalmods.traverse.biomebuilder.DefaultFeature;
import mysticalmods.traverse.init.ModFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class AutumnalWoodsBiomes {
  private static final BiomeTemplate AUTUMNAL_WOODS_TEMPLATE = new BiomeTemplate(TraverseBiomes.BIOME_TEMPLATE.builder()
      .addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.FOREST_FLOWERS, DefaultFeature.FOREST_GRASS)
      .addStructureFeature(StructureFeatures.RUINED_PORTAL)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.AUTUMNAL_TREES)
      .category(Biome.Category.FOREST)
      .addDefaultSpawnEntries()
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.WOLF, 5, 4, 4))
      .effects(TraverseBiomes.createDefaultBiomeAmbience()
          .withGrassColor(0xD6C23D)
          .withFoliageColor(0xD2D31F)
      )
      .temperature(0.8F)
      .downfall(0.4F)
  );

  static final Biome AUTUMNAL_WOODS = AUTUMNAL_WOODS_TEMPLATE.builder()
      .depth(0.2F)
      .scale(0.05F)
      .playerSpawnFriendly()
      .build();

  static final Biome AUTUMNAL_WOODED_HILLS = AUTUMNAL_WOODS_TEMPLATE.builder()
      .depth(0.45F)
      .scale(0.3F)
      .build();
}
