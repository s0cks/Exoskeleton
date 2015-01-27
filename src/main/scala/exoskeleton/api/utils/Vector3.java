package exoskeleton.api.utils;

import exoskeleton.api.ISaveable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class Vector3
implements ISaveable{
    private double x;
    private double y;
    private double z;

    private Vector3(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private Vector3(){}

    public static Vector3 of(double x, double y, double z){
        return new Vector3(x, y, z);
    }

    public static Vector3 of(NBTTagCompound comp){
        Vector3 vec = new Vector3();
        vec.readFromNBT(comp);
        return vec;
    }

    public double x(){
        return this.x;
    }

    public double y(){
        return this.y;
    }

    public double z(){
        return this.z;
    }

    public void teleportPlayer(EntityPlayer player){
        player.setPositionAndUpdate(this.x, this.y, this.z);
    }

    @Override
    public void readFromNBT(NBTTagCompound comp){
        this.x = comp.getDouble("x");
        this.y = comp.getDouble("y");
        this.z = comp.getDouble("z");
    }

    @Override
    public void writeToNBT(NBTTagCompound comp){
        comp.setDouble("x", this.x);
        comp.setDouble("y", this.y);
        comp.setDouble("z", this.z);
    }
}