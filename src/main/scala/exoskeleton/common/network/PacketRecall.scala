package exoskeleton.common.network

import cpw.mods.fml.common.network.simpleimpl.{MessageContext, IMessageHandler, IMessage}
import exoskeleton.common.lib.data.DataManager
import io.netty.buffer.ByteBuf
import net.minecraft.entity.player.EntityPlayer

class PacketRecall
extends IMessage
with IMessageHandler[PacketRecall, IMessage]{
  override def fromBytes(buf: ByteBuf): Unit ={}
  override def toBytes(buf: ByteBuf): Unit ={}

  override def onMessage(message: PacketRecall, ctx: MessageContext): IMessage ={
    val e = ctx.getServerHandler.playerEntity;
    if(e != null && e.isInstanceOf[EntityPlayer]){
      DataManager.get(e.asInstanceOf[EntityPlayer]).getRecallPoint().teleportPlayer(e.asInstanceOf[EntityPlayer]);
    }

    return null;
  }
}