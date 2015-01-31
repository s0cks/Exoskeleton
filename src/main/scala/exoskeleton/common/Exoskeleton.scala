package exoskeleton.common

import cpw.mods.fml.common.event._
import cpw.mods.fml.common.network.NetworkRegistry
import cpw.mods.fml.common.{FMLCommonHandler, Mod, SidedProxy}
import exoskeleton.api.{HeatValue, ExoskeletonAPI, ExoskeletonCores}
import exoskeleton.common.command.{CommandGiveSkill, CommandRemoveSkill, CommandSetRecall}
import exoskeleton.common.core._
import exoskeleton.common.handler._
import exoskeleton.common.network.PacketHandler
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.monster.{EntitySkeleton, EntitySpider, EntityZombie}
import net.minecraft.entity.passive.EntitySquid
import net.minecraft.init.Blocks
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
    ExoskeletonCores.registerCore(CoreBulldozer);

    proxy.registerRenders();

    this.addXRaysMappings();
    this.addThermalMappings();
    this.addHeatMappings();

    NetworkRegistry.INSTANCE.registerGuiHandler(this, ExoGuiHandler);
    PacketHandler.init();
  }

  @Mod.EventHandler
  def serverStarting(e: FMLServerStartingEvent): Unit ={
    e.registerServerCommand(new CommandGiveSkill());
    e.registerServerCommand(new CommandRemoveSkill());
    e.registerServerCommand(new CommandSetRecall());
  }

  private def addHeatMappings(): Unit ={
    ExoskeletonAPI.applyHeatMappingValueToBlock(Blocks.lava, HeatValue.VERY_HOT);
    ExoskeletonAPI.applyHeatMappingValueToBlock(Blocks.flowing_lava, HeatValue.VERY_HOT);
    ExoskeletonAPI.applyHeatMappingValueToBlock(Blocks.fire, HeatValue.HOT);
    ExoskeletonAPI.applyHeatMappingValueToBlock(Blocks.flowing_water, HeatValue.COLD);
    ExoskeletonAPI.applyHeatMappingValueToBlock(Blocks.water, HeatValue.COLD);
    ExoskeletonAPI.applyHeatMappingValueToBlock(Blocks.torch, HeatValue.HOT);
    ExoskeletonAPI.applyHeatMappingValueToBlock(Blocks.brewing_stand, HeatValue.HOT);
    ExoskeletonAPI.applyHeatMappingValueToBlock(Blocks.ice, HeatValue.FREEZING);
    ExoskeletonAPI.applyHeatMappingValueToBlock(Blocks.packed_ice, HeatValue.FREEZING);
  }

  private def addXRaysMappings(): Unit ={
    ExoskeletonAPI.applyXRayMappingToBlock(Blocks.coal_ore);
    ExoskeletonAPI.applyXRayMappingToBlock(Blocks.diamond_ore);
    ExoskeletonAPI.applyXRayMappingToBlock(Blocks.emerald_ore);
    ExoskeletonAPI.applyXRayMappingToBlock(Blocks.gold_ore);
    ExoskeletonAPI.applyXRayMappingToBlock(Blocks.iron_ore);
    ExoskeletonAPI.applyXRayMappingToBlock(Blocks.lapis_ore);
    ExoskeletonAPI.applyXRayMappingToBlock(Blocks.lit_redstone_ore);
    ExoskeletonAPI.applyXRayMappingToBlock(Blocks.quartz_ore);
    ExoskeletonAPI.applyXRayMappingToBlock(Blocks.redstone_ore);
  }

  private def addThermalMappings(): Unit ={
    ExoskeletonAPI.applyThermalBlacklistToEntity(classOf[EntitySquid]);
    ExoskeletonAPI.applyThermalBlacklistToEntity(classOf[EntityZombie]);
    ExoskeletonAPI.applyThermalBlacklistToEntity(classOf[EntitySpider]);
    ExoskeletonAPI.applyThermalBlacklistToEntity(classOf[EntitySkeleton]);
  }
}
