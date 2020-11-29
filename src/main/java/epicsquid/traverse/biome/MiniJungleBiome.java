package epicsquid.traverse.biome;

import epicsquid.traverse.init.ModFeatureConfig;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.SeaGrassConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class MiniJungleBiome extends AbstractBiome {

  static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG);
  static final RainType PRECIPITATION = RainType.RAIN;
  static final Category CATEGORY = Category.JUNGLE;
  static final float DEPTH = -0.1F;
  static final float SCALE = 0.45F;
  static final float TEMPERATURE = 0.95F;
  static final float DOWNFALL = 0.9F;
  static final int WATER_COLOR = 0x003320;
  static final int WATER_FOG_COLOR = 0x052721;
  static final String PARENT = null;

  public MiniJungleBiome() {
    super(new Biome.Builder().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPITATION).category(CATEGORY).depth(DEPTH).scale(SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).parent(PARENT));
  }

  public void init () {
    this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
    this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
    DefaultBiomeFeatures.addCarvers(this);
    DefaultBiomeFeatures.addStructures(this);
    DefaultBiomeFeatures.addLakes(this);
    DefaultBiomeFeatures.addMonsterRooms(this);
    DefaultBiomeFeatures.addStoneVariants(this);
    DefaultBiomeFeatures.addOres(this);
    DefaultBiomeFeatures.addSedimentDisks(this);
    DefaultBiomeFeatures.addBamboo(this);
    DefaultBiomeFeatures.addExtraDefaultFlowers(this);
    DefaultBiomeFeatures.addJungleGrass(this);
    DefaultBiomeFeatures.addMushrooms(this);
    DefaultBiomeFeatures.addReedsAndPumpkins(this);
    DefaultBiomeFeatures.addSprings(this);
    DefaultBiomeFeatures.addJunglePlants(this);
    DefaultBiomeFeatures.addFreezeTopLayer(this);
    ModFeatureConfig.addMiniJungleVegetation(this);
    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.withConfiguration(new SeaGrassConfig(64, 0.6D)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 4, 4));
    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PARROT, 40, 1, 2));
    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PANDA, 1, 1, 2));
    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
    this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.TROPICAL_FISH, 30, 5, 8));
    this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 10, 8, 8));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));
    this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.OCELOT, 2, 1, 1));
  }
}
