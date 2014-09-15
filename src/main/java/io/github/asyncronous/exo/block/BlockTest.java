package io.github.asyncronous.exo.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import io.github.asyncronous.exo.EXOTag;
import io.github.asyncronous.exo.Exoskeleton;
import io.github.asyncronous.exo.item.ItemCore;
import io.github.asyncronous.exo.item.ItemExoskeletonArmor;
import io.github.asyncronous.exo.tile.TileTestBlock;

public class BlockTest
extends BlockContainer{
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
                TileTestBlock tile = (TileTestBlock) world.getTileEntity(x, y, z);
                tile.getCore().write(EXOTag.getTag(stack), armor);
            } else if(stack.getItem() instanceof ItemCore){
                TileTestBlock tile = (TileTestBlock) world.getTileEntity(x, y, z);
                tile.setCore(((ItemCore) stack.getItem()).core);
            }
        } else{
            TileTestBlock tile = (TileTestBlock) world.getTileEntity(x, y, z);
            player.addChatComponentMessage(new ChatComponentText("Core: " + tile.getCore().getName()));
        }

        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_){
        return new TileTestBlock();
    }
}