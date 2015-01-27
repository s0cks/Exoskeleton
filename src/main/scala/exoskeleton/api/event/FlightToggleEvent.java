package exoskeleton.api.event;

import net.minecraft.entity.player.EntityPlayer;

public class FlightToggleEvent{
    public final EntityPlayer player;

    public FlightToggleEvent(EntityPlayer player){
        this.player = player;
    }
}