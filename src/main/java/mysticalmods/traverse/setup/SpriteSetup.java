package mysticalmods.traverse.setup;

import mysticalmods.traverse.Traverse;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.util.ResourceLocation;
import noobanidus.libs.noobutil.client.SignSprites;

public class SpriteSetup {
  public static void init() {
    SignSprites.addRenderMaterial(new RenderMaterial(Atlases.SIGN_ATLAS, new ResourceLocation(Traverse.MODID, "entity/sign/fir")));
  }
}
