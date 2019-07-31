package epicsquid.traverse.world.feature;

import epicsquid.traverse.RegistryManager;
import epicsquid.traverse.Traverse;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Random;

@Mod.EventBusSubscriber(modid = Traverse.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModFeatures {

	public static Random rand = new Random();
	public static Feature<NoFeatureConfig> RED_AUTUMNAL_TREE = RegistryManager.RED_AUTUMNAL_TREE.getTreeFeature(rand);
	public static Feature<NoFeatureConfig> BROWN_AUTUMNAL_TREE = RegistryManager.BROWN_AUTUMNAL_TREE.getTreeFeature(rand);
	public static Feature<NoFeatureConfig> ORANGE_AUTUMNAL_TREE = RegistryManager.ORANGE_AUTUMNAL_TREE.getTreeFeature(rand);
	public static Feature<NoFeatureConfig> YELLOW_AUTUMNAL_TREE = RegistryManager.YELLOW_AUTUMNAL_TREE.getTreeFeature(rand);
	public static Feature<NoFeatureConfig> LUSH_FLOWER = new MeadowFlowersFeature(NoFeatureConfig::deserialize);
	public static Feature<NoFeatureConfig> MINI_JUNGLE_TREE = new JungleTreeFeature(NoFeatureConfig::deserialize, false, 4, Blocks.JUNGLE_LOG.getDefaultState(), Blocks.JUNGLE_LEAVES.getDefaultState(), true);
	public static Feature<NoFeatureConfig> OAK_SHRUB = new ShrubFeature(NoFeatureConfig::deserialize, Blocks.OAK_LOG.getDefaultState(), Blocks.OAK_LEAVES.getDefaultState());
	public static Feature<NoFeatureConfig> FIR_TREE = RegistryManager.FIR_TREE.getTreeFeature(rand);
	public static Feature<NoFeatureConfig> TALL_SWAMP_TREE = new TreeFeature(NoFeatureConfig::deserialize, false, 7, Blocks.OAK_LOG.getDefaultState(), Blocks.OAK_LEAVES.getDefaultState(), true);
	public static Feature<NoFeatureConfig> FALLEN_OAK_TREE = new FallenLogFeature(NoFeatureConfig::deserialize, false, Blocks.OAK_LOG.getDefaultState(), 3, 2);


	@SubscribeEvent
	public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
		IForgeRegistry<Feature<?>> registry = event.getRegistry();

		registry.register(RED_AUTUMNAL_TREE.setRegistryName(Traverse.MODID, "red_autumnal_tree"));
		registry.register(BROWN_AUTUMNAL_TREE.setRegistryName(Traverse.MODID, "brown_autumnal_tree"));
		registry.register(ORANGE_AUTUMNAL_TREE.setRegistryName(Traverse.MODID, "orange_autumnal_tree"));
		registry.register(YELLOW_AUTUMNAL_TREE.setRegistryName(Traverse.MODID, "yellow_autumnal_tree"));
		registry.register(LUSH_FLOWER.setRegistryName(Traverse.MODID, "lush_flower"));
		registry.register(MINI_JUNGLE_TREE.setRegistryName(Traverse.MODID, "mini_jungle_tree"));
		registry.register(OAK_SHRUB.setRegistryName(Traverse.MODID, "oak_shrub"));
		registry.register(FIR_TREE.setRegistryName(Traverse.MODID, "fir_tree"));
		registry.register(TALL_SWAMP_TREE.setRegistryName(Traverse.MODID, "tall_swamp_tree"));
		registry.register(FALLEN_OAK_TREE.setRegistryName(Traverse.MODID, "fallen_oak_tree"));
	}
}
