package io.github.asyncronous.exoskeleton

import cpw.mods.fml.common.network.IGuiHandler
import io.github.asyncronous.exoskeleton.gui.GuiToolbox
import io.github.asyncronous.exoskeleton.gui.container.ContainerToolbox
import io.github.asyncronous.exoskeleton.tile.TileEntityToolbox
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

object ExoGuiHandler
extends IGuiHandler{
  override def getServerGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): AnyRef ={
    val tile: TileEntity = world.getTileEntity(x, y, z);
    ID match
    {
      case 0 =>{
        return new ContainerToolbox(tile.asInstanceOf[TileEntityToolbox], player);
      }
      case _ =>{
        return null;
      }
    }
  }

  override def getClientGuiElement(ID: Int, player: EntityPlayer, world: World, x: Int, y: Int, z: Int): AnyRef ={
    val tile: TileEntity = world.getTileEntity(x, y, z);
    ID match
    {
      case 0 =>{
        return new GuiToolbox(new ContainerToolbox(tile.asInstanceOf[TileEntityToolbox], player));
      }
      case _ =>{
        return null;
      }
    }
  }
}