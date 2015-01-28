package exoskeleton.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public final class ModelExoBoots
extends ModelBiped{
    private static ModelExoBoots instance;

    public static ModelExoBoots instance(){
        return instance == null ? instance = new ModelExoBoots() : instance;
    }

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
        jointR.addBox(-2.8F, 4F, -1F, 1, 2, 2);
        jointR.setRotationPoint(-2F, 12F, 0F);
        jointR.setTextureSize(128, 64);
        jointR.mirror = true;
        setRotation(jointR, 0F, 0F, 0F);
        this.bipedRightLeg.addChild(this.jointR);

        footR = new ModelRenderer(this, 56, 0);
        footR.addBox(-3F, 10F, -2.5F, 5, 1, 5);
        footR.setRotationPoint(-2F, 12F, 0F);
        footR.setTextureSize(128, 64);
        footR.mirror = true;
        setRotation(footR, 0F, 0F, 0F);
        this.bipedRightLeg.addChild(this.footR);

        jointL = new ModelRenderer(this, 56, 0);
        jointL.addBox(1.8F, 4F, -1F, 1, 2, 2);
        jointL.setRotationPoint(2F, 12F, 0F);
        jointL.setTextureSize(128, 64);
        jointL.mirror = true;
        setRotation(jointL, 0F, 0F, 0F);
        this.bipedLeftLeg.addChild(this.jointL);

        braceR = new ModelRenderer(this, 56, 0);
        braceR.addBox(-2.5F, 5.5F, -0.5F, 1, 5, 1);
        braceR.setRotationPoint(-2F, 12F, 0F);
        braceR.setTextureSize(128, 64);
        braceR.mirror = true;
        setRotation(braceR, 0F, 0F, 0F);
        this.bipedRightLeg.addChild(this.braceR);

        footL = new ModelRenderer(this, 56, 0);
        footL.addBox(-2F, 10F, -2.5F, 5, 1, 5);
        footL.setRotationPoint(2F, 12F, 0F);
        footL.setTextureSize(128, 64);
        footL.mirror = true;
        setRotation(footL, 0F, 0F, 0F);
        this.bipedLeftLeg.addChild(this.footL);

        padL = new ModelRenderer(this, 0, 32);
        padL.addBox(-1.5F, 11F, -2.5F, 4, 1, 5);
        padL.setRotationPoint(2F, 12F, 0F);
        padL.setTextureSize(128, 64);
        padL.mirror = true;
        setRotation(padL, 0F, 0F, 0F);
        this.bipedLeftLeg.addChild(this.padL);

        padR = new ModelRenderer(this, 0, 32);
        padR.addBox(-2.5F, 11F, -2.5F, 4, 1, 5);
        padR.setRotationPoint(-2F, 12F, 0F);
        padR.setTextureSize(128, 64);
        padR.mirror = true;
        setRotation(padR, 0F, 0F, 0F);
        this.bipedRightLeg.addChild(this.padR);

        braceL = new ModelRenderer(this, 56, 0);
        braceL.addBox(1.5F, 5.5F, -0.5F, 1, 5, 1);
        braceL.setRotationPoint(2F, 12F, 0F);
        braceL.setTextureSize(128, 64);
        braceL.mirror = true;
        setRotation(braceL, 0F, 0F, 0F);
        this.bipedLeftLeg.addChild(this.braceL);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z){
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5){
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.bipedLeftLeg.render(f5);
        this.bipedRightLeg.render(f5);
    }
}