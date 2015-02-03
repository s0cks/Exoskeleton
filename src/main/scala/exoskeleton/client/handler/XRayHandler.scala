package exoskeleton.client.handler

import cpw.mods.fml.client.FMLClientHandler
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import exoskeleton.client.overlay.XRayOverlay
import exoskeleton.common.lib.ArmorHelper
import exoskeleton.common.lib.data.DataManager
import net.minecraft.entity.player.EntityPlayer
import net.minecraftforge.client.event.RenderWorldLastEvent

object XRayHandler{
  private val overlay = new XRayOverlay;

  @SubscribeEvent
  def render(e: RenderWorldLastEvent): Unit ={
    val mc = FMLClientHandler.instance().getClient;
    val player = mc.thePlayer.asInstanceOf[EntityPlayer];

    if(DataManager.get(player).xray() && ArmorHelper.hasExoHelm(player)){
      this.overlay.draw(mc);
    }
  }
}