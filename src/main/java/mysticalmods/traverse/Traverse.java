package mysticalmods.traverse;

import mysticalmods.traverse.config.ConfigManager;
import epicsquid.traverse.init.*;
import mysticalmods.traverse.setup.ClientInit;
import mysticalmods.traverse.setup.ModSetup;
import mysticalmods.traverse.init.*;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import noobanidus.libs.noobutil.registrate.CustomRegistrate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("traverse")
public class Traverse {
  public static final String MODID = "traverse";
  public static CustomRegistrate REGISTRATE;
  public static final Logger LOG = LogManager.getLogger();

  public static final ResourceLocation FIR_SIGN_TEXTURE = new ResourceLocation(Traverse.MODID, "entity/sign/fir");

  public static final ItemGroup ITEM_GROUP = new ItemGroup("traverse") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(ModBlocks.FIR_LOG.get());
    }
  };

  public Traverse() {
    REGISTRATE = CustomRegistrate.create(MODID);
    REGISTRATE.itemGroup(() -> ITEM_GROUP);

    ConfigManager.loadConfig(ConfigManager.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + "-common.toml"));
    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigManager.COMMON_CONFIG);
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    bus.addListener(ModSetup::init);

    ModBlocks.load();
    ModItems.load();
    ModEntities.load();
    ModFeatures.load();
    ModSurfaceBuilders.load();
    ModLang.load();

    DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientInit::init);
  }
}
