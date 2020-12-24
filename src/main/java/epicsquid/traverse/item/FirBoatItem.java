package epicsquid.traverse.item;

import epicsquid.traverse.entity.TerraformBoatEntity;
import epicsquid.traverse.init.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;

public class FirBoatItem extends Item {
  private static Predicate<Entity> RIDERS = EntityPredicates.NOT_SPECTATING.and(Entity::canBeCollidedWith);

  public FirBoatItem(Properties properties) {
    super(properties);
  }

  @Override
  public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
    ItemStack stack = player.getHeldItem(hand);
    RayTraceResult hit = rayTrace(world, player, RayTraceContext.FluidMode.ANY);
    if (hit.getType() != RayTraceResult.Type.BLOCK) {
      return ActionResult.resultPass(stack);
    } else {
      Vector3d rotation = player.getLook(1.0f);
      List<Entity> entities = world.getEntitiesInAABBexcluding(player, player.getBoundingBox().expand(rotation.scale(5)).grow(1), RIDERS);
      if (!entities.isEmpty()) {
        Vector3d eyes = player.getEyePosition(1.0f);
        for (Entity entity : entities) {
          if (entity.getBoundingBox().grow(entity.getCollisionBorderSize()).contains(eyes)) {
            return ActionResult.resultPass(stack);
          }
        }
      }

      TerraformBoatEntity boat = createBoat(world, hit.getHitVec().x, hit.getHitVec().y, hit.getHitVec().z);
      if (boat == null) {
        return ActionResult.resultPass(stack);
      }

      if (!world.hasNoCollisions(boat, boat.getBoundingBox().shrink(0.1))) {
        return ActionResult.resultFail(stack);
      } else {
        if (!world.isRemote) {
          world.addEntity(boat);
        }

        if (!player.isCreative()) {
          stack.shrink(1);
        }

        player.addStat(Stats.ITEM_USED.get(this));
        return ActionResult.resultSuccess(stack);
      }
    }
  }

  @Nullable
  private TerraformBoatEntity createBoat(World world, double x, double y, double z) {
    TerraformBoatEntity entity = ModEntities.FIR_BOAT.get().create(world);
    if (entity != null) {
      entity.setRawPosition(x, y, z);
      entity.setPosition(x, y, z);
      entity.setMotion(Vector3d.ZERO);
      entity.prevPosX = x;
      entity.prevPosY = y;
      entity.prevPosZ = z;
    }
    return entity;
  }
}
