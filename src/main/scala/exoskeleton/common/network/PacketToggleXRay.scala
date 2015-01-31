package exoskeleton.common.network

import cpw.mods.fml.common.network.simpleimpl.{MessageContext, IMessageHandler, IMessage}
import exoskeleton.common.lib.data.DataManager
import io.netty.buffer.ByteBuf
import net.minecraft.entity.player.{EntityPlayerMP, EntityPlayer}

class PacketToggleXRay
extends IMessage
with IMessageHandler[PacketToggleXRay, IMessage]{
  override def fromBytes(buf: ByteBuf): Unit ={}
  override def toBytes(buf: ByteBuf): Unit ={}

  override def onMessage(message: PacketToggleXRay, ctx: MessageContext): IMessage ={
    val e = ctx.getServerHandler.playerEntity;
    if(e != null && e.isInstanceOf[EntityPlayer]){
      DataManager.get(e.asInstanceOf[EntityPlayer]).setXRay(!DataManager.get(e.asInstanceOf[EntityPlayer]).xray());
      PacketHandler.instance.sendTo(new PacketSyncPlayerData(e.asInstanceOf[EntityPlayer]), e.asInstanceOf[EntityPlayerMP]);
    }
    return null;
  }
}
