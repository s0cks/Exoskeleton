package exoskeleton.common.core

import java.util.Random

import exoskeleton.api.Tree
import exoskeleton.common.lib.tree.TreeReflex
import net.minecraft.block.Block
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingAttackEvent
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent

object CoreReflex
extends AbstractCore("reflex"){
  private val rand = new Random();

  override def getTree(): Tree ={
    return TreeReflex;
  }

  override def onAttacked(e: LivingAttackEvent, player: EntityPlayer, source: DamageSource): Unit ={

  }

  override def onUpdate(player: EntityPlayer): Unit ={

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