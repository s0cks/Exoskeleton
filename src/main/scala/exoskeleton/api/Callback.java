package exoskeleton.api;

import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public interface Callback{
    public void on(PlayerTickEvent e);
}