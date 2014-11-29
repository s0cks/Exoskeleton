package exoskeleton.common

import net.minecraft.item.ItemStack

trait Toolbox{
  def setInventory(stack: ItemStack, inv: Array[ItemStack]);
  def getInventory(stack: ItemStack): Array[ItemStack];
}
