package io.github.asyncronous.exoskeleton.item

import io.github.asyncronous.exoskeleton.Exoskeleton
import net.minecraft.item.ItemArmor
import net.minecraft.item.ItemArmor.ArmorMaterial

class ItemExoArmor(index: Int)
extends ItemArmor(ArmorMaterial.IRON, 0, index){
  this.setCreativeTab(Exoskeleton.tab);
}