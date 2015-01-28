package exoskeleton.common.handler

import cpw.mods.fml.common.FMLCommonHandler
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.{PlayerEvent => PEvent}
import cpw.mods.fml.relauncher.Side
import exoskeleton.common.lib.data.DataManager
import exoskeleton.common.lib.skills.SkillsManager
import exoskeleton.common.network.{PacketHandler, PacketSyncPlayerData, PacketSyncSkills}
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraftforge.event.entity.player.PlayerEvent

object DataHandler{
  @SubscribeEvent
  def onPlayerLoad(e: PlayerEvent.LoadFromFile): Unit ={
    System.out.println("Loading Player Data (" + e.entityPlayer.getCommandSenderName + ")");
    DataManager.getPlayerData(e.entityPlayer);
    SkillsManager.getPlayerData(e.entityPlayer);
  }

  @SubscribeEvent
  def onPlayerSave(e: PlayerEvent.SaveToFile): Unit ={
    System.out.println("Saving Player Data (" + e.entityPlayer.getCommandSenderName + ")");
    DataManager.savePlayerData(e.entityPlayer);
    SkillsManager.savePlayerData(e.entityPlayer);
  }

  @SubscribeEvent
  def onPlayerLoggedIn(e: PEvent.PlayerLoggedInEvent): Unit ={
    val side = FMLCommonHandler.instance().getEffectiveSide;
    if(side == Side.SERVER){
      System.out.println("Syncing Data (" + e.player.getCommandSenderName + ")");
      PacketHandler.instance.sendTo(new PacketSyncPlayerData(e.player), e.player.asInstanceOf[EntityPlayerMP]);
      PacketHandler.instance.sendTo(new PacketSyncSkills(e.player), e.player.asInstanceOf[EntityPlayerMP]);
    }
  }
}