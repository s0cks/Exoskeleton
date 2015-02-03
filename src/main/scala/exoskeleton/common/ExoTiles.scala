package exoskeleton.common

import cpw.mods.fml.common.registry.GameRegistry
import exoskeleton.common.tile.{TileEntityAssembler, TileEntityModifier, TileEntityToolbox}

object ExoTiles{
  def init(): Unit ={
    GameRegistry.registerTileEntity(classOf[TileEntityToolbox], "tileToolbox");
    GameRegistry.registerTileEntity(classOf[TileEntityAssembler], "tileEntityAssembler");
    GameRegistry.registerTileEntity(classOf[TileEntityModifier], "tileEntityModifier");
  }
}
