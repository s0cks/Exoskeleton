package exoskeleton.client.handler

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import exoskeleton.api.ExoskeletonAPI
import exoskeleton.api.utils.RenderUtils
import exoskeleton.common.lib.data.DataManager
import net.minecraftforge.client.event.RenderPlayerEvent
import org.lwjgl.opengl.GL11

object CamoHandler{
  @SubscribeEvent
  def doCamo(ev: RenderPlayerEvent.Pre): Unit ={
    if(DataManager.get(ev.entityPlayer).isCamoActive()){
      ev.setCanceled(true);
      GL11.glPushMatrix();
      RenderUtils.translateToWorldCoords(ev.entity, ev.partialRenderTick);

      GL11.glPushMatrix();
      val x = ev.entity.posX.asInstanceOf[Int];
      val y = ev.entity.posY.asInstanceOf[Int];
      val z = ev.entity.posZ.asInstanceOf[Int];
      val camo = ExoskeletonAPI.getCamouflage(ev.entity.worldObj, x, z);
      camo.draw(ev.entityPlayer, x, y, z);
      GL11.glPopMatrix();

      GL11.glPopMatrix();
    }
  }
}