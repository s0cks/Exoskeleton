package exoskeleton.api

import net.minecraft.client.Minecraft

trait Overlay{
  def draw(minecraft: Minecraft);
}