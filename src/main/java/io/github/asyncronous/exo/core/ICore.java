package io.github.asyncronous.exo.core;

import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;

import io.github.asyncronous.exo.item.ItemExoskeletonArmor;

public interface ICore
extends Cloneable{
    public void write(NBTTagCompound comp, ItemExoskeletonArmor armor);
    public Item getItem();
    public String getName();
}