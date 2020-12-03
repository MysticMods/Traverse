package epicsquid.traverse.biome.variants;

import net.minecraft.client.renderer.model.Variant;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;

import javax.annotation.Nullable;
import java.util.*;

public class BiomeVariants {
  public static Random rand = new Random();

  private static Map<RegistryKey<Biome>, Set<Variant>> replacements = new HashMap<>();

  public static void addReplacement (RegistryKey<Biome> replacing, RegistryKey<Biome> replacement, double chance) {
    replacements.computeIfAbsent(replacing, (k) -> new HashSet<>()).add(new Variant(replacement, chance));
  }

  @Nullable
  public static RegistryKey<Biome> pickReplacement (RegistryKey<Biome> replacing) {
    Set<Variant> variants = replacements.get(replacing);
    if (variants != null) {
      for (Variant v : variants) {
        if (rand.nextDouble() < v.getChance()) {
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
