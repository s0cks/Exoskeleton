package exoskeleton.common.command

import exoskeleton.common.lib.skills.PlayerSkills
import exoskeleton.common.network.PacketHandler
import exoskeleton.common.network.sync.PacketSyncSkills
import net.minecraft.command.{CommandBase, ICommandSender}
import net.minecraft.entity.player.{EntityPlayer, EntityPlayerMP}

class CommandRemoveSkill
  extends CommandBase{
  override def getCommandName: String ={
    return "remove_skill";
  }

  override def getCommandUsage(p_71518_1_ : ICommandSender): String ={
    return "remove_skill [tree] [skill tag]";
  }

  override def processCommand(sender: ICommandSender, args: Array[String]): Unit ={
    val tree: String = args(0);
    val skill: String = args(1);

    if(sender.isInstanceOf[EntityPlayer]){
      PlayerSkills.get(sender.asInstanceOf[EntityPlayer]).removeSkill(tree, skill);
      PacketHandler.instance.sendTo(new PacketSyncSkills(sender.asInstanceOf[EntityPlayer]), sender.asInstanceOf[EntityPlayerMP]);
    }
  }
}