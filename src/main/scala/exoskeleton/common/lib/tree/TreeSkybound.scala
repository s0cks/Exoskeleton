package exoskeleton.common.lib.tree

import exoskeleton.api.skill.{Skill, Tree}
import net.minecraft.util.ResourceLocation

object TreeSkybound
extends Tree("skybound", new ResourceLocation("exo", "textures/ulink_skybound.png"), 0xFF0000){
  val FLIGHT = new Skill(0, 0, "flight");

  this.addSkill(this.FLIGHT);
}