package epicsquid.traverse.biome;

import net.minecraft.world.biome.Biome;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBiome extends Biome {
  public static List<AbstractBiome> BIOMES = new ArrayList<>();

  protected AbstractBiome(Builder biomeBuilder) {
    super(biomeBuilder);
    BIOMES.add(this);
  }

  public abstract void init ();

  public static void finalise () {
    BIOMES.forEach(AbstractBiome::init);
  }
}
