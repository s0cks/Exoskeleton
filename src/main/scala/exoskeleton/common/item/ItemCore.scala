package exoskeleton.common.item

import exoskeleton.api.Core
import exoskeleton.common.Exoskeleton
import net.minecraft.item.Item

class ItemCore(val core: Core)
extends Item{
  this.setCreativeTab(Exoskeleton.tab);
  this.setMaxStackSize(1);
  this.setUnlocalizedName("core." + core.getID());
}