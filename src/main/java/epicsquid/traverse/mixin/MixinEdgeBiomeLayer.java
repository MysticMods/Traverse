package epicsquid.traverse.mixin;

import epicsquid.traverse.biome.BiomeVariants;
import epicsquid.traverse.world.Reference;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.EdgeBiomeLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EdgeBiomeLayer.class)
public class MixinEdgeBiomeLayer {
  @Inject(at = @At("HEAD"), method = "apply(Lnet/minecraft/world/gen/INoiseRandom;IIIII)I", cancellable = true)
  private void apply(INoiseRandom context, int north, int west, int south, int east, int center, CallbackInfoReturnable<Integer> info) {
    RegistryKey<Biome> key = BiomeRegistry.getKeyFromID(center);

    RegistryKey<Biome> centerKey = BiomeVariants.pickReplacement(context, key, BiomeVariants.VariantType.CENTER);
    if (centerKey != null && surrounded(north, west, south, east, center)) {
      int id = Reference.getBiomeID(centerKey);
      if (id != -1) {
        info.setReturnValue(id);
      } else {
        System.out.println("Biome replacement " + centerKey + " has an ID of -1!");
      }
    }
  }

  private static boolean surrounded(int neighbor1, int neighbor2, int neighbor3, int neighbor4, int biome) {
    return neighbor1 == biome && neighbor2 == biome && neighbor3 == biome && neighbor4 == biome;
  }
}
