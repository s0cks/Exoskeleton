package exoskeleton.common.core

import java.util.Random

import exoskeleton.api.skill.Tree
import exoskeleton.common.lib.ArmorHelper
import exoskeleton.common.lib.tree.TreeMedic
import net.minecraft.block.Block
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingAttackEvent
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent

object CoreMedic
extends AbstractCore("medic"){
  private val rand = new Random();

  override def getTree(): Tree ={
    return TreeMedic;
  }

  override def onAttacked(e: LivingAttackEvent, player: EntityPlayer, source: DamageSource): Unit ={
    if(ArmorHelper.hasExoChest(player) && hasSkill(ArmorHelper.getChest(player), "lifeSteal")){
      if(rand.nextBoolean()){
        e.source.getEntity.attackEntityFrom(DamageSource.magic, 1);
        player.heal(1);
      }
    }
  }

  override def onUpdate(player: EntityPlayer): Unit ={
    if(ArmorHelper.hasExoHelm(player) && hasSkill(ArmorHelper.getHelmet(player), "regen")){
      if(this.rand.nextBoolean() && player.getHealth < player.getMaxHealth){
        player.heal(0.5F);
      }
    }

    if(hasSkill(ArmorHelper.getLeggings(player), "speedyLegs") && ArmorHelper.hasExoLegs(player) && player.moveForward > 0.0F && player.onGround){
      player.moveFlying(0.0F, 1.0F, 0.016F * 2);
    }

    if(hasSkill(ArmorHelper.getBoots(player), "stepUp") && ArmorHelper.hasExoBoots(player)){
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

  override def onHarvest(e: HarvestDropsEvent): Unit ={

  }

  override def onHud(player: EntityPlayer): Unit ={

  }

  override def onJump(player: EntityPlayer): Unit ={

  }
}