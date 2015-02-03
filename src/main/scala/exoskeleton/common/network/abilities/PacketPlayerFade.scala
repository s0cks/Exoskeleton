package exoskeleton.common.network.abilities

import cpw.mods.fml.common.network.simpleimpl.{IMessage, IMessageHandler, MessageContext}
import exoskeleton.common.handler.FadeHandler
import exoskeleton.common.lib.fade.PlayerFadeInfo
import io.netty.buffer.ByteBuf
import net.minecraft.entity.player.EntityPlayer

class PacketPlayerFade()
extends IMessage
with IMessageHandler[PacketPlayerFade, IMessage]{
  override def fromBytes(buf: ByteBuf): Unit ={}

  override def toBytes(buf: ByteBuf): Unit ={}

  override def onMessage(message: PacketPlayerFade, ctx: MessageContext): IMessage ={
    val e = ctx.getServerHandler.playerEntity;
    if(e != null && e.isInstanceOf[EntityPlayer]){
      FadeHandler.playerFadeInfo.put(e.getCommandSenderName, new PlayerFadeInfo(e.getCommandSenderName, 100));
      e.setInvisible(true);
    }

    return null;
  }
}