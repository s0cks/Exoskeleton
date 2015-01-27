package exoskeleton.common

import cpw.mods.fml.common.event.{FMLServerStartingEvent, FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.network.NetworkRegistry
import cpw.mods.fml.common.{FMLCommonHandler, Mod, SidedProxy}
import exoskeleton.api.{ExoskeletonAPI, ExoskeletonCores}
import exoskeleton.common.command.{CommandSetRecall, CommandRemoveSkill, CommandGiveSkill}
import exoskeleton.common.core._
import exoskeleton.common.handler._
import exoskeleton.common.network.PacketHandler
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation
import net.minecraftforge.common.MinecraftForge

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
  val glow_effects = new ResourceLocation("exo", "textures/glow_effects.png");

  @Mod.EventHandler
  def preInit(e: FMLPreInitializationEvent): Unit ={
    MinecraftForge.EVENT_BUS.register(CoreHandler);
    MinecraftForge.EVENT_BUS.register(DataHandler);
    MinecraftForge.EVENT_BUS.register(NightVisionHandler);

    FMLCommonHandler.instance().bus().register(KeyHandler);
    FMLCommonHandler.instance().bus().register(FadeHandler);
    FMLCommonHandler.instance().bus().register(BacktrackHandler);
  }

  @Mod.EventHandler
  def init(e: FMLInitializationEvent): Unit ={
    ExoItems.init();
    ExoBlocks.init();
    ExoTiles.init();
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
