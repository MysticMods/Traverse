package epicsquid.traverse.biomebuilder;

import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public final class TerraformBiomeBuilder extends BuilderBiomeSettings {
  private final ArrayList<DefaultFeature> defaultFeatures = new ArrayList<>();
  private final ArrayList<FeatureEntry> features = new ArrayList<>();
  private final ArrayList<StructureFeature<? extends IFeatureConfig, ? extends Structure<? extends IFeatureConfig>>> structureFeatures = new ArrayList<>();
  private final ArrayList<MobSpawnInfo.Spawners> spawnEntries = new ArrayList<>();
  private float spawnChance = -1.0F;
  private boolean template = false;
  private boolean playerSpawnFriendly = false;

  private TerraformBiomeBuilder() {
    super();

    parent(null);
  }

  public TerraformBiomeBuilder(TerraformBiomeBuilder existing) { // Template copy code
    super(existing);

    this.defaultFeatures.addAll(existing.defaultFeatures);
    this.features.addAll(existing.features);
    this.structureFeatures.addAll(existing.structureFeatures);
    this.spawnEntries.addAll(existing.spawnEntries);

    this.spawnChance = existing.spawnChance;
    this.playerSpawnFriendly = existing.playerSpawnFriendly;
  }

  @SuppressWarnings("unchecked")
  public Biome build() {
    if (template) {
      throw new IllegalStateException("Tried to call build() on a frozen Builder instance!");
    }

    Biome.Builder builder = new Biome.Builder();
    builder.category(this.category);
    builder.depth(this.depth);
    builder.scale(this.scale);
    builder.downfall(this.downfall);
    builder.precipitation(this.precipitation);
    builder.temperature(this.temperature);
    builder.setEffects(this.effects.build());

    BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(this.surfaceBuilder);

    MobSpawnInfo.Builder spawnSettings = new MobSpawnInfo.Builder();
    // Set spawn chance
    if (this.spawnChance != -1.0F) {
      spawnSettings.withCreatureSpawnProbability(this.spawnChance);
    }

    for (MobSpawnInfo.Spawners spawnEntry : spawnEntries) {
      spawnSettings.withSpawner(spawnEntry.type.getClassification(), spawnEntry);
    }

    if (playerSpawnFriendly) {
      spawnSettings.isValidSpawnBiomeForPlayer();
    }

    // Add structures
    for (StructureFeature<? extends IFeatureConfig, ? extends Structure<? extends IFeatureConfig>> structure : structureFeatures) {
      generationSettings.withStructure(structure);
    }

    // Add any minecraft (default) features
    for (DefaultFeature defaultFeature : defaultFeatures) {
      defaultFeature.add(generationSettings);
    }

    // Add custom features that don't fit in the templates
    for (FeatureEntry feature : features) {
      generationSettings.withFeature(feature.getStage(), feature.getFeature());
    }

    builder.withGenerationSettings(generationSettings.build());
    builder.withMobSpawnSettings(spawnSettings.copy());
    return builder.build();
  }

  @Override
  public TerraformBiomeBuilder surfaceBuilder(ConfiguredSurfaceBuilder<?> surfaceBuilder) {
    super.surfaceBuilder(surfaceBuilder);
    return this;
  }

  @Override
  public TerraformBiomeBuilder precipitation(Biome.RainType precipitation) {
    super.precipitation(precipitation);
    return this;
  }

  @Override
  public TerraformBiomeBuilder category(Biome.Category category) {
    super.category(category);
    return this;
  }

  @Override
  public TerraformBiomeBuilder depth(float depth) {
    super.depth(depth);
    return this;
  }

  @Override
  public TerraformBiomeBuilder scale(float scale) {
    super.scale(scale);
    return this;
  }

  @Override
  public TerraformBiomeBuilder temperature(float temperature) {
    super.temperature(temperature);
    return this;
  }

  @Override
  public TerraformBiomeBuilder downfall(float downfall) {
    super.downfall(downfall);
    return this;
  }

  @Override
  public TerraformBiomeBuilder parent(String parent) {
    super.parent(parent);
    return this;
  }

  @Override
  public TerraformBiomeBuilder effects(BiomeAmbience.Builder effects) {
    super.effects(effects);
    return this;
  }

  public TerraformBiomeBuilder addFeature(GenerationStage.Decoration step, ConfiguredFeature feature) {
    this.features.add(new FeatureEntry(step, feature));
    return this;
  }

  public TerraformBiomeBuilder addSpawnEntry(MobSpawnInfo.Spawners entry) {
    this.spawnEntries.add(entry);
    return this;
  }

  public TerraformBiomeBuilder addStructureFeature(StructureFeature<? extends IFeatureConfig, ? extends Structure<? extends IFeatureConfig>> stucture) {
    this.structureFeatures.add(stucture);
    return this;
  }

  public TerraformBiomeBuilder addDefaultFeature(DefaultFeature feature) {
    defaultFeatures.add(feature);
    return this;
  }

  public TerraformBiomeBuilder addDefaultFeatures(DefaultFeature... features) {
    defaultFeatures.addAll(Arrays.asList(features));
    return this;
  }

  public TerraformBiomeBuilder addDefaultSpawnEntries() {
    this.addDefaultCreatureSpawnEntries()
        .addDefaultAmbientSpawnEntries()
        .addDefaultMonsterSpawnEntries();
    return this;
  }

  public TerraformBiomeBuilder addDefaultCreatureSpawnEntries() {
    this.addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SHEEP, 12, 4, 4))
        .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.PIG, 10, 4, 4))
        .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4))
        .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.COW, 8, 4, 4));
    return this;
  }

  public TerraformBiomeBuilder addDefaultAmbientSpawnEntries() {
    this.addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));
    return this;
  }

  public TerraformBiomeBuilder addDefaultMonsterSpawnEntries() {
    this.addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4))
        .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 95, 4, 4))
        .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 5, 1, 1))
        .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 4))
        .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4))
        .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 4, 4))
        .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4))
        .addSpawnEntry(new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1));
    return this;
  }

  public TerraformBiomeBuilder playerSpawnFriendly() {
    playerSpawnFriendly = true;
    return this;
  }

  void markTemplate() {
    this.template = true;
  }

  public static TerraformBiomeBuilder create() {
    return new TerraformBiomeBuilder();
  }
}
