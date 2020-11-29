package epicsquid.traverse.setup;

import epicsquid.traverse.Traverse;
import epicsquid.traverse.init.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(modid = Traverse.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

  @SubscribeEvent
  public static void init(FMLClientSetupEvent event) {
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
