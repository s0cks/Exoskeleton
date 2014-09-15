package io.github.asyncronous.exo.item;

import net.minecraft.item.ItemArmor;

import io.github.asyncronous.exo.Exoskeleton;

public class ItemExoskeletonArmor
extends ItemArmor{
    public static final byte HELMET = 0x0;
    public static final byte CHEST = 0x1;
    public static final byte LEGS = 0x2;
    public static final byte BOOTS = 0x3;

    public ItemExoskeletonArmor(int rIndex, int aIndex){
        super(ArmorMaterial.IRON, rIndex, aIndex);
        this.setCreativeTab(Exoskeleton.tab);
    }

    public boolean helm(){
        return this.armorType == 0;
    }

    public boolean chest(){
        return this.armorType == 1;
    }

    public boolean legs(){
        return this.armorType == 2;
    }

    public boolean boots(){
        return this.armorType == 3;
    }
}