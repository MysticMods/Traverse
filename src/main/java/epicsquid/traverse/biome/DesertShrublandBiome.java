package epicsquid.traverse.biome;

import epicsquid.traverse.init.ModFeatureConfig;
import epicsquid.traverse.world.surfacebuilder.ModSurfaceBuilders;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class DesertShrublandBiome extends AbstractBiome {

  static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(ModSurfaceBuilders.DESERT_SHRUBLAND, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG);
  static final RainType PRECIPITATION = RainType.NONE;
  static final Category CATEGORY = Category.DESERT;
  static final float DEPTH = 0.125F;
  static final float SCALE = 0.125F;
  static final float TEMPERATURE = 2.0F;
  static final float DOWNFALL = 0.0F;
  static final int WATER_COLOR = 0x3f76e4;
  static final int WATER_FOG_COLOR = 0x50533;
  static final String PARENT = null;

  public DesertShrublandBiome() {
    super(new Biome.Builder().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPITATION).category(CATEGORY).depth(DEPTH).scale(SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).parent(PARENT));
  }

  public void init () {
    this.addStructure(Feature.VILLAGE.withConfiguration(new VillageConfig("village/desert/town_centers", 6)));
    this.addStructure(Feature.PILLAGER_OUTPOST.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
    this.addStructure(Feature.DESERT_PYRAMID.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
    this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
    this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
    DefaultBiomeFeatures.addCarvers(this);
    DefaultBiomeFeatures.addStructures(this);
    DefaultBiomeFeatures.addDesertLakes(this);
    DefaultBiomeFeatures.addMonsterRooms(this);
    DefaultBiomeFeatures.addStoneVariants(this);
    DefaultBiomeFeatures.addOres(this);
    DefaultBiomeFeatures.addSedimentDisks(this);
    DefaultBiomeFeatures.addDefaultFlowers(this);
    DefaultBiomeFeatures.addGrass(this);
    DefaultBiomeFeatures.addDeadBushes(this);
    DefaultBiomeFeatures.addMushrooms(this);
    DefaultBiomeFeatures.addExtraReedsPumpkinsCactus(this);
    DefaultBiomeFeatures.addSprings(this);
    DefaultBiomeFeatures.addDesertFeatures(this);
    DefaultBiomeFeatures.addFreezeTopLayer(this);
    ModFeatureConfig.addDesertShrublandFeatures(this);
    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.RABBIT, 4, 2, 3));
    this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 10, 8, 8));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 19, 4, 4));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 1, 1, 1));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.HUSK, 80, 4, 4));
  }

}
