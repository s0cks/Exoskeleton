package io.github.asyncronous.exo.core;

import net.minecraft.nbt.NBTTagCompound;

import io.github.asyncronous.exo.item.ItemExoskeletonArmor;

public final class CoreRecon
extends AbstractCore{
    public CoreRecon(){
        super("recon");
    }

    @Override
    public void write(NBTTagCompound comp, ItemExoskeletonArmor armor){
        if(armor.helm()){
            comp.setString("coreName", "Recon");
            comp.setBoolean("nightvision", true);
            comp.setBoolean("noDrown", true);
        } else if(armor.legs()){
            comp.setString("coreName", "Recon");
            comp.setDouble("jumpBoost", 0.2D);
            comp.setBoolean("negateFallDamage", true);
        } else if(armor.boots()){
            comp.setDouble("speed", 0.035);
            comp.setString("coreName", "Recon");
            comp.setBoolean("stepup", true);
        }
    }
}