package exoskeleton.common;

import cpw.mods.fml.common.network.IGuiHandler;
import exoskeleton.client.gui.GuiDebug;
import exoskeleton.client.gui.GuiModifier;
import exoskeleton.client.gui.GuiTest;
import exoskeleton.client.gui.GuiToolbox;
import exoskeleton.common.gui.ContainerModifier;
import exoskeleton.common.gui.ContainerToolbox;
import exoskeleton.common.lib.tree.TreeRecon;
import exoskeleton.common.tile.TileEntityModifier;
import exoskeleton.common.tile.TileEntityToolbox;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public final class EXOGuiHandler
implements IGuiHandler{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        TileEntity tile = world.getTileEntity(x, y, z);
        switch(ID)
        {
            case 0:{
                return new ContainerToolbox(((TileEntityToolbox) tile), player);
            }
            case 1:{
                return new ContainerModifier(((TileEntityModifier) tile), player);
            }
            default:{
                return null;
            }
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        TileEntity tile = world.getTileEntity(x, y, z);
        switch(ID)
        {
            case 0:{
                return new GuiToolbox(new ContainerToolbox(((TileEntityToolbox) tile), player));
            }
            case 1:{
                return new GuiModifier(new ContainerModifier(((TileEntityModifier) tile), player));
            }
            case 2:{
                return new GuiTest(player, ((TileEntityModifier) tile), new TreeRecon());
            }
            case 3:{
                return new GuiDebug(player);
            }
            default:{
                return null;
            }
        }
    }
}