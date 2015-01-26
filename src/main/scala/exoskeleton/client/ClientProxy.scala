package exoskeleton.client

import cpw.mods.fml.client.FMLClientHandler
import cpw.mods.fml.client.registry.{ClientRegistry, RenderingRegistry}
import exoskeleton.client.render.{AssemblerRenderer, ToolboxRenderer}
import exoskeleton.common.CommonProxy
import exoskeleton.common.block.{BlockAssembler, BlockToolbox}
import exoskeleton.common.tile.{TileEntityAssembler, TileEntityToolbox}
import net.minecraft.item.Item
import net.minecraft.world.World
import net.minecraftforge.client.MinecraftForgeClient

class ClientProxy
extends CommonProxy{
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

  override def getClientWorld(): World={
    return FMLClientHandler.instance().getClient.theWorld;
  }
}
