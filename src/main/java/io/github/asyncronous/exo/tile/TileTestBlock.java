package io.github.asyncronous.exo.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import io.github.asyncronous.exo.Cores;
import io.github.asyncronous.exo.core.ICore;

public class TileTestBlock
extends TileEntity{
    private ICore core = Cores.coreEmpty;

    @Override
    public void readFromNBT(NBTTagCompound comp){
        super.readFromNBT(comp);
        this.core = Cores.find(comp.getString("core"));
    }

    @Override
    public void writeToNBT(NBTTagCompound comp){
        super.writeToNBT(comp);
        comp.setString("core", this.core.getName());
    }

    public ICore getCore(){
        return core;
    }

    public void setCore(ICore core){
        this.core = core;
    }
}