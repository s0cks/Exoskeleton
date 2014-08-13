package io.github.asyncronous.exo.item;

import net.minecraft.item.ItemArmor;

import io.github.asyncronous.exo.Exoskeleton;

public class ItemExoskeletonArmor
extends ItemArmor{
    public ItemExoskeletonArmor(int rIndex, int aIndex){
        super(ArmorMaterial.IRON, rIndex, aIndex);
        this.setCreativeTab(Exoskeleton.tab);
    }
}