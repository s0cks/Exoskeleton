package exoskeleton.client.particles;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public class EntitySmokeCloudFX
extends EntityFX{
    private double gravity = 0.004D;

    public EntitySmokeCloudFX(World world, double x, double y, double z){
        super(world, x, y, z, 0.0D, 0.0D, 0.0D);
        this.motionX *= 0.1;
        this.motionY *= 0.1;
        this.motionZ *= 0.1;
        this.particleScale *= 0.75F;
        this.particleMaxAge = (int) (24.0D / (Math.random() * 0.5D + 0.2D));
        this.particleMaxAge = (int) (this.particleMaxAge * 3.0F);
        this.noClip = true;
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge){
            this.setDead();
        }

        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.motionY += gravity;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);

        if (this.posY == this.prevPosY) {
            this.motionX *= 1.1D;
            this.motionZ *= 1.1D;
        }

        this.motionX *= 0.96D;
        this.motionY *= 0.96D;
        this.motionZ *= 0.96D;

        if (this.onGround) {
            this.motionX *= 0.67D;
            this.motionZ *= 0.67D;
        }
    }
}