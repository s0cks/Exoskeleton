package io.github.asyncronous.exoskeleton.render

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.IItemRenderer
import net.minecraftforge.client.IItemRenderer.{ItemRenderType, ItemRendererHelper}
import net.minecraftforge.client.model.{AdvancedModelLoader, IModelCustom}
import org.lwjgl.opengl.GL11

class ToolboxRenderer(val id: Int)
extends TileEntitySpecialRenderer
with IItemRenderer{
  private val model: IModelCustom = AdvancedModelLoader.loadModel(new ResourceLocation("exo", "models/toolbox.tcn"));
  private val texture: ResourceLocation = new ResourceLocation("exo", "textures/blocks/toolbox.png");

  override def renderTileEntityAt(tile: TileEntity, x: Double, y: Double, z: Double, scale: Float): Unit ={
    this.bindTexture(this.texture);
    GL11.glPushMatrix();
    GL11.glTranslated(x + 0.5, y, z + 0.5);
    GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
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
}