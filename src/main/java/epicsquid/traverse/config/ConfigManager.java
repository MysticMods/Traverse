package epicsquid.traverse.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ConfigManager {

  public static List<BiomeConfig> BIOMES = new ArrayList<>();

  private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

  public static BiomeConfig ARID_HIGHLANDS = new BiomeConfig("arid_highlands", 4);
  public static BiomeConfig AUTUMNAL_WOODED_HILLS = new BiomeConfig("autumnal_wooded_hills", 1);
  public static BiomeConfig AUTUMNAL_WOODS = new BiomeConfig("autumnal_woods", 3);
  public static BiomeConfig CLIFFS = new BiomeConfig("cliffs", 1);
  public static BiomeConfig CONIFEROUS_FOREST = new BiomeConfig("coniferous_forest", 4);
  public static BiomeConfig CONIFEROUS_WOODLAND_HILLS = new BiomeConfig("coniferous_woodland_hills_biome", 1);
  public static BiomeConfig DESERT_SHRUBLAND = new BiomeConfig("desert_shrubland", 4);
  public static BiomeConfig HIGH_CONIFEROUS_FOREST = new BiomeConfig("high_coniferous_forest", 2);
  public static BiomeConfig LUSH_SWAMP = new BiomeConfig("lush_swamp", 5);
  public static BiomeConfig MEADOW = new BiomeConfig("meadow", 6);
  public static BiomeConfig MINI_JUNGLE = new BiomeConfig("mini_jungle", 2);
  public static BiomeConfig PLAINS_PLATEAU = new BiomeConfig("plains_plateau", 2);
  public static BiomeConfig ROCK_EDGE = new BiomeConfig("rock_edge", 1);
  public static BiomeConfig ROLLING_HILLS = new BiomeConfig("rolling_hills", 4);
  public static BiomeConfig SNOWY_CONIFEROUS_FOREST = new BiomeConfig("snowy_coniferous_forest", 5);
  public static BiomeConfig SNOWY_CONIFEROUS_WOODED_HILLS = new BiomeConfig("snowy_coniferous_wooded_hills", 2);
  public static BiomeConfig SNOWY_HIGH_CONIFEROUS_FOREST = new BiomeConfig("snowy_high_coniferous_forest", 1);
  public static BiomeConfig WOODED_ISLAND = new BiomeConfig("wooded_island", 2);
  public static BiomeConfig WOODED_PLATEAU = new BiomeConfig("wooded_plateau", 2);
  public static BiomeConfig WOODLANDS = new BiomeConfig("woodlands", 6);

  public static ForgeConfigSpec COMMON_CONFIG;

  static {
    BIOMES.forEach(o -> o.apply(COMMON_BUILDER));
    COMMON_CONFIG = COMMON_BUILDER.build();
  }

  public static void loadConfig(ForgeConfigSpec spec, Path path) {
    CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
    configData.load();
    spec.setConfig(configData);
  }
}
