package exoskeleton.common.item

import exoskeleton.api.ICore
import exoskeleton.common.Exoskeleton
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.IIcon

class ItemCore(val core: ICore)
extends Item{
  private var icon: IIcon = null;
  private var overlay: IIcon = null;

  this.setCreativeTab(Exoskeleton.tab);
  this.setMaxStackSize(1);
  this.setUnlocalizedName("core." + core.getID());

  override def registerIcons(reg: IIconRegister): Unit ={
    this.icon = reg.registerIcon("exo:cores/base_core");
    this.overlay = reg.registerIcon("exo:overlay/" + this.core.getID() + "_core");
  }

  override def getIcon(stack: ItemStack, pass: Int): IIcon={
    pass match{
      case 0=>{
        return this.icon;
      }
      case 1=>{
        return this.overlay;
      }
    }
  }

  override def requiresMultipleRenderPasses(): Boolean={
    return true;
  }

  override def getRenderPasses(meta: Int): Int={
    return 2;
  }
}