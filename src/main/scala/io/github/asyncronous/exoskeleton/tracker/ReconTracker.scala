package io.github.asyncronous.exoskeleton.tracker

import net.minecraft.entity.Entity
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.world.World
import net.minecraftforge.common.IExtendedEntityProperties

class ReconTracker
extends IExtendedEntityProperties{
  private var jumpBoost: Double = 0.0D;

  override def saveNBTData(compound: NBTTagCompound): Unit ={
    compound.setDouble("jumpBoost", this.jumpBoost);
  }

  override def init(entity: Entity, world: World): Unit ={

  }

  override def loadNBTData(compound: NBTTagCompound): Unit ={
    this.jumpBoost = compound.getDouble("jumpBoost");
  }

  def getJumpBoost(): Double={
    return this.jumpBoost;
  }

  def setJumpBoost(d: Double): Unit ={
    this.jumpBoost = d;
  }
}