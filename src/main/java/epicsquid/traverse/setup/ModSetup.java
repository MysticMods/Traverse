package epicsquid.traverse.setup;

import epicsquid.traverse.RegistryManager;
import epicsquid.traverse.blocks.ModBlocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.AxeItem;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.HashMap;

public class ModSetup {

  public static void init(FMLCommonSetupEvent event) {
    AxeItem.BLOCK_STRIPPING_MAP = new HashMap<>(AxeItem.BLOCK_STRIPPING_MAP);
    AxeItem.BLOCK_STRIPPING_MAP.put(ModBlocks.FIR_LOG, ModBlocks.STRIPPED_FIR_LOG);
    AxeItem.BLOCK_STRIPPING_MAP.put(ModBlocks.FIR_WOOD, ModBlocks.STRIPPED_FIR_WOOD);
    ComposterBlock.CHANCES.put(RegistryManager.BROWN_LEAVES.asItem(), 0.3f);
    ComposterBlock.CHANCES.put(RegistryManager.BROWN_SAPLING.asItem(), 0.3f);
    ComposterBlock.CHANCES.put(RegistryManager.ORANGE_LEAVES.asItem(), 0.3f);
    ComposterBlock.CHANCES.put(RegistryManager.ORANGE_SAPLING.asItem(), 0.3f);
    ComposterBlock.CHANCES.put(RegistryManager.RED_LEAVES.asItem(), 0.3f);
    ComposterBlock.CHANCES.put(RegistryManager.RED_SAPLING.asItem(), 0.3f);
    ComposterBlock.CHANCES.put(RegistryManager.YELLOW_LEAVES.asItem(), 0.3f);
    ComposterBlock.CHANCES.put(RegistryManager.YELLOW_SAPLING.asItem(), 0.3f);
    ComposterBlock.CHANCES.put(ModBlocks.FIR_LEAVES.asItem(), 0.3f);
    ComposterBlock.CHANCES.put(ModBlocks.FIR_SAPLING.asItem(), 0.3f);
  }
}
