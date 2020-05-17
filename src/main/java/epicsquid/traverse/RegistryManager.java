package epicsquid.traverse;

import epicsquid.mysticallib.block.*;
import epicsquid.mysticallib.world.BaseTree;
import epicsquid.traverse.biome.*;
import epicsquid.traverse.blocks.ModBlocks;
import epicsquid.traverse.config.ConfigManager;
import epicsquid.traverse.world.FirTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Traverse.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryManager {

  private static final List<Block> BLOCKS = new ArrayList<>();
  public static final BaseTree RED_AUTUMNAL_TREE = new BaseTree(4, () -> Blocks.DARK_OAK_LOG, () -> ModBlocks.RED_AUTUMNAL_LEAVES);
  public static final BaseTree BROWN_AUTUMNAL_TREE = new BaseTree(5, () -> Blocks.OAK_LOG, () -> ModBlocks.BROWN_AUTUMNAL_LEAVES);
  public static final BaseTree ORANGE_AUTUMNAL_TREE = new BaseTree(4, () -> Blocks.OAK_LOG, () -> ModBlocks.ORANGE_AUTUMNAL_LEAVES);
  public static final BaseTree YELLOW_AUTUMNAL_TREE = new BaseTree(6, () -> Blocks.BIRCH_LOG, () -> ModBlocks.YELLOW_AUTUMNAL_LEAVES);
  public static final FirTree FIR_TREE = new FirTree();

  public static Block RED_SAPLING;
  public static Block BROWN_SAPLING;
  public static Block YELLOW_SAPLING;
  public static Block ORANGE_SAPLING;
  public static Block FIR_SAPLING;

  public static Block FIR_SLAB;
  public static Block FIR_PRESSURE_PLATE;
  public static Block FIR_FENCE;
  public static Block FIR_FENCE_GATE;
  public static Block FIR_TRAPDOOR;
  public static Block FIR_STAIRS;
  public static Block FIR_BUTTON;
  public static Block FIR_DOOR;

/*  public static Feature<FallenLogFeatureConfig> FALLEN_OAK_TREE = new FallenLogFeature(FallenLogFeatureConfig::deserialize);

  @SubscribeEvent
  public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
    IForgeRegistry<Feature<?>> registry = event.getRegistry();
    registry.register(FALLEN_OAK_TREE.setRegistryName(Traverse.MODID, "fallen_tree"));
  }*/

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
    BLOCKS.add(RED_SAPLING = new BaseSaplingBlock(RED_AUTUMNAL_TREE, saplingProps).setRegistryName(Traverse.MODID, "red_autumnal_sapling"));
    BLOCKS.add(ModBlocks.BROWN_AUTUMNAL_LEAVES);
    BLOCKS.add(BROWN_SAPLING = new BaseSaplingBlock(BROWN_AUTUMNAL_TREE, saplingProps).setRegistryName(Traverse.MODID, "brown_autumnal_sapling"));
    BLOCKS.add(ModBlocks.ORANGE_AUTUMNAL_LEAVES);
    BLOCKS.add(ORANGE_SAPLING = new BaseSaplingBlock(ORANGE_AUTUMNAL_TREE, saplingProps).setRegistryName(Traverse.MODID, "orange_autumnal_sapling"));
    BLOCKS.add(ModBlocks.YELLOW_AUTUMNAL_LEAVES);
    BLOCKS.add(YELLOW_SAPLING = new BaseSaplingBlock(YELLOW_AUTUMNAL_TREE, saplingProps).setRegistryName(Traverse.MODID, "yellow_autumnal_sapling"));

    // Fir Trees
    Block.Properties firWoodProps = Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD);
    Block.Properties firProps = Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD);
    Block.Properties firPropsPassable = Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).doesNotBlockMovement();

    Block firPlanks = new Block(firProps).setRegistryName(Traverse.MODID, "fir_planks");

    BLOCKS.add(firPlanks);
    BLOCKS.add(ModBlocks.FIR_LEAVES);
    BLOCKS.add(FIR_SAPLING = new BaseSaplingBlock(FIR_TREE, saplingProps).setRegistryName(Traverse.MODID, "fir_sapling"));
    BLOCKS.add(ModBlocks.FIR_LOG);
    BLOCKS.add(ModBlocks.FIR_WOOD);
    BLOCKS.add(ModBlocks.STRIPPED_FIR_LOG);
    BLOCKS.add(ModBlocks.STRIPPED_FIR_WOOD);
    BLOCKS.add(FIR_SLAB = new SlabBlock(firProps).setRegistryName(Traverse.MODID, "fir_slab"));
    BLOCKS.add(FIR_PRESSURE_PLATE = new BasePressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, firPropsPassable).setRegistryName(Traverse.MODID, "fir_pressure_plate"));
    BLOCKS.add(FIR_FENCE = new FenceBlock(firProps).setRegistryName(Traverse.MODID, "fir_fence"));
    BLOCKS.add(FIR_FENCE_GATE = new FenceGateBlock(firProps).setRegistryName(Traverse.MODID, "fir_fence_gate"));
    BLOCKS.add(FIR_TRAPDOOR = new BaseTrapDoorBlock(firProps).setRegistryName(Traverse.MODID, "fir_trapdoor"));
    BLOCKS.add(FIR_STAIRS = new StairsBlock(firPlanks::getDefaultState, firProps).setRegistryName(Traverse.MODID, "fir_stairs"));
    BLOCKS.add(FIR_BUTTON = new BaseWoodButtonBlock(firProps).setRegistryName(Traverse.MODID, "fir_button"));
    BLOCKS.add(FIR_DOOR = new BaseDoorBlock(firProps).setRegistryName(Traverse.MODID, "fir_door"));

    BLOCKS.forEach(registry::register);
  }

  @SubscribeEvent
  public static void registerBiomes(RegistryEvent.Register<Biome> event) {
    IForgeRegistry<Biome> registry = event.getRegistry();

    registerBiome(registry, new AridHighlandsBiome(), "arid_highlands", ConfigManager.ARID_HIGHLANDS.getWeight(), false, BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(registry, new AutumnalWoodedHillsBiome(), "autumnal_wooded_hills", ConfigManager.AUTUMNAL_WOODED_HILLS.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(registry, new AutumnalWoodsBiome(), "autumnal_woods", ConfigManager.AUTUMNAL_WOODS.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
//		registerBiome(registry, new CliffsBiome(), "cliffs", 2, false, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.COLD, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(registry, new ConiferousForestBiome(), "coniferous_forest", ConfigManager.CONIFEROUS_FOREST.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(registry, new ConiferousWoodedHillsBiome(), "coniferous_woodland_hills_biome", ConfigManager.CONIFEROUS_WOODLAND_HILLS.getWeight(), false, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(registry, new DesertShrublandBiome(), "desert_shrubland", ConfigManager.DESERT_SHRUBLAND.getWeight(), false, BiomeManager.BiomeType.DESERT, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.OVERWORLD);
    registerBiome(registry, new HighConiferousForestBiome(), "high_coniferous_forest", ConfigManager.HIGH_CONIFEROUS_FOREST.getWeight(), false, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
    registerBiome(registry, new LushSwampBiome(), "lush_swamp", ConfigManager.LUSH_SWAMP.getWeight(), false, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.WET, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.OVERWORLD);
    registerBiome(registry, new MeadowBiome(), "meadow", ConfigManager.MEADOW.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.WET, BiomeDictionary.Type.OVERWORLD);
    registerBiome(registry, new MiniJungleBiome(), "mini_jungle", ConfigManager.MINI_JUNGLE.getWeight(), true, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.WET, BiomeDictionary.Type.OVERWORLD);
    registerBiome(registry, new PlainsPlateauBiome(), "plains_plateau", ConfigManager.PLAINS_PLATEAU.getWeight(), false, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(registry, new RockyEdgeBiome(), "rock_edge", ConfigManager.ROCK_EDGE.getWeight(), false, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.HOT, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
    registerBiome(registry, new RollingHillsBiome(), "rolling_hills", ConfigManager.ROLLING_HILLS.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(registry, new SnowyConiferousForestBiome(), "snowy_coniferous_forest", ConfigManager.SNOWY_CONIFEROUS_FOREST.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(registry, new SnowyConiferousWoodedHillsBiome(), "snowy_coniferous_wooded_hills", ConfigManager.SNOWY_CONIFEROUS_WOODED_HILLS.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(registry, new SnowyHighConiferousForestBiome(), "snowy_high_coniferous_forest", ConfigManager.SNOWY_HIGH_CONIFEROUS_FOREST.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
//		registerBiome(registry, new WoodedIslandBiome(), "wooded_island", 1, false, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
    registerBiome(registry, new WoodedPlateauBiome(), "wooded_plateau", ConfigManager.WOODED_PLATEAU.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
    registerBiome(registry, new WoodlandsBiome(), "woodlands", ConfigManager.WOODLANDS.getWeight(), true, BiomeManager.BiomeType.COOL, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);
  }

  private static void registerBiome(IForgeRegistry<Biome> registry, Biome biome, String name, int weight, boolean spawn, BiomeManager.BiomeType type, BiomeDictionary.Type... types) {
    registry.register(biome.setRegistryName(Traverse.MODID, name));
    if (weight > 0) {
      BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(biome, weight));
      if (spawn) {
        BiomeManager.addSpawnBiome(biome);
      }
      BiomeDictionary.addTypes(biome, types);
    }
  }
}
