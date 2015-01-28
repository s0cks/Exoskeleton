package exoskeleton.common.network

import cpw.mods.fml.common.network.simpleimpl.{MessageContext, IMessageHandler, IMessage}
import io.netty.buffer.ByteBuf
import net.minecraft.entity.player.EntityPlayer

class PacketBlink
extends IMessage
with IMessageHandler[PacketBlink, IMessage]{
  override def fromBytes(buf: ByteBuf): Unit ={}
  override def toBytes(buf: ByteBuf): Unit ={}

  override def onMessage(message: PacketBlink, ctx: MessageContext): IMessage ={
    val e = ctx.getServerHandler.playerEntity;
    if(e != null && e.isInstanceOf[EntityPlayer]){
      val vec = e.rayTrace(3, 1.0F);
      if(vec != null){
        e.setPositionAndUpdate(vec.blockX, vec.blockY, vec.blockZ);
      }
    }
    return null;
  }
}
