package exoskeleton.common.core

import exoskeleton.api.skill.Tree
import exoskeleton.common.lib.tree.TreeBulldozer
import net.minecraft.block.Block
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingAttackEvent
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent

object CoreBulldozer
extends AbstractCore("bulldozer"){
  override def getTree(): Tree ={
    return TreeBulldozer;
  }

  override def onAttacked(e: LivingAttackEvent, player: EntityPlayer, source: DamageSource): Unit ={

  }

  override def onUpdate(player: EntityPlayer): Unit ={

  }

  override def getBreakSpeedModifier(player: EntityPlayer, b: Block, meta: Int, oldSpeed: Float): Float={
    return oldSpeed;
  }

  override def onHarvest(e: HarvestDropsEvent): Unit ={

  }

  override def onHud(player: EntityPlayer): Unit ={

  }

  override def onJump(player: EntityPlayer): Unit ={

  }
}