package io.github.asyncronous.exo.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import io.github.asyncronous.exo.EXOTag;
import io.github.asyncronous.exo.item.ItemExoskeletonArmor;

public final class EXOToolTipHandler{
    @SubscribeEvent
    public void onToolTip(ItemTooltipEvent e){
        if(e.itemStack.getItem() instanceof ItemExoskeletonArmor){
            NBTTagCompound comp = EXOTag.getTag(e.itemStack);
            e.toolTip.add("Core: " + comp.getString("coreName"));
        }
    }
}