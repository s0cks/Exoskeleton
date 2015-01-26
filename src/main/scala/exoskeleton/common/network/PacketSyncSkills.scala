package exoskeleton.common.network

import cpw.mods.fml.common.network.simpleimpl.{MessageContext, IMessageHandler, IMessage}
import io.netty.buffer.ByteBuf

class PacketSyncSkills
extends IMessage
with IMessageHandler[PacketSyncSkills, IMessage]{
  override def fromBytes(buf: ByteBuf): Unit ={

  }

  override def toBytes(buf: ByteBuf): Unit ={

  }

  override def onMessage(message: PacketSyncSkills, ctx: MessageContext): IMessage ={
    return null;
  }
}