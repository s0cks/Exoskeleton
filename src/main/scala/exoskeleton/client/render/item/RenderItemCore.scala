package exoskeleton.client.render.item

import cpw.mods.fml.client.FMLClientHandler
import exoskeleton.common.item.ItemCore
import net.minecraft.client.renderer.Tessellator
import net.minecraft.item.ItemStack
import net.minecraftforge.client.IItemRenderer
import net.minecraftforge.client.IItemRenderer.{ItemRendererHelper, ItemRenderType}
import org.lwjgl.opengl.GL11

object RenderItemCore
extends IItemRenderer{
  override def handleRenderType(item: ItemStack, `type`: ItemRenderType): Boolean={
    return `type` == ItemRenderType.INVENTORY;
  }

  override def shouldUseRenderHelper(`type`: ItemRenderType, item: ItemStack, helper: ItemRendererHelper): Boolean ={
    return false;
  }

  override def renderItem(`type`: ItemRenderType, stack: ItemStack, data: AnyRef*): Unit ={
    val item = stack.getItem;
    if(item.isInstanceOf[ItemCore]){
      GL11.glEnable(GL11.GL_BLEND);
      GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

      val icon = item.getIcon(stack, 0);
      val tess = Tessellator.instance;
      tess.startDrawingQuads();
      tess.addVertexWithUV(0, 16, 0, icon.getMinU, icon.getMaxV);
      tess.addVertexWithUV(16, 16, 0, icon.getMaxU, icon.getMaxV);
      tess.addVertexWithUV(16, 0, 0, icon.getMaxU, icon.getMinV);
      tess.addVertexWithUV(0, 0, 0, icon.getMinU, icon.getMinV);
      tess.draw();

      val core = item.asInstanceOf[ItemCore].core;
      if(core != null){
        FMLClientHandler.instance().getClient.renderEngine.bindTexture(core.overlay().core);
        tess.startDrawingQuads();
        tess.addVertexWithUV(0, 16, 0, 0, 1);
        tess.addVertexWithUV(16, 16, 0, 1, 1);
        tess.addVertexWithUV(16, 0, 0, 1, 0);
        tess.addVertexWithUV(0, 0, 0, 0, 0);
        tess.draw();
      }

      GL11.glDisable(GL11.GL_BLEND);
    }
  }
}