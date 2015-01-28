package exoskeleton.common.item

import cpw.mods.fml.relauncher.{SideOnly, Side}
import exoskeleton.api.ExoskeletonTag
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.item.ItemStack
import net.minecraft.util.IIcon

class ItemExoHelmet
extends ItemExoArmor(0){
  private var core: IIcon = null;
  private var frame: IIcon = null;

  this.setUnlocalizedName("exo.helm");

  @SideOnly(Side.CLIENT)
  override def registerIcons(register: IIconRegister): Unit ={
    this.frame = register.registerIcon("exo:exoHelmet_frame");
    this.core = register.registerIcon("exo:exoHelmet");
  }

  @SideOnly(Side.CLIENT)
  override def getIcon(stack: ItemStack, pass: Int): IIcon={
    if(stack.hasTagCompound &&
      stack.getTagCompound.hasKey(ExoskeletonTag.IDENTIFIER)){

      return this.core;
    } else{
      return this.frame;
    }
  }
}