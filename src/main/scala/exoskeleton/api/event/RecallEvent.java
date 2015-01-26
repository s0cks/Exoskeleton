package exoskeleton.api.event;

import net.minecraft.entity.player.EntityPlayer;

public class RecallEvent{
    public final EntityPlayer player;

    public RecallEvent(EntityPlayer player){
        this.player = player;
    }
}