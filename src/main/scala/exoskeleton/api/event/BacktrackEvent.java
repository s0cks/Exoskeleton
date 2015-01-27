package exoskeleton.api.event;

import net.minecraft.entity.player.EntityPlayer;

public class BacktrackEvent{
    public final EntityPlayer player;

    public BacktrackEvent(EntityPlayer player){
        this.player = player;
    }
}