package exoskeleton.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;

public class ModelExoBoots
extends ModelBiped{
    ModelRenderer jointR;
    ModelRenderer footR;
    ModelRenderer jointL;
    ModelRenderer braceR;
    ModelRenderer footL;
    ModelRenderer padL;
    ModelRenderer padR;
    ModelRenderer braceL;

    public ModelExoBoots(){
        textureWidth = 128;
        textureHeight = 64;

        jointR = new ModelRenderer(this, 56, 0);
        jointR.addBox(-1F, -2F, -2F, 1, 2, 2);
        jointR.setRotationPoint(-3.6F, 18.5F, 1F);
        jointR.setTextureSize(128, 64);
        jointR.mirror = true;

        setRotation(jointR, 0F, 0F, 0F);
        footR = new ModelRenderer(this, 56, 0);
        footR.addBox(-1F, -2F, -2F, 5, 1, 5);
        footR.setRotationPoint(-3.7F, 24F, -0.5F);
        footR.setTextureSize(128, 64);
        footR.mirror = true;
        setRotation(footR, 0F, 0F, 0F);

        jointL = new ModelRenderer(this, 56, 0);
        jointL.addBox(-1F, -2F, -2F, 1, 2, 2);
        jointL.setRotationPoint(4.6F, 18.5F, 1F);
        jointL.setTextureSize(128, 64);
        jointL.mirror = true;
        setRotation(jointL, 0F, 0F, 0F);

        braceR = new ModelRenderer(this, 56, 0);
        braceR.addBox(-1F, -2F, -2F, 1, 5, 1);
        braceR.setRotationPoint(-3.4F, 19.5F, 1.5F);
        braceR.setTextureSize(128, 64);
        braceR.mirror = true;
        setRotation(braceR, 0F, 0F, 0F);

        footL = new ModelRenderer(this, 56, 0);
        footL.addBox(-1F, -2F, -2F, 5, 1, 5);
        footL.setRotationPoint(0.5F, 24F, -0.5F);
        footL.setTextureSize(128, 64);
        footL.mirror = true;
        setRotation(footL, 0F, 0F, 0F);

        padL = new ModelRenderer(this, 0, 32);
        padL.addBox(0F, 0F, 0F, 4, 1, 5);
        padL.setRotationPoint(0.4F, 23.01F, -2.5F);
        padL.setTextureSize(128, 64);
        padL.mirror = true;
        setRotation(padL, 0F, 0F, 0F);

        padR = new ModelRenderer(this, 0, 32);
        padR.addBox(0F, 0F, 0F, 4, 1, 5);
        padR.setRotationPoint(-4.4F, 23.01F, -2.5F);
        padR.setTextureSize(128, 64);
        padR.mirror = true;
        setRotation(padR, 0F, 0F, 0F);

        braceL = new ModelRenderer(this, 56, 0);
        braceL.addBox(-1F, -2F, -2F, 1, 5, 1);
        braceL.setRotationPoint(4.4F, 19.5F, 1.5F);
        braceL.setTextureSize(128, 64);
        braceL.mirror = true;
        setRotation(braceL, 0F, 0F, 0F);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z){
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}