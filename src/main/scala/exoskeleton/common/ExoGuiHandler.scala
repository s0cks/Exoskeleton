package exoskeleton.common

import cpw.mods.fml.common.network.IGuiHandler
import exoskeleton.client.gui._
import exoskeleton.common.gui.{ContainerModifier, ContainerToolbox}
import exoskeleton.common.lib.tree.TreeRecon
import exoskeleton.common.tile.{TileEntityModifier, TileEntityToolbox}
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
      case 1 =>{
        return new ContainerModifier(tile.asInstanceOf[TileEntityModifier], player);
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
      case 1=>{
        return new GuiModifier(new ContainerModifier(tile.asInstanceOf[TileEntityModifier], player));
      }
      case 2 =>{
        return new GuiTest(player, TreeRecon);
      }
      case 3 =>{
        return new GuiDebug(player);
      }
      case _ =>{
        return null;
      }
    }
  }
}
