package exoskeleton.client.gui

import java.util

import exoskeleton.common.lib.skills.PlayerSkills
import net.minecraft.client.gui.{GuiButton, GuiScreen}
import net.minecraft.entity.player.EntityPlayer

class GuiDebug(player: EntityPlayer)
extends GuiScreen{
  override def initGui(): Unit ={
    val list: util.List[GuiButton] = this.buttonList.asInstanceOf[util.List[GuiButton]];

    list.add(new GuiButton(1, 10, 35, 125, 20, "Add Night Vision"));
    list.add(new GuiButton(2, 10, 65, 125, 20, "Add No Drown"));
    list.add(new GuiButton(3, 10, 95, 125, 20, "Add Jump Boost"));
    list.add(new GuiButton(4, 10, 125, 125, 20, "Add Debug"));

    list.add(new GuiButton(5, 137, 35, 125, 20, "Remove Night Vision"));
    list.add(new GuiButton(6, 137, 65, 125, 20, "Remove No Drown"));
    list.add(new GuiButton(7, 137, 95, 125, 20, "Remove Jump Boost"));
    list.add(new GuiButton(8, 137, 125, 125, 20, "Remove Debug"));
  }

  override def actionPerformed(button: GuiButton): Unit ={
    button.id match
    {
      case 1 =>{
        if(PlayerSkills.get(player).hasSkill("recon", "nightVision")){
        } else{
          PlayerSkills.get(player).addSkill("recon", "nightVision");
        }
      }
      case 2 =>{
        if(PlayerSkills.get(player).hasSkill("recon", "noDrown")){
        } else{
          PlayerSkills.get(player).addSkill("recon", "noDrown");
        }
      }
      case 3 =>{
        if(PlayerSkills.get(player).hasSkill("recon", "jumpBoost")){
        } else{
          PlayerSkills.get(player).addSkill("recon", "jumpBoost");
        }
      }
      case 4 =>{
        if(PlayerSkills.get(player).hasSkill("recon", "debug")){
        } else{
          PlayerSkills.get(player).addSkill("recon", "debug");
        }
      }
      case 5 =>{
        PlayerSkills.get(player).removeSkill("recon", "nightVision");
      }
      case 6 =>{
        PlayerSkills.get(player).removeSkill("recon", "noDrown");
      }
      case 7 =>{
        PlayerSkills.get(player).removeSkill("recon", "jumpBoost");
      }
      case 8 =>{
        PlayerSkills.get(player).removeSkill("recon", "debug");
      }
      case _ =>{

      }
    }
  }
}