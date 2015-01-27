package exoskeleton.common.command

import exoskeleton.api.utils.Vector3
import exoskeleton.common.lib.data.DataManager
import net.minecraft.command.{CommandBase, ICommandSender}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.ChatComponentText

class CommandSetRecall
extends CommandBase{
  override def getCommandName: String ={
    return "set_recall";
  }

  override def getCommandUsage(p_71518_1_ : ICommandSender): String ={
    return "set_recall";
  }

  override def processCommand(sender: ICommandSender, args: Array[String]): Unit ={
    if(sender.isInstanceOf[EntityPlayer]){
      val player = sender.asInstanceOf[EntityPlayer];
      val x = player.posX;
      val y = player.posY;
      val z = player.posZ;

      DataManager.get(player).setRecallPoint(Vector3.of(x, y, z));
      sender.addChatMessage(new ChatComponentText("Recall Point Set"));
    }
  }
}