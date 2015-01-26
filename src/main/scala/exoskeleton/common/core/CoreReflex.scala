package exoskeleton.common.core

import java.util.Random

import exoskeleton.api.Tree
import exoskeleton.client.MotorBlock
import net.minecraft.block.Block
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingAttackEvent
import org.lwjgl.opengl.GL11

object CoreReflex
extends AbstractCore("reflex"){
  private val rand = new Random();

  override def getTree(): Tree ={
    return null;
  }

  override def onAttacked(e: LivingAttackEvent, player: EntityPlayer, source: DamageSource): Unit ={

  }

  override def onUpdate(player: EntityPlayer): Unit ={

  }

  override def getBreakSpeedModifier(player: EntityPlayer, b: Block, meta: Int, oldSpeed: Float): Float ={
    return oldSpeed;
  }

  override def onHud(player: EntityPlayer): Unit ={
    GL11.glPopMatrix();

    MotorBlock.drawString("Reflex", 0, 20, 3.0F);

    GL11.glPushMatrix();
  }

  override def onJump(player: EntityPlayer): Unit ={

  }
}