package exoskeleton.common

import net.minecraft.world.World

trait CommonProxy{
  def registerRenders(){}
  def registerHandlers(){}
  def getClientWorld(): World = null;
}
