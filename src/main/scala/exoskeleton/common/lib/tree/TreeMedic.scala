package exoskeleton.common.lib.tree

import exoskeleton.api.{Tree, Skill}
import net.minecraft.util.ResourceLocation

object TreeMedic
extends Tree("medic", new ResourceLocation("exo", "textures/ulink_medic.png"), 0xFFFFFF){
  val LIFE_STEAL = new Skill(0, 0, "lifeSteal");
  val REGEN = new Skill(0, 0, "regen");
  val SPEEDY_LEGS = new Skill(0, 0, "speedyLegs");
  val STEP_UP = new Skill(0, 0, "stepUp");
}