package exoskeleton.api.event;

import net.minecraft.entity.player.EntityPlayer;

public class AutoSmeltToggleEvent{
    public final EntityPlayer player;

    public AutoSmeltToggleEvent(EntityPlayer player){
        this.player = player;
    }
}