package exoskeleton.api.utils;

import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public interface Callback{
    public void on(PlayerTickEvent e);
}