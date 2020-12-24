package epicsquid.traverse.entity;

import com.tterrag.registrate.util.entry.RegistryEntry;
import epicsquid.traverse.Traverse;
import epicsquid.traverse.init.ModBlocks;
import epicsquid.traverse.init.ModItems;
import epicsquid.traverse.item.FirBoatItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class TerraformBoatEntity extends BoatEntity {
  private static ResourceLocation FIR_SKIN = new ResourceLocation(Traverse.MODID, "textures/entity/boat/fir.png");
  private TerraformBoat boat;

  public TerraformBoatEntity(EntityType<? extends BoatEntity> type, World world, TerraformBoat boat) {
    super(type, world);
    this.boat = boat;
  }

  public Item asItem() {
    return boat.getBoatItem();
  }

  public Item asPlanks() {
    return boat.getPlanks();
  }

  public ResourceLocation getSkin() {
    return boat.getSkin();
  }

  private boolean isOnLand() {
    return this.getPaddleSound() == SoundEvents.ENTITY_BOAT_PADDLE_LAND;
  }

  @Override
  protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    float savedFallDistance = this.fallDistance;
    super.updateFallState(y, false, state, pos);
    if (!this.isPassenger() && onGroundIn) {
      this.fallDistance = savedFallDistance;
      if (this.fallDistance > 3.0F) {
        if (!this.isOnLand()) {
          this.fallDistance = 0.0F;
          return;
        }

        this.onLivingFall(this.fallDistance, 1.0F);
        if (!this.world.isRemote && this.isAlive()) {
          this.remove();
          if (this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
            int i;
            for (i = 0; i < 3; ++i) {
              this.entityDropItem(this.asPlanks());
            }

            for (i = 0; i < 2; ++i) {
              this.entityDropItem(Items.STICK);
            }
          }
        }
      }

      this.fallDistance = 0.0F;
    }

  }

  @Override
  public IPacket<?> createSpawnPacket() {
    return NetworkHooks.getEntitySpawningPacket(this);
  }

  @Override
  public void setBoatType(Type type) {
    throw new UnsupportedOperationException("Cannot change type of Terraform/Traverse boat");
  }

  @Override
  public Type getBoatType() {
    return this.boat.getType();
  }

  public static class TerraformBoat {
    private RegistryEntry<FirBoatItem> boatItem;
    private RegistryEntry<Block> planks;
    private ResourceLocation skin;
    private BoatEntity.Type type;

    public TerraformBoat(RegistryEntry<FirBoatItem> boatItem, RegistryEntry<Block> planks, ResourceLocation skin) {
      this(boatItem, planks, skin, Type.OAK);
    }

    public TerraformBoat(RegistryEntry<FirBoatItem> boatItem, RegistryEntry<Block> planks, ResourceLocation skin, Type type) {
      this.boatItem = boatItem;
      this.planks = planks;
      this.skin = skin;
      this.type = type;
    }

    public Item getBoatItem() {
      return boatItem.get();
    }

    public Item getPlanks() {
      return planks.get().asItem();
    }

    public ResourceLocation getSkin() {
      return skin;
    }

    public Type getType() {
      return type;
    }
  }

  public static class FirBoatEntity extends TerraformBoatEntity {
    private static TerraformBoat FIR_BOAT = new TerraformBoatEntity.TerraformBoat(ModItems.FIR_BOAT, ModBlocks.FIR_PLANKS, FIR_SKIN, BoatEntity.Type.OAK);

    public FirBoatEntity(EntityType<? extends BoatEntity> type, World world) {
      super(type, world, FIR_BOAT);
    }
  }
}
