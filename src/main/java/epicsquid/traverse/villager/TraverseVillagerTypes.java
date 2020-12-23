package epicsquid.traverse.villager;

import epicsquid.traverse.init.ModBiomes;
import epicsquid.traverse.mixin.AccessorVillagerType;
import net.minecraft.entity.villager.VillagerType;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;

import java.util.Map;

public class TraverseVillagerTypes {
  public static void register () {
    register(VillagerType.SAVANNA, ModBiomes.ARID_HIGHLANDS);
    register(VillagerType.PLAINS, ModBiomes.AUTUMNAL_WOODED_HILLS, ModBiomes.AUTUMNAL_WOODS, ModBiomes.CLIFFS, ModBiomes.CONIFEROUS_FOREST, ModBiomes.CONIFEROUS_WOODED_HILLS, ModBiomes.HIGH_CONIFEROUS_FOREST, ModBiomes.WOODED_ISLAND, ModBiomes.WOODLANDS, ModBiomes.MEADOW, ModBiomes.PLAINS_PLATEAU, ModBiomes.ROCKY_EDGE, ModBiomes.WOODED_PLATEAU, ModBiomes.ROLLING_HILLS);
    register(VillagerType.DESERT, ModBiomes.DESERT_SHRUBLAND);
    register(VillagerType.SWAMP, ModBiomes.LUSH_SWAMP);
    register(VillagerType.SNOW, ModBiomes.SNOWY_CLIFFS);
    register(VillagerType.TAIGA, ModBiomes.SNOWY_CONIFEROUS_FOREST, ModBiomes.SNOWY_CONIFEROUS_WOODED_HILLS, ModBiomes.SNOWY_HIGH_CONIFEROUS_FOREST);
  }

  @SafeVarargs
  private static void register(VillagerType type, RegistryKey<Biome> ... biomes) {
    Map<RegistryKey<Biome>, VillagerType> map = AccessorVillagerType.getBiomeTypeToIdMap();
    for (RegistryKey<Biome> biome : biomes) {
      map.put(biome, type);
    }
  }
}
