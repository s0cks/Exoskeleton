package io.github.asyncronous.exoskeleton

import cpw.mods.fml.common.registry.GameRegistry
import io.github.asyncronous.exoskeleton.block.{BlockToolbox, BlockTest}
import io.github.asyncronous.exoskeleton.item.ItemToolbox

object ExoBlocks{
  def init(): Unit ={
    GameRegistry.registerBlock(BlockTest, "blockTest");
    GameRegistry.registerBlock(BlockToolbox, classOf[ItemToolbox], "blockToolbox");
  }
}