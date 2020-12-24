package epicsquid.traverse.villager;

import epicsquid.traverse.biome.TraverseBiomes;
import epicsquid.traverse.mixin.AccessorVillagerType;
import net.minecraft.entity.villager.VillagerType;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;

import java.util.Map;

public class TraverseVillagerTypes {
  public static void register() {
    register(VillagerType.SAVANNA, TraverseBiomes.ARID_HIGHLANDS);
    register(VillagerType.PLAINS, TraverseBiomes.AUTUMNAL_WOODED_HILLS, TraverseBiomes.AUTUMNAL_WOODS, TraverseBiomes.CLIFFS, TraverseBiomes.CONIFEROUS_FOREST, TraverseBiomes.CONIFEROUS_WOODED_HILLS, TraverseBiomes.HIGH_CONIFEROUS_FOREST, TraverseBiomes.WOODED_ISLAND, TraverseBiomes.WOODLANDS, TraverseBiomes.MEADOW, TraverseBiomes.PLAINS_PLATEAU, TraverseBiomes.ROCKY_EDGE, TraverseBiomes.WOODED_PLATEAU, TraverseBiomes.ROLLING_HILLS);
    register(VillagerType.DESERT, TraverseBiomes.DESERT_SHRUBLAND);
    register(VillagerType.SWAMP, TraverseBiomes.LUSH_SWAMP);
    register(VillagerType.SNOW, TraverseBiomes.SNOWY_CLIFFS);
    register(VillagerType.TAIGA, TraverseBiomes.SNOWY_CONIFEROUS_FOREST, TraverseBiomes.SNOWY_CONIFEROUS_WOODED_HILLS, TraverseBiomes.SNOWY_HIGH_CONIFEROUS_FOREST);
  }

  @SafeVarargs
  private static void register(VillagerType type, RegistryKey<Biome>... biomes) {
    Map<RegistryKey<Biome>, VillagerType> map = AccessorVillagerType.getBiomeTypeToIdMap();
    for (RegistryKey<Biome> biome : biomes) {
      map.put(biome, type);
    }
  }
}
