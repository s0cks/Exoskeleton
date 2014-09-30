package io.github.asyncronous.exoskeleton.item

import io.github.asyncronous.exoskeleton.Exoskeleton
import io.github.asyncronous.exoskeleton.api.Core
import net.minecraft.item.Item

class ItemCore(val core: Core)
extends Item{
  this.setCreativeTab(Exoskeleton.tab);
  this.setMaxStackSize(1);
  this.setUnlocalizedName("core." + core.getID());
}