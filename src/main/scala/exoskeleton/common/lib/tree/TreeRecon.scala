package exoskeleton.common.lib.tree

import exoskeleton.api.{Skill, Tree}
import net.minecraft.util.ResourceLocation

object TreeRecon
extends Tree("recon", new ResourceLocation("exo", "textures/ulink_recon.png"), 0xFF0000){
  val JUMP_BOOST = new Skill(0, 0, "jumpBoost");
  val NO_DROWN = new Skill(0, 0, "noDrown");
  val BREAST_STROKE = new Skill(0, 0, "breastStroke");
  val SPEEDY_LEGS = new Skill(0, 0, "speedyLegs");
  val STEP_UP = new Skill(0, 0, "stepUp");
  val NIGHT_VISION = new Skill(0, 0, "nightVision");

  this.addSkill(this.JUMP_BOOST);
  this.addSkill(this.NO_DROWN);
  this.addSkill(this.BREAST_STROKE);
  this.addSkill(this.SPEEDY_LEGS);
  this.addSkill(this.STEP_UP);
  this.addSkill(this.NIGHT_VISION);
}