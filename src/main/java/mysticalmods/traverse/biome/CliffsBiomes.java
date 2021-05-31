package mysticalmods.traverse.biome;

import mysticalmods.traverse.biomebuilder.BiomeTemplate;
import mysticalmods.traverse.biomebuilder.TerraformBiomeBuilder;
import mysticalmods.traverse.init.ModFeatures;
import mysticalmods.traverse.init.ModSurfaceBuilders;
import mysticalmods.traverse.biomebuilder.DefaultFeature;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class CliffsBiomes {
  static final BiomeTemplate CLIFFS_TEMPLATE = new BiomeTemplate(TerraformBiomeBuilder.create()
      .surfaceBuilder(ModSurfaceBuilders.CONFIGURED_DEFAULT_STONE)
      .addDefaultFeatures(DefaultFeature.LAND_CARVERS, DefaultFeature.DEFAULT_UNDERGROUND_STRUCTURES, DefaultFeature.DUNGEONS, DefaultFeature.LAKES, DefaultFeature.EMERALD_ORE, DefaultFeature.ORES, DefaultFeature.DISKS, DefaultFeature.DEFAULT_MUSHROOMS, DefaultFeature.DEFAULT_VEGETATION, DefaultFeature.SPRINGS, DefaultFeature.FROZEN_TOP_LAYER, DefaultFeature.DEFAULT_GRASS, DefaultFeature.DEFAULT_FLOWERS)
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
      .downfall(0.4F));

  public static final Biome CLIFFS = CLIFFS_TEMPLATE.builder().temperature(0.3f).build();

  public static final Biome SNOWY_CLIFFS = CLIFFS_TEMPLATE.builder().temperature(0.22f).build();
}
