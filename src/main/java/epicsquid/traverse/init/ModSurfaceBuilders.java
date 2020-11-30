package epicsquid.traverse.init;

import com.tterrag.registrate.util.entry.RegistryEntry;
import epicsquid.traverse.world.placer.FallenTrunkPlacer;
import epicsquid.traverse.world.placer.NoneFoliagePlacer;
import epicsquid.traverse.world.surfacebuilder.BeachSurfaceBuilder;
import epicsquid.traverse.world.surfacebuilder.SandWithPatchesSurfaceBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.trunkplacer.TrunkPlacerType;
import noobanidus.libs.noobutil.types.SupplierBlockStateProvider;

import static epicsquid.traverse.Traverse.REGISTRATE;

public class ModSurfaceBuilders {
	public static final RegistryEntry<SurfaceBuilder<SurfaceBuilderConfig>> ARID_HIGHLANDS = REGISTRATE.simple("arid_highlands", SurfaceBuilder.class, () -> new SandWithPatchesSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_, 0.9D));
	public static final RegistryEntry<SurfaceBuilder<SurfaceBuilderConfig>> DESERT_SHRUBLAND = REGISTRATE.simple("desert_shrubland", SurfaceBuilder.class, () -> new SandWithPatchesSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_, 1.5D));
	public static final RegistryEntry<SurfaceBuilder<SurfaceBuilderConfig>> WOODED_ISLAND = REGISTRATE.simple("wooded_island", SurfaceBuilder.class, () -> new BeachSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_, 62, v -> Blocks.SAND.getDefaultState()));

  public static void load() {
  }
}
