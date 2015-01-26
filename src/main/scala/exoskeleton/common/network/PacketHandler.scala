package exoskeleton.common.network

import cpw.mods.fml.common.network.NetworkRegistry
import cpw.mods.fml.relauncher.Side

object PacketHandler{
  val instance = NetworkRegistry.INSTANCE.newSimpleChannel("exoskeleton");

  def init(): Unit ={
    instance.registerMessage(classOf[PacketPlayerFade], classOf[PacketPlayerFade], 0x0, Side.SERVER);
    instance.registerMessage(classOf[PacketPlayerBloom], classOf[PacketPlayerBloom], 0x1, Side.SERVER);
  }
}