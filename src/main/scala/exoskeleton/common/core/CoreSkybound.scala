package exoskeleton.common.core

import exoskeleton.api.Tree
import exoskeleton.client.MotorBlock
import exoskeleton.common.lib.ArmorHelper
import exoskeleton.common.lib.data.DataManager
import exoskeleton.common.lib.tree.TreeSkybound
import net.minecraft.block.Block
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingAttackEvent
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent
import org.lwjgl.opengl.GL11
;

object CoreSkybound
extends AbstractCore("skybound"){
  override def getTree(): Tree ={
    return TreeSkybound;
  }

  override def onAttacked(e: LivingAttackEvent, player: EntityPlayer, source: DamageSource): Unit ={

  }

  override def onUpdate(player: EntityPlayer): Unit ={
    if(DataManager.get(player).flightEnabled()){
      player.capabilities.allowFlying = true;
    } else{
      if(!player.capabilities.isCreativeMode){
        player.capabilities.allowFlying = false;
        player.capabilities.isFlying = false;
        player.capabilities.disableDamage = false;
      }
    }
  }

  override def getBreakSpeedModifier(player: EntityPlayer, b: Block, meta: Int, oldSpeed: Float): Float ={
    return oldSpeed;
  }

  override def onHud(player: EntityPlayer): Unit ={
    if(DataManager.get(player).flightEnabled()){
      GL11.glPushMatrix();
      MotorBlock.drawString("Flight Enabled", 0, 10, 0x000000);
      GL11.glPopMatrix();
    }
  }

  override def onJump(player: EntityPlayer): Unit ={
    if(hasSkill(player, "thrusters") && ArmorHelper.hasExoBoots(player)){
      player.motionY += 0.2D;
    }
  }

  override def onHarvest(e: HarvestDropsEvent): Unit ={

  }
}