package exoskeleton.common.handler

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.TickEvent.{Phase, PlayerTickEvent}
import exoskeleton.common.lib.data.DataManager

object BacktrackHandler{
  private var counter: Int = 60;

  @SubscribeEvent
  def onPlayerTick(e: PlayerTickEvent): Unit ={
    if(e.phase == Phase.END && e.side.isServer){
      if(counter <= 0){
        DataManager.get(e.player).setBacktrackPosition(e.player);
        counter = 60;
      } else{
        counter -= 1;;
      }
    }
  }
}