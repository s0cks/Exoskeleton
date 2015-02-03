package exoskeleton.api.utils;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import exoskeleton.api.Callback;

public class CountdownTimer{
    private final int max;
    private final Callback callback;
    private int counter;

    public CountdownTimer(int max, Callback callback){
        this.callback = callback;
        this.max = max;
        this.counter = max;
    }

    @SubscribeEvent
    public void onTick(PlayerTickEvent e){
        if(e.phase == Phase.END && e.side.isServer()){
            if(this.counter <= 0){
                this.callback.on(e);
                this.counter = this.max;
            } else{
                this.counter--;
            }
        }
    }
}