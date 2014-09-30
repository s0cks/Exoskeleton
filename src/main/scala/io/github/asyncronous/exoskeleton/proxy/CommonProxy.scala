package io.github.asyncronous.exoskeleton.proxy

import cpw.mods.fml.client.registry.{ClientRegistry, RenderingRegistry}
import cpw.mods.fml.common.registry.GameRegistry
import io.github.asyncronous.exoskeleton.block.BlockToolbox
import io.github.asyncronous.exoskeleton.render.ToolboxRenderer
import io.github.asyncronous.exoskeleton.tile.TileEntityToolbox
import net.minecraft.item.Item
import net.minecraftforge.client.MinecraftForgeClient

trait CommonProxy{
  def registerTiles(){}
  def registerRenders(){}
  def registerHandlers(){}
}

class ClientProxy
extends CommonProxy{
  override def registerTiles(): Unit ={
    GameRegistry.registerTileEntity(classOf[TileEntityToolbox], "tileToolbox");
  }

  override def registerRenders(): Unit ={
    val toolboxId: Int = RenderingRegistry.getNextAvailableRenderId();
    val toolboxRenderer: ToolboxRenderer = new ToolboxRenderer(toolboxId);
    BlockToolbox.setRenderID(toolboxId);
    ClientRegistry.bindTileEntitySpecialRenderer(classOf[TileEntityToolbox], toolboxRenderer);
    RenderingRegistry.registerBlockHandler(toolboxRenderer);
    MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockToolbox), toolboxRenderer);
  }
}

class ServerProxy
extends CommonProxy{

}