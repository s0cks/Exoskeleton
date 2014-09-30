package io.github.asyncronous.exoskeleton.handler

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import io.github.asyncronous.exoskeleton.api.{Core, ExoskeletonCores}
import io.github.asyncronous.exoskeleton.item.ItemExoArmor
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraftforge.event.entity.living.LivingAttackEvent
import net.minecraftforge.event.entity.living.LivingEvent.{LivingJumpEvent, LivingUpdateEvent}
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed

object CoreHandler{
  @SubscribeEvent
  def onBreakSpeed(e: BreakSpeed): Unit = {
    var stack: ItemStack = null;
    for (i: Int <- 0 to 3) {
      stack = e.entityPlayer.getCurrentArmor(i);

      if (stack != null &&
        stack.getItem().isInstanceOf[ItemExoArmor]) {

        val core: Core = ExoskeletonCores.findCore(stack);
        if(core != null){
          e.newSpeed = core.getBreakSpeedModifier(e.entityPlayer, e.block, e.metadata, e.originalSpeed);
        }
      }
    }
  }

  @SubscribeEvent
  def onUpdate(e: LivingUpdateEvent): Unit = {
    if (e.entityLiving.isInstanceOf[EntityPlayer]) {
      val player: EntityPlayer = e.entityLiving.asInstanceOf[EntityPlayer];
      var stack: ItemStack = null;
      for (i: Int <- 0 to 3) {
        stack = player.getCurrentArmor(i);

        if (stack != null &&
          stack.getItem().isInstanceOf[ItemExoArmor]) {

          val core: Core = ExoskeletonCores.findCore(stack);
          if(core != null){
            core.onUpdate(player);
          }
        }
      }
    }
  }

  @SubscribeEvent
  def onAttack(e: LivingAttackEvent): Unit ={
    if(e.entityLiving.isInstanceOf[EntityPlayer]){
      val player: EntityPlayer = e.entityLiving.asInstanceOf[EntityPlayer];
      var stack: ItemStack = null;
      for(i: Int <- 0 to 3) {
        stack = player.getCurrentArmor(i);

        if(stack != null &&
          stack.getItem().isInstanceOf[ItemExoArmor]) {

          val core: Core = ExoskeletonCores.findCore(stack);
          if(core != null){
            core.onAttacked(e, player, e.source);
          }
        }
      }
    }
  }

  @SubscribeEvent
  def onJump(e: LivingJumpEvent): Unit ={
    if(e.entityLiving.isInstanceOf[EntityPlayer]){
      val player: EntityPlayer = e.entityLiving.asInstanceOf[EntityPlayer];
      var stack: ItemStack = null;
      for(i: Int <- 0 to 3){
        stack = player.getCurrentArmor(i);

        if(stack != null &&
          stack.getItem().isInstanceOf[ItemExoArmor]){

          val core: Core = ExoskeletonCores.findCore(stack);
          if(core != null){
            core.onJump(player);
          }
        }
      }
    }
  }
}