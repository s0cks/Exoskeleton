package exoskeleton.common.lib.data

import java.io.{File, FileInputStream, FileOutputStream}
import java.util

import cpw.mods.fml.common.ObfuscationReflectionHelper
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.nbt.{CompressedStreamTools, NBTTagCompound}
import net.minecraft.server.MinecraftServer
import net.minecraft.world.storage.SaveHandler

object DataManager{
  private val map = new util.HashMap[String, PlayerData]();

  def get(player: EntityPlayer): PlayerData={
    return this.map.get(player.getCommandSenderName);
  }

  def set(player: EntityPlayer, data: PlayerData): Unit ={
    if(player == null) throw new NullPointerException("Player == null");
    this.map.put(player.getCommandSenderName, data);
  }

  def getPlayerData(player: EntityPlayer): Unit={
    val pNBTManagerObj = MinecraftServer.getServer.worldServerForDimension(0).getSaveHandler.getSaveHandler;
    val sh = pNBTManagerObj.asInstanceOf[SaveHandler];
    val dir: File = ObfuscationReflectionHelper.getPrivateValue(classOf[SaveHandler], sh, "playersDirectory", "field_75771_c");
    val file = new File(dir, player.getDisplayName + ".exoData");
    val comp = this.load(file);
    val data = new PlayerData();
    data.readFromNBT(comp);
    map.put(player.getCommandSenderName, data);
  }

  def savePlayerData(player: EntityPlayer): Unit ={
    val pNBTManagerObj = MinecraftServer.getServer.worldServerForDimension(0).getSaveHandler.getSaveHandler;
    val sh = pNBTManagerObj.asInstanceOf[SaveHandler];
    val dir: File = ObfuscationReflectionHelper.getPrivateValue(classOf[SaveHandler], sh, "playersDirectory", "field_75771_c");
    val file = new File(dir, player.getDisplayName + ".exoData");
    val compound = new NBTTagCompound;
    map.get(player.getCommandSenderName).writeToNBT(compound);
    this.save(compound, file);
  }

  private def load(file: File): NBTTagCompound={
    try{
      var compound = new NBTTagCompound();
      if(file != null && file.exists()){
        val fis = new FileInputStream(file);
        compound = CompressedStreamTools.readCompressed(fis);
        fis.close();
      }

      return compound;
    } catch{
      case ex: Exception=>{
        ex.printStackTrace(System.err);
        return new NBTTagCompound;
      }
    }
  }

  private def save(comp: NBTTagCompound, file: File): Unit ={
    try{
      val fos = new FileOutputStream(file);
      CompressedStreamTools.writeCompressed(comp, fos);
      fos.close();
    } catch{
      case ex: Exception=>{
        ex.printStackTrace(System.err);
      }
    }
  }
}