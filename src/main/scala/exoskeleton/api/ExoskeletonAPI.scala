package exoskeleton.api

import com.google.common.eventbus.EventBus
import java.util

import net.minecraft.block.Block
import net.minecraft.entity.EntityLiving
;

object ExoskeletonAPI{
  private val heatMap = new util.HashMap[Block, HeatValue]();
  private val oreXRayMap = new util.LinkedList[Block]();
  private val thermalMap = new util.LinkedList[Class[_ <: EntityLiving]]();

  val event_bus = new EventBus()

  def getHeatValue(b: Block): HeatValue={
    if(this.heatMap.containsKey(b)){
      return this.heatMap.get(b);
    } else{
      return null;
    }
  }

  def addHeatValue(b: Block, v: HeatValue): Unit ={
    this.heatMap.put(b, v);
  }

  def isXRayable(b: Block): Boolean={
    return this.oreXRayMap.contains(b);
  }

  def addOreXRay(b: Block): Unit ={
    this.oreXRayMap.add(b);
  }

  def applyThermalMappingToEntity(c: Class[_ <: EntityLiving]): Unit ={
    this.thermalMap.add(c);
  }

  def hasThermalMapping(c: Class[_]): Boolean={
    return this.thermalMap.contains(c);
  }
}