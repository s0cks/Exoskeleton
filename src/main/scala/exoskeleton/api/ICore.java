package exoskeleton.api;

import exoskeleton.api.skill.Tree;
import exoskeleton.api.utils.OverlaySet;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public interface ICore{
    public String getID();
    public Tree getTree();
    public void onJump(EntityPlayer player);
    public void onAttacked(LivingAttackEvent e, EntityPlayer player, DamageSource source);
    public void onUpdate(EntityPlayer player);
    public void onHud(EntityPlayer player);
    public void onHarvest(HarvestDropsEvent e);
    public float getBreakSpeedModifier(EntityPlayer player, Block b, int meta, float oldSpeed);
    public OverlaySet overlay();
}