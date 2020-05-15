package epicsquid.traverse.setup;

import epicsquid.traverse.blocks.ModBlocks;
import epicsquid.traverse.items.ModItems;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.AxeItem;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ModSetup {

  public void init(FMLCommonSetupEvent event) {
    AxeItem.BLOCK_STRIPPING_MAP.put(ModBlocks.FIR_LOG, ModBlocks.STRIPPED_FIR_LOG);
    AxeItem.BLOCK_STRIPPING_MAP.put(ModBlocks.FIR_WOOD, ModBlocks.STRIPPED_FIR_WOOD);
    ComposterBlock.CHANCES.put(ModItems.
  }
}
