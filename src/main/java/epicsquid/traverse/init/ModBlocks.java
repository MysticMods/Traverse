package epicsquid.traverse.init;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.providers.RegistrateItemModelProvider;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import epicsquid.traverse.Traverse;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.IForgeRegistryEntry;
import noobanidus.libs.noobutil.block.BaseBlocks;
import noobanidus.libs.noobutil.block.ModdedStandingSignBlock;
import noobanidus.libs.noobutil.block.ModdedWallSignBlock;
import noobanidus.libs.noobutil.world.tree.TreeWrapper;

import java.util.Objects;

import static epicsquid.traverse.Traverse.REGISTRATE;

public class ModBlocks {
  private static final NonNullUnaryOperator<Block.Properties> LEAVES_PROPS = o -> o.hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid().harvestTool(ToolType.HOE).setAllowsSpawn((s, w, p, t) -> t == EntityType.OCELOT || t == EntityType.PARROT).setSuffocates((s, w, p) -> false);
  private static final NonNullUnaryOperator<Block.Properties> SAPLING_PROPS = o -> o.doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0f).sound(SoundType.PLANT);
  private static final NonNullUnaryOperator<Block.Properties> FIR_WOOD_PROPS = o -> o.hardnessAndResistance(2.0F).sound(SoundType.WOOD).harvestTool(ToolType.AXE);
  private static final NonNullUnaryOperator<Block.Properties> FIR_WOOD_PROPS_PASSABLE = o -> o.hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).doesNotBlockMovement().harvestTool(ToolType.AXE);

  private static <T extends IForgeRegistryEntry<?>> String name(T block) {
    return Objects.requireNonNull(block.getRegistryName()).getPath();
  }

  public static <T extends SlabBlock> NonNullBiConsumer<DataGenContext<Block, T>, RegistrateBlockstateProvider> slab(RegistryEntry<? extends Block> parent) {
    return (ctx, p) -> p.slabBlock(ctx.getEntry(), p.blockTexture(parent.get()), p.blockTexture(parent.get()));
  }

  public static <T extends SaplingBlock> NonNullBiConsumer<DataGenContext<Block, T>, RegistrateBlockstateProvider> sapling(RegistryEntry<? extends Block> parent) {
    return (ctx, p) -> p.getVariantBuilder(ctx.getEntry()).partialState().setModels(new ConfiguredModel(p.models().cross(ctx.getName(), p.blockTexture(ctx.getEntry()))));
  }

  public static <T extends PressurePlateBlock> NonNullBiConsumer<DataGenContext<Block, T>, RegistrateBlockstateProvider> pressurePlate(RegistryEntry<? extends Block> parent) {
    return (ctx, p) -> {
      ModelFile up = p.models().singleTexture(ctx.getName(), new ResourceLocation(ModelProvider.BLOCK_FOLDER + "/pressure_plate_up"), p.blockTexture(parent.get()));
      ModelFile down = p.models().singleTexture(ctx.getName() + "_down", new ResourceLocation(ModelProvider.BLOCK_FOLDER + "/pressure_plate_down"), p.blockTexture(parent.get()));
      p.getVariantBuilder(ctx.getEntry())
          .partialState().with(PressurePlateBlock.POWERED, false).addModels(new ConfiguredModel(up))
          .partialState().with(PressurePlateBlock.POWERED, true).addModels(new ConfiguredModel(down));
    };
  }

  public static <T extends FenceBlock> NonNullBiConsumer<DataGenContext<Block, T>, RegistrateBlockstateProvider> fence(RegistryEntry<? extends Block> parent) {
    return (ctx, p) -> {
      p.fenceBlock(ctx.getEntry(), p.blockTexture(parent.get()));
      p.models().fenceInventory(name(ctx.getEntry()) + "_inventory", p.blockTexture(parent.get()));
    };
  }

  public static <T extends FenceGateBlock> NonNullBiConsumer<DataGenContext<Block, T>, RegistrateBlockstateProvider> gate(RegistryEntry<? extends Block> parent) {
    return (ctx, p) -> p.fenceGateBlock(ctx.getEntry(), p.blockTexture(parent.get()));
  }

  public static <T extends TrapDoorBlock> NonNullBiConsumer<DataGenContext<Block, T>, RegistrateBlockstateProvider> trapdoor(RegistryEntry<? extends Block> parent) {
    return (ctx, p) -> p.trapdoorBlock(ctx.getEntry(), p.blockTexture(ctx.getEntry()), true);
  }

  public static <T extends StairsBlock> NonNullBiConsumer<DataGenContext<Block, T>, RegistrateBlockstateProvider> stairs(RegistryEntry<? extends Block> parent) {
    return (ctx, p) -> p.stairsBlock(ctx.getEntry(), p.blockTexture(parent.get()));
  }

  public static <T extends DoorBlock> NonNullBiConsumer<DataGenContext<Block, T>, RegistrateBlockstateProvider> door() {
    return (ctx, p) -> p.doorBlock(ctx.getEntry(), p.modLoc("block/" + ctx.getName() + "_bottom"), p.modLoc("block/" + ctx.getName() + "_top"));
  }

  public static <T extends Item> ItemModelBuilder inventoryModel(DataGenContext<Item, T> ctx, RegistrateItemModelProvider p) {
    return p.blockWithInventoryModel(ctx::getEntry);
  }

  private static final float[] DEFAULT_SAPLING_DROP_RATES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

  public static final RegistryEntry<LeavesBlock> RED_AUTUMNAL_LEAVES = REGISTRATE.block("red_autumnal_leaves", Material.LEAVES, LeavesBlock::new)
      .properties(LEAVES_PROPS)
      .item()
      .model((ctx, p) -> p.blockItem(ModBlocks.RED_AUTUMNAL_LEAVES))
      .build()
      .loot((p, e) -> p.registerLootTable(e, RegistrateBlockLootTables.droppingWithChancesAndSticks(e, ModBlocks.RED_AUTUMNAL_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES)))
      .register();

  public static final RegistryEntry<LeavesBlock> BROWN_AUTUMNAL_LEAVES = REGISTRATE.block("brown_autumnal_leaves", Material.LEAVES, LeavesBlock::new)
      .properties(LEAVES_PROPS)
      .item()
      .model((ctx, p) -> p.blockItem(ModBlocks.BROWN_AUTUMNAL_LEAVES))
      .build()
      .loot((p, e) -> p.registerLootTable(e, RegistrateBlockLootTables.droppingWithChancesAndSticks(e, ModBlocks.BROWN_AUTUMNAL_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES)))
      .register();

  public static final RegistryEntry<LeavesBlock> ORANGE_AUTUMNAL_LEAVES = REGISTRATE.block("orange_autumnal_leaves", Material.LEAVES, LeavesBlock::new)
      .properties(LEAVES_PROPS)
      .item()
      .model((ctx, p) -> p.blockItem(ModBlocks.ORANGE_AUTUMNAL_LEAVES))
      .build()
      .loot((p, e) -> p.registerLootTable(e, RegistrateBlockLootTables.droppingWithChancesAndSticks(e, ModBlocks.ORANGE_AUTUMNAL_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES)))
      .register();

  public static final RegistryEntry<LeavesBlock> YELLOW_AUTUMNAL_LEAVES = REGISTRATE.block("yellow_autumnal_leaves", Material.LEAVES, LeavesBlock::new)
      .properties(LEAVES_PROPS)
      .item()
      .model((ctx, p) -> p.blockItem(ModBlocks.YELLOW_AUTUMNAL_LEAVES))
      .build()
      .loot((p, e) -> p.registerLootTable(e, RegistrateBlockLootTables.droppingWithChancesAndSticks(e, ModBlocks.YELLOW_AUTUMNAL_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES)))
      .register();

  public static final RegistryEntry<LeavesBlock> FIR_LEAVES = REGISTRATE.block("fir_leaves", Material.LEAVES, LeavesBlock::new)
      .properties(LEAVES_PROPS)
      .item()
      .model((ctx, p) -> p.blockItem(ModBlocks.FIR_LEAVES))
      .build()
      .loot((p, e) -> p.registerLootTable(e, RegistrateBlockLootTables.droppingWithChancesAndSticks(e, ModBlocks.FIR_SAPLING.get(), DEFAULT_SAPLING_DROP_RATES)))
      .register();

  public static final RegistryEntry<BaseBlocks.SaplingBlock> FIR_SAPLING = REGISTRATE.block("fir_sapling", Material.PLANTS, o -> new BaseBlocks.SaplingBlock(new TreeWrapper(() -> ModFeatures.FIR_TREE), o))
      .properties(SAPLING_PROPS)
      .blockstate(sapling(ModBlocks.FIR_SAPLING))
      .item()
      .model((ctx, p) -> p.blockSprite(ModBlocks.FIR_SAPLING))
      .build()
      .register();

  public static final RegistryEntry<BaseBlocks.SaplingBlock> RED_AUTUMNAL_SAPLING = REGISTRATE.block("red_autumnal_sapling", Material.PLANTS, o -> new BaseBlocks.SaplingBlock(new TreeWrapper(() -> ModFeatures.RED_AUTUMNAL_TREE), o))
      .properties(SAPLING_PROPS)
      .blockstate(sapling(ModBlocks.RED_AUTUMNAL_SAPLING))
      .item()
      .model((ctx, p) -> p.blockSprite(ModBlocks.RED_AUTUMNAL_SAPLING))
      .build()
      .register();

  public static final RegistryEntry<BaseBlocks.SaplingBlock> BROWN_AUTUMNAL_SAPLING = REGISTRATE.block("brown_autumnal_sapling", Material.PLANTS, o -> new BaseBlocks.SaplingBlock(new TreeWrapper(() -> ModFeatures.BROWN_AUTUMNAL_TREE), o))
      .properties(SAPLING_PROPS)
      .blockstate(sapling(ModBlocks.BROWN_AUTUMNAL_SAPLING))
      .item()
      .model((ctx, p) -> p.blockSprite(ModBlocks.BROWN_AUTUMNAL_SAPLING))
      .build()
      .register();

  public static final RegistryEntry<BaseBlocks.SaplingBlock> ORANGE_AUTUMNAL_SAPLING = REGISTRATE.block("orange_autumnal_sapling", Material.PLANTS, o -> new BaseBlocks.SaplingBlock(new TreeWrapper(() -> ModFeatures.ORANGE_AUTUMNAL_TREE), o))
      .properties(SAPLING_PROPS)
      .blockstate(sapling(ModBlocks.ORANGE_AUTUMNAL_SAPLING))
      .item()
      .model((ctx, p) -> p.blockSprite(ModBlocks.ORANGE_AUTUMNAL_SAPLING))
      .build()
      .register();

  public static final RegistryEntry<BaseBlocks.SaplingBlock> YELLOW_AUTUMNAL_SAPLING = REGISTRATE.block("yellow_autumnal_sapling", Material.PLANTS, o -> new BaseBlocks.SaplingBlock(new TreeWrapper(() -> ModFeatures.YELLOW_AUTUMNAL_TREE), o))
      .properties(SAPLING_PROPS)
      .blockstate(sapling(ModBlocks.YELLOW_AUTUMNAL_SAPLING))
      .item()
      .model((ctx, p) -> p.blockSprite(ModBlocks.YELLOW_AUTUMNAL_SAPLING))
      .build()
      .register();

  public static final RegistryEntry<Block> FIR_PLANKS = REGISTRATE.block("fir_planks", Material.WOOD, Block::new)
      .properties(FIR_WOOD_PROPS)
      .item()
      .model((ctx, p) -> p.blockItem(ModBlocks.FIR_PLANKS))
      .build()
      .register();

  public static final RegistryEntry<SlabBlock> FIR_SLAB = REGISTRATE.block("fir_slab", Material.WOOD, SlabBlock::new)
      .properties(FIR_WOOD_PROPS)
      .blockstate(slab(FIR_PLANKS))
      .item()
      .model((ctx, p) -> p.blockItem(ModBlocks.FIR_SLAB))
      .build()
      .register();

  public static final RegistryEntry<BaseBlocks.PressurePlateBlock> FIR_PRESSURE_PLATE = REGISTRATE.block("fir_pressure_plate", Material.WOOD, o -> new BaseBlocks.PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, o))
      .properties(FIR_WOOD_PROPS_PASSABLE)
      .blockstate(pressurePlate(ModBlocks.FIR_PLANKS))
      .item()
      .model((ctx, p) -> p.blockItem(ctx::getEntry))
      .build()
      .register();

  public static final RegistryEntry<FenceBlock> FIR_FENCE = REGISTRATE.block("fir_fence", Material.WOOD, FenceBlock::new)
      .properties(FIR_WOOD_PROPS)
      .blockstate(fence(ModBlocks.FIR_PLANKS))
      .item()
      .model(ModBlocks::inventoryModel)
      .build()
      .register();

  public static final RegistryEntry<FenceGateBlock> FIR_FENCE_GATE = REGISTRATE.block("fir_fence_gate", Material.WOOD, FenceGateBlock::new)
      .properties(FIR_WOOD_PROPS)
      .blockstate(gate(ModBlocks.FIR_PLANKS))
      .item()
      .model((ctx, p) -> p.blockItem(ModBlocks.FIR_FENCE_GATE))
      .build()
      .register();

  public static final RegistryEntry<BaseBlocks.TrapDoorBlock> FIR_TRAPDOOR = REGISTRATE.block("fir_trapdoor", Material.WOOD, BaseBlocks.TrapDoorBlock::new)
      .properties(o -> FIR_WOOD_PROPS.apply(o).notSolid())
      .blockstate(trapdoor(ModBlocks.FIR_TRAPDOOR))
      .item()
      .model((ctx, p) -> p.withExistingParent(ctx.getName(), p.modLoc("block/fir_trapdoor_bottom")))
      .build()
      .register();

  public static final RegistryEntry<StairsBlock> FIR_STAIRS = REGISTRATE.block("fir_stairs", Material.WOOD, o -> new StairsBlock(() -> FIR_PLANKS.get().getDefaultState(), o))
      .properties(FIR_WOOD_PROPS)
      .blockstate(stairs(ModBlocks.FIR_PLANKS))
      .item()
      .model((ctx, p) -> p.blockItem(ModBlocks.FIR_STAIRS))
      .build()
      .register();

  public static final RegistryEntry<BaseBlocks.WoodButtonBlock> FIR_BUTTON = REGISTRATE.block("fir_button", Material.WOOD, BaseBlocks.WoodButtonBlock::new)
      .properties(FIR_WOOD_PROPS)
      .blockstate((ctx, p) -> p.getVariantBuilder(ctx.getEntry()).forAllStates((state) -> {
        ModelFile inventory = p.models().getBuilder("fir_button_inventory").parent(p.models().getExistingFile(new ResourceLocation("block/button_inventory"))).texture("texture", p.blockTexture(ModBlocks.FIR_PLANKS.get()));
        ModelFile parent = p.models().getExistingFile(state.get(AbstractButtonBlock.POWERED) ? new ResourceLocation("block/button_pressed") : new ResourceLocation("block/button"));
        ModelFile button = p.models().getBuilder("fir_button" + (state.get(AbstractButtonBlock.POWERED) ? "_pressed" : "")).parent(parent).texture("texture", p.blockTexture(ModBlocks.FIR_PLANKS.get()));
        ConfiguredModel.Builder builder = ConfiguredModel.builder().modelFile(button);
        AttachFace attach = state.get(AbstractButtonBlock.FACE);
        Direction facing = state.get(AbstractButtonBlock.HORIZONTAL_FACING);
        if (attach == AttachFace.FLOOR) {
          if (facing == Direction.EAST) {
            builder.rotationY(90);
          } else if (facing == Direction.WEST) {
            builder.rotationY(270);
          } else if (facing == Direction.SOUTH) {
            builder.rotationY(180);
          }
        } else if (attach == AttachFace.WALL) {
          builder.rotationX(90);
          builder.uvLock(true);
          if (facing == Direction.EAST) {
            builder.rotationY(90);
          } else if (facing == Direction.WEST) {
            builder.rotationY(270);
          } else if (facing == Direction.SOUTH) {
            builder.rotationY(180);
          }
        } else { // CEILING
          builder.rotationX(180);
          if (facing == Direction.EAST) {
            builder.rotationY(270);
          } else if (facing == Direction.WEST) {
            builder.rotationY(90);
          } else if (facing == Direction.NORTH) {
            builder.rotationY(180);
          }
        }
        return builder.build();
      }))
      .item()
      .model((ctx, p) -> p.blockWithInventoryModel(ModBlocks.FIR_BUTTON))
      .build()
      .register();

  public static final RegistryEntry<BaseBlocks.DoorBlock> FIR_DOOR = REGISTRATE.block("fir_door", Material.WOOD, BaseBlocks.DoorBlock::new)
      .properties(o -> FIR_WOOD_PROPS.apply(o).notSolid())
      .blockstate(door())
      .loot((ctx, p) -> ctx.registerLootTable(p, RegistrateBlockLootTables.registerDoor(p)))
      .item()
      .model((ctx, p) -> p.generated(ctx::getEntry))
      .build()
      .register();

  private static ResourceLocation FIR_SIGN_TEXTURE = new ResourceLocation(Traverse.MODID, "entity/sign/fir");

  public static final RegistryEntry<ModdedStandingSignBlock> FIR_SIGN = REGISTRATE.block("fir_sign", Material.WOOD, (p) -> new ModdedStandingSignBlock(p, FIR_SIGN_TEXTURE))
      .properties(o -> o.doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).harvestTool(ToolType.AXE))
      .blockstate(NonNullBiConsumer.noop())
      .item((block, props) -> new SignItem(props, block, ModBlocks.FIR_WALL_SIGN.get()))
      .model((ctx, p) -> p.generated(ctx::getEntry, p.modLoc("item/fir_sign")))
      .build()
      .register();

  public static final RegistryEntry<ModdedWallSignBlock> FIR_WALL_SIGN = REGISTRATE.block("fir_wall_sign", Material.WOOD, (p) -> new ModdedWallSignBlock(p, FIR_SIGN_TEXTURE))
      .properties(o -> o.doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).harvestTool(ToolType.AXE))
      .blockstate(NonNullBiConsumer.noop())
      .setData(ProviderType.LANG, NonNullBiConsumer.noop())
      .register();

  public static final RegistryEntry<RotatedPillarBlock> FIR_LOG = REGISTRATE.block("fir_log", Material.WOOD, RotatedPillarBlock::new)
      .properties(o -> AbstractBlock.Properties.create(Material.WOOD, (state) -> MaterialColor.OBSIDIAN).hardnessAndResistance(2.0f).sound(SoundType.WOOD))
      .blockstate((ctx, p) ->
          p.logBlock(ctx.getEntry())
      )
      .item()
      .model((ctx, p) -> p.blockItem(ModBlocks.FIR_LOG))
      .tag(ItemTags.LOGS_THAT_BURN)
      .tag(ItemTags.LOGS)
      .build()
      .tag(BlockTags.LOGS_THAT_BURN)
      .tag(BlockTags.LOGS)
      .register();

  public static final RegistryEntry<RotatedPillarBlock> FIR_WOOD = REGISTRATE.block("fir_wood", Material.WOOD, RotatedPillarBlock::new)
      .properties(o -> AbstractBlock.Properties.create(Material.WOOD, (state) -> MaterialColor.OBSIDIAN).hardnessAndResistance(2.0f).sound(SoundType.WOOD))
      .blockstate((ctx, p) ->
          p.getVariantBuilder(ctx.getEntry()).partialState().setModels(new ConfiguredModel(p.models().cubeAll(ctx.getName(), p.blockTexture(ModBlocks.FIR_LOG.get()))))
      )
      .item()
      .model((ctx, p) -> p.blockItem(ModBlocks.FIR_WOOD))
      .tag(ItemTags.LOGS_THAT_BURN)
      .tag(ItemTags.LOGS)
      .build()
      .tag(BlockTags.LOGS_THAT_BURN)
      .tag(BlockTags.LOGS)
      .register();

  public static final RegistryEntry<RotatedPillarBlock> STRIPPED_FIR_LOG = REGISTRATE.block("stripped_fir_log", Material.WOOD, RotatedPillarBlock::new)
      .properties(o -> AbstractBlock.Properties.create(Material.WOOD, (state) -> MaterialColor.WOOD).hardnessAndResistance(2.0f).sound(SoundType.WOOD))
      .blockstate((ctx, p) ->
          p.logBlock(ctx.getEntry())
      )
      .item()
      .model((ctx, p) -> p.blockItem(ModBlocks.STRIPPED_FIR_LOG))
      .tag(ItemTags.LOGS_THAT_BURN)
      .tag(ItemTags.LOGS)
      .build()
      .tag(BlockTags.LOGS_THAT_BURN)
      .tag(BlockTags.LOGS)
      .register();

  public static final RegistryEntry<RotatedPillarBlock> STRIPPED_FIR_WOOD = REGISTRATE.block("stripped_fir_wood", Material.WOOD, RotatedPillarBlock::new)
      .properties(o -> AbstractBlock.Properties.create(Material.WOOD, (state) -> MaterialColor.WOOD).hardnessAndResistance(2.0f).sound(SoundType.WOOD))
      .blockstate((ctx, p) ->
          p.getVariantBuilder(ctx.getEntry()).partialState().setModels(new ConfiguredModel(p.models().cubeAll(ctx.getName(), p.blockTexture(ModBlocks.STRIPPED_FIR_LOG.get()))))
      )
      .item()
      .model((ctx, p) -> p.blockItem(ModBlocks.STRIPPED_FIR_WOOD))
      .tag(ItemTags.LOGS_THAT_BURN)
      .tag(ItemTags.LOGS)
      .build()
      .tag(BlockTags.LOGS_THAT_BURN)
      .tag(BlockTags.LOGS)
      .register();

  public static RegistryEntry<FlowerPotBlock> POTTED_FIR_SAPLING = REGISTRATE.block("potted_fir_sapling", Material.MISCELLANEOUS, (p) -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.FIR_SAPLING, AbstractBlock.Properties.from(Blocks.OAK_SAPLING)))
      .blockstate((ctx, p) -> p.simpleBlock(ctx.getEntry(), p.models().withExistingParent(ctx.getName(), "minecraft:block/flower_pot_cross").texture("plant", "traverse:block/fir_sapling")))
      .loot((ctx, p) -> ctx.registerLootTable(p, RegistrateBlockLootTables.droppingAndFlowerPot(ModBlocks.FIR_SAPLING.get())))
      .register();

  public static RegistryEntry<FlowerPotBlock> POTTED_RED_AUTUMNAL_SAPLING = REGISTRATE.block("potted_red_autumnal_sapling", Material.MISCELLANEOUS, (p) -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.RED_AUTUMNAL_SAPLING, AbstractBlock.Properties.from(Blocks.OAK_SAPLING)))
      .blockstate((ctx, p) -> p.simpleBlock(ctx.getEntry(), p.models().withExistingParent(ctx.getName(), "minecraft:block/flower_pot_cross").texture("plant", "traverse:block/red_autumnal_sapling")))
      .loot((ctx, p) -> ctx.registerLootTable(p, RegistrateBlockLootTables.droppingAndFlowerPot(ModBlocks.RED_AUTUMNAL_SAPLING.get())))
      .register();

  public static RegistryEntry<FlowerPotBlock> POTTED_BROWN_AUTUMNAL_SAPLING = REGISTRATE.block("potted_brown_autumnal_sapling", Material.MISCELLANEOUS, (p) -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.BROWN_AUTUMNAL_SAPLING, AbstractBlock.Properties.from(Blocks.OAK_SAPLING)))
      .blockstate((ctx, p) -> p.simpleBlock(ctx.getEntry(), p.models().withExistingParent(ctx.getName(), "minecraft:block/flower_pot_cross").texture("plant", "traverse:block/brown_autumnal_sapling")))
      .loot((ctx, p) -> ctx.registerLootTable(p, RegistrateBlockLootTables.droppingAndFlowerPot(ModBlocks.BROWN_AUTUMNAL_SAPLING.get())))
      .register();

  public static RegistryEntry<FlowerPotBlock> POTTED_ORANGE_AUTUMNAL_SAPLING = REGISTRATE.block("potted_orange_autumnal_sapling", Material.MISCELLANEOUS, (p) -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.ORANGE_AUTUMNAL_SAPLING, AbstractBlock.Properties.from(Blocks.OAK_SAPLING)))
      .blockstate((ctx, p) -> p.simpleBlock(ctx.getEntry(), p.models().withExistingParent(ctx.getName(), "minecraft:block/flower_pot_cross").texture("plant", "traverse:block/orange_autumnal_sapling")))
      .loot((ctx, p) -> ctx.registerLootTable(p, RegistrateBlockLootTables.droppingAndFlowerPot(ModBlocks.ORANGE_AUTUMNAL_SAPLING.get())))
      .register();

  public static RegistryEntry<FlowerPotBlock> POTTED_YELLOW_AUTUMNAL_SAPLING = REGISTRATE.block("potted_yellow_autumnal_sapling", Material.MISCELLANEOUS, (p) -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.YELLOW_AUTUMNAL_SAPLING, AbstractBlock.Properties.from(Blocks.OAK_SAPLING)))
      .blockstate((ctx, p) -> p.simpleBlock(ctx.getEntry(), p.models().withExistingParent(ctx.getName(), "minecraft:block/flower_pot_cross").texture("plant", "traverse:block/yellow_autumnal_sapling")))
      .loot((ctx, p) -> ctx.registerLootTable(p, RegistrateBlockLootTables.droppingAndFlowerPot(ModBlocks.YELLOW_AUTUMNAL_SAPLING.get())))
      .register();

  public static void load() {

  }
}
