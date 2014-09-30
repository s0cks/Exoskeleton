package io.github.asyncronous.exoskeleton.block

import io.github.asyncronous.exoskeleton.{ExoskeletonTag, Exoskeleton}
import io.github.asyncronous.exoskeleton.item.ItemExoArmor
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.world.World

object BlockTest
extends Block(Material.iron) {
  this.setCreativeTab(Exoskeleton.tab);

  override def onBlockActivated(world: World, x: Int, y: Int, z: Int, player: EntityPlayer, p_149727_6_ : Int, p_149727_7_ : Float, p_149727_8_ : Float, p_149727_9_ : Float): Boolean = {
    val stack: ItemStack = player.getCurrentArmor(0);

    if(stack != null &&
      stack.getItem().isInstanceOf[ItemExoArmor]){

      val comp: NBTTagCompound = ExoskeletonTag.getTag(stack);
      comp.setString("coreName", "recon");
    }

    return true;
  }
}