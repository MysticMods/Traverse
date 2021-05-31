package mysticalmods.traverse.mixin;

import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.model.RenderMaterial;
import noobanidus.libs.noobutil.client.SignSprites;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(Atlases.class)
public class MixinAtlases {
  @Inject(method = "collectAllMaterials", at = @At("RETURN"))
  private static void collectModdedSigns(Consumer<RenderMaterial> consumer, CallbackInfo info) {
    for (RenderMaterial material : SignSprites.getSprites()) {
      consumer.accept(material);
    }
  }
}
