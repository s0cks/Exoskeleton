package exoskeleton.common.block

import exoskeleton.common.Exoskeleton
import exoskeleton.common.lib.RotationHelper
import exoskeleton.common.tile.TileEntityAssembler
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

object BlockAssembler
extends BlockContainer(Material.iron){
  private var renderID = 0;

  this.setBlockName("assembler");
  this.setCreativeTab(Exoskeleton.tab);

  def setRenderID(id: Int): Unit ={
    this.renderID = id;
  }

  override def onBlockPlacedBy(world: World, x: Int, y: Int, z: Int, living: EntityLivingBase, stack: ItemStack): Unit ={
    val tile: TileEntityAssembler = world.getTileEntity(x, y, z).asInstanceOf[TileEntityAssembler];
    tile.rotation = RotationHelper.get3DRotation(living);
  }

  override def createNewTileEntity(p_149915_1_ : World, p_149915_2_ : Int): TileEntity={
    return new TileEntityAssembler();
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