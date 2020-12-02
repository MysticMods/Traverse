package epicsquid.traverse.biomebuilder;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class BuilderBiomeSettings implements Cloneable {
  protected ConfiguredSurfaceBuilder<?> surfaceBuilder;
  protected Biome.RainType precipitation;
  protected Biome.Category category;
  protected BiomeAmbience.Builder effects;
  protected Float depth;
  protected Float scale;
  protected Float temperature;
  protected Float downfall;
  protected String parent;

  public BuilderBiomeSettings() {
    super();
  }

  public BuilderBiomeSettings(BuilderBiomeSettings existing) {
    if (existing.surfaceBuilder != null) {
      this.surfaceBuilder(existing.surfaceBuilder);
    }

    if (existing.precipitation != null) {
      this.precipitation(existing.precipitation);
    }

    if (existing.category != null) {
      this.category(existing.category);
    }

    if (existing.depth != null) {
      this.depth(existing.depth);
    }

    if (existing.scale != null) {
      this.scale(existing.scale);
    }

    if (existing.temperature != null) {
      this.temperature(existing.temperature);
    }

    if (existing.downfall != null) {
      this.downfall(existing.downfall);
    }

    if (existing.parent != null) {
      this.parent(existing.parent);
    }

    if (existing.effects != null) {
      this.effects(existing.effects);
    }
  }

  @Deprecated
  public <SC extends ISurfaceBuilderConfig> BuilderBiomeSettings configureSurfaceBuilder(SurfaceBuilder<SC> builder, SC config) {
    this.surfaceBuilder = new ConfiguredSurfaceBuilder<>(builder, config);
    return this;
  }

  public BuilderBiomeSettings surfaceBuilder(ConfiguredSurfaceBuilder<?> surfaceBuilder) {
    this.surfaceBuilder = surfaceBuilder;
    return this;
  }

  public BuilderBiomeSettings precipitation(Biome.RainType precipitation) {
    this.precipitation = precipitation;
    return this;
  }

  public BuilderBiomeSettings category(Biome.Category category) {
    this.category = category;
    return this;
  }

  public BuilderBiomeSettings depth(float depth) {
    this.depth = depth;
    return this;
  }

  public BuilderBiomeSettings scale(float scale) {
    this.scale = scale;
    return this;
  }

  public BuilderBiomeSettings temperature(float temperature) {
    this.temperature = temperature;
    return this;
  }

  public BuilderBiomeSettings downfall(float downfall) {
    this.downfall = downfall;
    return this;
  }

  public BuilderBiomeSettings parent(String parent) {
    this.parent = parent;
    return this;
  }

  public BuilderBiomeSettings effects(BiomeAmbience.Builder effects) {
    this.effects = effects;
    return this;
  }
}
