package exoskeleton.common.lib.tree

import exoskeleton.api.{Skill, Tree}
import net.minecraft.util.ResourceLocation

object TreeGhost
extends Tree("ghost", new ResourceLocation("exo", "textures/ulink_ghost.png"), 0xFF0000){
  val FADE = new Skill(0, 0, "ghost");

  this.addSkill(this.FADE);
}