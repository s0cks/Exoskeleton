package exoskeleton.common.handler

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.TickEvent.{Phase, PlayerTickEvent}
import exoskeleton.common.lib.data.DataManager
import exoskeleton.common.network.PacketHandler
import exoskeleton.common.network.sync.PacketSyncPlayerData
import net.minecraft.entity.player.EntityPlayerMP

object BacktrackHandler{
  private var counter: Int = 60;

  @SubscribeEvent
  def onPlayerTick(e: PlayerTickEvent): Unit ={
    if(e.phase == Phase.END && e.side.isServer){
      if(counter <= 0){
        DataManager.get(e.player).setBacktrackPosition(e.player);
        PacketHandler.instance.sendTo(new PacketSyncPlayerData(e.player), e.player.asInstanceOf[EntityPlayerMP]);
        counter = 60;
      } else{
        counter -= 1;;
      }
    }
  }
}