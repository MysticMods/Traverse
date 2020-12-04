package epicsquid.traverse.biomebuilder.mixin;

import epicsquid.traverse.biome.variants.BiomeVariants;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.EdgeBiomeLayer;
import net.minecraft.world.gen.layer.HillsLayer;
import net.minecraft.world.gen.layer.ShoreLayer;
import net.minecraftforge.common.BiomeDictionary;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EdgeBiomeLayer.class)
public class MixinEdgeBiomeLayer {
  @Inject(at = @At("HEAD"), method = "apply", cancellable = true)
  private void apply(INoiseRandom context, int north, int west, int south, int east, int center, CallbackInfoReturnable<Integer> info) {
    RegistryKey<Biome> key = BiomeRegistry.getKeyFromID(center);

    RegistryKey<Biome> centerKey = BiomeVariants.pickReplacement(key, BiomeVariants.VariantType.CENTER);
    if (centerKey != null && surrounded(north, west, south, east, center)) {
      info.setReturnValue(WorldGenRegistries.BIOME.getId(WorldGenRegistries.BIOME.getValueForKey(centerKey)));
    }
  }

	private static boolean surrounded(int neighbor1, int neighbor2, int neighbor3, int neighbor4, int biome) {
		return neighbor1 == biome && neighbor2 == biome && neighbor3 == biome && neighbor4 == biome;
	}
}
