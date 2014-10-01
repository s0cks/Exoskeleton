package io.github.asyncronous.exoskeleton.handler

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import io.github.asyncronous.exoskeleton.tracker.ReconTracker
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing

object TrackerHandler{
  val RECON: String = "exoRecon";

  @SubscribeEvent
  def onConstruction(e: EntityConstructing): Unit ={
    if(e.entity.isInstanceOf[EntityPlayerMP]){
      e.entity.registerExtendedProperties("exoRecon", new ReconTracker());
    }
  }
}