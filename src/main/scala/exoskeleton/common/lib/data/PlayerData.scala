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
  private var thermalOn: Boolean = false;
  private var nightVision: Boolean = false;
  private var xrayVision: Boolean = false;
  private var infiltrator: Boolean = false;
  private var camo: Boolean = false;

  def setRecallPoint(vec: Vector3): Unit ={
    this.recallPoint = vec;
  }

  def getRecallPoint(): Vector3={
    return this.recallPoint;
  }

  def setBacktrackPosition(player: EntityPlayer): Unit={
    this.lastPlace = Vector3.of(player.posX, player.posY, player.posZ);
  }

  def setBacktrackPosition(vec: Vector3): Unit ={
    this.lastPlace = vec;
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

  def setThermal(b: Boolean): Unit ={
    this.thermalOn = b;
  }

  def thermal(): Boolean={
    return this.thermalOn;
  }

  def setNightVision(b: Boolean): Unit ={
    this.nightVision = b;
  }

  def nightVisionEnabled(): Boolean ={
    return this.nightVision;
  }

  def setXRay(b: Boolean): Unit ={
    this.xrayVision = b;
  }

  def xray(): Boolean={
    return this.xrayVision;
  }

  def setInfilrator(b: Boolean): Unit ={
    this.infiltrator = b;
  }

  def infiltratorEnabled(): Boolean={
    return this.infiltrator;
  }

  def isCamoActive(): Boolean={
    return this.camo;
  }

  def setCamo(b: Boolean): Unit ={
    this.camo = b;
  }

  override def readFromNBT(comp: NBTTagCompound): Unit ={
    this.recallPoint = Vector3.of(comp.getCompoundTag("recallPoint"));
    this.lastPlace = Vector3.of(comp.getCompoundTag("backtrackPos"));
    this.autoSmelt = comp.getBoolean("autosmelt");
    this.allowFlight = comp.getBoolean("allowFlight");
    this.thermalOn = comp.getBoolean("thermalOn");
    this.nightVision = comp.getBoolean("nightVision");
    this.xrayVision = comp.getBoolean("xray");
    this.infiltrator = comp.getBoolean("infiltrator");
    this.camo = comp.getBoolean("camo");
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
    comp.setBoolean("thermalOn", this.thermalOn);
    comp.setBoolean("nightVision", this.nightVision);
    comp.setBoolean("xray", this.xrayVision);
    comp.setBoolean("infiltrator", this.infiltrator);
    comp.setBoolean("camo", this.camo);
  }
}