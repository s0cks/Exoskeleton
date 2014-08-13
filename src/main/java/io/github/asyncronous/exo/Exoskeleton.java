package io.github.asyncronous.exo;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import io.github.asyncronous.exo.core.CoreAssassin;
import io.github.asyncronous.exo.core.CoreBerzerker;
import io.github.asyncronous.exo.core.CoreBulldozer;
import io.github.asyncronous.exo.core.CoreEmpty;
import io.github.asyncronous.exo.core.CoreFrost;
import io.github.asyncronous.exo.core.CoreGhost;
import io.github.asyncronous.exo.core.CoreInfernal;
import io.github.asyncronous.exo.core.CoreMystic;
import io.github.asyncronous.exo.core.CoreRecon;
import io.github.asyncronous.exo.core.CoreReflex;
import io.github.asyncronous.exo.core.CoreSkybound;
import io.github.asyncronous.exo.item.ItemCore;
import io.github.asyncronous.exo.item.ItemExoskeletonBoots;
import io.github.asyncronous.exo.item.ItemExoskeletonChestplate;
import io.github.asyncronous.exo.item.ItemExoskeletonHelmet;
import io.github.asyncronous.exo.item.ItemExoskeletonLeggings;

@Mod(modid = "EXO", version = "0.0.0", name = "Exoskeleton")
public final class Exoskeleton{
    @Mod.Instance("EXO")
    public static Exoskeleton instance;

    public static final CreativeTabs tab = new CreativeTabs("exoskeleton"){
        @Override
        public Item getTabIconItem(){
            return itemCoreEmpty;
        }
    };

    // Cores
    public static final Item itemCoreAssassin = new ItemCore(new CoreAssassin());
    public static final Item itemCoreBerzerker = new ItemCore(new CoreBerzerker());
    public static final Item itemCoreBulldozer = new ItemCore(new CoreBulldozer());
    public static final Item itemCoreFrost = new ItemCore(new CoreFrost());
    public static final Item itemCoreGhost = new ItemCore(new CoreGhost());
    public static final Item itemCoreInfernal = new ItemCore(new CoreInfernal());
    public static final Item itemCoreMystic = new ItemCore(new CoreMystic());
    public static final Item itemCoreRecon = new ItemCore(new CoreRecon());
    public static final Item itemCoreReflex = new ItemCore(new CoreReflex());
    public static final Item itemCoreSkybound = new ItemCore(new CoreSkybound());
    public static final Item itemCoreEmpty = new ItemCore(new CoreEmpty());

    // Armour pieces
    public static final Item itemExoskeletonHelmet = new ItemExoskeletonHelmet();
    public static final Item itemExoskeletonChestplate = new ItemExoskeletonChestplate();
    public static final Item itemExoskeletonLeggings = new ItemExoskeletonLeggings();
    public static final Item itemExoskeletonBoots = new ItemExoskeletonBoots();

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent e){

    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent e){
        GameRegistry.registerItem(itemCoreAssassin, "itemCoreAssassin");
        GameRegistry.registerItem(itemCoreBerzerker, "itemCoreBerzerker");
        GameRegistry.registerItem(itemCoreBulldozer, "itemCoreBulldozer");
        GameRegistry.registerItem(itemCoreFrost, "itemCoreFrost");
        GameRegistry.registerItem(itemCoreGhost, "itemCoreGhost");
        GameRegistry.registerItem(itemCoreInfernal, "itemCoreInfernal");
        GameRegistry.registerItem(itemCoreMystic, "itemCoreMystic");
        GameRegistry.registerItem(itemCoreRecon, "itemCoreRecon");
        GameRegistry.registerItem(itemCoreReflex, "itemCoreReflex");
        GameRegistry.registerItem(itemCoreSkybound, "itemCoreSkybound");
        GameRegistry.registerItem(itemCoreEmpty, "itemCoreEmpty");

        GameRegistry.registerItem(itemExoskeletonHelmet, "itemExoskeletonHelmet");
        GameRegistry.registerItem(itemExoskeletonChestplate, "itemExoskeletonChestplate");
        GameRegistry.registerItem(itemExoskeletonLeggings, "itemExoskeletonLeggings");
        GameRegistry.registerItem(itemExoskeletonBoots, "itemExoskeletonBoots");
    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent e){

    }
}