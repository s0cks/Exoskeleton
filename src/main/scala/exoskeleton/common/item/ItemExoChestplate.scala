package exoskeleton.common.item

import exoskeleton.api.ExoskeletonTag
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.item.ItemStack
import net.minecraft.util.IIcon

class ItemExoChestplate
extends ItemExoArmor(1){
  private var frame: IIcon = null;
  private var core: IIcon = null;

  this.setUnlocalizedName("exo.chest");

  override def registerIcons(register: IIconRegister): Unit ={
    this.frame = register.registerIcon("exo:exoChestplate_frame");
    this.core = register.registerIcon("exo:exoChestplate");
  }

  override def getIcon(stack: ItemStack, pass: Int): IIcon={
    if(stack.hasTagCompound &&
       stack.getTagCompound.hasKey(ExoskeletonTag.IDENTIFIER)){

      return this.core;
    } else{
      return this.frame;
    }
  }
}