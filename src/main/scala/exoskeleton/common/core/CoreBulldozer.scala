package exoskeleton.common.core

import exoskeleton.api.Tree
import exoskeleton.common.lib.tree.TreeBulldozer
import net.minecraft.block.Block
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingAttackEvent

object CoreBulldozer
extends AbstractCore("bulldozer"){
  override def onJump(player: EntityPlayer): Unit ={

  }

  override def onAttacked(e: LivingAttackEvent, player: EntityPlayer, source: DamageSource): Unit ={

  }

  override def onUpdate(player: EntityPlayer): Unit ={

  }

  override def getBreakSpeedModifier(player: EntityPlayer, b: Block, meta: Int, oldSpeed: Float): Float ={
    return oldSpeed * 2.0F;
  }

  override def onHud(player: EntityPlayer): Unit ={

  }

  override def getTree(): Tree ={
    return new TreeBulldozer();
  }
}