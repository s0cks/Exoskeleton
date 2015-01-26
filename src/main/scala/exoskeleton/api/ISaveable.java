package exoskeleton.api;

import net.minecraft.nbt.NBTTagCompound;

public interface ISaveable{
    public void readFromNBT(NBTTagCompound comp);
    public void writeToNBT(NBTTagCompound comp);
}