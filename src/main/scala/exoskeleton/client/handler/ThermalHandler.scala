package exoskeleton.client.handler

import java.util

import cpw.mods.fml.client.FMLClientHandler
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import exoskeleton.api.ExoskeletonAPI
import exoskeleton.api.utils.RenderUtils
import exoskeleton.client.overlay.ThermalOverlay
import exoskeleton.common.lib.ArmorHelper
import exoskeleton.common.lib.data.DataManager
import net.minecraft.client.renderer.entity.RenderManager
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.{Entity, EntityLiving}
import net.minecraftforge.client.event.RenderWorldLastEvent
import org.lwjgl.opengl.GL11

import scala.collection.JavaConversions._;
;

object ThermalHandler{
  private val overlay = new ThermalOverlay;

  @SubscribeEvent
  def render(e: RenderWorldLastEvent): Unit ={
    val mc = FMLClientHandler.instance().getClient;
    val player = mc.thePlayer.asInstanceOf[EntityPlayer];
    if(DataManager.get(player).thermal() && ArmorHelper.hasExoHelm(player)){
      overlay.draw(mc);
    }
  }

  @SubscribeEvent
  def doXRay(ev: RenderWorldLastEvent): Unit ={
    val player = FMLClientHandler.instance().getClient.thePlayer.asInstanceOf[EntityPlayer];
    if(DataManager.get(player).thermal() && ArmorHelper.hasExoHelm(player)){
      GL11.glPushMatrix();
      val p = FMLClientHandler.instance().getClient.renderViewEntity.asInstanceOf[EntityPlayer];
      RenderUtils.translateToWorldCoords(p, ev.partialTicks);
      GL11.glDisable(GL11.GL_LIGHTING);
      val world = p.worldObj;
      val range = 24 / 2;
      val entities = world.getEntitiesWithinAABBExcludingEntity(p, p.boundingBox.expand(range, range, range));
      for(e: Entity <- entities.asInstanceOf[util.List[Entity]]){
        if(e.isInstanceOf[EntityLiving] && !ExoskeletonAPI.hasThermalBlacklist(e.getClass())){
          GL11.glPushMatrix();
          GL11.glTranslated(e.posX, e.posY, e.posZ);
          GL11.glEnable(GL11.GL_BLEND);
          GL11.glLineWidth(2.0F);
          GL11.glDisable(GL11.GL_TEXTURE_2D);
          GL11.glDisable(GL11.GL_CULL_FACE);
          GL11.glDepthMask(false);
          GL11.glDisable(GL11.GL_DEPTH_TEST);
          GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
          GL11.glEnable(GL11.GL_POLYGON_OFFSET_LINE);
          GL11.glPolygonOffset(-1.0F, -1.0F);
          GL11.glColorMask(true, false, false, false);
          RenderUtils.bindColor(0xFFFFFF);
          GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_LINE);
          RenderManager.instance.getEntityRenderObject(e).doRender(e, 0.0F, 0.0F, 0.0F, 0.0F, ev.partialTicks);
          GL11.glColorMask(true, true, true, true);
          GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
          GL11.glEnable(GL11.GL_CULL_FACE);
          GL11.glEnable(GL11.GL_TEXTURE_2D);
          GL11.glDisable(GL11.GL_BLEND);
          GL11.glEnable(GL11.GL_DEPTH_TEST);
          GL11.glDepthMask(true);
          GL11.glPopMatrix();
        }
      }

      GL11.glEnable(GL11.GL_LIGHTING);
      GL11.glPopMatrix();
    }
  }
}