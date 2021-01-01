package epicsquid.traverse.setup;

import epicsquid.traverse.init.ModBlocks;
import epicsquid.traverse.mixin.AccessorSetFireInfo;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.item.AxeItem;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("deprecation")
public class ModSetup {
  public static void init(FMLCommonSetupEvent event) {
    event.enqueueWork(() -> {
      AxeItem.BLOCK_STRIPPING_MAP = new HashMap<>(AxeItem.BLOCK_STRIPPING_MAP);
      AxeItem.BLOCK_STRIPPING_MAP.put(ModBlocks.FIR_LOG.get(), ModBlocks.STRIPPED_FIR_LOG.get());
      AxeItem.BLOCK_STRIPPING_MAP.put(ModBlocks.FIR_WOOD.get(), ModBlocks.STRIPPED_FIR_WOOD.get());
      ComposterBlock.CHANCES.put(ModBlocks.BROWN_AUTUMNAL_LEAVES.get().asItem(), 0.3f);
      ComposterBlock.CHANCES.put(ModBlocks.BROWN_AUTUMNAL_SAPLING.get().asItem(), 0.3f);
      ComposterBlock.CHANCES.put(ModBlocks.ORANGE_AUTUMNAL_LEAVES.get().asItem(), 0.3f);
      ComposterBlock.CHANCES.put(ModBlocks.ORANGE_AUTUMNAL_SAPLING.get().asItem(), 0.3f);
      ComposterBlock.CHANCES.put(ModBlocks.RED_AUTUMNAL_LEAVES.get().asItem(), 0.3f);
      ComposterBlock.CHANCES.put(ModBlocks.RED_AUTUMNAL_SAPLING.get().asItem(), 0.3f);
      ComposterBlock.CHANCES.put(ModBlocks.YELLOW_AUTUMNAL_LEAVES.get().asItem(), 0.3f);
      ComposterBlock.CHANCES.put(ModBlocks.YELLOW_AUTUMNAL_SAPLING.get().asItem(), 0.3f);
      ComposterBlock.CHANCES.put(ModBlocks.FIR_LEAVES.get().asItem(), 0.3f);
      ComposterBlock.CHANCES.put(ModBlocks.FIR_SAPLING.get().asItem(), 0.3f);
      TileEntityType.SIGN.validBlocks = new HashSet<>(TileEntityType.SIGN.validBlocks);
      TileEntityType.SIGN.validBlocks.add(ModBlocks.FIR_SIGN.get());
      TileEntityType.SIGN.validBlocks.add(ModBlocks.FIR_WALL_SIGN.get());

      AccessorSetFireInfo fire = (AccessorSetFireInfo) ((FireBlock) Blocks.FIRE);
      fire.invokeSetFireInfo(ModBlocks.FIR_PLANKS.get(), 5, 20);
      fire.invokeSetFireInfo(ModBlocks.FIR_SLAB.get(), 5, 20);
      fire.invokeSetFireInfo(ModBlocks.FIR_FENCE_GATE.get(), 5, 20);
      fire.invokeSetFireInfo(ModBlocks.FIR_FENCE.get(), 5, 20);
      fire.invokeSetFireInfo(ModBlocks.FIR_STAIRS.get(), 5, 20);
      fire.invokeSetFireInfo(ModBlocks.FIR_LOG.get(), 5, 5);
      fire.invokeSetFireInfo(ModBlocks.STRIPPED_FIR_LOG.get(), 5, 5);
      fire.invokeSetFireInfo(ModBlocks.FIR_WOOD.get(), 5, 5);
      fire.invokeSetFireInfo(ModBlocks.STRIPPED_FIR_WOOD.get(), 5, 5);
      fire.invokeSetFireInfo(ModBlocks.FIR_LEAVES.get(), 30, 60);
      fire.invokeSetFireInfo(ModBlocks.YELLOW_AUTUMNAL_LEAVES.get(), 30, 60);
      fire.invokeSetFireInfo(ModBlocks.RED_AUTUMNAL_LEAVES.get(), 30, 60);
      fire.invokeSetFireInfo(ModBlocks.ORANGE_AUTUMNAL_LEAVES.get(), 30, 60);
      fire.invokeSetFireInfo(ModBlocks.BROWN_AUTUMNAL_LEAVES.get(), 30, 60);
    });
  }


}
