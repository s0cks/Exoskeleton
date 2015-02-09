package exoskeleton.common.block

import exoskeleton.common.Exoskeleton
import exoskeleton.common.tile.TileEntityModifier
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

object BlockModifier
extends BlockContainer(Material.iron){
  private var renderID = 0;

  this.setBlockName("modifier");
  this.setCreativeTab(Exoskeleton.tab);

  override def onBlockActivated(world: World, x: Int, y: Int, z: Int, player: EntityPlayer, p_149727_6_ : Int, p_149727_7_ : Float, p_149727_8_ : Float, p_149727_9_ : Float): Boolean = {
    player.openGui(Exoskeleton.instance, 2, world, x, y, z);
    return true;
  }

  override def createNewTileEntity(p_149915_1_ : World, p_149915_2_ : Int): TileEntity ={
    return new TileEntityModifier();
  }

  def setRenderID(id: Int): Unit ={
    this.renderID = id;
  }

  override def isOpaqueCube(): Boolean={
    return false;
  }

  override def getRenderType(): Int={
    return this.renderID;
  }

  override def renderAsNormalBlock(): Boolean={
    return false;
  }
}
