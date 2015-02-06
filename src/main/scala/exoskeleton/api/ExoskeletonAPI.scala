package exoskeleton.api

import java.util

import com.google.common.eventbus.EventBus
import net.minecraft.block.Block
import net.minecraft.entity.EntityLiving
import net.minecraft.item.Item
import net.minecraft.world.World
import net.minecraft.world.biome.BiomeGenBase
;

object ExoskeletonAPI{
  private val heatMap = new util.HashMap[Block, HeatValue]();
  private val oreXRayMap = new util.LinkedList[Block]();
  private val thermalBlacklist = new util.LinkedList[Class[_ <: EntityLiving]]();
  private val magnetBlacklist = new util.LinkedList[Class[_ <: Item]]();
  private val camouflageMap = new util.HashMap[BiomeGenBase, Camouflage]()

  val event_bus = new EventBus()

  def getHeatValue(b: Block): HeatValue={
    if(this.heatMap.containsKey(b)){
      return this.heatMap.get(b);
    } else{
      return null;
    }
  }

  def registerActiveCamouflage(biome: BiomeGenBase, camo: Camouflage): Unit ={
    this.camouflageMap.put(biome, camo);
  }

  def getCamouflage(world: World, x: Int, z: Int): Camouflage={
    val biome = world.getBiomeGenForCoords(x, z);
    if(this.camouflageMap.containsKey(biome)){
      return this.camouflageMap.get(biome);
    } else{
      return this.camouflageMap.get(BiomeGenBase.plains);
    }
  }

  def applyHeatMappingValueToBlock(b: Block, v: HeatValue): Unit ={
    this.heatMap.put(b, v);
  }

  def isXRayable(b: Block): Boolean={
    return this.oreXRayMap.contains(b);
  }

  def applyXRayMappingToBlock(b: Block): Unit ={
    this.oreXRayMap.add(b);
  }

  def applyThermalBlacklistToEntity(c: Class[_ <: EntityLiving]): Unit ={
    this.thermalBlacklist.add(c);
  }

  def hasThermalBlacklist(c: Class[_]): Boolean={
    return this.thermalBlacklist.contains(c);
  }

  def blacklistItemFromMagnet(c: Class[_ <: Item]): Unit ={
    this.magnetBlacklist.add(c);
  }

  def isItemBlacklistedFromMagnet(i: Item): Boolean={
    return this.magnetBlacklist.contains(i.getClass);
  }
}