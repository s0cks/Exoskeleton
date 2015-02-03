package exoskeleton.common.network.abilities

import cpw.mods.fml.common.network.simpleimpl.{IMessage, IMessageHandler, MessageContext}
import exoskeleton.common.lib.data.DataManager
import exoskeleton.common.network.PacketHandler
import exoskeleton.common.network.sync.PacketSyncPlayerData
import io.netty.buffer.ByteBuf
import net.minecraft.entity.player.{EntityPlayer, EntityPlayerMP}

class PacketToggleNightVision
extends IMessage
with IMessageHandler[PacketToggleNightVision, IMessage]{
  override def fromBytes(buf: ByteBuf): Unit ={}
  override def toBytes(buf: ByteBuf): Unit ={}

  override def onMessage(message: PacketToggleNightVision, ctx: MessageContext): IMessage ={
    val e = ctx.getServerHandler.playerEntity;
    if(e != null && e.isInstanceOf[EntityPlayer]){
      DataManager.get(e.asInstanceOf[EntityPlayer]).setNightVision(!DataManager.get(e.asInstanceOf[EntityPlayer]).nightVisionEnabled());
      PacketHandler.instance.sendTo(new PacketSyncPlayerData(e.asInstanceOf[EntityPlayer]), e.asInstanceOf[EntityPlayerMP]);
    }
    return null;
  }
}