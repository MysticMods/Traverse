package epicsquid.traverse.biome.variants;

import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;

import javax.annotation.Nullable;
import java.util.*;

public class BiomeVariants {
  public static Random rand = new Random();

  private static Map<RegistryKey<Biome>, Set<Variant>> hillReplacements = new HashMap<>();
  private static Map<RegistryKey<Biome>, Set<Variant>> biomeReplacements = new HashMap<>();
  private static Map<RegistryKey<Biome>, Set<Variant>> riverReplacements = new HashMap<>();
  private static Map<RegistryKey<Biome>, Set<Variant>> edgeReplacements = new HashMap<>();
  private static Map<RegistryKey<Biome>, Set<Variant>> centerReplacements = new HashMap<>();
  private static Map<RegistryKey<Biome>, Set<Variant>> shoreReplacements = new HashMap<>();

  public enum VariantType {
    HILLS, BIOME, RIVER, EDGE, CENTER, SHORE
  }

  public static void addReplacement(RegistryKey<Biome> replacing, RegistryKey<Biome> replacement, double chance, VariantType type) {
    if (type == VariantType.BIOME) {
      biomeReplacements.computeIfAbsent(replacing, (k) -> new HashSet<>()).add(new Variant(replacement, chance));
    } else if (type == VariantType.HILLS) {
      hillReplacements.computeIfAbsent(replacing, (k) -> new HashSet<>()).add(new Variant(replacement, chance));
    } else if (type == VariantType.RIVER) {
      riverReplacements.computeIfAbsent(replacing, (k) -> new HashSet<>()).add(new Variant(replacement, chance));
    } else if (type == VariantType.EDGE) {
      edgeReplacements.computeIfAbsent(replacing, (k) -> new HashSet<>()).add(new Variant(replacement, chance));
    } else if (type == VariantType.CENTER) {
      centerReplacements.computeIfAbsent(replacing, (k) -> new HashSet<>()).add(new Variant(replacement, chance));
    } else if (type == VariantType.SHORE) {
      shoreReplacements.computeIfAbsent(replacing, (k) -> new HashSet<>()).add(new Variant(replacement, chance));
    }
  }

  @Nullable
  public static RegistryKey<Biome> pickReplacement(RegistryKey<Biome> replacing, VariantType type) {
    Set<Variant> variants;
    if (type == VariantType.BIOME) {
      variants = biomeReplacements.get(replacing);
    } else if (type == VariantType.HILLS) {
      variants = hillReplacements.get(replacing);
    } else if (type == VariantType.RIVER) {
      variants = riverReplacements.get(replacing);
    } else if (type == VariantType.EDGE) {
      variants = edgeReplacements.get(replacing);
    } else if (type == VariantType.CENTER) {
      variants = centerReplacements.get(replacing);
    } else if (type == VariantType.SHORE) {
      variants = shoreReplacements.get(replacing);
    } else {
      return null;
    }
    if (variants != null) {
      for (Variant v : variants) {
        if (type == VariantType.RIVER || rand.nextDouble() < v.getChance()) {
          return v.getReplacement();
        }
      }
    }
    return null;
  }

  private static class Variant implements Comparable<Variant> {
    private final RegistryKey<Biome> replacement;
    private final double chance;

    public Variant(RegistryKey<Biome> replacement, double chance) {
      this.replacement = replacement;
      this.chance = chance;
    }

    public RegistryKey<Biome> getReplacement() {
      return replacement;
    }

    public double getChance() {
      return chance;
    }

    @Override
    public int compareTo(Variant o) {
      return Double.compare(getChance(), o.getChance());
    }
  }
}
