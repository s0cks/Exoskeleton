package exoskeleton.common

import cpw.mods.fml.common.registry.GameRegistry
import exoskeleton.common.block.{BlockAssembler, BlockModifier, BlockTest, BlockToolbox}
import exoskeleton.common.item.ItemToolbox

object ExoBlocks{
  def init(): Unit ={
    GameRegistry.registerBlock(BlockTest, "blockTest");
    GameRegistry.registerBlock(BlockAssembler, "blockAssembler");
    GameRegistry.registerBlock(BlockToolbox, classOf[ItemToolbox], "blockToolbox");
    GameRegistry.registerBlock(BlockModifier, "blockModifier");
  }
}
