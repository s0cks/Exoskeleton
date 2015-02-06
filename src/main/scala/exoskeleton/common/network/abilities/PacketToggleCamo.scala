package exoskeleton.common.network.abilities

import cpw.mods.fml.common.network.simpleimpl.{IMessage, IMessageHandler, MessageContext}
import exoskeleton.common.lib.data.DataManager
import exoskeleton.common.network.PacketHandler
import exoskeleton.common.network.sync.PacketSyncPlayerData
import io.netty.buffer.ByteBuf
import net.minecraft.entity.player.{EntityPlayer, EntityPlayerMP}

class PacketToggleCamo
  extends IMessage
  with IMessageHandler[PacketToggleCamo, IMessage] {
  override def fromBytes(buf: ByteBuf): Unit = {}

  override def toBytes(buf: ByteBuf): Unit = {}

  override def onMessage(message: PacketToggleCamo, ctx: MessageContext): IMessage = {
    val e = ctx.getServerHandler.playerEntity;
    if (e != null && e.isInstanceOf[EntityPlayer]) {
      System.out.println("Toggling Camo");
      DataManager.get(e.asInstanceOf[EntityPlayer]).setCamo(!DataManager.get(e.asInstanceOf[EntityPlayer]).isCamoActive());
      System.out.println(DataManager.get(e.asInstanceOf[EntityPlayer]).isCamoActive());
      PacketHandler.instance.sendTo(new PacketSyncPlayerData(e.asInstanceOf[EntityPlayer]), e.asInstanceOf[EntityPlayerMP]);
    }
    return null;
  }
}