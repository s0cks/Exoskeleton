package exoskeleton.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public final class ModelExoHelmet
extends ModelBiped{
    private final IModelCustom model;

    public ModelExoHelmet(){
        model = AdvancedModelLoader.loadModel(new ResourceLocation("exo", "models/exo_helm.tcn"));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float scale){
        this.setRotationAngles(f, f1, f2, f3, f4, scale, entity);
        GL11.glPushMatrix();
        GL11.glScaled(1.2, 1.2, 1.2);
        model.renderAll();
        GL11.glPopMatrix();
    }
}