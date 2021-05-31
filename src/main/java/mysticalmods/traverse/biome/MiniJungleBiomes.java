package mysticalmods.traverse.biome;

import mysticalmods.traverse.biomebuilder.DefaultFeature;
import mysticalmods.traverse.init.ModFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;

public class MiniJungleBiomes {
  static final Biome MINI_JUNGLE = TraverseBiomes.BIOME_TEMPLATE.builder()
      .addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.JUNGLE_GRASS, DefaultFeature.JUNGLE_VEGETATION, DefaultFeature.EXTRA_DEFAULT_FLOWERS, DefaultFeature.BAMBOO)
      .addStructureFeature(StructureFeatures.RUINED_PORTAL_JUNGLE)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.MINI_JUNGLE_SEAGRASS)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.MINI_JUNGLE_TREES)
      .addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FLOWER_SWAMP)
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.PARROT, 40, 1, 2))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.PANDA, 1, 1, 2))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.TROPICAL_FISH, 30, 5, 8))
      .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.OCELOT, 2, 1, 1))
      .category(Biome.Category.JUNGLE)
      .depth(-0.1F)
      .scale(0.45F)
      .temperature(0.95F)
      .downfall(0.9F)
      .effects(TraverseBiomes.createDefaultBiomeAmbience()
          .setWaterColor(0x003320)
          .setWaterFogColor(0x052721)
      )
      .build();
}
