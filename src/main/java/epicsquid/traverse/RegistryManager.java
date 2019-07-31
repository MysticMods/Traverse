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
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Traverse.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryManager {

	private static final List<Block> BLOCKS = new ArrayList<>();
	public static final BaseTree RED_AUTUMNAL_TREE = new BaseTree(4, () -> Blocks.DARK_OAK_LOG, () -> ModBlocks.RED_AUTUMNAL_LEAVES);
	public static final BaseTree BROWN_AUTUMNAL_TREE = new BaseTree(5, () -> Blocks.OAK_LOG, () -> ModBlocks.BROWN_AUTUMNAL_LEAVES);
	public static final BaseTree ORANGE_AUTUMNAL_TREE = new BaseTree(4, () -> Blocks.OAK_LOG, () -> ModBlocks.ORANGE_AUTUMNAL_LEAVES);
	public static final BaseTree YELLOW_AUTUMNAL_TREE = new BaseTree(6, () -> Blocks.BIRCH_LOG, () -> ModBlocks.YELLOW_AUTUMNAL_LEAVES);
	public static final FirTree FIR_TREE = new FirTree();

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();

		BLOCKS.forEach(block -> registry.register(new BlockItem(block, new Item.Properties().group(Traverse.ITEM_GROUP)).setRegistryName(block.getRegistryName())));
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();

		Block.Properties saplingProps = Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0f).sound(SoundType.PLANT);

		BLOCKS.add(ModBlocks.RED_AUTUMNAL_LEAVES);
		BLOCKS.add(new BaseSaplingBlock(RED_AUTUMNAL_TREE, saplingProps).setRegistryName(Traverse.MODID, "red_autumnal_sapling"));
		BLOCKS.add(ModBlocks.BROWN_AUTUMNAL_LEAVES);
		BLOCKS.add(new BaseSaplingBlock(BROWN_AUTUMNAL_TREE, saplingProps).setRegistryName(Traverse.MODID, "brown_autumnal_sapling"));
		BLOCKS.add(ModBlocks.ORANGE_AUTUMNAL_LEAVES);
		BLOCKS.add(new BaseSaplingBlock(ORANGE_AUTUMNAL_TREE, saplingProps).setRegistryName(Traverse.MODID, "orange_autumnal_sapling"));
		BLOCKS.add(ModBlocks.YELLOW_AUTUMNAL_LEAVES);
		BLOCKS.add(new BaseSaplingBlock(YELLOW_AUTUMNAL_TREE, saplingProps).setRegistryName(Traverse.MODID, "yellow_autumnal_sapling"));

		// Fir Trees
		Block.Properties firWoodProps = Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
		Block.Properties firProps = Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD);

		Block firPlanks = new Block(firProps).setRegistryName(Traverse.MODID, "fir_planks");

		BLOCKS.add(firPlanks);
		BLOCKS.add(ModBlocks.FIR_LEAVES);
		BLOCKS.add(new BaseSaplingBlock(FIR_TREE, saplingProps).setRegistryName(Traverse.MODID, "fir_sapling"));
		BLOCKS.add(ModBlocks.FIR_LOG);
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
	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		IForgeRegistry<Biome> registry = event.getRegistry();

		registerBiome(registry, new AridHighlandsBiome(), "arid_highlands", 4, false, BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HILLS);
		registerBiome(registry, new AutumnalWoodedHillsBiome(), "autumnal_wooded_hills", 1, true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS);
		registerBiome(registry, new AutumnalWoodsBiome(), "autumnal_woods", 8, true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST);
		registerBiome(registry, new CliffsBiome(), "cliffs", 2, false, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.COLD, BiomeDictionary.Type.HILLS);
		registerBiome(registry, new ConiferousForestBiome(), "coniferous_forest", 4, true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS);
		registerBiome(registry, new ConiferousWoodedHillsBiome(), "coniferous_woodland_hills_biome", 1, false, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.CONIFEROUS);
		registerBiome(registry, new DesertShrublandBiome(), "desert_shurbland", 5, false, BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.DEAD);
		registerBiome(registry, new HighConiferousForestBiome(), "high_coniferous_forest", 3, false, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.COLD);
		registerBiome(registry, new LushSwampBiome(), "lush_swamp", 6, false, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.WET, BiomeDictionary.Type.SWAMP);
		registerBiome(registry, new MeadowBiome(), "meadow", 7, true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.WET);
		registerBiome(registry, new MiniJungleBiome(), "mini_jungle", 3, true, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.WET);
		registerBiome(registry, new PlainsPlateauBiome(), "plains_plateau", 1, false, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.HILLS);
		registerBiome(registry, new RockyEdgeBiome(), "rock_edge", 4, false, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.HOT, BiomeDictionary.Type.MOUNTAIN);
		registerBiome(registry, new RollingHillsBiome(), "rolling_hills", 6, true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.HILLS);
		registerBiome(registry, new SnowyConiferousForestBiome(), "snowy_coniferous_forest", 5, true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS);
		registerBiome(registry, new SnowyConiferousWoodedHillsBiome(), "snowy_coniferous_wooded_hills", 2, true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.HILLS);
		registerBiome(registry, new SnowyHighConiferousForestBiome(), "snowy_high_coniferous_forest", 1, true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HILLS);
		registerBiome(registry, new WoodedIslandBiome(), "wooded_island", 1, false, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST);
		registerBiome(registry, new WoodedPlateauBiome(), "wooded_plateau", 2, true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS);
		registerBiome(registry, new AutumnalWoodsBiome(), "woodlands", 9, true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST);
	}

	private static void registerBiome(IForgeRegistry<Biome> registry, Biome biome, String name, int weight, boolean spawn, BiomeManager.BiomeType type, BiomeDictionary.Type... types) {
		registry.register(biome.setRegistryName(Traverse.MODID, name));
		BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(biome, weight));
		if (spawn) {
			BiomeManager.addSpawnBiome(biome);
		}
		BiomeDictionary.addTypes(biome, types);
	}
}
