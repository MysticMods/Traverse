package epicsquid.traverse.mixin;

import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraft.entity.villager.VillagerType;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(VillagerType.class)
public interface AccessorVillagerType {
  @Accessor("BY_BIOME")
  static Map<RegistryKey<Biome>, VillagerType> getBiomeTypeToIdMap() {
    throw new AssertionError("Untransformed Accessor!");
  }
}
