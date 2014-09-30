package io.github.asyncronous.exoskeleton

import cpw.mods.fml.common.network.NetworkRegistry
import cpw.mods.fml.common.{SidedProxy, Mod}
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import io.github.asyncronous.exoskeleton.api.ExoskeletonCores
import io.github.asyncronous.exoskeleton.core.{CoreBulldozer, CoreRecon}
import io.github.asyncronous.exoskeleton.handler.{ExoToolTipHandler, CoreHandler}
import io.github.asyncronous.exoskeleton.proxy.CommonProxy
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.init.Items
import net.minecraft.item.Item
import net.minecraftforge.common.MinecraftForge

@Mod(
  modid = "exo",
  name = "Exoskeleton",
  version = "0.0.0",
  modLanguage = "scala"
)
object Exoskeleton{
  @SidedProxy(
    clientSide = "io.github.asyncronous.exoskeleton.proxy.ClientProxy",
    serverSide = "io.github.asyncronous.exoskeleton.proxy.ServerProxy"
  )
  var proxy: CommonProxy = null;

  val tab: CreativeTabs = new CreativeTabs("exoskeleton"){
    override def getTabIconItem: Item ={
      return Items.diamond;
    }
  };

  @Mod.EventHandler
  def preInit(e: FMLPreInitializationEvent): Unit ={
    MinecraftForge.EVENT_BUS.register(CoreHandler);
    MinecraftForge.EVENT_BUS.register(ExoToolTipHandler);
  }

  @Mod.EventHandler
  def init(e: FMLInitializationEvent): Unit ={
    ExoItems.init();
    ExoBlocks.init();
  }

  @Mod.EventHandler
  def postInit(e: FMLPostInitializationEvent): Unit ={
    ExoskeletonCores.registerCore(CoreRecon);
    ExoskeletonCores.registerCore(CoreBulldozer);

    proxy.registerHandlers();
    proxy.registerRenders();
    proxy.registerTiles();

    NetworkRegistry.INSTANCE.registerGuiHandler(this, ExoGuiHandler);
  }
}