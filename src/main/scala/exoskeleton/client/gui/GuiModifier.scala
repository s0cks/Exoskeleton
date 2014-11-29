package exoskeleton.client.gui

import java.util

import exoskeleton.common.gui.ContainerModifier
import net.minecraft.client.gui.GuiButton
import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraft.util.ResourceLocation
import org.lwjgl.opengl.GL11

class GuiModifier(val modifier: ContainerModifier)
extends GuiContainer(modifier){
  private val texture: ResourceLocation = new ResourceLocation("exo", "textures/gui/modifier.png");

  override def initGui(): Unit = {
    val list: util.List[GuiButton] = this.buttonList.asInstanceOf[util.List[GuiButton]];
    list.add(new GuiButton(0, 0, 0, 125, 25, "Recon"));
    list.add(new GuiButton(1, 0, 30, 125, 25, "Bulldozer"));
  }

    override def drawGuiContainerBackgroundLayer(p_146976_1_ : Float, p_146976_2_ : Int, p_146976_3_ : Int): Unit ={
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    this.mc.renderEngine.bindTexture(this.texture);
    val dX = (this.width - this.xSize) / 2;
    val dY = (this.height - this.ySize) / 2;
    this.drawTexturedModalRect(dX, dY, 0, 0, this.xSize, this.ySize);
  }
}