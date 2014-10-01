package io.github.asyncronous.exoskeleton.tile

import net.minecraft.tileentity.TileEntity

class TileEntityAssembler
extends TileEntity{
  private var rot: Float = 0.0F;

  def setRotation(f: Float): Unit ={
    this.rot = f;
  }

  def getRotation(): Float={
    return this.rot;
  }
}