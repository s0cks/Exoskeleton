package exoskeleton.common

import cpw.mods.fml.common.registry.GameRegistry
import exoskeleton.common.core._
import exoskeleton.common.item._

object ExoItems{
  val itemCoreRecon: ItemCore = new ItemCore(CoreRecon);
  val itemCoreSkybound: ItemCore = new ItemCore(CoreSkybound);
  val itemCoreGhost = new ItemCore(CoreGhost);
  val itemCoreInferno = new ItemCore(CoreInferno);
  val itemCoreReflex = new ItemCore(CoreReflex);

  val itemExoArmorHelm: ItemExoHelmet = new ItemExoHelmet();
  val itemExoArmorChest: ItemExoChestplate = new ItemExoChestplate();
  val itemExoArmorLegs: ItemExoLeggings = new ItemExoLeggings();
  val itemExoArmorBoots: ItemExoBoots = new ItemExoBoots();

  def init(): Unit ={
    GameRegistry.registerItem(this.itemCoreRecon, "itemCoreRecon");
    GameRegistry.registerItem(this.itemCoreSkybound, "itemCoreSkybound");
    GameRegistry.registerItem(this.itemCoreGhost, "itemCoreGhost");
    GameRegistry.registerItem(this.itemCoreInferno, "itemCoreInferno");
    GameRegistry.registerItem(this.itemCoreReflex, "itemCoreReflex");

    GameRegistry.registerItem(this.itemExoArmorBoots, "itemExoArmorBoots");
    GameRegistry.registerItem(this.itemExoArmorChest, "itemExoArmorChest");
    GameRegistry.registerItem(this.itemExoArmorHelm, "itemExoArmorHelm");
    GameRegistry.registerItem(this.itemExoArmorLegs, "itemExoArmorLegs");
  }
}
