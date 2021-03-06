package mysticalmods.traverse.setup;

import mysticalmods.traverse.Traverse;
import mysticalmods.traverse.init.ModBlocks;
import mysticalmods.traverse.init.ModEntities;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(modid = Traverse.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

  @SubscribeEvent
  public static void init(FMLClientSetupEvent event) {
    RenderingRegistry.registerEntityRenderingHandler(ModEntities.FIR_BOAT.get(), BoatRenderer::new);

    event.enqueueWork(() -> {
      RenderType rendertype = RenderType.getCutoutMipped();
      RenderTypeLookup.setRenderLayer(ModBlocks.FIR_LEAVES.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.BROWN_AUTUMNAL_LEAVES.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.YELLOW_AUTUMNAL_LEAVES.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_AUTUMNAL_LEAVES.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.RED_AUTUMNAL_LEAVES.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.FIR_SAPLING.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.BROWN_AUTUMNAL_SAPLING.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.YELLOW_AUTUMNAL_SAPLING.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.ORANGE_AUTUMNAL_SAPLING.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.RED_AUTUMNAL_SAPLING.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.FIR_TRAPDOOR.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.FIR_DOOR.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_BROWN_AUTUMNAL_SAPLING.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_FIR_SAPLING.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_ORANGE_AUTUMNAL_SAPLING.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_BROWN_AUTUMNAL_SAPLING.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_FIR_SAPLING.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_RED_AUTUMNAL_SAPLING.get(), rendertype);
      RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_YELLOW_AUTUMNAL_SAPLING.get(), rendertype);
    });
  }
}
