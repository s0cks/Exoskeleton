package exoskeleton.client.camo

import exoskeleton.api.Camouflage
import exoskeleton.api.utils.RenderUtils
import net.minecraft.block.Block
import net.minecraft.entity.player.EntityPlayer

class BasicCamo(val block: Block)
extends Camouflage{
  override def draw(player: EntityPlayer, x: Int, y: Int, z: Int): Unit ={
    val brightness =  player.worldObj.getBlock(x, y, z).getMixedBrightnessForBlock(player.worldObj, x, y, z);
    RenderUtils.drawCubeAt(0.0, x, y, z, this.block, 0, brightness);
    RenderUtils.drawCubeAt(0.0, x, y - 1, z, this.block, 0, brightness);
  }
}