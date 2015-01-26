package exoskeleton.common.network

import cpw.mods.fml.client.FMLClientHandler
import cpw.mods.fml.common.network.simpleimpl.{IMessage, IMessageHandler, MessageContext}
import exoskeleton.client.particles.EntitySmokeCloudFX
import exoskeleton.common.Exoskeleton
import exoskeleton.common.handler.FadeHandler
import exoskeleton.common.lib.fade.PlayerFadeInfo
import io.netty.buffer.ByteBuf
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World

class PacketPlayerFade(player: EntityPlayer)
extends IMessage
with IMessageHandler[PacketPlayerFade, IMessage]{
  private var playerID: Int = 0;

  def this() = this(null);

  override def fromBytes(buf: ByteBuf): Unit ={
    this.playerID = buf.readInt();
  }

  override def toBytes(buf: ByteBuf): Unit ={
    buf.writeInt(this.player.getEntityId);
  }

  override def onMessage(message: PacketPlayerFade, ctx: MessageContext): IMessage ={
    val world: World = Exoskeleton.proxy.getClientWorld();
    if(world == null){
      return null;
    }

    val e = world.getEntityByID(message.playerID);
    if(e != null && e.isInstanceOf[EntityPlayer]){
      FadeHandler.playerFadeInfo.put(e.getCommandSenderName, new PlayerFadeInfo(e.getCommandSenderName, 100));
      spawnParticleAt(e.posX, e.posY, e.posZ);
      e.setInvisible(true);
    }

    return null;
  }

  private def spawnParticleAt(x: Double, y: Double, z: Double): Unit ={
    val minecraft = FMLClientHandler.instance().getClient;
    for(i: Int <- 0 to minecraft.theWorld.rand.nextInt(10)){
      minecraft.effectRenderer.addEffect(new EntitySmokeCloudFX(minecraft.theWorld, x, y, z));
    }
  }
}