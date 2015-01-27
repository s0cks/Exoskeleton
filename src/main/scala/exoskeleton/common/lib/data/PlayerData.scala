package exoskeleton.common.lib.data

import exoskeleton.api.ISaveable
import exoskeleton.api.utils.Vector3
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.nbt.NBTTagCompound

class PlayerData
extends ISaveable{
  private var recallPoint: Vector3 = null;
  private var lastPlace: Vector3 = null;
  private var autoSmelt: Boolean = false;
  private var allowFlight: Boolean = false;

  def setRecallPoint(vec: Vector3): Unit ={
    this.recallPoint = vec;
  }

  def getRecallPoint(): Vector3={
    return this.recallPoint;
  }

  def setBacktrackPosition(player: EntityPlayer) ={
    this.lastPlace = Vector3.of(player.posX, player.posY, player.posZ);
  }

  def getBacktrackPosition(): Vector3={
    return this.lastPlace;
  }

  def setAutoSmelt(b: Boolean): Unit ={
    this.autoSmelt = b;
  }

  def autoSmeltEnabled(): Boolean={
    return this.autoSmelt;
  }

  def setFlight(b: Boolean): Unit ={
    this.allowFlight = b;
  }

  def flightEnabled(): Boolean={
    return this.allowFlight;
  }

  override def readFromNBT(comp: NBTTagCompound): Unit ={
    this.recallPoint = Vector3.of(comp.getCompoundTag("recallPoint"));
    this.lastPlace = Vector3.of(comp.getCompoundTag("backtrackPos"));
    this.autoSmelt = comp.getBoolean("autosmelt");
    this.allowFlight = comp.getBoolean("allowFlight");
  }

  override def writeToNBT(comp: NBTTagCompound): Unit ={
    var c = new NBTTagCompound;
    this.recallPoint.writeToNBT(c);
    comp.setTag("recallPoint", c);

    c = new NBTTagCompound;
    this.lastPlace.writeToNBT(c);
    comp.setTag("backtrackPos", c);

    comp.setBoolean("autosmelt", this.autoSmelt);
    comp.setBoolean("allowFlight", this.allowFlight);
  }
}