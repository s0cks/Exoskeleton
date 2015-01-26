package exoskeleton.common.core

import exoskeleton.api.Core
import exoskeleton.common.lib.skills.PlayerSkills
import net.minecraft.entity.player.EntityPlayer

abstract class AbstractCore(val id: String)
extends Core{
  override def getID(): String ={
    return this.id;
  }

  protected def hasSkill(player: EntityPlayer, skill: String): Boolean={
    return PlayerSkills.get(player).hasSkill(this.getID(), skill);
  }
}