package exoskeleton.common.core

import exoskeleton.api.Tree
import exoskeleton.common.lib.ArmorHelper
import exoskeleton.common.lib.skills.PlayerSkills
import exoskeleton.common.lib.tree.TreeRecon
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingAttackEvent
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent

object CoreRecon
extends AbstractCore("recon"){
  override def onJump(player: EntityPlayer): Unit ={
    if(PlayerSkills.get(player).hasSkill("recon", "jumpBoost") && ArmorHelper.hasExoLegs(player)){
      player.motionY += 0.04;;
    }
  }

  override def getTree(): Tree={
    return TreeRecon;;
  }

  override def onAttacked(e: LivingAttackEvent, player: EntityPlayer, source: DamageSource): Unit ={
    if(hasSkill(player, "noDrown") && ArmorHelper.hasExoHelm(player)){
      if(e.source == DamageSource.drown){
        e.setCanceled(true);
      }
    }
  }

  override def onUpdate(player: EntityPlayer): Unit ={
    if(hasSkill(player, "breastStroke") && ArmorHelper.hasExoChest(player)){
      if(player.isInsideOfMaterial(Material.water) && player.moveForward > 0.0F){
        player.moveFlying(0.0F, 1.0F, 0.008F * 2);
      }
    }

    if(hasSkill(player, "speedyLegs") && ArmorHelper.hasExoLegs(player) && player.moveForward > 0.0F){
      player.moveFlying(0.0F, 1.0F, 0.016F * 2);
    }

    if(hasSkill(player, "stepUp") && ArmorHelper.hasExoBoots(player)){
      if(player.isSneaking()){
        player.stepHeight = 0.50001F;
      } else if(player.stepHeight == 0.50001F){
        player.stepHeight = 1.0F;
      }
    } else{
      player.stepHeight = 0.5F;
    }
  }

  override def getBreakSpeedModifier(player: EntityPlayer, b: Block, meta: Int, oldSpeed: Float): Float ={
    return oldSpeed;
  }

  override def onHud(player: EntityPlayer): Unit ={

  }

  override def onHarvest(e: HarvestDropsEvent): Unit ={

  }
}