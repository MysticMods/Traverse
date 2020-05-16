package epicsquid.traverse.setup;

import epicsquid.traverse.RegistryManager;
import epicsquid.traverse.Traverse;
import epicsquid.traverse.blocks.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Traverse.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

  @SubscribeEvent
  public static void init(FMLClientSetupEvent event) {
    RenderType rendertype = RenderType.getCutoutMipped();
    RenderTypeLookup.setRenderLayer(ModBlocks.FIR_LEAVES, rendertype);
    RenderTypeLookup.setRenderLayer(RegistryManager.BROWN_LEAVES, rendertype);
    RenderTypeLookup.setRenderLayer(RegistryManager.YELLOW_LEAVES, rendertype);
    RenderTypeLookup.setRenderLayer(RegistryManager.ORANGE_LEAVES, rendertype);
    RenderTypeLookup.setRenderLayer(RegistryManager.RED_LEAVES, rendertype);
    rendertype = RenderType.getCutout();
    RenderTypeLookup.setRenderLayer(ModBlocks.FIR_SAPLING, rendertype);
    RenderTypeLookup.setRenderLayer(RegistryManager.BROWN_SAPLING, rendertype);
    RenderTypeLookup.setRenderLayer(RegistryManager.YELLOW_SAPLING, rendertype);
    RenderTypeLookup.setRenderLayer(RegistryManager.ORANGE_SAPLING, rendertype);
    RenderTypeLookup.setRenderLayer(RegistryManager.RED_SAPLING, rendertype);
    RenderTypeLookup.setRenderLayer(RegistryManager.FIR_TRAPDOOR, rendertype);
    RenderTypeLookup.setRenderLayer(RegistryManager.FIR_DOOR, rendertype);
  }
}
