package mysticalmods.traverse.init;

import com.tterrag.registrate.providers.ProviderType;

import static mysticalmods.traverse.Traverse.REGISTRATE;

public class ModLang {
  static {
    REGISTRATE.addDataGenerator(ProviderType.LANG, (p) -> {
      p.add("itemGroup.traverse", "Traverse Reforged");
      p.add("biome.traverse.arid_highlands", "Arid Highlands");
      p.add("biome.traverse.autumnal_wooded_hills", "Autumnal Wooded Hills");
      p.add("biome.traverse.autumnal_woods", "Autumnal Woods");
      p.add("biome.traverse.cliffs", "Cliffs");
      p.add("biome.traverse.snowy_cliffs", "Snowy Cliffs");
      p.add("biome.traverse.coniferous_forest", "Coniferous Forest");
      p.add("biome.traverse.coniferous_woodland_hills", "Coniferous Wooded Hills");
      p.add("biome.traverse.desert_shrubland", "Desert Shrubland");
      p.add("biome.traverse.high_coniferous_forest", "High Coniferous Forest");
      p.add("biome.traverse.lush_swamp", "Lush Swamp");
      p.add("biome.traverse.meadow", "Meadow");
      p.add("biome.traverse.mini_jungle", "Miniature Jungle");
      p.add("biome.traverse.plains_plateau", "Plains Plateau");
      p.add("biome.traverse.rocky_edge", "Rocky Edge");
      p.add("biome.traverse.rolling_hills", "Rolling Hills");
      p.add("biome.traverse.snowy_coniferous_forest", "Snowy Coniferous Forest");
      p.add("biome.traverse.snowy_coniferous_wooded_hills", "Snowy Coniferous Wooded Hills");
      p.add("biome.traverse.snowy_high_coniferous_forest", "Snowy High Coniferous Forest");
      p.add("biome.traverse.wooded_island", "Wooded Island");
      p.add("biome.traverse.wooded_plateau", "Wooded Plateau");
      p.add("biome.traverse.woodlands", "Woodlands");
    });
  }

  public static void load () {
  }
}
