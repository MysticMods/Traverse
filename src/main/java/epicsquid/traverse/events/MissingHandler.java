package epicsquid.traverse.events;

import epicsquid.traverse.Traverse;
import epicsquid.traverse.init.ModBiomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid= Traverse.MODID)
public class MissingHandler {
  @SubscribeEvent
  public static void onMissingBiomes (RegistryEvent.MissingMappings<Biome> event) {
/*    for (RegistryEvent.MissingMappings.Mapping<Biome> mapping : event.getAllMappings()) {
      ResourceLocation rl = mapping.key;
      if (rl.getNamespace().equals(Traverse.MODID)) {
        if (rl.getPath().equals("rock_edge")) {
          mapping.remap(ModBiomes.ROCKY_EDGE.get());
        } else if (rl.getPath().equals("coniferous_woodland_hills_biome")) {
          mapping.remap(ModBiomes.CONIFEROUS_WOODLAND_HILLS.get());
        }
      }
    }*/
  }
}
