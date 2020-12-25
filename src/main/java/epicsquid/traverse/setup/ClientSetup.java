package epicsquid.traverse.setup;

import epicsquid.traverse.Traverse;
import epicsquid.traverse.init.ModBlocks;
import epicsquid.traverse.init.ModEntities;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import noobanidus.libs.noobutil.client.SignSprites;

@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(modid = Traverse.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

  @SubscribeEvent
  public static void init(FMLClientSetupEvent event) {
    RenderingRegistry.registerEntityRenderingHandler(ModEntities.FIR_BOAT.get(), BoatRenderer::new);

    DeferredWorkQueue.runLater(() -> {
      RenderType rendertype = RenderType.getCutoutMipped();
      RenderTypeLookup.setRenderLayer(ModBlocks.FIR_LEAVES.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.BROWN_AUTUMNAL_LEAVES.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.YELLOW_AUTUMNAL_LEAVES.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_AUTUMNAL_LEAVES.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.RED_AUTUMNAL_LEAVES.get(), rendertype);
      rendertype = RenderType.getCutout();
      RenderTypeLookup.setRenderLayer(ModBlocks.FIR_SAPLING.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.BROWN_AUTUMNAL_SAPLING.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.YELLOW_AUTUMNAL_SAPLING.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_AUTUMNAL_SAPLING.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.RED_AUTUMNAL_SAPLING.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.FIR_TRAPDOOR.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.FIR_DOOR.get(), rendertype);
    });
  }
}
