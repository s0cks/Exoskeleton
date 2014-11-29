package exoskeleton.common

import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.network.NetworkRegistry
import cpw.mods.fml.common.{Mod, SidedProxy}
import exoskeleton.api.ExoskeletonCores
import exoskeleton.common.core.{CoreBulldozer, CoreInferno, CoreRecon}
import exoskeleton.common.handler.{CoreHandler, ExoToolTipHandler, SkillsHandler}
import net.minecraft.creativetab.CreativeTabs
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
    clientSide = "exoskeleton.client.ClientProxy",
    serverSide = "exoskeleton.common.ServerProxy"
  )
  var proxy: CommonProxy = null;

  val tab: CreativeTabs = new CreativeTabs("exoskeleton"){
    override def getTabIconItem: Item ={
      return ExoItems.itemCoreRecon;
    }
  };

  @Mod.EventHandler
  def preInit(e: FMLPreInitializationEvent): Unit ={
    MinecraftForge.EVENT_BUS.register(CoreHandler);
    MinecraftForge.EVENT_BUS.register(SkillsHandler);
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
    ExoskeletonCores.registerCore(CoreInferno);

    proxy.registerHandlers();
    proxy.registerRenders();
    proxy.registerTiles();

    NetworkRegistry.INSTANCE.registerGuiHandler(this, ExoGuiHandler);
  }
}
