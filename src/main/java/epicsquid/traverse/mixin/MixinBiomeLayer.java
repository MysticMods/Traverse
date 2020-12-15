package epicsquid.traverse.mixin;

import epicsquid.traverse.biome.variants.BiomeVariants;
import epicsquid.traverse.world.Reference;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.BiomeLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BiomeLayer.class)
public class MixinBiomeLayer {
  @Inject(at = @At("RETURN"), method = "apply(Lnet/minecraft/world/gen/INoiseRandom;I)I", cancellable = true)
  private void transformVariants(INoiseRandom context, int value, CallbackInfoReturnable<Integer> info) {
    int biomeId = info.getReturnValueI();
    RegistryKey<Biome> biomeKey = BiomeRegistry.getKeyFromID(biomeId);
    RegistryKey<Biome> replacement = BiomeVariants.pickReplacement(biomeKey, BiomeVariants.VariantType.BIOME);
    if (replacement != null) {
      info.setReturnValue(Reference.getBiomeID(replacement));
    }
  }
}
