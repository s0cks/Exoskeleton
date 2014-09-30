package io.github.asyncronous.exoskeleton.handler

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import io.github.asyncronous.exoskeleton.ExoskeletonTag
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.event.entity.player.ItemTooltipEvent

object ExoToolTipHandler{
  @SubscribeEvent
  def onToolTip(e: ItemTooltipEvent): Unit ={
    if(e.itemStack.hasTagCompound &&
       e.itemStack.getTagCompound.hasKey(ExoskeletonTag.IDENTIFIER)){

      val comp: NBTTagCompound = ExoskeletonTag.getTag(e.itemStack);
      e.toolTip.add("Current Core: " + comp.getString("coreName"));
    }
  }
}