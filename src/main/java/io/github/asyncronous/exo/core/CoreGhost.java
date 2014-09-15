package io.github.asyncronous.exo.core;

import net.minecraft.nbt.NBTTagCompound;

import io.github.asyncronous.exo.item.ItemExoskeletonArmor;

public final class CoreGhost
extends AbstractCore{
    public CoreGhost(){
        super("ghost");
    }

    @Override
    public void write(NBTTagCompound comp, ItemExoskeletonArmor armor){
        if(armor.chest()){
            comp.setBoolean("invisNight", true);
            comp.setString("coreName", "Ghost");
        }
    }
}