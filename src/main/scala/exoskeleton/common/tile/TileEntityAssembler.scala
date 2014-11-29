package exoskeleton.common.tile

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity

class TileEntityAssembler
extends TileEntity
with IInventory {
  var inventory: Array[ItemStack] = new Array[ItemStack](10);
  var rotation: Float = 0.0F;

  override def getSizeInventory: Int = {
    return 10;
  }

  override def decrStackSize(i: Int, j: Int): ItemStack = {
    if (this.inventory(i) != null) {
      if (this.inventory(i).stackSize <= j) {
        val stack: ItemStack = this.inventory(i);
        this.inventory(i) = null;
        return stack;
      }

      val stack: ItemStack = this.inventory(i).splitStack(j);
      if (this.inventory(i).stackSize == 0) {
        this.inventory(i) = null;
      }
      return stack;
    } else {
      return null;
    }
  }

  override def closeInventory(): Unit = {

  }

  override def getInventoryStackLimit: Int = {
    return 64;
  }

  override def isItemValidForSlot(p_94041_1_ : Int, p_94041_2_ : ItemStack): Boolean = {
    return true;
  }

  override def getStackInSlotOnClosing(i: Int): ItemStack = {
    if (this.inventory(i) != null) {
      val stack: ItemStack = this.inventory(i);
      this.inventory(i) = null;
      return stack;
    } else {
      return null;
    }
  }

  override def openInventory(): Unit = {

  }

  override def setInventorySlotContents(i: Int, stack: ItemStack): Unit = {
    this.inventory(i) = stack;
    if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
      stack.stackSize = this.getInventoryStackLimit();
    }
    this.markDirty();
  }

  override def isUseableByPlayer(player: EntityPlayer): Boolean = {
    if (this.worldObj == null) {
      return true;
    }

    if (this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this) {
      return false;
    }

    return player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64D;
  }

  override def getStackInSlot(p_70301_1_ : Int): ItemStack = {
    return this.inventory(p_70301_1_);
  }

  override def hasCustomInventoryName: Boolean = {
    return false;
  }

  override def getInventoryName: String = {
    return "toolbox";
  }
}