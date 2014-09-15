package io.github.asyncronous.exo.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;

import io.github.asyncronous.exo.EXOTag;
import io.github.asyncronous.exo.item.ItemExoskeletonLeggings;

public final class ReconCoreHandler{
    @SubscribeEvent
    public void onDrown(LivingAttackEvent e){
        if(e.entityLiving instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) e.entityLiving;
            ItemStack helm = player.inventory.armorInventory[3];
            if(helm != null){
                NBTTagCompound comp = EXOTag.getTag(helm);
                if(comp.getBoolean("noDrown")){
                    if(e.source == DamageSource.drown){
                        e.setCanceled(true);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onUpdate(LivingUpdateEvent e){
        if(e.entityLiving instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) e.entityLiving;
            ItemStack helm = player.inventory.armorInventory[3];
            if(helm != null){
                NBTTagCompound comp = EXOTag.getTag(helm);
                if(comp.getBoolean("nightvision")){

                }
            }
        }
    }

    @SubscribeEvent
    public void onRun(LivingUpdateEvent e){
        if(e.entityLiving instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) e.entityLiving;
            ItemStack boots = player.inventory.armorInventory[0];
            if(boots != null){
                NBTTagCompound comp = EXOTag.getTag(boots);
                if((player.onGround || player.capabilities.isFlying) && player.moveForward > 0.0F && !player.isInsideOfMaterial(
                        Material.water)){
                    player.moveFlying(0.0F, 1.0F, player.capabilities.isFlying ? (float) comp.getDouble("speed") : (float) comp.getDouble("speed") * 2);
                }

                player.stepHeight = 1.0F;
            } else{
                player.stepHeight = 0.5F;
            }
        }
    }

    @SubscribeEvent
    public void onJump(LivingJumpEvent e){
        if(e.entityLiving instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) e.entityLiving;
            ItemStack legs = player.inventory.armorInventory[1];
            if(legs != null){
                if(legs.getItem() instanceof ItemExoskeletonLeggings){
                    NBTTagCompound comp = EXOTag.getTag(legs);
                    player.motionY += comp.getDouble("jumpBoost");
                }
            }
        }
    }

    @SubscribeEvent
    public void onFall(LivingFallEvent e){
        if(e.entityLiving instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) e.entityLiving;
            ItemStack legs = player.inventory.armorInventory[1];
            if(legs != null){
                if(legs.getItem() instanceof ItemExoskeletonLeggings){
                    NBTTagCompound comp = EXOTag.getTag(legs);
                    if(comp.getBoolean("negateFallDamage")){
                        e.setCanceled(true);
                    }
                }
            }
        }
    }
}