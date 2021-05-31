package mysticalmods.traverse.mixin;

import mysticalmods.traverse.biome.BiomeVariants;
import mysticalmods.traverse.world.Reference;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.HillsLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(HillsLayer.class)
public class MixinHillsLayer {
  @Inject(
      method = "apply(Lnet/minecraft/world/gen/INoiseRandom;Lnet/minecraft/world/gen/area/IArea;Lnet/minecraft/world/gen/area/IArea;II)I",
      at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/gen/INoiseRandom;random(I)I"),
      locals = LocalCapture.CAPTURE_FAILHARD,
      cancellable = true)
  private void transformVariants(INoiseRandom rand, IArea area1, IArea area2, int x, int z, CallbackInfoReturnable<Integer> cir, int i, int j, int k) {
    if (rand.random(3) == 0 || k == 0) {
      cir.setReturnValue(i);
    }
    RegistryKey<Biome> biomeKey = BiomeRegistry.getKeyFromID(i);
    RegistryKey<Biome> replacement = BiomeVariants.pickReplacement(rand, biomeKey, BiomeVariants.VariantType.HILLS);
    if (replacement != null) {
      int id = Reference.getBiomeID(replacement);
      if (id != -1) {
        cir.setReturnValue(id);
      } else {
        System.out.println("Biome replacement " + replacement + " has an ID of -1!");
      }
    }
  }
}
