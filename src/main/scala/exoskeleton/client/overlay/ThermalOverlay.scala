package exoskeleton.client.overlay

import exoskeleton.api.abilities.IOverlay
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.Tessellator
import org.lwjgl.opengl.GL11

class ThermalOverlay
extends IOverlay{
  private var thermal: Integer = null;

  override def draw(minecraft: Minecraft): Unit ={
    if(this.thermal == null){
      this.thermal = GL11.glGenLists(2);
      GL11.glNewList(thermal, GL11.GL_COMPILE);
      GL11.glMatrixMode(GL11.GL_MODELVIEW);
      GL11.glPushMatrix();
      GL11.glLoadIdentity();
      GL11.glMatrixMode(GL11.GL_PROJECTION);
      GL11.glPushMatrix();
      GL11.glLoadIdentity();
      GL11.glOrtho(-1.0F, 1.0F, -1.0F, 1.0F, -1.0F, 1.0F);
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
      GL11.glDisable(GL11.GL_LIGHTING);
      GL11.glDisable(GL11.GL_DEPTH_TEST);
      GL11.glDisable(GL11.GL_ALPHA_TEST);
      GL11.glEnable(GL11.GL_BLEND);
      GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

      val tess = new Tessellator();
      tess.startDrawingQuads();
      tess.setColorRGBA(117, 49, 181, 100);
      tess.addVertex(-1, -1, 0);
      tess.addVertex(1, -1, 0);
      tess.addVertex(1, 1, 0);
      tess.addVertex(-1, 1, 0);

      GL11.glDisable(GL11.GL_TEXTURE_2D);
      tess.draw();
      GL11.glEnable(GL11.GL_TEXTURE_2D);

      GL11.glDisable(GL11.GL_BLEND);
      GL11.glEnable(GL11.GL_DEPTH_TEST);
      GL11.glEnable(GL11.GL_ALPHA_TEST);
      GL11.glEnable(GL11.GL_LIGHTING);

      GL11.glPopMatrix();
      GL11.glMatrixMode(GL11.GL_MODELVIEW);
      GL11.glPopMatrix();
      GL11.glEndList();
    }

    GL11.glCallList(this.thermal);
  }
}