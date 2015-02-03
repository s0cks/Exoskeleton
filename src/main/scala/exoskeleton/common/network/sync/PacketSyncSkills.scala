package exoskeleton.common.network.sync

import cpw.mods.fml.client.FMLClientHandler
import cpw.mods.fml.common.network.ByteBufUtils
import cpw.mods.fml.common.network.simpleimpl.{IMessage, IMessageHandler, MessageContext}
import cpw.mods.fml.relauncher.{Side, SideOnly}
import exoskeleton.common.lib.skills.PlayerSkills
import io.netty.buffer.ByteBuf
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.nbt.NBTTagCompound

class PacketSyncSkills(player: EntityPlayer)
extends IMessage
with IMessageHandler[PacketSyncSkills, IMessage]{
  private var data: PlayerSkills = null;

  if(this.player != null){
    this.data = PlayerSkills.get(this.player);
  }

  def this() = this(null);

  override def fromBytes(buf: ByteBuf): Unit ={
    val comp = ByteBufUtils.readTag(buf);
    this.data = new PlayerSkills();
    this.data.load(comp);
  }

  override def toBytes(buf: ByteBuf): Unit ={
    if(this.data != null){
      val comp = new NBTTagCompound;
      this.data.save(comp);
      ByteBufUtils.writeTag(buf, comp);
    }
  }

  @SideOnly(Side.CLIENT)
  override def onMessage(message: PacketSyncSkills, ctx: MessageContext): IMessage ={
    PlayerSkills.instances.put(FMLClientHandler.instance().getClient.thePlayer, message.data);
    return null;
  }
}