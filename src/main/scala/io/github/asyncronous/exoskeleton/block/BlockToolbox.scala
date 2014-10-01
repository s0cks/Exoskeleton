package io.github.asyncronous.exoskeleton.block

import java.util.Random

import io.github.asyncronous.exoskeleton.Exoskeleton
import io.github.asyncronous.exoskeleton.api.Toolbox
import io.github.asyncronous.exoskeleton.helper.RotationHelper
import io.github.asyncronous.exoskeleton.tile.TileEntityToolbox
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.MovingObjectPosition
import net.minecraft.world.World

object BlockToolbox
extends BlockContainer(Material.iron){
  private var renderID = 0;

  this.setCreativeTab(Exoskeleton.tab);
  this.setHardness(2.0F);
  this.setResistance(10.0F);
  this.setBlockName("toolbox");
  this.setBlockBounds(0.1F, 0.0F, 0.3F, 0.9F, 0.5F, 0.7F);

  def setRenderID(id: Int): Unit ={
    this.renderID = id;
  }

  override def onBlockActivated(world: World, x: Int, y: Int, z: Int, player: EntityPlayer, p_149727_6_ : Int, p_149727_7_ : Float, p_149727_8_ : Float, p_149727_9_ : Float): Boolean = {
    player.openGui(Exoskeleton, 0, world, x, y, z);
    return true;
  }

  override def onBlockPlacedBy(world: World, x: Int, y: Int, z: Int, living: EntityLivingBase, stack: ItemStack): Unit ={
    val tile: TileEntityToolbox = world.getTileEntity(x, y, z).asInstanceOf[TileEntityToolbox];
    val tbox: Toolbox = stack.getItem().asInstanceOf[Toolbox];
    tile.inventory = tbox.getInventory(stack);
    tile.rotation = RotationHelper.get3DRotation(living);
  }

  override def removedByPlayer(world: World, player: EntityPlayer, x: Int, y: Int, z: Int, harvest: Boolean): Boolean={
    if(!player.capabilities.isCreativeMode &&
      !world.isRemote &&
      canHarvestBlock(player, world.getBlockMetadata(x, y, z))){

      val motion: Float = 0.7F;
      val motX: Double = (world.rand.nextFloat() * motion) + (1.0F - motion) * 0.5D;
      val motY: Double = (world.rand.nextFloat() * motion) + (1.0F - motion) * 0.5D;
      val motZ: Double = (world.rand.nextFloat() * motion) + (1.0F - motion) * 0.5D;
      val eItem: EntityItem = new EntityItem(world, x + motX, y + motY, z + motZ, this.getPickBlock(null, world, x, y, z));
      world.spawnEntityInWorld(eItem);
    }

    return world.setBlockToAir(x, y, z);
  }

  override def getPickBlock(t: MovingObjectPosition, world: World, x: Int, y: Int, z: Int): ItemStack={
    val tile: TileEntityToolbox = world.getTileEntity(x, y, z).asInstanceOf[TileEntityToolbox];
    val stack: ItemStack = new ItemStack(BlockToolbox);
    val tbox: Toolbox = stack.getItem().asInstanceOf[Toolbox];

    if(tile.inventory != null){
      tbox.setInventory(stack, tile.inventory);
    }
    return stack;
  }

  override def quantityDropped(rand: Random): Int={
    return 0;
  }

  override def getItemDropped(i: Int, rand: Random, j: Int): Item={
    return null;
  }

  override def createNewTileEntity(world: World, i: Int): TileEntity={
    return new TileEntityToolbox();
  }

  override def getRenderType(): Int={
    return this.renderID;
  }

  override def renderAsNormalBlock(): Boolean={
    return false;
  }

  override def isOpaqueCube(): Boolean={
    return false;
  }
}