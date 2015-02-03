package exoskeleton.common.network.sync

import cpw.mods.fml.common.network.ByteBufUtils
import cpw.mods.fml.common.network.simpleimpl.{IMessage, IMessageHandler, MessageContext}
import cpw.mods.fml.relauncher.{Side, SideOnly}
import exoskeleton.common.lib.data.{DataManager, PlayerData}
import io.netty.buffer.ByteBuf
import net.minecraft.client.Minecraft
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.nbt.NBTTagCompound

class PacketSyncPlayerData(player: EntityPlayer)
extends IMessage
with IMessageHandler[PacketSyncPlayerData, IMessage]{
  private var data: PlayerData = null;

  if(this.player != null){
    this.data = DataManager.get(this.player);
  }

  def this() = this(null);

  override def fromBytes(buf: ByteBuf): Unit ={
    val comp = ByteBufUtils.readTag(buf);
    this.data = new PlayerData();
    this.data.readFromNBT(comp);
  }

  override def toBytes(buf: ByteBuf): Unit ={
    if(this.data != null){
      val comp = new NBTTagCompound;
      this.data.writeToNBT(comp);
      ByteBufUtils.writeTag(buf, comp);
    }
  }

  @SideOnly(Side.CLIENT)
  override def onMessage(message: PacketSyncPlayerData, ctx: MessageContext): IMessage ={
    DataManager.set(Minecraft.getMinecraft.thePlayer, message.data);
    return null;
  }
}