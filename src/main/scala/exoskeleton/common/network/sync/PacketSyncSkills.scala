package exoskeleton.common.network.sync

import cpw.mods.fml.common.network.simpleimpl.{IMessage, IMessageHandler, MessageContext}
import cpw.mods.fml.relauncher.{Side, SideOnly}
import io.netty.buffer.ByteBuf
import net.minecraft.entity.player.EntityPlayer

class PacketSyncSkills(player: EntityPlayer)
extends IMessage
with IMessageHandler[PacketSyncSkills, IMessage]{


  if(this.player != null){
  }

  def this() = this(null);

  override def fromBytes(buf: ByteBuf): Unit ={
  }

  override def toBytes(buf: ByteBuf): Unit ={
  }

  @SideOnly(Side.CLIENT)
  override def onMessage(message: PacketSyncSkills, ctx: MessageContext): IMessage ={
    return null;
  }
}