package exoskeleton.common.core

import exoskeleton.api.Core
import exoskeleton.api.utils.ArmorOverlaySet
import exoskeleton.common.lib.skills.PlayerSkills
import net.minecraft.entity.player.EntityPlayer

abstract class AbstractCore(val id: String)
extends Core{
  private val overlays = new ArmorOverlaySet(
    "textures/items/overlay/" + this.id + "_helmet.png",
    "textures/items/overlay/" + this.id + "_chest.png",
    "textures/items/overlay/" + this.id + "_leggings.png",
    "textures/items/overlay/" + this.id + "_boots.png"
  )

  override def getID(): String ={
    return this.id;
  }

  protected def hasSkill(player: EntityPlayer, skill: String): Boolean={
    return PlayerSkills.get(player).hasSkill(this.getID(), skill);
  }

  override def overlay(): ArmorOverlaySet={
    return this.overlays;
  }
}