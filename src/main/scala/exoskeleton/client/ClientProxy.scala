package exoskeleton.client

import cpw.mods.fml.client.FMLClientHandler
import cpw.mods.fml.client.registry.{ClientRegistry, RenderingRegistry}
import cpw.mods.fml.common.FMLCommonHandler
import exoskeleton.client.handler.mapping.{ThermalHeatMapper, XRayOreMapper}
import exoskeleton.client.handler._
import exoskeleton.client.render.item._
import exoskeleton.client.render.tile.{RenderTileAssembler, RenderTileModifier, RenderTileToolbox}
import exoskeleton.common.block.{BlockAssembler, BlockModifier, BlockToolbox}
import exoskeleton.common.handler._
import exoskeleton.common.tile.{TileEntityAssembler, TileEntityModifier, TileEntityToolbox}
import exoskeleton.common.{CommonProxy, ExoItems}
import net.minecraft.item.Item
import net.minecraft.world.World
import net.minecraftforge.client.MinecraftForgeClient
import net.minecraftforge.common.MinecraftForge

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

  override def registerHandlers(): Unit ={
    FMLCommonHandler.instance().bus().register(KeyHandler);
    FMLCommonHandler.instance().bus().register(NetworkDataHandler);

    MinecraftForge.EVENT_BUS.register(NightVisionHandler);

    MinecraftForge.EVENT_BUS.register(ThermalHandler);
    MinecraftForge.EVENT_BUS.register(ThermalHeatMapper.instance());

    MinecraftForge.EVENT_BUS.register(AssassinHandler);
    MinecraftForge.EVENT_BUS.register(CamoHandler);

    MinecraftForge.EVENT_BUS.register(XRayHandler);
    MinecraftForge.EVENT_BUS.register(XRayOreMapper.instance());
  }

  override def getClientWorld(): World={
    return FMLClientHandler.instance().getClient.theWorld;
  }
}
