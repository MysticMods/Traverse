package mysticalmods.traverse.biomebuilder;

import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class FeatureEntry {

  private GenerationStage.Decoration step;
  private ConfiguredFeature feature;

  public FeatureEntry(GenerationStage.Decoration step, ConfiguredFeature feature) {
    this.step = step;
    this.feature = feature;
  }

  public GenerationStage.Decoration getStage() {
    return this.step;
  }

  public ConfiguredFeature getFeature() {
    return this.feature;
  }
}
