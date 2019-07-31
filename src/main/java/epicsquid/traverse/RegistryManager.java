package epicsquid.traverse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import epicsquid.mysticallib.block.BaseDoorBlock;
import epicsquid.mysticallib.block.BasePressurePlateBlock;
import epicsquid.mysticallib.block.BaseSaplingBlock;
import epicsquid.mysticallib.block.BaseStairsBlock;
import epicsquid.mysticallib.block.BaseTrapDoorBlock;
import epicsquid.mysticallib.block.BaseWoodButtonBlock;
import epicsquid.mysticallib.world.BaseTree;
import epicsquid.traverse.biome.*;
import epicsquid.traverse.blocks.ModBlocks;
import epicsquid.traverse.world.FirTree;
import epicsquid.traverse.world.feature.FallenLogFeature;
import epicsquid.traverse.world.feature.MeadowFlowersFeature;
import epicsquid.traverse.world.surfacebuilder.BeachSurfaceBuilder;
import epicsquid.traverse.world.surfacebuilder.SandWithPatchesSurfaceBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.trees.Tree;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.JungleGrassFeature;
import net.minecraft.world.gen.feature.JungleTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.ShrubFeature;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Traverse.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryManager {

	private static final List<Block> BLOCKS = new ArrayList<>();
	private static final Block.Properties LEAVES_PROPS = Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT);
	private static final BaseTree RED_AUTUMNAL_TREE = new BaseTree(4, () -> Blocks.DARK_OAK_LOG, () -> ModBlocks.RED_AUTUMNAL_LEAVES);
	private static final BaseTree BROWN_AUTUMNAL_TREE = new BaseTree(5, () -> Blocks.OAK_LOG, () -> ModBlocks.BROWN_AUTUMNAL_LEAVES);
	private static final BaseTree ORANGE_AUTUMNAL_TREE = new BaseTree(4, () -> Blocks.OAK_LOG, () -> ModBlocks.ORANGE_AUTUMNAL_LEAVES);
	private static final BaseTree YELLOW_AUTUMNAL_TREE = new BaseTree(6, () -> Blocks.BIRCH_LOG, () -> ModBlocks.YELLOW_AUTUMNAL_LEAVES);
	private static final FirTree FIR_TREE = new FirTree();

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();

		BLOCKS.forEach(block -> registry.register(new BlockItem(block, new Item.Properties().group(Traverse.ITEM_GROUP)).setRegistryName(block.getRegistryName())));
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();

		Block.Properties saplingProps = Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0f).sound(SoundType.PLANT);

		BLOCKS.add(createLeaves("red_autumnal_leaves"));
		BLOCKS.add(new BaseSaplingBlock(RED_AUTUMNAL_TREE, saplingProps).setRegistryName(Traverse.MODID, "red_autumnal_sapling"));
		BLOCKS.add(createLeaves("brown_autumnal_leaves"));
		BLOCKS.add(new BaseSaplingBlock(BROWN_AUTUMNAL_TREE, saplingProps).setRegistryName(Traverse.MODID, "brown_autumnal_sapling"));
		BLOCKS.add(createLeaves("orange_autumnal_leaves"));
		BLOCKS.add(new BaseSaplingBlock(ORANGE_AUTUMNAL_TREE, saplingProps).setRegistryName(Traverse.MODID, "orange_autumnal_sapling"));
		BLOCKS.add(createLeaves("yellow_autumnal_leaves"));
		BLOCKS.add(new BaseSaplingBlock(YELLOW_AUTUMNAL_TREE, saplingProps).setRegistryName(Traverse.MODID, "yellow_autumnal_sapling"));

		// Fir Trees
		Block.Properties firWoodProps = Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
		Block.Properties firProps = Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD);

		Block firPlanks = new Block(firProps).setRegistryName(Traverse.MODID, "fir_planks");

		BLOCKS.add(firPlanks);
		BLOCKS.add(createLeaves("fir_leaves"));
		BLOCKS.add(new BaseSaplingBlock(FIR_TREE, saplingProps).setRegistryName(Traverse.MODID, "fir_sapling"));
		BLOCKS.add(new LogBlock(MaterialColor.WOOD, firWoodProps).setRegistryName(Traverse.MODID, "fir_log"));
		BLOCKS.add(new LogBlock(MaterialColor.WOOD, firWoodProps).setRegistryName(Traverse.MODID, "stripped_fir_log"));
		BLOCKS.add(new RotatedPillarBlock(firWoodProps).setRegistryName(Traverse.MODID, "stripped_fir_wood"));
		BLOCKS.add(new RotatedPillarBlock(firWoodProps).setRegistryName(Traverse.MODID, "fir_wood"));
		BLOCKS.add(new SlabBlock(firProps).setRegistryName(Traverse.MODID, "fir_slab"));
		BLOCKS.add(new BasePressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, firProps.doesNotBlockMovement()).setRegistryName(Traverse.MODID, "fir_pressure_plate"));
		BLOCKS.add(new FenceBlock(firProps).setRegistryName(Traverse.MODID, "fir_fence"));
		BLOCKS.add(new FenceGateBlock(firProps).setRegistryName(Traverse.MODID, "fir_fence_gate"));
		BLOCKS.add(new BaseTrapDoorBlock(firProps).setRegistryName(Traverse.MODID, "fir_trapdoor"));
		BLOCKS.add(new BaseStairsBlock(firPlanks.getDefaultState(), firProps).setRegistryName(Traverse.MODID, "fir_stairs"));
		BLOCKS.add(new BaseWoodButtonBlock(firProps).setRegistryName(Traverse.MODID, "fir_button"));
		BLOCKS.add(new BaseDoorBlock(firProps).setRegistryName(Traverse.MODID, "fir_door"));

		BLOCKS.forEach(registry::register);
	}

	@SubscribeEvent
	public static void registerSurfaceBuilders(RegistryEvent.Register<SurfaceBuilder<?>> event) {
		IForgeRegistry<SurfaceBuilder<?>> registry = event.getRegistry();

		registry.register(new SandWithPatchesSurfaceBuilder(SurfaceBuilderConfig::deserialize, 0.9).setRegistryName(Traverse.MODID, "arid_highlands"));
		registry.register(new SandWithPatchesSurfaceBuilder(SurfaceBuilderConfig::deserialize, 1.5).setRegistryName(Traverse.MODID, "desert_shrubland"));
		registry.register(new BeachSurfaceBuilder(SurfaceBuilderConfig::deserialize, 62, v -> Blocks.SAND.getDefaultState()).setRegistryName(Traverse.MODID, "forest_island"));
	}

	@SubscribeEvent
	public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
		IForgeRegistry<Feature<?>> registry = event.getRegistry();
		Random rand = new Random();

		registry.register(RED_AUTUMNAL_TREE.getTreeFeature(rand).setRegistryName(Traverse.MODID, "red_autumnal_tree"));
		registry.register(BROWN_AUTUMNAL_TREE.getTreeFeature(rand).setRegistryName(Traverse.MODID, "brown_autumnal_tree"));
		registry.register(ORANGE_AUTUMNAL_TREE.getTreeFeature(rand).setRegistryName(Traverse.MODID, "orange_autumnal_tree"));
		registry.register(YELLOW_AUTUMNAL_TREE.getTreeFeature(rand).setRegistryName(Traverse.MODID, "yellow_autumnal_tree"));
		registry.register(new MeadowFlowersFeature(NoFeatureConfig::deserialize).setRegistryName(Traverse.MODID, "lush_flower"));
		registry.register(new JungleTreeFeature(NoFeatureConfig::deserialize, false, 4, Blocks.JUNGLE_LOG.getDefaultState(), Blocks.JUNGLE_LEAVES.getDefaultState(), true).setRegistryName(Traverse.MODID, "mini_jungle_tree"));
		registry.register(new ShrubFeature(NoFeatureConfig::deserialize, Blocks.OAK_LOG.getDefaultState(), Blocks.OAK_LEAVES.getDefaultState()).setRegistryName(Traverse.MODID, "oak_shrub"));
		registry.register(FIR_TREE.getTreeFeature(rand).setRegistryName(Traverse.MODID, "fir_tree"));
		registry.register(new TreeFeature(NoFeatureConfig::deserialize, false, 7, Blocks.OAK_LOG.getDefaultState(), Blocks.OAK_LEAVES.getDefaultState(), true).setRegistryName(Traverse.MODID, "tall_swamp_tree"));
		registry.register(new FallenLogFeature(NoFeatureConfig::deserialize, false, Blocks.OAK_LOG.getDefaultState(), 3, 2).setRegistryName(Traverse.MODID, "fallen_oak_tree"));
	}

	@SubscribeEvent
	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		IForgeRegistry<Biome> registry = event.getRegistry();

		registry.register(new AridHighlandsBiome().setRegistryName(Traverse.MODID, "arid_highlands"));
		registry.register(new AutumnalWoodedHillsBiome().setRegistryName(Traverse.MODID, "autumnal_wooded_hills"));
		registry.register(new AutumnalWoodsBiome().setRegistryName(Traverse.MODID, "autumnal_woods"));
		registry.register(new CliffsBiome().setRegistryName(Traverse.MODID, "cliffs"));
		registry.register(new ConiferousForestBiome().setRegistryName(Traverse.MODID, "coniferous_forest"));
		registry.register(new ConiferousWoodedHillsBiome().setRegistryName(Traverse.MODID, "coniferous_wooded_hills"));
		registry.register(new DesertShrublandBiome().setRegistryName(Traverse.MODID, "desert_shrublands"));
		registry.register(new HighConiferousForestBiome().setRegistryName(Traverse.MODID, "high_coniferous_forest"));
		registry.register(new LushSwampBiome().setRegistryName(Traverse.MODID, "lush_swamp"));
		registry.register(new MeadowBiome().setRegistryName(Traverse.MODID, "meadow"));
		registry.register(new MiniJungleBiome().setRegistryName(Traverse.MODID, "mini_jungle"));
		registry.register(new PlainsPlateauBiome().setRegistryName(Traverse.MODID, "plains_plateau"));
		registry.register(new RockyEdgeBiome().setRegistryName(Traverse.MODID, "rocky_edge"));
		registry.register(new RollingHillsBiome().setRegistryName(Traverse.MODID, "rolling_hills"));
		registry.register(new SnowyConiferousForestBiome().setRegistryName(Traverse.MODID, "snowy_coniferous_forest"));
		registry.register(new SnowyConiferousWoodedHillsBiome().setRegistryName(Traverse.MODID, "snowy_coniferous_wooded_hills"));
		registry.register(new SnowyHighConiferousForestBiome().setRegistryName(Traverse.MODID, "snowy_high_coniferous_forest"));
		registry.register(new WoodedIslandBiome().setRegistryName(Traverse.MODID, "wooded_island"));
		registry.register(new WoodedPlateauBiome().setRegistryName(Traverse.MODID, "wooded_plateau"));
		registry.register(new WoodlandsBiome().setRegistryName(Traverse.MODID, "woodlands"));
	}

	private static Block createLeaves(String name) {
		return new LeavesBlock(LEAVES_PROPS).setRegistryName(Traverse.MODID, name);
	}
}
