package exoskeleton.common.core

import java.util

import exoskeleton.api.ExoskeletonAPI
import exoskeleton.api.skill.Tree
import exoskeleton.api.utils.Vector3
import exoskeleton.common.lib.ArmorHelper
import exoskeleton.common.lib.tree.TreeMystic
import net.minecraft.block.Block
import net.minecraft.entity.Entity
import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.{AxisAlignedBB, DamageSource}
import net.minecraftforge.event.entity.living.LivingAttackEvent
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent

import scala.collection.JavaConversions._

object CoreMystic
extends AbstractCore("mystic"){
  override def getTree(): Tree ={
    return TreeMystic;
  }

  override def onAttacked(e: LivingAttackEvent, player: EntityPlayer, source: DamageSource): Unit ={}

  override def onUpdate(player: EntityPlayer): Unit ={
    if(ArmorHelper.hasExoChest(player) && hasSkill(ArmorHelper.getChest(player), "magnetMode")){
      val range = 6;
      val x = player.posX;
      val y = player.posY;
      val z = player.posZ;

      val items = player.worldObj.getEntitiesWithinAABB(classOf[EntityItem], AxisAlignedBB.getBoundingBox(x - range, y - range, z - range, x + range, y + range, z + range)).asInstanceOf[util.List[EntityItem]];
      for(item: EntityItem <- items){
        if(canPull(item)){
          setEntityMotionFromVector(item, Vector3.of(x, y, z), 0.45F);
        }
      }
    }
  }

  private def setEntityMotionFromVector(e: Entity, o: Vector3, modifier: Float): Unit ={
    val eVector = fromEntityCenter(e);
    var f = o.subtract(eVector);
    if(f.magnitude() > 1){
      f = f.normalize();
    }

    e.motionX = f.x() * modifier;
    e.motionY = f.y() * modifier;
    e.motionZ = f.z() * modifier;
  }

  private def fromEntityCenter(e: Entity): Vector3={
    return Vector3.of(e.posX, e.posY - e.yOffset + e.height / 2, e.posZ);
  }

  private def canPull(item: EntityItem): Boolean={
    if(item.isDead){
      return false;
    }

    val stack = item.getEntityItem;
    if(stack == null || ExoskeletonAPI.isItemBlacklistedFromMagnet(stack.getItem)){
      return false;
    }

    return true;
  }

  override def getBreakSpeedModifier(player: EntityPlayer, b: Block, meta: Int, oldSpeed: Float): Float ={
    return oldSpeed;
  }

  override def onHarvest(e: HarvestDropsEvent): Unit ={}

  override def onHud(player: EntityPlayer): Unit ={}

  override def onJump(player: EntityPlayer): Unit ={}
}