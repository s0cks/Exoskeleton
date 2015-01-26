package exoskeleton.api.event;

import net.minecraft.entity.player.EntityPlayer;

public class BlinkEvent{
    public final EntityPlayer player;

    public BlinkEvent(EntityPlayer player){
        this.player = player;
    }
}