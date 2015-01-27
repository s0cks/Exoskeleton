package exoskeleton.common.block

import exoskeleton.common.Exoskeleton
import exoskeleton.common.item.ItemExoArmor
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World

object BlockTest
extends Block(Material.iron) {
  this.setCreativeTab(Exoskeleton.tab);
  this.setBlockName("debug");

  override def onBlockActivated(world: World, x: Int, y: Int, z: Int, player: EntityPlayer, p_149727_6_ : Int, p_149727_7_ : Float, p_149727_8_ : Float, p_149727_9_ : Float): Boolean = {
    val stack: ItemStack = player.getCurrentEquippedItem();

    if(stack != null &&
       stack.getItem().isInstanceOf[ItemExoArmor]) {
      player.openGui(Exoskeleton, 3, world, x, y, z);
    }

    return true;
  }
}