package epicsquid.traverse.setup;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientInit {
  public static void init () {
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    bus.addListener(ClientSetup::init);
  }
}
