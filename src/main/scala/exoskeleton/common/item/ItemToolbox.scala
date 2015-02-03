package exoskeleton.common.item

import exoskeleton.api.{ExoskeletonTag, Toolbox}
import exoskeleton.common.Exoskeleton
import net.minecraft.block.Block
import net.minecraft.item.{ItemBlock, ItemStack}
import net.minecraft.nbt.{NBTTagCompound, NBTTagList}

class ItemToolbox(b: Block)
extends ItemBlock(b)
with Toolbox{
  this.setCreativeTab(Exoskeleton.tab);
  this.setUnlocalizedName("toolbox");

  override def setInventory(stack: ItemStack, inv: Array[ItemStack]): Unit={
    val comp: NBTTagCompound = ExoskeletonTag.getTag(stack);
    val tags: NBTTagList = new NBTTagList();
    for(i: Int <- 0 until inv.length){
      if(inv(i) != null){
        val c: NBTTagCompound = new NBTTagCompound();
        c.setByte("Slot", i.asInstanceOf[Byte]);
        inv(i).writeToNBT(c);
        tags.appendTag(c);
      }
    }
    comp.setTag("Items", tags);
  }

  override def getInventory(stack: ItemStack): Array[ItemStack]={
    val comp: NBTTagCompound = ExoskeletonTag.getTag(stack);
    val inv: Array[ItemStack] = new Array[ItemStack](10);
    val tags: NBTTagList = comp.getTagList("Items", 10);
    for(i: Int <- 0 until tags.tagCount()){
      val c: NBTTagCompound = tags.getCompoundTagAt(i);
      inv(c.getByte("Slot")) = ItemStack.loadItemStackFromNBT(c);
    }
    return inv;
  }
}