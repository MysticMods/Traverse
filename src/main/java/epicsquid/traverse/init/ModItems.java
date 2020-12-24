package epicsquid.traverse.init;

import com.tterrag.registrate.util.entry.RegistryEntry;
import epicsquid.traverse.item.FirBoatItem;

import static epicsquid.traverse.Traverse.REGISTRATE;

public class ModItems {
  public static RegistryEntry<FirBoatItem> FIR_BOAT = REGISTRATE.item("fir_boat", FirBoatItem::new)
      .properties(o -> o.maxStackSize(1))
      .register();

  public static void load() {
  }
}
