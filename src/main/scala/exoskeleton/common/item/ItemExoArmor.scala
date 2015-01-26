package exoskeleton.common.item

import java.util

import cpw.mods.fml.relauncher.{Side, SideOnly}
import exoskeleton.api.ExoskeletonTag
import exoskeleton.client.model.ModelExoBoots
import exoskeleton.common.Exoskeleton
import net.minecraft.client.model.ModelBiped
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.{Entity, EntityLivingBase}
import net.minecraft.item.ItemArmor.ArmorMaterial
import net.minecraft.item.{ItemArmor, ItemStack}
import net.minecraft.util.ResourceLocation;

class ItemExoArmor(index: Int)
extends ItemArmor(ArmorMaterial.IRON, 0, index){
  private val modelBoots: ModelBiped = new ModelExoBoots();
  private val texture: ResourceLocation = new ResourceLocation("exo", "textures/armor/exo_armor.png");

  this.setCreativeTab(Exoskeleton.tab);

  override def getArmorTexture(stack: ItemStack, entity: Entity, slot: Int, t: String): String={
    return this.texture.toString();
  }

  @SideOnly(Side.CLIENT)
  override def getArmorModel(entityLiving: EntityLivingBase, itemStack: ItemStack, armorSlot: Int): ModelBiped={
    armorSlot match
    {
      case 3 =>{
        return this.modelBoots;
      }
      case _ =>{
        return null;
      }
    }
  }

  @SideOnly(Side.CLIENT)
  override def addInformation(stack: ItemStack, player: EntityPlayer, list: util.List[_], b: Boolean): Unit ={
    if(stack.hasTagCompound && stack.getTagCompound.hasKey(ExoskeletonTag.IDENTIFIER)){
      val comp = ExoskeletonTag.getTag(stack);
      val ls: util.List[String] = list.asInstanceOf[util.List[String]];
      ls.add("Current Core: " + comp.getString("coreName"));
    }
  }
}