package io.github.asyncronous.exoskeleton

import cpw.mods.fml.common.registry.GameRegistry
import io.github.asyncronous.exoskeleton.core.CoreRecon
import io.github.asyncronous.exoskeleton.item._

object ExoItems{
  val itemCoreRecon: ItemCore = new ItemCore(CoreRecon);

  val itemExoArmorHelm: ItemExoHelmet = new ItemExoHelmet();
  val itemExoArmorChest: ItemExoChestplate = new ItemExoChestplate();
  val itemExoArmorLegs: ItemExoLeggings = new ItemExoLeggings();
  val itemExoArmorBoots: ItemExoBoots = new ItemExoBoots();

  def init(): Unit ={
    GameRegistry.registerItem(this.itemCoreRecon, "itemCoreRecon");

    GameRegistry.registerItem(this.itemExoArmorBoots, "itemExoArmorBoots");
  }
}