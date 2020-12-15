package epicsquid.traverse.mixin;

import epicsquid.traverse.biome.variants.BiomeVariants;
import epicsquid.traverse.world.Reference;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.HillsLayer;
import net.minecraft.world.gen.layer.ShoreLayer;
import net.minecraftforge.common.BiomeDictionary;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShoreLayer.class)
public class MixinShoreLayer {
  @Inject(at = @At("HEAD"), method = "apply(Lnet/minecraft/world/gen/INoiseRandom;IIIII)I", cancellable = true)
  private void apply(INoiseRandom context, int north, int west, int south, int east, int center, CallbackInfoReturnable<Integer> info) {
    RegistryKey<Biome> key = BiomeRegistry.getKeyFromID(center);
    RegistryKey<Biome> shoreKey = BiomeVariants.pickReplacement(key, BiomeVariants.VariantType.SHORE);
    if (shoreKey != null && neighboursOcean(north, east, south, west)) {
      info.setReturnValue(Reference.getBiomeID(shoreKey));
      return;
    }
    RegistryKey<Biome> edgeKey = BiomeVariants.pickReplacement(key, BiomeVariants.VariantType.EDGE);
    if (edgeKey != null && isEdge(north, east, south, west, center)) {
      info.setReturnValue(Reference.getBiomeID(edgeKey));
    }
  }

  private static boolean neighboursOcean(int north, int east, int south, int west) {
    return isOceanBiome(north) || isOceanBiome(east) || isOceanBiome(south) || isOceanBiome(west);
  }

  private static boolean isOceanBiome(int id) {
    RegistryKey<Biome> key = BiomeRegistry.getKeyFromID(id);
    return BiomeDictionary.getTypes(key).contains(BiomeDictionary.Type.OCEAN);
  }

  private static boolean isEdge(int north, int east, int south, int west, int center) {
    return areDissimilar(center, north) || areDissimilar(center, east) || areDissimilar(center, south) || areDissimilar(center, west);
  }

  private static boolean areDissimilar(int mainBiomeId, int secondaryBiomeId) {
    if (mainBiomeId == secondaryBiomeId) { // for efficiency, determine if the ids are equal first
      return false;
    } else {
      // Regard a biome as "similar" to it's derived biome, i.e.
      // No edge between plains and sunflower plains

      // The parent-child relationship previously modeled in Biome itself is gone,
      // and has been - for the time being - replaced by a hardcoded raw-id map
      // in AddHillsLayer.
      Int2IntMap parentChildMap = HillsLayer.field_242940_c;
      return parentChildMap.get(mainBiomeId) != secondaryBiomeId && parentChildMap.get(secondaryBiomeId) != mainBiomeId;
    }
  }
}
