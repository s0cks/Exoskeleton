package exoskeleton.common.lib.data

import exoskeleton.api.ISaveable
import exoskeleton.api.util.Vector3
import net.minecraft.nbt.NBTTagCompound

class PlayerData
extends ISaveable{
  private var recallPoint: Vector3 = null;

  def setRecallPoint(vec: Vector3): Unit ={
    this.recallPoint = vec;
  }

  def getRecallPoint(): Vector3={
    return this.recallPoint;
  }

  override def readFromNBT(comp: NBTTagCompound): Unit ={
    this.recallPoint = Vector3.of(comp.getCompoundTag("recallPoint"));
  }

  override def writeToNBT(comp: NBTTagCompound): Unit ={
    val recallPointComp = new NBTTagCompound;
    this.recallPoint.writeToNBT(recallPointComp);
    comp.setTag("recallPoint", recallPointComp);
  }
}