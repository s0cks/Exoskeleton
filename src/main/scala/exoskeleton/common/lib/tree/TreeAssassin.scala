package exoskeleton.common.lib.tree

import exoskeleton.api.skill.{Skill, Tree}
import net.minecraft.util.ResourceLocation

object TreeAssassin
extends Tree("assassin", new ResourceLocation("exo", "textures/ulink_assassin.png"), 0xFF0000){
  val EAGLE_VISION = new Skill(0, 0, "eagleVision");
}