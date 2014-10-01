package io.github.asyncronous.exoskeleton.render.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelExoHelmet
extends ModelBiped{
    ModelRenderer brace;
    ModelRenderer brace1;
    ModelRenderer brace2;
    ModelRenderer brace3;
    ModelRenderer brace4;
    ModelRenderer brace5;

    public ModelExoHelmet(){
        textureWidth = 128;
        textureHeight = 64;

        brace = new ModelRenderer(this, 56, 0);
        brace.addBox(0F, 0F, 0F, 9, 5, 2);
        brace.setRotationPoint(-4.51F, -6.5F, -3.6F);
        brace.setTextureSize(128, 64);
        brace.mirror = true;
        setRotation(brace, -0.0698132F, 0F, 0F);

        brace1 = new ModelRenderer(this, 56, 0);
        brace1.addBox(0F, 0F, 0F, 2, 5, 8);
        brace1.setRotationPoint(-1F, -4.5F, -3.5F);
        brace1.setTextureSize(128, 64);
        brace1.mirror = true;
        setRotation(brace1, 0F, 0F, 0F);

        brace2 = new ModelRenderer(this, 0, 32);
        brace2.addBox(0F, 0F, 0F, 5, 3, 8);
        brace2.setRotationPoint(-0.7F, -5.5F, -3.6F);
        brace2.setTextureSize(128, 64);
        brace2.mirror = true;
        setRotation(brace2, 0F, 0F, 0F);

        brace3 = new ModelRenderer(this, 56, 0);
        brace3.addBox(0F, 0F, 0F, 9, 2, 8);
        brace3.setRotationPoint(-4.5F, -6.5F, -3.5F);
        brace3.setTextureSize(128, 64);
        brace3.mirror = true;
        setRotation(brace3, 0F, 0F, 0F);

        brace4 = new ModelRenderer(this, 0, 32);
        brace4.addBox(0F, 0F, 0F, 9, 1, 9);
        brace4.setRotationPoint(-4.5F, -7.5F, -4.5F);
        brace4.setTextureSize(128, 64);
        brace4.mirror = true;
        setRotation(brace4, 0F, 0F, 0F);

        brace5 = new ModelRenderer(this, 0, 32);
        brace5.addBox(0F, 0F, 0F, 5, 3, 8);
        brace5.setRotationPoint(-4.3F, -5.5F, -3.6F);
        brace5.setTextureSize(128, 64);
        brace5.mirror = true;
        setRotation(brace5, 0F, 0F, 0F);

        this.bipedHead.cubeList.clear();
        this.bipedHeadwear.cubeList.clear();
        this.bipedEars.cubeList.clear();
        this.bipedHead.addChild(this.brace);
        this.bipedHead.addChild(this.brace1);
        this.bipedHead.addChild(this.brace2);
        this.bipedHead.addChild(this.brace3);
        this.bipedHead.addChild(this.brace4);
        this.bipedHead.addChild(this.brace5);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float scale){
        super.render(entity, f, f1, f2, f3, f4, scale);
        super.setRotationAngles(f, f1, f2, f3, f4, scale, entity);
    }

    private void prep(){
        bipedHead.isHidden = false;
        bipedBody.isHidden = false;
        bipedRightArm.isHidden = false;
        bipedLeftArm.isHidden = false;
        bipedRightLeg.isHidden = false;
        bipedLeftLeg.isHidden = false;

        bipedHead.showModel = true;
        bipedBody.showModel = true;
        bipedRightArm.showModel = true;
        bipedLeftArm.showModel = true;
        bipedRightLeg.showModel = true;
        bipedLeftLeg.showModel = true;
    }

    private void setRotation(ModelRenderer model, float x, float y, float z){
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}