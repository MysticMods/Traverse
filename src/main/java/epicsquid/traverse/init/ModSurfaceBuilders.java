package epicsquid.traverse.init;

import epicsquid.traverse.Traverse;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import noobanidus.libs.noobutil.world.gen.surfacebuilder.BeachSurfaceBuilder;
import noobanidus.libs.noobutil.world.gen.surfacebuilder.SandWithPatchesSurfaceBuilder;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = Traverse.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSurfaceBuilders {
  private static final Set<SurfaceBuilder<?>> BUILDERS = new HashSet<>();

  public static final SurfaceBuilder<SurfaceBuilderConfig> ARID_HIGHLANDS = add(new ResourceLocation(Traverse.MODID, "arid_highlands"), new SandWithPatchesSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_, 0.9D));
  public static final SurfaceBuilder<SurfaceBuilderConfig> DESERT_SHRUBLAND = add(new ResourceLocation(Traverse.MODID, "desert_shrubland"), new SandWithPatchesSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_, 1.5D));
  public static final SurfaceBuilder<SurfaceBuilderConfig> WOODED_ISLAND = add(new ResourceLocation(Traverse.MODID, "wooded_island"), new BeachSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_, 62, v -> Blocks.SAND.getDefaultState()));

  public static SurfaceBuilder<SurfaceBuilderConfig> add(ResourceLocation rl, SurfaceBuilder<SurfaceBuilderConfig> builder) {
    builder.setRegistryName(rl);
    BUILDERS.add(builder);
    return builder;
  }

  public static final ConfiguredSurfaceBuilder<?> CONFIGURED_ARID_HIGHLANDS = register("arid_highlands", new ConfiguredSurfaceBuilder<>(ARID_HIGHLANDS, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG));
  public static final ConfiguredSurfaceBuilder<?> CONFIGURED_DEFAULT_STONE = register("default_stone", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, SurfaceBuilder.STONE_STONE_GRAVEL_CONFIG));
  public static final ConfiguredSurfaceBuilder<?> CONFIGURED_DESERT_SHRUBLAND = register("desert_shrubland", new ConfiguredSurfaceBuilder<>(DESERT_SHRUBLAND, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG));
  public static final ConfiguredSurfaceBuilder<?> CONFIGURED_DEFAULT_GRASS = register("default_grass", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG));
  public static final ConfiguredSurfaceBuilder<?> CONFIGURED_WOODED_ISLAND = register("wooded_island", new ConfiguredSurfaceBuilder<>(WOODED_ISLAND, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG));
  public static final ConfiguredSurfaceBuilder<?> CONFIGURED_GRASSY_SWAMP = register("grassy_swamp", new ConfiguredSurfaceBuilder<>(SurfaceBuilder.SWAMP, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG));

  private static ConfiguredSurfaceBuilder<?> register(String id, ConfiguredSurfaceBuilder<?> feature) {
    return Registry.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(Traverse.MODID, id), feature);
  }

  @SubscribeEvent
  public static void forgeRegister(RegistryEvent.Register<SurfaceBuilder<?>> event) {
    IForgeRegistry<SurfaceBuilder<?>> registry = event.getRegistry();
    for (SurfaceBuilder<?> entry : BUILDERS) {
      registry.register(entry);
    }
  }

  public static void load() {
  }
}
