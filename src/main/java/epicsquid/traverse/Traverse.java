package epicsquid.traverse;

import epicsquid.traverse.config.ConfigManager;
import epicsquid.traverse.init.ModBiomes;
import epicsquid.traverse.init.ModBlocks;
import epicsquid.traverse.init.ModFeatures;
import epicsquid.traverse.setup.ClientSetup;
import epicsquid.traverse.setup.ModSetup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import noobanidus.libs.noobutil.data.RecipeGenerator;
import noobanidus.libs.noobutil.registrate.CustomRegistrate;

@Mod("traverse")
public class Traverse {
  public static final String MODID = "traverse";
  public static CustomRegistrate REGISTRATE;
  public static RecipeGenerator RECIPES = new RecipeGenerator(MODID);

  public static final ItemGroup ITEM_GROUP = new ItemGroup("traverse") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(ModBlocks.FIR_LOG.get());
    }
  };

  public Traverse() {
    REGISTRATE = CustomRegistrate.create(MODID);
    REGISTRATE.itemGroup(() -> ITEM_GROUP);

    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigManager.COMMON_CONFIG);
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    bus.addListener(ModSetup::init);

    ModBlocks.load();
    ModFeatures.load();
    ModBiomes.load();

    DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
      bus.addListener(ClientSetup::init);
    });

    ConfigManager.loadConfig(ConfigManager.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + "-common.toml"));
  }
}
