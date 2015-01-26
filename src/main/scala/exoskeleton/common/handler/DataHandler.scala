package exoskeleton.common.handler

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import exoskeleton.common.lib.data.DataManager
import exoskeleton.common.lib.skills.SkillsManager
import net.minecraftforge.event.entity.player.PlayerEvent

object DataHandler{
  @SubscribeEvent
  def onPlayerLoad(e: PlayerEvent.LoadFromFile): Unit ={
    SkillsManager.getPlayerData(e.entityPlayer);
    DataManager.getPlayerData(e.entityPlayer);
  }

  @SubscribeEvent
  def onPlayerSave(e: PlayerEvent.SaveToFile): Unit ={
    SkillsManager.savePlayerData(e.entityPlayer);
    DataManager.savePlayerData(e.entityPlayer);
  }
}