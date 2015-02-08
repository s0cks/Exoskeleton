package exoskeleton.common.handler

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import exoskeleton.common.lib.data.DataManager
import net.minecraft.entity.EntityLiving
import net.minecraft.entity.player.EntityPlayer
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent

object MobSelectionHandler {
  @SubscribeEvent
  def onSelectPlayer(e: LivingSetAttackTargetEvent): Unit ={
    if(e.target.isInstanceOf[EntityPlayer] && (DataManager.get(e.target.asInstanceOf[EntityPlayer]).isCamoActive() || e.target.isInvisible)){
      e.entityLiving.asInstanceOf[EntityLiving].setAttackTarget(null);
    }
  }
}