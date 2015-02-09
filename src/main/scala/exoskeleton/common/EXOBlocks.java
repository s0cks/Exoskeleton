package exoskeleton.common;

import cpw.mods.fml.common.registry.GameRegistry;
import exoskeleton.common.block.BlockAssembler$;
import exoskeleton.common.block.BlockModifier$;
import exoskeleton.common.block.BlockTest$;
import exoskeleton.common.block.BlockToolbox$;
import exoskeleton.common.item.ItemToolbox;

public final class EXOBlocks{
    public static void initialize(){
        GameRegistry.registerBlock(BlockTest$.MODULE$, "blockTest");
        GameRegistry.registerBlock(BlockAssembler$.MODULE$, "blockAssembler");
        GameRegistry.registerBlock(BlockToolbox$.MODULE$, ItemToolbox.class, "blockToolbox");
        GameRegistry.registerBlock(BlockModifier$.MODULE$, "blockModifier");
    }
}