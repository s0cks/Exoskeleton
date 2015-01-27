package exoskeleton.common.core

import exoskeleton.api.Tree
import exoskeleton.client.MotorBlock
import exoskeleton.common.lib.ArmorHelper
import exoskeleton.common.lib.data.DataManager
import exoskeleton.common.lib.skills.PlayerSkills
import net.minecraft.block.Block
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.crafting.FurnaceRecipes
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingAttackEvent
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent
import org.lwjgl.opengl.GL11

object CoreInferno
extends AbstractCore("inferno"){
  override def onJump(player: EntityPlayer): Unit ={

  }

  override def onAttacked(e: LivingAttackEvent, player: EntityPlayer, source: DamageSource): Unit ={
    if(PlayerSkills.get(player).hasSkill("inferno", "fireIgnore") &&
       source == DamageSource.onFire &&
       ArmorHelper.hasExoLegs(player)){

      e.setCanceled(true);
    } else if(PlayerSkills.get(player).hasSkill("inferno", "lavaIgnore") &&
              source == DamageSource.lava &&
              ArmorHelper.hasExoLegs(player)){

      e.setCanceled(true);
    }
  }

  override def onUpdate(player: EntityPlayer): Unit ={

  }

  override def getBreakSpeedModifier(player: EntityPlayer, b: Block, meta: Int, oldSpeed: Float): Float ={
    return oldSpeed;
  }

  override def onHud(player: EntityPlayer): Unit ={
    if(DataManager.get(player).autoSmeltEnabled()){
      GL11.glPushMatrix();
      MotorBlock.drawString("AutoSmelt Enabled", 0, 10, 0x000000);;
      GL11.glPopMatrix();
    }
  }

  override def getTree(): Tree ={
    return null;
  }

  override def onHarvest(e: HarvestDropsEvent): Unit ={
    if(DataManager.get(e.harvester).autoSmeltEnabled()){
      for(i: Int <- 0 until e.drops.size()){
        val stack = FurnaceRecipes.smelting().getSmeltingResult(e.drops.get(i));

        if(stack != null){
          e.drops.set(i, stack.copy());
        }
      }
    }
  }
}