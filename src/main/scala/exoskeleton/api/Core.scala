package exoskeleton.api

import exoskeleton.api.utils.OverlaySet
import net.minecraft.block.Block
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingAttackEvent
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent

trait Core{
  def getID(): String;
  def getTree(): Tree;
  def onJump(player: EntityPlayer);
  def onAttacked(e: LivingAttackEvent, player: EntityPlayer, source: DamageSource);
  def onUpdate(player: EntityPlayer)
  def getBreakSpeedModifier(player: EntityPlayer, b: Block, meta: Int,  oldSpeed: Float): Float;
  def onHud(player: EntityPlayer);
  def onHarvest(e: HarvestDropsEvent);
  def overlay(): OverlaySet;
}