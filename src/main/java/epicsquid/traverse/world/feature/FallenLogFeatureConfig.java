package epicsquid.traverse.world.feature;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.treedecorator.TreeDecorator;

import java.util.List;

public class FallenLogFeatureConfig extends BaseTreeFeatureConfig {
  public final int lengthRandom;
  public final int baseLength;

  protected FallenLogFeatureConfig(BlockStateProvider trunk, BlockStateProvider leaves, List<TreeDecorator> decorators, int baseLength, int lengthRandom) {
    super(trunk, leaves, decorators, baseLength);
    this.baseLength = baseLength;
    this.lengthRandom = lengthRandom;
  }

  @Override
  public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
    ImmutableMap.Builder<T, T> builder = ImmutableMap.builder();

    builder
        .put(ops.createString("trunk_provider"), this.trunkProvider.serialize(ops))
        .put(ops.createString("leaves_provider"), this.leavesProvider.serialize(ops))
        .put(ops.createString("decorators"), ops.createList(this.decorators.stream().map(treeDecorator -> treeDecorator.serialize(ops))))
        .put(ops.createString("base_length"), ops.createInt(this.baseHeight))
        .put(ops.createString("length_random"), ops.createInt(this.lengthRandom));

    return new Dynamic<>(ops, ops.createMap(builder.build()));
  }

  public static <T> FallenLogFeatureConfig deserialize(Dynamic<T> dynamic) {
    BlockStateProviderType<?> trunk = Registry.BLOCK_STATE_PROVIDER_TYPE.getOrDefault(new ResourceLocation(dynamic.get("trunk_provider").get("type").asString().orElseThrow(RuntimeException::new)));
    BlockStateProviderType<?> leaves = Registry.BLOCK_STATE_PROVIDER_TYPE.getOrDefault(new ResourceLocation(dynamic.get("leaves_provider").get("type").asString().orElseThrow(RuntimeException::new)));

    return new FallenLogFeatureConfig(
        trunk.func_227399_a_(dynamic.get("trunk_provider").orElseEmptyMap()),
        leaves.func_227399_a_(dynamic.get("leaves_provider").orElseEmptyMap()),
        dynamic.get("decorators").asList(
            dynamicx -> Registry.TREE_DECORATOR_TYPE.getOrDefault(
                new ResourceLocation(dynamicx.get("type").asString().orElseThrow(RuntimeException::new))
            ).func_227431_a_(dynamicx)
        ),
        dynamic.get("base_length").asInt(0),
        dynamic.get("length_random").asInt(0)
    );
  }

  public static class Builder extends BaseTreeFeatureConfig.Builder {
    private List<TreeDecorator> decorators = Lists.newArrayList();
    private int baseLength;
    private int lengthRandom;

    public Builder(BlockStateProvider trunk) {
      super(trunk, new SimpleBlockStateProvider(Blocks.AIR.getDefaultState()));
    }

    public Builder baseLength(int length) {
      this.baseLength = length;
      return this;
    }

    public Builder lengthRandom(int variance) {
      this.lengthRandom = variance;
      return this;
    }

    @Override
    public FallenLogFeatureConfig build() {
      return new FallenLogFeatureConfig(this.trunkProvider, this.leavesProvider, this.decorators, this.baseLength, this.lengthRandom);
    }
  }
}
