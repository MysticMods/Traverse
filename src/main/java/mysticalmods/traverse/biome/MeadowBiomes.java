package mysticalmods.traverse.biome;

import mysticalmods.traverse.biomebuilder.DefaultFeature;
import mysticalmods.traverse.init.ModFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class MeadowBiomes {
  static final Biome MEADOW = TraverseBiomes.BIOME_TEMPLATE.builder()
      .addDefaultFeatures(DefaultFeature.LAKES)
      .addStructureFeature(StructureFeatures.VILLAGE_PLAINS)
      .addStructureFeature(StructureFeatures.PILLAGER_OUTPOST)
      .addStructureFeature(StructureFeatures.RUINED_PORTAL)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.MEADOW_GRASS)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.LUSH_FLOWERS)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.MEADOW_TREES)
      .addDefaultSpawnEntries()
      .category(Biome.Category.PLAINS)
      .depth(0.1F)
      .scale(0F)
      .temperature(0.8F)
      .downfall(0.7F)
      .effects(TraverseBiomes.createDefaultBiomeAmbience()
          .withGrassColor(0x65CC53)
          .withFoliageColor(0x5DD64A)
      )
      .playerSpawnFriendly()
      .build();
}
