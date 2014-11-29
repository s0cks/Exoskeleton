package exoskeleton.common.gui

import exoskeleton.common.tile.TileEntityAssembler
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.{Container, Slot}

class ContainerAssembler(val inv: TileEntityAssembler, val player: EntityPlayer)
extends Container{
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
}