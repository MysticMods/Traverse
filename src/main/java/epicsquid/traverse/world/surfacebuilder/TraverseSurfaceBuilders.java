package epicsquid.traverse.world.surfacebuilder;

import epicsquid.traverse.Traverse;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.HashMap;
import java.util.Map;

public class TraverseSurfaceBuilders {
	private static final Map<ResourceLocation, SurfaceBuilder<? extends SurfaceBuilderConfig>> SURFACE_BUILDERS = new HashMap<>();


	private static <S extends SurfaceBuilder<? extends SurfaceBuilderConfig>> S add(String name, S feature) {
		SURFACE_BUILDERS.put(new ResourceLocation(Traverse.MODID, name), feature);
		return feature;
	}

	public static void register() {
		for (ResourceLocation id : SURFACE_BUILDERS.keySet()) {
			Registry.register(Registry.SURFACE_BUILDER, id, SURFACE_BUILDERS.get(id));
		}
	}

}
