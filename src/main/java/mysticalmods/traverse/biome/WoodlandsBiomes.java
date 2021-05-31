package mysticalmods.traverse.biome;

import mysticalmods.traverse.biomebuilder.DefaultFeature;
import mysticalmods.traverse.init.ModFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class WoodlandsBiomes {
  static final Biome WOODLANDS = TraverseBiomes.BIOME_TEMPLATE.builder()
      .addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.FOREST_FLOWERS, DefaultFeature.FOREST_GRASS)
      .addStructureFeature(StructureFeatures.VILLAGE_PLAINS)
      .addStructureFeature(StructureFeatures.PILLAGER_OUTPOST)
      .addStructureFeature(StructureFeatures.RUINED_PORTAL)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.WOODLANDS_TREES)
      .addDefaultSpawnEntries()
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.WOLF, 5, 4, 4))
      .category(Biome.Category.FOREST)
      .depth(0.15F)
      .scale(0.05F)
      .temperature(0.8F)
      .downfall(0.4F)
      .effects(TraverseBiomes.createDefaultBiomeAmbience()
          .withGrassColor(0x99A955)
          .withFoliageColor(0x849E4A)
      )
      .playerSpawnFriendly()
      .build();
}
