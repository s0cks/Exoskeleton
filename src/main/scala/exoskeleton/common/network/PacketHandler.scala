package exoskeleton.common.network

import cpw.mods.fml.common.network.NetworkRegistry
import cpw.mods.fml.relauncher.Side

object PacketHandler{
  val instance = NetworkRegistry.INSTANCE.newSimpleChannel("exoskeleton");

  def init(): Unit ={
    instance.registerMessage(classOf[PacketPlayerFade], classOf[PacketPlayerFade], 0x0, Side.SERVER);
    instance.registerMessage(classOf[PacketSyncPlayerData], classOf[PacketSyncPlayerData], 0x1, Side.CLIENT);
    instance.registerMessage(classOf[PacketSyncSkills], classOf[PacketSyncSkills], 0x2, Side.CLIENT);
    instance.registerMessage(classOf[PacketToggleFlight], classOf[PacketToggleFlight], 0x3, Side.SERVER);
    instance.registerMessage(classOf[PacketRecall], classOf[PacketRecall], 0x4, Side.SERVER);
    instance.registerMessage(classOf[PacketBacktrack], classOf[PacketBacktrack], 0x5, Side.SERVER);
    instance.registerMessage(classOf[PacketBlink], classOf[PacketBlink], 0x6, Side.SERVER);
    instance.registerMessage(classOf[PacketToggleAutoSmelt], classOf[PacketToggleAutoSmelt], 0x7, Side.SERVER);
    instance.registerMessage(classOf[PacketToggleThermal], classOf[PacketToggleThermal], 0x8, Side.SERVER);
    instance.registerMessage(classOf[PacketToggleNightVision], classOf[PacketToggleNightVision], 0x9, Side.SERVER);
  }
}