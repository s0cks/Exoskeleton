package exoskeleton.common.gui.slot

import exoskeleton.common.item.ItemUpgradeLink
import net.minecraft.inventory.{IInventory, Slot}
import net.minecraft.item.ItemStack

class SlotUpgradeLink(inventory: IInventory, index: Int, x: Int, y: Int)
extends Slot(inventory, index, x, y){
  override def isItemValid(stack: ItemStack): Boolean={
    return stack.getItem.isInstanceOf[ItemUpgradeLink];
  }
}