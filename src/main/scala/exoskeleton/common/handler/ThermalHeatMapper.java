package exoskeleton.common.handler;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import exoskeleton.api.ExoskeletonAPI;
import exoskeleton.api.HeatValue;
import exoskeleton.api.utils.RenderUtils;
import exoskeleton.common.lib.data.DataManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import org.lwjgl.opengl.GL11;

public class ThermalHeatMapper{
    private static ThermalHeatMapper instance;

    public static ThermalHeatMapper instance(){
        return instance == null ? instance = new ThermalHeatMapper() : instance;
    }

    @SubscribeEvent
    public void doHeatMapping(RenderWorldLastEvent ev){
        EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
        if(DataManager.get(player).thermal()){
            GL11.glPushMatrix();
            Entity e = FMLClientHandler.instance().getClient().renderViewEntity;
            RenderUtils.translateToWorldCoords(e, ev.partialTicks);
            renderHeatMap(e);
            GL11.glPopMatrix();
        }
    }

    private void renderHeatMap(Entity e){
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        World world = e.worldObj;
        int range = 16;
        int x = (int) e.posX;
        int y = (int) e.posY;
        int z = (int) e.posZ;

        for(int i = x - range; i <= x + range; i++){
            for(int k = z - range; k <= z + range; k++){
                for(int j = y - range; j < y + range; j++){
                    HeatValue value = ExoskeletonAPI.getHeatValue(world.getBlock(i, j, k));

                    if(value != null){
                        GL11.glPushMatrix();
                        value.bind();
                        RenderUtils.renderQuad(i, j, k);
                        GL11.glPopMatrix();
                    }
                }
            }
        }

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
    }
}