package epicsquid.traverse.init;

import com.tterrag.registrate.util.entry.RegistryEntry;
import epicsquid.traverse.entity.TerraformBoatEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;

import static epicsquid.traverse.Traverse.REGISTRATE;

public class ModEntities {
  public static RegistryEntry<EntityType<TerraformBoatEntity.FirBoatEntity>> FIR_BOAT = REGISTRATE.entity("fir_boat", TerraformBoatEntity.FirBoatEntity::new, EntityClassification.MISC)
      .properties(o -> o.size(1.375f, 0.5625f))
      .register();

  public static void load() {
  }
}
