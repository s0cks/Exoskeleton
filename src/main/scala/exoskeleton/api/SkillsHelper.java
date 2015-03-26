package exoskeleton.api;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public final class SkillsHelper{
    public static boolean hasSkill(ItemStack stack, String tree, String skill){
        if(stack == null) return false;
        NBTTagCompound comp = ExoskeletonTag.getTag(stack);
        if(comp.hasKey(tree)){
            NBTTagCompound treeComp = comp.getCompoundTag(tree);
            return treeComp.hasKey(skill);
        }
        return false;
    }
}