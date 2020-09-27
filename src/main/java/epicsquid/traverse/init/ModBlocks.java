package epicsquid.traverse.init;

import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import epicsquid.traverse.Traverse;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import noobanidus.libs.noobutil.block.BaseBlocks;
import noobanidus.libs.noobutil.world.GenericTree;

import static epicsquid.traverse.Traverse.REGISTRATE;

public class ModBlocks {
  private static final NonNullUnaryOperator<Block.Properties> LEAVES_PROPS = o -> o.hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid();
  private static final NonNullUnaryOperator<Block.Properties> SAPLING_PROPS = o -> o.doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0f).sound(SoundType.PLANT);
  private static final NonNullUnaryOperator<Block.Properties> FIR_WOOD_PROPS = o -> o.hardnessAndResistance(2.0F).sound(SoundType.WOOD);
  private static final NonNullUnaryOperator<Block.Properties> FIR_WOOD_PROPS_PASSABLE = o -> o.hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).doesNotBlockMovement();

  public static final RegistryEntry<LeavesBlock> RED_AUTUMNAL_LEAVES = REGISTRATE.block("red_autumnal_leaves", Material.LEAVES, LeavesBlock::new).properties(LEAVES_PROPS).register();
  public static final RegistryEntry<LeavesBlock> BROWN_AUTUMNAL_LEAVES = REGISTRATE.block("brown_autumnal_leaves", Material.LEAVES, LeavesBlock::new).properties(LEAVES_PROPS).register();
  public static final RegistryEntry<LeavesBlock> ORANGE_AUTUMNAL_LEAVES = REGISTRATE.block("orange_autumnal_leaves", Material.LEAVES, LeavesBlock::new).properties(LEAVES_PROPS).register();
  public static final RegistryEntry<LeavesBlock> YELLOW_AUTUMNAL_LEAVES = REGISTRATE.block("yellow_autumnal_leaves", Material.LEAVES, LeavesBlock::new).properties(LEAVES_PROPS).register();
  public static final RegistryEntry<LeavesBlock> FIR_LEAVES = REGISTRATE.block("fir_leaves", Material.LEAVES, LeavesBlock::new).properties(LEAVES_PROPS).register();

  public static final RegistryEntry<BaseBlocks.SaplingBlock> FIR_SAPLING = REGISTRATE.block("fir_sapling", Material.PLANTS, o -> new BaseBlocks.SaplingBlock(new GenericTree(ModFeatureConfig.FIR_TREE_CONFIG), o)).properties(SAPLING_PROPS).register();
  public static final RegistryEntry<BaseBlocks.SaplingBlock> RED_SAPLING = REGISTRATE.block("red_autumnal_sapling", Material.PLANTS, o -> new BaseBlocks.SaplingBlock(new GenericTree(ModFeatureConfig.RED_AUTUMNAL_TREE_CONFIG), o)).properties(SAPLING_PROPS).register();
  public static final RegistryEntry<BaseBlocks.SaplingBlock> BROWN_SAPLING = REGISTRATE.block("brown_autumnal_sapling", Material.PLANTS, o -> new BaseBlocks.SaplingBlock(new GenericTree(ModFeatureConfig.BROWN_AUTUMNAL_TREE_CONFIG), o)).properties(SAPLING_PROPS).register();
  public static final RegistryEntry<BaseBlocks.SaplingBlock> ORANGE_SAPLING = REGISTRATE.block("orange_autumnal_sapling", Material.PLANTS, o -> new BaseBlocks.SaplingBlock(new GenericTree(ModFeatureConfig.ORANGE_AUTUMNAL_TREE_CONFIG), o)).properties(SAPLING_PROPS).register();
  public static final RegistryEntry<BaseBlocks.SaplingBlock> YELLOW_SAPLING = REGISTRATE.block("yellow_autumnal_sapling", Material.PLANTS, o -> new BaseBlocks.SaplingBlock(new GenericTree(ModFeatureConfig.YELLOW_AUTUMNAL_TREE_CONFIG), o)).properties(SAPLING_PROPS).register();

  public static final RegistryEntry<Block> FIR_PLANKS = REGISTRATE.block("fir_planks", Block::new).properties(FIR_WOOD_PROPS).register();

  public static final RegistryEntry<SlabBlock> FIR_SLAB = REGISTRATE.block("fir_slab", SlabBlock::new).properties(FIR_WOOD_PROPS).register();

  public static final RegistryEntry<BaseBlocks.PressurePlateBlock> FIR_PRESSURE_PLATE = REGISTRATE.block("fir_pressure_plate", o -> new BaseBlocks.PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, o)).properties(FIR_WOOD_PROPS_PASSABLE).register();

  public static final RegistryEntry<FenceBlock> FIR_FENCE = REGISTRATE.block("fir_fence", FenceBlock::new).properties(FIR_WOOD_PROPS).register();

  public static final RegistryEntry<FenceGateBlock> FIR_FENCE_GATE = REGISTRATE.block("fir_fence_gate", FenceGateBlock::new).properties(FIR_WOOD_PROPS).register();

  public static final RegistryEntry<BaseBlocks.TrapDoorBlock> FIR_TRAPDOOR = REGISTRATE.block("fir_trapdoor", BaseBlocks.TrapDoorBlock::new).properties(FIR_WOOD_PROPS).register();

  public static final RegistryEntry<StairsBlock> FIR_STAIRS = REGISTRATE.block("fir_stairs", o -> new StairsBlock(() -> FIR_PLANKS.get().getDefaultState(), o)).properties(FIR_WOOD_PROPS).register();

  public static final RegistryEntry<BaseBlocks.WoodButtonBlock> FIR_BUTTON = REGISTRATE.block("fir_button", BaseBlocks.WoodButtonBlock::new).properties(FIR_WOOD_PROPS).register();

  public static final RegistryEntry<BaseBlocks.DoorBlock> FIR_DOOR = REGISTRATE.block("fir_door", BaseBlocks.DoorBlock::new).properties(FIR_WOOD_PROPS).register();

  public static final RegistryEntry<LogBlock> FIR_LOG = REGISTRATE.block("fir_log", Material.WOOD, (o) -> new LogBlock(MaterialColor.WOOD, o)).properties(o -> o.hardnessAndResistance(2.0f).sound(SoundType.WOOD)).register();
  public static final RegistryEntry<LogBlock> FIR_WOOD = REGISTRATE.block("fir_wood", Material.WOOD, (o) -> new LogBlock(MaterialColor.WOOD, o)).properties(o -> o.hardnessAndResistance(2.0f).sound(SoundType.WOOD)).register();

  public static final RegistryEntry<LogBlock> STRIPPED_FIR_LOG = REGISTRATE.block("stripped_fir_log", Material.WOOD, (o) -> new LogBlock(MaterialColor.WOOD, o)).properties(o -> o.hardnessAndResistance(2.0f).sound(SoundType.WOOD)).register();
  public static final RegistryEntry<LogBlock> STRIPPED_FIR_WOOD = REGISTRATE.block("stripped_fir_wood", Material.WOOD, (o) -> new LogBlock(MaterialColor.WOOD, o)).properties(o -> o.hardnessAndResistance(2.0f).sound(SoundType.WOOD)).register();

  public static void load() {

  }
}
