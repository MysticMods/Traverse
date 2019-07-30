package epicsquid.traverse;

import epicsquid.traverse.setup.ModSetup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("traverse")
public class Traverse {
	public static final String MODID = "traverse";

	//	public static final ItemGroup ITEM_GROUP = new ItemGroup("traverse") {
	//		@Override
	//		public ItemStack createIcon() {
	//			return new ItemStack(ModItems.CARAPACE);
	//		}
	//	};

	public static ModSetup setup = new ModSetup();

	public Traverse() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(setup::init);

		//		ConfigManager.loadConfig(ConfigManager.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + "-common.toml"));
	}
}
