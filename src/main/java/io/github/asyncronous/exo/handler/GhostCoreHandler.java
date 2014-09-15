package io.github.asyncronous.exo.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import io.github.asyncronous.exo.EXOTag;

public class GhostCoreHandler{
    @SubscribeEvent
    public void onTick(LivingUpdateEvent e){
        if(e.entityLiving instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) e.entityLiving;
            ItemStack chest = player.inventory.armorInventory[2];
            if(chest != null){
                System.out.println("Found Chest");
                NBTTagCompound comp = EXOTag.getTag(chest);
                if(comp.getBoolean("invisNight")){
                    System.out.println("Found Tag");
                    if(!Minecraft.getMinecraft().theWorld.provider.isDaytime()){
                        System.out.println("Setting Player Invisible");
                        player.setInvisible(true);
                    }
                }
            }

            player.setInvisible(false);
        }
    }
}