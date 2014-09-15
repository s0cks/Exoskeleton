package io.github.asyncronous.exo;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public final class EXOTag{
    public static final String IDENTIFIER = "exo";

    public static NBTTagCompound getTag(ItemStack stack){
        if(stack == null){
            return null;
        }

        if(!stack.hasTagCompound()){
            stack.setTagCompound(new NBTTagCompound());
        }

        NBTTagCompound comp = stack.getTagCompound();
        if(!comp.hasKey(IDENTIFIER)){
            comp.setTag(IDENTIFIER, new NBTTagCompound());
        }

        return comp.getCompoundTag(IDENTIFIER);
    }
}