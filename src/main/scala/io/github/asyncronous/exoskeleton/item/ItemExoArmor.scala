package io.github.asyncronous.exoskeleton.item

import cpw.mods.fml.relauncher.{Side, SideOnly}
import io.github.asyncronous.exoskeleton.Exoskeleton
import io.github.asyncronous.exoskeleton.render.model.{ModelExoBoots, ModelExoChest}
import net.minecraft.client.model.ModelBiped
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemArmor.ArmorMaterial
import net.minecraft.item.{ItemArmor, ItemStack}

class ItemExoArmor(index: Int)
extends ItemArmor(ArmorMaterial.IRON, 0, index){
  private val modelChest: ModelBiped = new ModelExoChest();
  private val modelBoots: ModelBiped = new ModelExoBoots();

  this.setCreativeTab(Exoskeleton.tab);

  @SideOnly(Side.CLIENT)
  override def getArmorModel(entityLiving: EntityLivingBase, itemStack: ItemStack, armorSlot: Int): ModelBiped={
    armorSlot match
    {
      case 1 =>{
        return this.modelChest;
      }
      case 3 =>{
        return this.modelBoots;
      }
      case _ =>{
        return super.getArmorModel(entityLiving, itemStack, armorSlot);
      }
    }
  }
}