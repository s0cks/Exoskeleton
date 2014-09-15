package io.github.asyncronous.exo.core;

import net.minecraft.nbt.NBTTagCompound;

import io.github.asyncronous.exo.item.ItemExoskeletonArmor;

public final class CoreReflex
extends AbstractCore{
    public CoreReflex(){
        super("reflex");
    }

    @Override
    public void write(NBTTagCompound comp, ItemExoskeletonArmor armor){
        if(armor.boots()){
            comp.setString("coreName", "reflex");
            comp.setDouble("jumpBoost", 0.2D);
            comp.setBoolean("negateFallDamage", true);
        } else if(armor.legs()){
            comp.setString("coreName", "reflex");
            comp.setDouble("runBoost", 0.2D);
        }
    }
}