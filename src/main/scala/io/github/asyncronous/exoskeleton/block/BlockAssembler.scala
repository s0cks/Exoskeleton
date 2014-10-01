package io.github.asyncronous.exoskeleton.block

import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

object BlockAssembler
extends BlockContainer(Material.iron){
  this.setBlockName("assembler");

  override def createNewTileEntity(p_149915_1_ : World, p_149915_2_ : Int): TileEntity={
    return null;
  }

  override def isOpaqueCube(): Boolean={
    return false;
  }

  override def renderAsNormalBlock(): Boolean={
    return false;
  }
}