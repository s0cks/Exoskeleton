package exoskeleton.client.render.tile

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler
import cpw.mods.fml.relauncher.{Side, SideOnly}
import exoskeleton.common.tile.TileEntityToolbox
import net.minecraft.block.Block
import net.minecraft.client.renderer.RenderBlocks
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ResourceLocation
import net.minecraft.world.IBlockAccess
import net.minecraftforge.client.IItemRenderer
import net.minecraftforge.client.IItemRenderer.{ItemRenderType, ItemRendererHelper}
import net.minecraftforge.client.model.AdvancedModelLoader
import org.lwjgl.opengl.GL11

@SideOnly(Side.CLIENT)
class RenderTileToolbox(val id: Int)
extends TileEntitySpecialRenderer
with ISimpleBlockRenderingHandler
with IItemRenderer{
  private val texture = new ResourceLocation("exo", "textures/blocks/toolbox.png");
  private val model = AdvancedModelLoader.loadModel(new ResourceLocation("exo", "models/toolbox.tcn"));

  override def renderTileEntityAt(tile: TileEntity, x: Double, y: Double, z: Double, scale: Float): Unit ={
    this.bindTexture(this.texture);
    val t: TileEntityToolbox = tile.asInstanceOf[TileEntityToolbox];
    GL11.glPushMatrix();
    GL11.glTranslated(x + 0.5, y + 0.05, z + 0.5);
    GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
    GL11.glRotatef(t.rotation, 0.0F, 1.0F, 0.0F);
    GL11.glScalef(0.05F, 0.05F, 0.05F);
    this.model.renderAll();
    GL11.glPopMatrix();
  }

  override def shouldUseRenderHelper(`type`: ItemRenderType, item: ItemStack, helper: ItemRendererHelper): Boolean ={
    return true;
  }

  override def handleRenderType(item: ItemStack, `type`: ItemRenderType): Boolean ={
    return true;
  }

  override def renderItem(`type`: ItemRenderType, item: ItemStack, data: AnyRef*): Unit ={
    this.bindTexture(this.texture);
    GL11.glPushMatrix();
    GL11.glTranslated(0.5D, 0.0D, 0.5D);
    GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
    GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
    GL11.glScalef(0.075F, 0.075F, 0.075F);
    this.model.renderAll();
    GL11.glPopMatrix();
  }

  override def renderInventoryBlock(block: Block, metadata: Int, modelId: Int, renderer: RenderBlocks): Unit ={

  }

  override def getRenderId: Int ={
    return this.id;
  }

  override def shouldRender3DInInventory(modelId: Int): Boolean ={
    return true;
  }

  override def renderWorldBlock(world: IBlockAccess, x: Int, y: Int, z: Int, block: Block, modelId: Int, renderer: RenderBlocks): Boolean ={
    return true;
  }
}