package epicsquid.traverse.biome;

import epicsquid.traverse.biomebuilder.DefaultFeature;
import epicsquid.traverse.init.ModFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class RollingHillsBiomes {
  static final Biome ROLLING_HILLS = TraverseBiomes.BIOME_TEMPLATE.builder()
      .addDefaultFeatures(DefaultFeature.LAKES)
      .addStructureFeature(StructureFeatures.RUINED_PORTAL)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.ROLLING_HILLS_GRASS)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.LUSH_FLOWERS)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.ROLLING_HILLS_TREES)
      .addDefaultSpawnEntries()
      .category(Biome.Category.PLAINS)
      .depth(0.4F)
      .scale(0.3F)
      .temperature(0.5F)
      .downfall(0.8F)
      .effects(TraverseBiomes.createDefaultBiomeAmbience()
          .withGrassColor(0x7FE03E)
          .withFoliageColor(0x58EA33)
      )
      .playerSpawnFriendly()
      .build();
}
