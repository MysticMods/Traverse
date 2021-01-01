package epicsquid.traverse.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.FireBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(FireBlock.class)
public interface AccessorSetFireInfo {
  @Invoker("setFireInfo")
  void invokeSetFireInfo(Block blockIn, int encouragement, int flammability);
}
