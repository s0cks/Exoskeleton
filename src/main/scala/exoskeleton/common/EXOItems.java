package exoskeleton.common;

import cpw.mods.fml.common.registry.GameRegistry;
import exoskeleton.common.item.ItemExoBoots;
import exoskeleton.common.item.ItemExoChestplate;
import exoskeleton.common.item.ItemExoHelmet;
import exoskeleton.common.item.ItemExoLeggings;

public final class EXOItems{
    public static ItemExoHelmet itemEXOHelmet = new ItemExoHelmet();
    public static ItemExoChestplate itemEXOChestplate = new ItemExoChestplate();
    public static ItemExoLeggings itemEXOLeggings = new ItemExoLeggings();
    public static ItemExoBoots itemEXOBoots = new ItemExoBoots();

    public static void initialize(){
        GameRegistry.registerItem(itemEXOHelmet, "itemEXOHelmet");
        GameRegistry.registerItem(itemEXOChestplate, "itemEXOChestplate");
        GameRegistry.registerItem(itemEXOLeggings, "itemEXOLeggings");
        GameRegistry.registerItem(itemEXOBoots, "itemEXOBoots");
    }
}