package exoskeleton.common.handler

import cpw.mods.fml.client.FMLClientHandler
import cpw.mods.fml.client.registry.ClientRegistry
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.TickEvent.{Phase, PlayerTickEvent}
import cpw.mods.fml.relauncher.Side
import exoskeleton.common.lib.ArmorHelper
import exoskeleton.common.network._
import net.minecraft.client.settings.KeyBinding
import org.lwjgl.input.Keyboard

object KeyHandler{
  private val key_function = new KeyBinding("key.function.desc", Keyboard.KEY_F, "key.exoskeleton.category");
  private val key_recall = new KeyBinding("key.recall.desc", Keyboard.KEY_R, "key.exoskeleton.category");
  private val key_blink = new KeyBinding("key.blink.desc", Keyboard.KEY_B, "key.exoskeleton.category");
  private val key_backtrack = new KeyBinding("key.backtrack.desc", Keyboard.KEY_V, "key.exoskeleton.category");
  private val key_autosmelt = new KeyBinding("key.autosmelt.desc", Keyboard.KEY_G, "key.exoskeleton.category");

  ClientRegistry.registerKeyBinding(this.key_function);
  ClientRegistry.registerKeyBinding(this.key_recall);
  ClientRegistry.registerKeyBinding(this.key_blink);
  ClientRegistry.registerKeyBinding(this.key_backtrack);
  ClientRegistry.registerKeyBinding(this.key_autosmelt);

  @SubscribeEvent
  def onTick(e: PlayerTickEvent): Unit ={
    if(e.side == Side.SERVER){
      return;
    }

    if(e.phase == Phase.START){
      if(this.key_function.isPressed && FMLClientHandler.instance().getClient.inGameHasFocus){
        if(ArmorHelper.fadable(e.player)){
          PacketHandler.instance.sendToServer(new PacketPlayerFade());
        } else if(ArmorHelper.flight(e.player)){
          PacketHandler.instance.sendToServer(new PacketToggleFlight());
        }
      }

      if(this.key_recall.isPressed && FMLClientHandler.instance().getClient.inGameHasFocus){
        if(ArmorHelper.recallable(e.player)){
          PacketHandler.instance.sendToServer(new PacketRecall());
        }
      }

      if(this.key_blink.isPressed && FMLClientHandler.instance().getClient.inGameHasFocus){
        if(ArmorHelper.blinkable(e.player)){
          PacketHandler.instance.sendToServer(new PacketBlink());
        }
      }

      if(this.key_backtrack.isPressed && FMLClientHandler.instance().getClient.inGameHasFocus){
        if(ArmorHelper.backtrack(e.player)){
          PacketHandler.instance.sendToServer(new PacketBacktrack());
        }
      }

      if(this.key_autosmelt.isPressed && FMLClientHandler.instance().getClient.inGameHasFocus){
        if(ArmorHelper.autosmelt(e.player)){
          PacketHandler.instance.sendToServer(new PacketToggleAutoSmelt());
        }
      }
    }
  }
}