package exoskeleton.common.gui

import exoskeleton.common.tile.TileEntityModifier
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.{Container, Slot}
import net.minecraft.item.ItemStack

class ContainerModifier(val inv: TileEntityModifier, val player: EntityPlayer)
extends Container{
  this.addSlotToContainer(new Slot(inv, 0, 100, 100));

  for(j: Int <- 0 until 3){
    for(k: Int <- 0 until 9){
      this.addSlotToContainer(new Slot(player.inventory, k + j * 9 + 9, 8 + k * 18, 94 + j * 18));
    }
  }

  for(j: Int <- 0 until 9){
    this.addSlotToContainer(new Slot(player.inventory, j, 8 + j * 18, 152));
  }

  override def canInteractWith(player: EntityPlayer): Boolean ={
    return this.inv.isUseableByPlayer(player);
  }

  def getStack(slot: Int): ItemStack={
    return this.inv.getStackInSlot(slot);
  }
}