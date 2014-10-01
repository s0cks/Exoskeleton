package io.github.asyncronous.exoskeleton.item

import cpw.mods.fml.relauncher.{Side, SideOnly}
import io.github.asyncronous.exoskeleton.Exoskeleton
import io.github.asyncronous.exoskeleton.render.model.{ModelExoHelmet, ModelExoBoots, ModelExoChest}
import net.minecraft.client.model.ModelBiped
import net.minecraft.entity.{Entity, EntityLivingBase}
import net.minecraft.item.ItemArmor.ArmorMaterial
import net.minecraft.item.{ItemArmor, ItemStack}
import net.minecraft.util.ResourceLocation

class ItemExoArmor(index: Int)
extends ItemArmor(ArmorMaterial.IRON, 0, index){
  private val modelChest: ModelBiped = new ModelExoChest();
  private val modelBoots: ModelBiped = new ModelExoBoots();
  private val modelHelm: ModelBiped = new ModelExoHelmet();
  private val texture: ResourceLocation = new ResourceLocation("exo", "textures/armor/exo_armor.png");

  this.setCreativeTab(Exoskeleton.tab);

  override def getArmorTexture(stack: ItemStack, entity: Entity, slot: Int, t: String): String={
    return this.texture.toString();
  }

  @SideOnly(Side.CLIENT)
  override def getArmorModel(entityLiving: EntityLivingBase, itemStack: ItemStack, armorSlot: Int): ModelBiped={
    armorSlot match
    {
      case 0 =>{
        return this.modelHelm;
      }
      case 1 =>{
        return this.modelChest;
      }
      case 3 =>{
        return this.modelBoots;
      }
      case _ =>{
        return null;
      }
    }
  }
}