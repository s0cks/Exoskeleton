package exoskeleton.common.handler

import cpw.mods.fml.client.FMLClientHandler
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import exoskeleton.client.overlay.ThermalOverlay
import exoskeleton.common.lib.data.DataManager
import net.minecraft.entity.player.EntityPlayer
import net.minecraftforge.client.event.RenderWorldLastEvent;

object ThermalHandler{
  private val overlay = new ThermalOverlay;

  @SubscribeEvent
  def render(e: RenderWorldLastEvent): Unit ={
    val mc = FMLClientHandler.instance().getClient;
    val player = mc.thePlayer.asInstanceOf[EntityPlayer];
    if(DataManager.get(player).thermal()){
      overlay.draw(mc);
    }
  }
}