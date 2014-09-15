package io.github.asyncronous.exo.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;

import io.github.asyncronous.exo.EXOTag;
import io.github.asyncronous.exo.item.ItemExoskeletonBoots;

public final class ReflexCoreHandler{
    @SubscribeEvent
    public void reflexJump(LivingJumpEvent e){
        if(e.entityLiving instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) e.entityLiving;
            ItemStack boots = player.inventory.armorInventory[0];
            if(boots != null){
                if(boots.getItem() instanceof ItemExoskeletonBoots){
                    NBTTagCompound comp = EXOTag.getTag(boots);
                    player.motionY += comp.getDouble("jumpBoost");
                }
            }
        }
    }

    @SubscribeEvent
    public void reflexFall(LivingFallEvent e){
        if(e.entityLiving instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) e.entityLiving;
            ItemStack boots = player.inventory.armorInventory[0];
            if(boots != null){
                if(boots.getItem() instanceof ItemExoskeletonBoots){
                    NBTTagCompound comp = EXOTag.getTag(boots);
                    if(comp.getBoolean("negateFallDamage")){
                        e.setCanceled(true);
                    }
                }
            }
        }
    }
}