package exoskeleton.common.handler

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import exoskeleton.api.ExoskeletonTag
import exoskeleton.common.item.ItemExoArmor
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.event.entity.player.ItemTooltipEvent

object ExoToolTipHandler{
  @SubscribeEvent
  def onToolTip(e: ItemTooltipEvent): Unit ={
    if(e.itemStack.hasTagCompound &&
       e.itemStack.getTagCompound.hasKey(ExoskeletonTag.IDENTIFIER) &&
       e.itemStack.getItem.isInstanceOf[ItemExoArmor]){

      val comp: NBTTagCompound = ExoskeletonTag.getTag(e.itemStack);
      e.toolTip.add("Current Core: " + comp.getString("coreName"));
    }
  }
}