package exoskeleton.common;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import exoskeleton.api.Camouflage;
import exoskeleton.api.ExoskeletonAPI;
import exoskeleton.api.ExoskeletonCores;
import exoskeleton.client.camo.BasicCamo;
import exoskeleton.common.command.CommandGiveSkill;
import exoskeleton.common.command.CommandRemoveSkill;
import exoskeleton.common.command.CommandSetRecall;
import exoskeleton.common.core.CoreAssassin$;
import exoskeleton.common.core.CoreBerzerk$;
import exoskeleton.common.core.CoreBulldozer$;
import exoskeleton.common.core.CoreFrost$;
import exoskeleton.common.core.CoreGhost$;
import exoskeleton.common.core.CoreInferno$;
import exoskeleton.common.core.CoreMedic$;
import exoskeleton.common.core.CoreMystic$;
import exoskeleton.common.core.CoreRecon$;
import exoskeleton.common.core.CoreReflex$;
import exoskeleton.common.core.CoreSkybound$;
import exoskeleton.common.handler.BacktrackHandler$;
import exoskeleton.common.handler.CoreHandler$;
import exoskeleton.common.handler.DataHandler$;
import exoskeleton.common.handler.FadeHandler$;
import exoskeleton.common.network.PacketHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = "exo",
        name = "Exoskeleton",
        version = "1.0.0.0"
)
public final class Exoskeleton{
    @Instance("exo")
    public static Exoskeleton instance;

    @SidedProxy(
            clientSide = "exoskeleton.client.ClientProxy",
            serverSide = "exoskeleton.common.ServerProxy"
    )
    public static CommonProxy proxy;

    public static final Logger logger = LogManager.getLogger(Exoskeleton.class);
    public static final CreativeTabs tab = new CreativeTabs("exoskeleton"){
        @Override
        public Item getTabIconItem(){
            return Items.diamond;
        }
    };

    @EventHandler
    public void onPreInit(FMLPreInitializationEvent e){
        EXOConfiguration.instance().initialize(e.getSuggestedConfigurationFile());

        MinecraftForge.EVENT_BUS.register(DataHandler$.MODULE$);
        MinecraftForge.EVENT_BUS.register(CoreHandler$.MODULE$);

        proxy.registerHandlers();

        FMLCommonHandler.instance().bus().register(FadeHandler$.MODULE$);
        FMLCommonHandler.instance().bus().register(BacktrackHandler$.MODULE$);
        FMLCommonHandler.instance().bus().register(DataHandler$.MODULE$);
    }

    @EventHandler
    public void onInit(FMLInitializationEvent e){
        ExoskeletonCores.registerCore(CoreRecon$.MODULE$);
        ExoskeletonCores.registerCore(CoreInferno$.MODULE$);
        ExoskeletonCores.registerCore(CoreSkybound$.MODULE$);
        ExoskeletonCores.registerCore(CoreGhost$.MODULE$);
        ExoskeletonCores.registerCore(CoreReflex$.MODULE$);
        ExoskeletonCores.registerCore(CoreMedic$.MODULE$);
        ExoskeletonCores.registerCore(CoreBulldozer$.MODULE$);
        ExoskeletonCores.registerCore(CoreAssassin$.MODULE$);
        ExoskeletonCores.registerCore(CoreFrost$.MODULE$);
        ExoskeletonCores.registerCore(CoreMystic$.MODULE$);
        ExoskeletonCores.registerCore(CoreBerzerk$.MODULE$);

        ExoskeletonCores.registerItems();
        EXOItems.initialize();
        EXOTiles.initialize();
        EXOBlocks.initialize();

        if(Loader.isModLoaded("waila")){
            FMLInterModComms.sendMessage("waila", "register", "exoskeleton.client.waila.EXOEntityHandler.register");
        }
    }

    @EventHandler
    public void onPostInit(FMLPostInitializationEvent e){
        proxy.registerRenders();

        this.registerCamouflages();
        this.registerOreXRays();

        NetworkRegistry.INSTANCE.registerGuiHandler(Exoskeleton.instance, ExoGuiHandler$.MODULE$);

        PacketHandler.init();
    }

    @EventHandler
    public void onServerStarting(FMLServerStartingEvent e){
        e.registerServerCommand(new CommandGiveSkill());
        e.registerServerCommand(new CommandRemoveSkill());
        e.registerServerCommand(new CommandSetRecall());
    }

    private void registerCamouflages(){
        Camouflage camoDesert = new BasicCamo(Blocks.sand);
        Camouflage camoDefault = new BasicCamo(Blocks.stone);
        Camouflage camoNether = new BasicCamo(Blocks.netherrack);

        ExoskeletonAPI.registerActiveCamouflage(BiomeGenBase.plains, camoDefault);
        ExoskeletonAPI.registerActiveCamouflage(BiomeGenBase.desert, camoDesert);
        ExoskeletonAPI.registerActiveCamouflage(BiomeGenBase.desertHills, camoDesert);
        ExoskeletonAPI.registerActiveCamouflage(BiomeGenBase.hell, camoNether);
    }

    private void registerOreXRays(){
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
}