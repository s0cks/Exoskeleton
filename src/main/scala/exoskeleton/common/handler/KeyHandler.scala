package exoskeleton.common.handler

import cpw.mods.fml.client.FMLClientHandler
import cpw.mods.fml.client.registry.ClientRegistry
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.TickEvent.{Phase, PlayerTickEvent}
import cpw.mods.fml.relauncher.Side
import exoskeleton.api.ExoskeletonAPI
import exoskeleton.api.event.{BlinkEvent, RecallEvent}
import exoskeleton.common.lib.ArmorHelper
import exoskeleton.common.network.{PacketHandler, PacketPlayerFade}
import net.minecraft.client.settings.KeyBinding
import org.lwjgl.input.Keyboard

object KeyHandler{
  private val key_fade = new KeyBinding("key.fade.desc", Keyboard.KEY_F, "key.exoskeleton.category");
  private val key_recall = new KeyBinding("key.recall.desc", Keyboard.KEY_R, "key.exoskeleton.category");
  private val key_blink = new KeyBinding("key.blink.desc", Keyboard.KEY_B, "key.exoskeleton.category");

  ClientRegistry.registerKeyBinding(this.key_fade);
  ClientRegistry.registerKeyBinding(this.key_recall);
  ClientRegistry.registerKeyBinding(this.key_blink);

  @SubscribeEvent
  def onTick(e: PlayerTickEvent): Unit ={
    if(e.side == Side.SERVER){
      return;
    }

    if(e.phase == Phase.START){
      if(this.key_fade.isPressed && FMLClientHandler.instance().getClient.inGameHasFocus){
        if(ArmorHelper.fadable(e.player)){
          PacketHandler.instance.sendToServer(new PacketPlayerFade(e.player));
        }
      }

      if(this.key_recall.isPressed && FMLClientHandler.instance().getClient.inGameHasFocus){
        if(ArmorHelper.recallable(e.player)){
          ExoskeletonAPI.event_bus.post(new RecallEvent(e.player));
        }
      }

      if(this.key_blink.isPressed && FMLClientHandler.instance().getClient.inGameHasFocus){
        if(ArmorHelper.blinkable(e.player)){
          ExoskeletonAPI.event_bus.post(new BlinkEvent(e.player));
        }
      }
    }
  }
}