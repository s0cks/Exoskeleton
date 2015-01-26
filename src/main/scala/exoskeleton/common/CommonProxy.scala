package exoskeleton.common

import net.minecraft.world.World

trait CommonProxy{
  def registerRenders(){}
  def getClientWorld(): World = null;
}
