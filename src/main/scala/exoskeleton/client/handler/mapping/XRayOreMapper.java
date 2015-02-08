package exoskeleton.client.handler.mapping;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import exoskeleton.api.ExoskeletonAPI;
import exoskeleton.api.utils.RenderUtils;
import exoskeleton.common.ExoConfiguration;
import exoskeleton.common.lib.data.DataManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import org.lwjgl.opengl.GL11;

public final class XRayOreMapper{
    private static XRayOreMapper instance;

    public static XRayOreMapper instance(){
        return instance == null ? instance = new XRayOreMapper() : instance;
    }

    @SubscribeEvent
    public void doXRay(RenderWorldLastEvent ev){
        EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
        if(DataManager.get(player).xray()){
            GL11.glPushMatrix();
            Entity e = FMLClientHandler.instance().getClient().renderViewEntity;
            RenderUtils.translateToWorldCoords(e, ev.partialTicks);
            this.renderXRay(e);
            GL11.glPopMatrix();
        }
    }

    private void renderXRay(Entity e){
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        World world = e.worldObj;
        int range = 24 / 2;
        int x = (int) e.posX;
        int y = (int) e.posY;
        int z = (int) e.posZ;

        for(int i = x - range; i <= x + range; i++){
            for(int k = z - range; k <= z + range; k++){
                for(int j = y - range; j < y + range; j++){
                    if(ExoskeletonAPI.isXRayable(world.getBlock(i, j, k))){
                        GL11.glPushMatrix();
                        RenderUtils.drawWireframe(i, j, k, ExoConfiguration.xray_color());
                        GL11.glPopMatrix();
                    }
                }
            }
        }

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
    }
}