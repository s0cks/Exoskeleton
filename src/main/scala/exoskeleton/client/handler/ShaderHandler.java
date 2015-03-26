package exoskeleton.client.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exoskeleton.common.lib.data.DataManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.Map;

public final class ShaderHandler{
    private boolean resetShaders;
    private int oldDisplayWidth;
    private int oldDisplayHeight;

    private static final Map<Integer, ShaderGroup> shaders = new HashMap<Integer, ShaderGroup>();

    private static final int SHADER_NIGHTVISION = 0x0;
    private static final int SHADER_THERMALVISION = 0x1;

    private static final ResourceLocation[] shader_resources = {
            new ResourceLocation("shaders/post/nightvision.json"),
            new ResourceLocation("shaders/post/thermalvision.json")
    };

    private static ShaderHandler instance;

    public static ShaderHandler instance(){
        return instance == null ? instance = new ShaderHandler() : instance;
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void renderShaders(Pre e){
        if(e.type == ElementType.ALL){
            Minecraft mc = Minecraft.getMinecraft();
            if(OpenGlHelper.shadersSupported){
                updateShaderFrameBuffers(mc);
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                for(ShaderGroup sg : shaders.values()){
                    GL11.glPushMatrix();
                    sg.loadShaderGroup(e.partialTicks);
                    GL11.glPopMatrix();
                }
            }
            mc.getFramebuffer().bindFramebuffer(true);
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void playerTick(PlayerTickEvent ev){
        if(ev.side == Side.SERVER){
            return;
        }

        if(ev.phase == Phase.START){
            Minecraft mc = Minecraft.getMinecraft();
            checkShaders(ev, mc);
        }
    }

    private void checkShaders(PlayerTickEvent ev, Minecraft mc){
        if(DataManager.get(ev.player).nightVisionEnabled()){
            try{
                setShader(new ShaderGroup(mc.getTextureManager(), mc.getResourceManager(), mc.getFramebuffer(), shader_resources[SHADER_NIGHTVISION]), SHADER_NIGHTVISION);
            } catch(Exception e){
                e.printStackTrace(System.err);
            }
        } else{
            deactivateShader(SHADER_NIGHTVISION);
        }

        if(DataManager.get(ev.player).thermal()){
            try{
                setShader(new ShaderGroup(mc.getTextureManager(), mc.getResourceManager(), mc.getFramebuffer(), shader_resources[SHADER_THERMALVISION]), SHADER_THERMALVISION);
            } catch(Exception e){
                e.printStackTrace(System.err);
            }
        } else{
            deactivateShader(SHADER_THERMALVISION);
        }
    }

    private void setShader(ShaderGroup shader, int index){
        if(OpenGlHelper.shadersSupported){
            if(shaders.containsKey(index)){
                shaders.get(index).deleteShaderGroup();
                shaders.remove(index);
            }

            try{
                if(shader == null){
                    deactivateShader(index);
                } else{
                    resetShaders = true;
                    shaders.put(index, shader);
                }
            } catch(Exception e){
                shaders.remove(index);
            }
        }
    }

    private void deactivateShader(int index){
        if(shaders.containsKey(index)){
            shaders.get(index).deleteShaderGroup();
        }

        shaders.remove(index);
    }

    private void updateShaderFrameBuffers(Minecraft mc){
        if ((resetShaders) || (mc.displayWidth != oldDisplayWidth) || (oldDisplayHeight != mc.displayHeight)) {
            for(ShaderGroup sg : shaders.values()){
                sg.createBindFramebuffers(mc.displayWidth, mc.displayHeight);
            }
            oldDisplayWidth = mc.displayWidth;
            oldDisplayHeight = mc.displayHeight;
            resetShaders = false;
        }
    }
}