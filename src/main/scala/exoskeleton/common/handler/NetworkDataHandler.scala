package exoskeleton.common.handler

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent
import exoskeleton.common.Exoskeleton
import exoskeleton.common.lib.data.{DataManager, PlayerData}
import net.minecraft.client.Minecraft

object NetworkDataHandler{
  @SubscribeEvent
  def onPlayerJoinWorld(e: ClientConnectedToServerEvent): Unit ={
    if(Exoskeleton.proxy.getClientWorld() != null && Minecraft.getMinecraft.thePlayer != null){
      System.out.println("Putting Dummy Data (" + Minecraft.getMinecraft.thePlayer.getCommandSenderName + ")");
      DataManager.set(Minecraft.getMinecraft.thePlayer, new PlayerData());

    }
  }
}