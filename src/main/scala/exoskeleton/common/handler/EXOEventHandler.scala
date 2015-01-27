package exoskeleton.common.handler

import com.google.common.eventbus.Subscribe
import exoskeleton.api.event._
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
    val vec = e.player.rayTrace(3, 1.0F);
    if(vec != null){
      e.player.setPositionAndUpdate(vec.blockX, vec.blockY, vec.blockZ);
    }
  }

  @Subscribe
  def onBacktrack(e: BacktrackEvent): Unit ={
    val vec = DataManager.get(e.player).getBacktrackPosition();
    if(vec != null){
      e.player.setPositionAndUpdate(vec.x, vec.y, vec.z);
    }
  }

  @Subscribe
  def onAutoSmelt(e: AutoSmeltToggleEvent): Unit ={
    DataManager.get(e.player).setAutoSmelt(!DataManager.get(e.player).autoSmeltEnabled());
  }

  @Subscribe
  def onFlight(e: FlightToggleEvent): Unit ={
    DataManager.get(e.player).setFlight(!DataManager.get(e.player).flightEnabled());
    System.out.println("Flight Toggled: " + DataManager.get(e.player).flightEnabled());
  }
}