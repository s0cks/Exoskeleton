package exoskeleton.common.item

import java.util

import cpw.mods.fml.relauncher.{Side, SideOnly}
import exoskeleton.api.ExoskeletonTag
import exoskeleton.api.utils.StringUtils
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
  private val texture: ResourceLocation = new ResourceLocation("exo", "textures/armor/exo_armor.png");

  this.setCreativeTab(Exoskeleton.tab);

  @SideOnly(Side.CLIENT)
  override def getArmorTexture(stack: ItemStack, entity: Entity, slot: Int, t: String): String={
    return this.texture.toString();
  }

  @SideOnly(Side.CLIENT)
  override def getArmorModel(entityLiving: EntityLivingBase, itemStack: ItemStack, armorSlot: Int): ModelBiped={
    armorSlot match
    {
      case 3 =>{
        return ModelExoBoots.instance();
      }
      case _ =>{
        return null;
      }
    }
  }

  override def getRenderPasses(meta: Int): Int={
    return 2;
  }

  @SideOnly(Side.CLIENT)
  override def addInformation(stack: ItemStack, player: EntityPlayer, list: util.List[_], b: Boolean): Unit ={
    if(stack.hasTagCompound && stack.getTagCompound.hasKey(ExoskeletonTag.IDENTIFIER)){
      val comp = ExoskeletonTag.getTag(stack);
      val ls: util.List[String] = list.asInstanceOf[util.List[String]];
      ls.add("Current Core: " + StringUtils.capitalize(comp.getString("coreName")));
    }
  }
}