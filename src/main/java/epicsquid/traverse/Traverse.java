package epicsquid.traverse;

import epicsquid.traverse.config.ConfigManager;
import epicsquid.traverse.items.ModItems;
import epicsquid.traverse.setup.ModSetup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("traverse")
public class Traverse {
  public static final String MODID = "traverse";

  public static final ItemGroup ITEM_GROUP = new ItemGroup("traverse") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(ModItems.FIR_LOG);
    }
  };

  public static ModSetup setup = new ModSetup();

  public Traverse() {
    FMLJavaModLoadingContext.get().getModEventBus().addListener(setup::init);

    ConfigManager.loadConfig(ConfigManager.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + "-common.toml"));
  }
}
