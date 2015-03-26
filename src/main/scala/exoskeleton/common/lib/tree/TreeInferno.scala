package exoskeleton.common.lib.tree

import exoskeleton.api.skill.{Skill, Tree}
import net.minecraft.util.ResourceLocation

object TreeInferno
extends Tree("inferno", new ResourceLocation("exo", "textures/ulink_inferno.png"), 0xFF0000){
  val AUTO_SMELT = new Skill(0, 0, "autoSmelt");

  this.addSkill(this.AUTO_SMELT);
}