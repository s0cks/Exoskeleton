package io.github.asyncronous.exoskeleton.api

import net.minecraft.block.Block
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingAttackEvent

trait Core{
  def getID(): String;
  def onJump(player: EntityPlayer);
  def onAttacked(e: LivingAttackEvent, player: EntityPlayer, source: DamageSource);
  def onUpdate(player: EntityPlayer)
  def getBreakSpeedModifier(player: EntityPlayer, b: Block, meta: Int,  oldSpeed: Float): Float;
}