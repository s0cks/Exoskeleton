package exoskeleton.client

import cpw.mods.fml.client.FMLClientHandler
import cpw.mods.fml.client.registry.{ClientRegistry, RenderingRegistry}
import exoskeleton.client.render.item._
import exoskeleton.client.render.tile.{RenderTileModifier, RenderTileToolbox, RenderTileAssembler}
import exoskeleton.common.{ExoItems, CommonProxy}
import exoskeleton.common.block.{BlockModifier, BlockAssembler, BlockToolbox}
import exoskeleton.common.tile.{TileEntityModifier, TileEntityAssembler, TileEntityToolbox}
import net.minecraft.item.Item
import net.minecraft.world.World
import net.minecraftforge.client.MinecraftForgeClient

class ClientProxy
extends CommonProxy{
  override def registerRenders(): Unit ={
    val tboxId = RenderingRegistry.getNextAvailableRenderId();
    val tboxR = new RenderTileToolbox(tboxId);
    BlockToolbox.setRenderID(tboxId);
    ClientRegistry.bindTileEntitySpecialRenderer(classOf[TileEntityToolbox], tboxR);
    RenderingRegistry.registerBlockHandler(tboxR);
    MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockToolbox), tboxR);

    val assemblerId = RenderingRegistry.getNextAvailableRenderId();
    val assemblerR = new RenderTileAssembler(assemblerId);
    BlockAssembler.setRenderID(assemblerId);
    ClientRegistry.bindTileEntitySpecialRenderer(classOf[TileEntityAssembler], assemblerR);
    RenderingRegistry.registerBlockHandler(assemblerR);

    val modifierId = RenderingRegistry.getNextAvailableRenderId;
    val modifierR = new RenderTileModifier(modifierId);
    BlockModifier.setRenderID(modifierId);
    ClientRegistry.bindTileEntitySpecialRenderer(classOf[TileEntityModifier], modifierR);
    RenderingRegistry.registerBlockHandler(modifierR);

    MinecraftForgeClient.registerItemRenderer(ExoItems.itemExoArmorBoots, new RenderItemExoBoots());
    MinecraftForgeClient.registerItemRenderer(ExoItems.itemExoArmorChest, new RenderItemExoChest());
    MinecraftForgeClient.registerItemRenderer(ExoItems.itemExoArmorHelm, new RenderItemExoHelm());
    MinecraftForgeClient.registerItemRenderer(ExoItems.itemExoArmorLegs, new RenderItemExoLegs());
  }

  override def getClientWorld(): World={
    return FMLClientHandler.instance().getClient.theWorld;
  }
}
