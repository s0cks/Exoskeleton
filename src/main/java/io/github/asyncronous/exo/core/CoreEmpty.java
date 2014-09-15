package io.github.asyncronous.exo.core;

import net.minecraft.nbt.NBTTagCompound;

import io.github.asyncronous.exo.item.ItemExoskeletonArmor;

public final class CoreEmpty
extends AbstractCore{
    public CoreEmpty(){
        super("empty");
    }

    @Override
    public void write(NBTTagCompound comp, ItemExoskeletonArmor armor){

    }
}