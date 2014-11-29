package exoskeleton.client

import cpw.mods.fml.client.registry.{ClientRegistry, RenderingRegistry}
import cpw.mods.fml.common.registry.GameRegistry
import exoskeleton.common.CommonProxy
import exoskeleton.common.block.{BlockAssembler, BlockToolbox}
import exoskeleton.client.render.{AssemblerRenderer, ToolboxRenderer}
import exoskeleton.common.tile.{TileEntityAssembler, TileEntityModifier, TileEntityToolbox}
import net.minecraft.item.Item
import net.minecraftforge.client.MinecraftForgeClient

class ClientProxy
extends CommonProxy{
  override def registerTiles(): Unit ={
    GameRegistry.registerTileEntity(classOf[TileEntityToolbox], "tileToolbox");
    GameRegistry.registerTileEntity(classOf[TileEntityAssembler], "tileEntityAssembler");
    GameRegistry.registerTileEntity(classOf[TileEntityModifier], "tileEntityModifier");
  }

  override def registerRenders(): Unit ={
    val tboxId = RenderingRegistry.getNextAvailableRenderId();
    val tboxR = new ToolboxRenderer(tboxId);
    BlockToolbox.setRenderID(tboxId);
    ClientRegistry.bindTileEntitySpecialRenderer(classOf[TileEntityToolbox], tboxR);
    RenderingRegistry.registerBlockHandler(tboxR);
    MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockToolbox), tboxR);

    val assemblerId = RenderingRegistry.getNextAvailableRenderId();
    val assemblerR = new AssemblerRenderer(assemblerId);
    BlockAssembler.setRenderID(assemblerId);
    ClientRegistry.bindTileEntitySpecialRenderer(classOf[TileEntityAssembler], assemblerR);
    RenderingRegistry.registerBlockHandler(assemblerR);
  }
}
