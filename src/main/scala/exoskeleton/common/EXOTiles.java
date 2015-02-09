package exoskeleton.common;

import cpw.mods.fml.common.registry.GameRegistry;
import exoskeleton.common.tile.TileEntityAssembler;
import exoskeleton.common.tile.TileEntityModifier;
import exoskeleton.common.tile.TileEntityToolbox;

public final class EXOTiles{
    public static void initialize(){
        GameRegistry.registerTileEntity(TileEntityToolbox.class, "tileEntityToolbox");
        GameRegistry.registerTileEntity(TileEntityAssembler.class, "tileEntityAssembler");
        GameRegistry.registerTileEntity(TileEntityModifier.class, "tileEntityModififer");
    }
}