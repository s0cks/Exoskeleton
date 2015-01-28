package exoskeleton.common

import cpw.mods.fml.common.event._
import cpw.mods.fml.common.network.NetworkRegistry
import cpw.mods.fml.common.{FMLCommonHandler, Mod, SidedProxy}
import exoskeleton.api.{ExoskeletonAPI, ExoskeletonCores}
import exoskeleton.common.command.{CommandGiveSkill, CommandRemoveSkill, CommandSetRecall}
import exoskeleton.common.core._
import exoskeleton.common.handler._
import exoskeleton.common.network.PacketHandler
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraftforge.common.MinecraftForge
import org.apache.logging.log4j.LogManager

@Mod(
  modid = "exo",
  name = "Exoskeleton",
  version = "0.0.0.0",
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
  val logger = LogManager.getLogger("Exoskeleton");;

  @Mod.EventHandler
  def preInit(e: FMLPreInitializationEvent): Unit ={
    ExoConfiguration.init(e.getSuggestedConfigurationFile);

    MinecraftForge.EVENT_BUS.register(DataHandler);
    MinecraftForge.EVENT_BUS.register(CoreHandler);

    proxy.registerHandlers();

    FMLCommonHandler.instance().bus().register(FadeHandler);
    FMLCommonHandler.instance().bus().register(BacktrackHandler);
    FMLCommonHandler.instance().bus().register(DataHandler);
  }

  @Mod.EventHandler
  def init(e: FMLInitializationEvent): Unit ={
    ExoItems.init();
    ExoBlocks.init();
    ExoTiles.init();

    FMLInterModComms.sendMessage("waila", "register", "exoskeleton.client.waila.EXOEntityHandler.register");
  }

  @Mod.EventHandler
  def postInit(e: FMLPostInitializationEvent): Unit ={
    ExoskeletonCores.registerCore(CoreRecon);
    ExoskeletonCores.registerCore(CoreInferno);
    ExoskeletonCores.registerCore(CoreSkybound);
    ExoskeletonCores.registerCore(CoreGhost);
    ExoskeletonCores.registerCore(CoreReflex);
    ExoskeletonCores.registerCore(CoreMedic);

    ExoskeletonAPI.event_bus.register(EXOEventHandler);

    proxy.registerRenders();

    NetworkRegistry.INSTANCE.registerGuiHandler(this, ExoGuiHandler);
    PacketHandler.init();
  }

  @Mod.EventHandler
  def serverStarting(e: FMLServerStartingEvent): Unit ={
    e.registerServerCommand(new CommandGiveSkill());
    e.registerServerCommand(new CommandRemoveSkill());
    e.registerServerCommand(new CommandSetRecall());
  }
}
