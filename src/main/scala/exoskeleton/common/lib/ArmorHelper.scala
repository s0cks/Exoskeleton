package exoskeleton.common.lib

import exoskeleton.common.item.{ItemExoLeggings, ItemExoBoots, ItemExoChestplate, ItemExoHelmet}
import net.minecraft.entity.player.EntityPlayer

object ArmorHelper{
  def hasExoHelm(player: EntityPlayer): Boolean ={
    return player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().isInstanceOf[ItemExoHelmet];
  }

  def hasExoChest(player: EntityPlayer): Boolean ={
    return player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().isInstanceOf[ItemExoChestplate];
  }

  def hasExoLegs(player: EntityPlayer): Boolean ={
    return player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().isInstanceOf[ItemExoLeggings];
  }

  def hasExoBoots(player: EntityPlayer): Boolean ={
    return player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().isInstanceOf[ItemExoBoots];
  }
}