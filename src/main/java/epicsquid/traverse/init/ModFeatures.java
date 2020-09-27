package epicsquid.traverse.init;

import com.tterrag.registrate.util.entry.RegistryEntry;
import epicsquid.traverse.world.feature.FallenLogFeature;
import epicsquid.traverse.world.feature.FallenLogFeatureConfig;

import static epicsquid.traverse.Traverse.REGISTRATE;

public class ModFeatures {
  public static final RegistryEntry<FallenLogFeature> FALLEN_OAK_TREE = REGISTRATE.feature("fallen_tree", FallenLogFeature::new, FallenLogFeatureConfig::deserialize).register();

  public static void load() {
  }
}
