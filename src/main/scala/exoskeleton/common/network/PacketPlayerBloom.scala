package exoskeleton.common.network

import cpw.mods.fml.common.network.simpleimpl.{IMessage, IMessageHandler, MessageContext}
import exoskeleton.common.Exoskeleton
import io.netty.buffer.ByteBuf
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World

class PacketPlayerBloom(player: EntityPlayer)
  extends IMessage
  with IMessageHandler[PacketPlayerBloom, IMessage]{
  private var playerID: Int = 0;

  def this() = this(null);

  override def fromBytes(buf: ByteBuf): Unit ={
    this.playerID = buf.readInt();
  }

  override def toBytes(buf: ByteBuf): Unit ={
    buf.writeInt(this.player.getEntityId);
  }

  override def onMessage(message: PacketPlayerBloom, ctx: MessageContext): IMessage ={
    val world: World = Exoskeleton.proxy.getClientWorld();
    if(world == null){
      return null;
    }

    val e = world.getEntityByID(message.playerID);
    if(e != null && e.isInstanceOf[EntityPlayer]){
      e.setInvisible(false);
    }

    return null;
  }
}