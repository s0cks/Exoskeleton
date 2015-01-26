package exoskeleton.common.command

import exoskeleton.common.lib.skills.PlayerSkills
import net.minecraft.command.{ICommandSender, CommandBase}
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.ChatComponentText

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
    } else{
      sender.addChatMessage(new ChatComponentText("Error"));
    }
  }
}