package exoskeleton.common.core

import exoskeleton.api.utils.OverlaySet
import exoskeleton.api.{ICore, SkillsHelper}
import net.minecraft.item.ItemStack

abstract class AbstractCore(val id: String)
extends ICore{
  private val overlays = new OverlaySet(
    "textures/items/overlay/" + this.id + "_helmet.png",
    "textures/items/overlay/" + this.id + "_chest.png",
    "textures/items/overlay/" + this.id + "_leggings.png",
    "textures/items/overlay/" + this.id + "_boots.png",
    "textures/items/overlay/" + this.id + "_core.png"
  )

  override def getID(): String ={
    return this.id;
  }

  protected def hasSkill(stack: ItemStack, skill: String): Boolean={
    return SkillsHelper.hasSkill(stack, this.id, skill);
  }

  override def overlay(): OverlaySet={
    return this.overlays;
  }
}