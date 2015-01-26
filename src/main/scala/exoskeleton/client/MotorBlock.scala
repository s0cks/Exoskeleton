package exoskeleton.client

import net.minecraft.util.ResourceLocation
import truetyper.{FontHelper, FontLoader}

object MotorBlock{
  private val location = new ResourceLocation("exo", "font/Motorblock.ttf");
  private val motorblock = FontLoader.createFont(location, 12, true);

  def drawString(str: String, x: Int, y: Int): Unit ={
    FontHelper.drawString(str, x, y, this.motorblock, 1.0F, 1.0F);
  }

  def drawString(str: String, x: Int, y: Int, scale: Float): Unit ={
    FontHelper.drawString(str, x, y, this.motorblock, scale, scale);;
  }
}