package epicsquid.traverse.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import noobanidus.libs.noobutil.config.BiomeConfig;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ConfigManager {

  public static List<BiomeConfig> BIOMES = new ArrayList<>();

  private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
  private static final BiomeConfig.Builder config = new BiomeConfig.Builder(BIOMES);

  public static BiomeConfig ARID_HIGHLANDS = config.build("arid_highlands", 10);
  public static BiomeConfig AUTUMNAL_WOODS = config.build("autumnal_woods", 5);
  public static BiomeConfig CLIFFS = config.build("cliffs", 4);
  public static BiomeConfig SNOWY_CLIFFS = config.build("snowy_cliffs", 3);
  public static BiomeConfig CONIFEROUS_FOREST = config.build("coniferous_forest", 4);
  public static BiomeConfig DESERT_SHRUBLAND = config.build("desert_shrubland", 4);
  public static BiomeConfig HIGH_CONIFEROUS_FOREST = config.build("high_coniferous_forest", 1);
  public static BiomeConfig LUSH_SWAMP = config.build("lush_swamp", 1);
  public static BiomeConfig MEADOW = config.build("meadow", 5);
  public static BiomeConfig MINI_JUNGLE = config.build("mini_jungle", 1);
  public static BiomeConfig PLAINS_PLATEAU = config.build("plains_plateau", 3);
  public static BiomeConfig ROLLING_HILLS = config.build("rolling_hills", 4);
  public static BiomeConfig SNOWY_CONIFEROUS_FOREST = config.build("snowy_coniferous_forest", 3);
  public static BiomeConfig SNOWY_HIGH_CONIFEROUS_FOREST = config.build("snowy_high_coniferous_forest", 1);
  public static BiomeConfig WOODED_ISLAND = config.build("wooded_islands", 1);
  public static BiomeConfig WOODLANDS = config.build("woodlands", 5);

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
