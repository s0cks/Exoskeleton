package exoskeleton.common.core

import java.util.Random

import exoskeleton.api.skill.Tree
import exoskeleton.common.lib.ArmorHelper
import exoskeleton.common.lib.tree.TreeGhost
import net.minecraft.block.Block
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingAttackEvent
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent

object CoreGhost
extends AbstractCore("ghost"){
  private val rand = new Random();

  override def getTree(): Tree ={
    return TreeGhost;
  }

  override def onAttacked(e: LivingAttackEvent, player: EntityPlayer, source: DamageSource): Unit ={
    if(this.rand.nextInt(10) == 1){
      e.setCanceled(true);
    }
  }

  override def onUpdate(player: EntityPlayer): Unit ={
    if(hasSkill(ArmorHelper.getBoots(player), "crouchingTiger") && ArmorHelper.hasExoBoots(player)){
      if(player.isSneaking && player.onGround && player.moveForward > 0.0F){
        player.moveFlying(0.0F, 1.0F, 0.035F * 2);
      }
    }
  }

  override def getBreakSpeedModifier(player: EntityPlayer, b: Block, meta: Int, oldSpeed: Float): Float ={
    return oldSpeed;
  }

  override def onHud(player: EntityPlayer): Unit ={

  }

  override def onJump(player: EntityPlayer): Unit ={

  }

  override def onHarvest(e: HarvestDropsEvent): Unit ={

  }
}