package epicsquid.traverse.world.surfacebuilder;

import epicsquid.traverse.Traverse;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Traverse.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSurfaceBuilders {

	public static SurfaceBuilder<SurfaceBuilderConfig> ARID_HIGHLANDS = new SandWithPatchesSurfaceBuilder(SurfaceBuilderConfig::deserialize, 0.9);
	public static SurfaceBuilder<SurfaceBuilderConfig> FOREST_ISLAND = new SandWithPatchesSurfaceBuilder(SurfaceBuilderConfig::deserialize, 1.5);
	public static SurfaceBuilder<SurfaceBuilderConfig> DESERT_SHRUBLAND = new BeachSurfaceBuilder(SurfaceBuilderConfig::deserialize, 62, v -> Blocks.SAND.getDefaultState());

	@SubscribeEvent
	public static void registerSurfaceBuilders(RegistryEvent.Register<SurfaceBuilder<?>> event) {
		IForgeRegistry<SurfaceBuilder<?>> registry = event.getRegistry();

		registry.register(ARID_HIGHLANDS.setRegistryName(Traverse.MODID, "arid_highlands"));
		registry.register(DESERT_SHRUBLAND.setRegistryName(Traverse.MODID, "desert_shrubland"));
		registry.register(FOREST_ISLAND.setRegistryName(Traverse.MODID, "forest_island"));
	}
}
