package exoskeleton.client.camo

import exoskeleton.api.Camouflage
import exoskeleton.api.utils.RenderUtils
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks

class CamoNether
extends Camouflage{
  override def draw(player: EntityPlayer, x: Int, y: Int, z: Int): Unit ={
    RenderUtils.drawCubeAt(0.0, x, y, z, Blocks.netherrack, 0);
    RenderUtils.drawCubeAt(0.0, x, y - 1, z, Blocks.netherrack, 0);
  }
}