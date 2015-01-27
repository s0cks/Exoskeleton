package exoskeleton.common.item

import exoskeleton.api.Core
import exoskeleton.common.Exoskeleton
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.item.{ItemStack, Item}
import net.minecraft.util.IIcon

class ItemCore(val core: Core)
extends Item{
  private var icon: IIcon = null;

  this.setCreativeTab(Exoskeleton.tab);
  this.setMaxStackSize(1);
  this.setUnlocalizedName("core." + core.getID());

  override def registerIcons(reg: IIconRegister): Unit ={
    this.icon = reg.registerIcon("exo:cores/base_core");
  }

  override def getIcon(stack: ItemStack, pass: Int): IIcon={
    return this.icon;
  }
}