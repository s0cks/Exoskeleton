package exoskeleton.common.item

import exoskeleton.api.ExoskeletonTag
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.item.ItemStack
import net.minecraft.util.IIcon

class ItemExoBoots
extends ItemExoArmor(3){
  private var core: IIcon = null;
  private var frame: IIcon = null;

  this.setUnlocalizedName("exo.boots");

  override def registerIcons(register: IIconRegister): Unit ={
    this.frame = register.registerIcon("exo:exoBoots_frame");
    this.core = register.registerIcon("exo:exoBoots");
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