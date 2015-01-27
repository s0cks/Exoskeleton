package exoskeleton.common.lib.tree

import exoskeleton.api.{Skill, Tree}
import net.minecraft.util.ResourceLocation

object TreeReflex
extends Tree("reflex", new ResourceLocation("exo", "textures/ulink_reflex.png"), 0xFF0000){
  val RECALL = new Skill(0, 0, "recall");
  val BLINK = new Skill(0, 0, "blink");
  val BACKTRACK = new Skill(0, 0, "backtrack");
  val NO_ENDERMAN = new Skill(0, 0, "noEnderman");

  this.addSkill(this.RECALL);
  this.addSkill(this.BLINK);
  this.addSkill(this.BACKTRACK);
  this.addSkill(this.NO_ENDERMAN);
}