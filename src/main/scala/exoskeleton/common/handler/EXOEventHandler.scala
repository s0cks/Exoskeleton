package exoskeleton.common.handler

import com.google.common.eventbus.Subscribe
import exoskeleton.api.event.{BlinkEvent, RecallEvent}
import exoskeleton.common.lib.data.DataManager

object EXOEventHandler{
  @Subscribe
  def onRecall(e: RecallEvent): Unit ={
    val vec = DataManager.get(e.player).getRecallPoint();
    if(vec != null){
      e.player.setPositionAndUpdate(vec.x, vec.y, vec.z);
    }
  }

  @Subscribe
  def onBlink(e: BlinkEvent): Unit ={
    System.out.println("Ray Tracing");
    val vec = e.player.rayTrace(3, 1.0F);
    if(vec != null){
      e.player.setPositionAndUpdate(vec.blockX, vec.blockY, vec.blockZ);
    }
  }
}