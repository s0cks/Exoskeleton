package exoskeleton.api.item;

import net.minecraft.item.ItemStack;

public interface IToolbox{
    public void setInventory(ItemStack stack, ItemStack[] items);
    public ItemStack[] getInventory(ItemStack stack);
}