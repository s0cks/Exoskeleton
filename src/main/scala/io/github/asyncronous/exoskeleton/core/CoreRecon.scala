package io.github.asyncronous.exoskeleton.core

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.potion.{Potion, PotionEffect}
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingAttackEvent

object CoreRecon
extends AbstractCore("recon"){
  override def onJump(player: EntityPlayer): Unit ={
    player.motionY += 0.2D;
  }

  override def onAttacked(e: LivingAttackEvent, player: EntityPlayer, source: DamageSource): Unit ={
    if(source == DamageSource.drown){
      e.setCanceled(true);
    }
  }

  override def onUpdate(player: EntityPlayer): Unit ={
    player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 400));
  }
}