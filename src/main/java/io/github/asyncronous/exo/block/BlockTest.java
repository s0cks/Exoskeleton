package io.github.asyncronous.exo.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import io.github.asyncronous.exo.Cores;
import io.github.asyncronous.exo.EXOTag;
import io.github.asyncronous.exo.Exoskeleton;
import io.github.asyncronous.exo.item.ItemExoskeletonArmor;

public class BlockTest
extends Block{
    public BlockTest(){
        super(Material.iron);
        this.setCreativeTab(Exoskeleton.tab);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_){
        ItemStack stack = player.getCurrentEquippedItem();
        if(stack != null){
            if(stack.getItem() instanceof ItemExoskeletonArmor){
                ItemExoskeletonArmor armor = (ItemExoskeletonArmor) stack.getItem();
                Cores.coreReflex.write(EXOTag.getTag(stack), armor);
            }
        }

        return true;
    }
}