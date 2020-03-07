package epicsquid.traverse.biome;

import epicsquid.traverse.world.surfacebuilder.ModSurfaceBuilders;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class AridHighlandsBiome extends Biome {

  static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(ModSurfaceBuilders.ARID_HIGHLANDS, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG);
  static final RainType PRECIPITATION = RainType.NONE;
  static final Category CATEGORY = Category.DESERT;
  static final float DEPTH = 1.3F;
  static final float SCALE = 0.3F;
  static final float TEMPERATURE = 2.0F;
  static final float DOWNFALL = 0.0F;
  static final int WATER_COLOR = 0x3F76E4;
  static final int WATER_FOG_COLOR = 0x50533;
  static final int GRASS_COLOR = 0xBACD78;
  static final int FOLIAGE_COLOR = 0x80A02E;
  static final String PARENT = null;

  public AridHighlandsBiome() {
    super(new Biome.Builder().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPITATION).category(CATEGORY).depth(DEPTH).scale(SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).parent(PARENT));
    this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
    this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
    DefaultBiomeFeatures.addCarvers(this);
    DefaultBiomeFeatures.addStructures(this);
    DefaultBiomeFeatures.addLakes(this);
    DefaultBiomeFeatures.addMonsterRooms(this);
    DefaultBiomeFeatures.addStoneVariants(this);
    DefaultBiomeFeatures.addOres(this);
    DefaultBiomeFeatures.addSedimentDisks(this);
    DefaultBiomeFeatures.addDoubleFlowers(this);
    DefaultBiomeFeatures.addDesertFeatures(this);
    DefaultBiomeFeatures.addDeadBushes(this);
    DefaultBiomeFeatures.addExtraReedsPumpkinsCactus(this);
    // Add Savanna Grass
    DefaultBiomeFeatures.addVeryDenseGrass(this);
    DefaultBiomeFeatures.addSavannaTrees(this);
    DefaultBiomeFeatures.addMushrooms(this);
    DefaultBiomeFeatures.addReedsAndPumpkins(this);
    DefaultBiomeFeatures.addSprings(this);
    DefaultBiomeFeatures.addFreezeTopLayer(this);
    TraverseDefaultBiomeFeatures.addShrubs(this, 1);
    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.RABBIT, 3, 2, 3));
    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 6, 3, 3));
    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 5, 3, 3));
    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 5, 3, 3));
    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 4, 3, 3));
    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.HORSE, 1, 1, 3));
    this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.DONKEY, 1, 1, 1));
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

  @Override
  public int getGrassColor(double posX, double posZ) {
    return GRASS_COLOR;
  }

  @Override
  public int getFoliageColor() {
    return FOLIAGE_COLOR;
  }
}
