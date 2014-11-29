package exoskeleton.client.gui

import exoskeleton.common.gui.ContainerToolbox
import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.util.ResourceLocation
import org.lwjgl.opengl.GL11

class GuiToolbox(val c: ContainerToolbox)
extends GuiContainer(c){
  private val texture: ResourceLocation = new ResourceLocation("exo", "textures/gui/toolbox.png");

  override def drawGuiContainerBackgroundLayer(p_146976_1_ : Float, p_146976_2_ : Int, p_146976_3_ : Int): Unit={
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    this.mc.getTextureManager.bindTexture(this.texture);
    val dX = (this.width - this.xSize) / 2;
    val dY = (this.height - this.ySize) / 2;
    this.drawTexturedModalRect(dX, dY - 25, 0, 0, this.xSize, this.ySize + 50);
  }
}