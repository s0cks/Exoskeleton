package exoskeleton.common.lib

import exoskeleton.api.{ExoskeletonCores, SkillsHelper}
import exoskeleton.common.core._
import exoskeleton.common.item.{ItemExoBoots, ItemExoChestplate, ItemExoHelmet, ItemExoLeggings}
import net.minecraft.block.material.Material
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack

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

  def getHelmet(player: EntityPlayer): ItemStack={
    return player.getCurrentArmor(3);
  }

  def getChest(player: EntityPlayer): ItemStack={
    return player.getCurrentArmor(2);
  }

  def getLeggings(player: EntityPlayer): ItemStack={
    return player.getCurrentArmor(1);
  }

  def getBoots(player: EntityPlayer): ItemStack={
    return player.getCurrentArmor(0);
  }

  def fadable(player: EntityPlayer): Boolean={
    return hasExoChest(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(2)) == CoreGhost &&
           SkillsHelper.hasSkill(getChest(player), "ghost", "fade");
  }

  def camo(player: EntityPlayer): Boolean={
    return hasExoChest(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(2)) == CoreAssassin &&
           SkillsHelper.hasSkill(getChest(player), "assassin", "camo");
  }

  def nightVision(player: EntityPlayer): Boolean={
    return hasExoHelm(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(3)) == CoreRecon &&
           SkillsHelper.hasSkill(getHelmet(player), "recon", "nightVision");
  }

  def thermal(player: EntityPlayer): Boolean={
    return hasExoHelm(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(3)) == CoreGhost &&
           SkillsHelper.hasSkill(getHelmet(player), "ghost", "thermal");
  }

  def xray(player: EntityPlayer): Boolean={
    return hasExoHelm(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(3)) == CoreBulldozer &&
           SkillsHelper.hasSkill(getHelmet(player), "bulldozer", "xray");
  }

  def assassin(player: EntityPlayer): Boolean={
    return hasExoHelm(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(3)) == CoreAssassin &&
           SkillsHelper.hasSkill(getHelmet(player), "assassin", "eagleVision");
  }

  def recallable(player: EntityPlayer): Boolean={
    return hasExoBoots(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(0)) == CoreReflex &&
           SkillsHelper.hasSkill(getBoots(player), "reflex", "recall") &&
           !player.isInsideOfMaterial(Material.lava);
  }

  def blinkable(player: EntityPlayer): Boolean={
    return hasExoLegs(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(1)) == CoreReflex &&
           SkillsHelper.hasSkill(getLeggings(player), "reflex", "blink");
  }

  def backtrack(player: EntityPlayer): Boolean={
    return hasExoChest(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(2)) == CoreReflex &&
           SkillsHelper.hasSkill(getChest(player), "reflex", "backtrack");
  }

  def autosmelt(player: EntityPlayer): Boolean={
    return hasExoChest(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(2)) == CoreInferno &&
           SkillsHelper.hasSkill(getChest(player), "inferno", "autoSmelt");
  }

  def flight(player: EntityPlayer): Boolean={
    return hasExoChest(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(2)) == CoreSkybound &&
           SkillsHelper.hasSkill(getChest(player), "skybound", "flight");
  }
}