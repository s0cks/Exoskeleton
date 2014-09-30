package io.github.asyncronous.exoskeleton.gui.container

import io.github.asyncronous.exoskeleton.tile.TileEntityToolbox
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.{Slot, Container}

class ContainerToolbox(val inv: TileEntityToolbox, val player: EntityPlayer)
extends Container{
  private val rows: Int = 2;

  for(j: Int <- 0 until this.rows){
    for(k: Int <- 0 until 5){
      this.addSlotToContainer(new Slot(this.inv, k + j * 5, 44 + k * 18, 34 + j * 18));
    }
  }

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