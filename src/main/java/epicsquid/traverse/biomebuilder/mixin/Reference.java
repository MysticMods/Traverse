package epicsquid.traverse.biomebuilder.mixin;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

import javax.annotation.Nullable;

public class Reference {
  public static DynamicRegistries.Impl dynamicRegistry;

  @Nullable
  private static MutableRegistry<Biome> getBiomeRegistry() {
    if (dynamicRegistry == null) {
      return null;
    }
    return dynamicRegistry.getRegistry(Registry.BIOME_KEY);
  }

  public static int getBiomeID (RegistryKey<Biome> key) {
    MutableRegistry<Biome> reg = getBiomeRegistry();
    if (reg == null) {
      return -1;
    }

    Biome biome = reg.getValueForKey(key);
    if (biome == null) {
      return -1;
    }

    return reg.getId(biome);
  }
}
