package exoskeleton.common.handler

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import exoskeleton.api.{Core, ExoskeletonCores}
import exoskeleton.common.item.ItemExoArmor
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraftforge.event.entity.living.LivingAttackEvent
import net.minecraftforge.event.entity.living.LivingEvent.{LivingJumpEvent, LivingUpdateEvent}
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent

object CoreHandler{
  @SubscribeEvent
  def onHarvestCheck(e: HarvestDropsEvent): Unit ={
    if(e.harvester != null){
      var stack: ItemStack = null;
      for(i: Int <- 0 to 3){
        stack = e.harvester.getCurrentArmor(i);

        if(stack != null && stack.getItem.isInstanceOf[ItemExoArmor]){
          val core = ExoskeletonCores.findCore(stack);
          if(core != null){
            core.onHarvest(e);
          }
        }
      }
    }
  }

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