package exoskeleton;

import exoskeleton.api.ExoskeletonCores;
import exoskeleton.common.core.CoreReflex$;
import exoskeleton.common.lib.skills.PlayerSkills;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;

public class Hooks{
    public static boolean shouldAttackPlayer(EntityEnderman enderman, EntityPlayer player){
        ItemStack itemstack = player.inventory.armorInventory[3];

        if (itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.pumpkin)){
            return false;
        } else if(itemstack != null && ExoskeletonCores.findCore(itemstack) == CoreReflex$.MODULE$ && PlayerSkills.get(player).hasSkill("reflex", "noEnderman")){
            return false;
        } else {
            Vec3 vec3 = player.getLook(1.0F).normalize();
            Vec3 vec31 = Vec3.createVectorHelper(enderman.posX - player.posX, enderman.boundingBox.minY + (double)(enderman.height / 2.0F) - (player.posY + (double)player.getEyeHeight()), enderman.posZ - player.posZ);
            double d0 = vec31.lengthVector();
            vec31 = vec31.normalize();
            double d1 = vec3.dotProduct(vec31);
            return d1 > 1.0D - 0.025D / d0 && player.canEntityBeSeen(enderman);
        }
    }
}