package epicsquid.traverse.world.feature;

import epicsquid.traverse.Traverse;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Traverse.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModFeatures {

//	public static Feature<NoFeatureConfig> FALLEN_OAK_TREE = new FallenLogFeature(NoFeatureConfig::deserialize, false, Blocks.OAK_LOG.getDefaultState(), 3, 2);


	@SubscribeEvent
	public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
		IForgeRegistry<Feature<?>> registry = event.getRegistry();
//		registry.register(FALLEN_OAK_TREE.setRegistryName(Traverse.MODID, "fallen_oak_tree"));
	}
}
