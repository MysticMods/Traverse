package epicsquid.traverse;

import java.util.ArrayList;
import java.util.List;

import epicsquid.mysticallib.block.BaseDoorBlock;
import epicsquid.mysticallib.block.BasePressurePlateBlock;
import epicsquid.mysticallib.block.BaseSaplingBlock;
import epicsquid.mysticallib.block.BaseStairsBlock;
import epicsquid.mysticallib.block.BaseTrapDoorBlock;
import epicsquid.mysticallib.block.BaseWoodButtonBlock;
import epicsquid.mysticallib.world.BaseTree;
import epicsquid.traverse.blocks.ModBlocks;
import epicsquid.traverse.world.FirTree;
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
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Traverse.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryManager {

	private static final List<Block> BLOCKS = new ArrayList<>();

	private static final Block.Properties LEAVES_PROPS = Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
			.sound(SoundType.PLANT);

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
		BLOCKS.add(new BaseSaplingBlock(new BaseTree(4, () -> Blocks.DARK_OAK_LOG, () -> ModBlocks.RED_AUTUMNAL_LEAVES), saplingProps).setRegistryName(Traverse.MODID, "red_autumnal_sapling"));
		BLOCKS.add(createLeaves("brown_autumnal_leaves"));
		BLOCKS.add(new BaseSaplingBlock(new BaseTree(5, () -> Blocks.OAK_LOG, () -> ModBlocks.BROWN_AUTUMNAL_LEAVES), saplingProps).setRegistryName(Traverse.MODID, "brown_autumnal_sapling"));
		BLOCKS.add(createLeaves("orange_autumnal_leaves"));
		BLOCKS.add(new BaseSaplingBlock(new BaseTree(4, () -> Blocks.OAK_LOG, () -> ModBlocks.ORANGE_AUTUMNAL_LEAVES), saplingProps).setRegistryName(Traverse.MODID, "orange_autumnal_sapling"));
		BLOCKS.add(createLeaves("yellow_autumnal_leaves"));
		BLOCKS.add(new BaseSaplingBlock(new BaseTree(6, () -> Blocks.BIRCH_LOG, () -> ModBlocks.YELLOW_AUTUMNAL_LEAVES), saplingProps).setRegistryName(Traverse.MODID, "yellow_autumnal_sapling"));

		// Fir Trees
		Block.Properties firWoodProps = Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
		Block.Properties firProps = Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD);

		Block firPlanks = new Block(firProps).setRegistryName(Traverse.MODID, "fir_planks");

		BLOCKS.add(firPlanks);
		BLOCKS.add(createLeaves("fir_leaves"));
		BLOCKS.add(new BaseSaplingBlock(new FirTree(), saplingProps).setRegistryName(Traverse.MODID, "fir_sapling"));
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

	private static Block createLeaves(String name) {
		return new LeavesBlock(LEAVES_PROPS).setRegistryName(Traverse.MODID, name);
	}
}
