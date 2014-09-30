package io.github.asyncronous.exoskeleton.api

import net.minecraft.item.ItemStack

trait Toolbox{
  def setInventory(stack: ItemStack, inv: Array[ItemStack]);
  def getInventory(stack: ItemStack): Array[ItemStack];
}
