package epicsquid.traverse.mixin;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraft.util.ResourceLocation;
import noobanidus.libs.noobutil.block.IModdedSign;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SignTileEntityRenderer.class)
public class MixinSignTileEntityRenderer {
  @Inject(method = "getMaterial", at = @At("HEAD"), cancellable = true)
  private static void getMaterial(Block block, CallbackInfoReturnable<RenderMaterial> info) {
    if (block instanceof IModdedSign) {
      ResourceLocation texture = ((IModdedSign) block).getTexture();
      info.setReturnValue(new RenderMaterial(Atlases.SIGN_ATLAS, texture));
    }
  }
}
