package exoskeleton.api

import java.util

import cpw.mods.fml.common.registry.GameRegistry
import exoskeleton.api.skill.Tree
import exoskeleton.common.item.ItemCore
import net.minecraft.item.ItemStack

import scala.collection.JavaConversions._

object ExoskeletonCores{
  private val cores: util.List[ICore] = new util.LinkedList[ICore]();
  private val items = new util.HashMap[ICore, ItemStack]();

  def registerItems(): Unit ={
    for(c: ICore <- this.cores){
      val item = new ItemCore(c);
      val stack = new ItemStack(item);

      GameRegistry.registerItem(item, "itemICore_" + c.getID());

      items.put(c, stack);
    }
  }

  def getItemByName(n: String): ItemStack={
    val c = this.getByName(n);
    return this.items.get(c).copy();
  }

  def getItemByCore(c: ICore): ItemStack={
    return this.items.get(c).copy();
  }

  def registerCore(c: ICore): Unit ={
    this.cores.add(c);
  }

  def getByName(n: String): ICore={
    for(c: ICore <- this.cores){
      if(c.getID().equalsIgnoreCase(n)){
        return c;
      }
    }

    return null;
  }

  def findCore(stack: ItemStack): ICore={
    if(stack.hasTagCompound() &&
       stack.getTagCompound.hasKey(ExoskeletonTag.IDENTIFIER)){

      return getByName(ExoskeletonTag.getTag(stack).getString("coreName"));
    }

    return null;
  }

  def hasCore(stack: ItemStack): Boolean={
    return this.findCore(stack) != null;
  }

  def installCore(stack: ItemStack, core: ICore): Unit ={
    val comp = ExoskeletonTag.getTag(stack);
    comp.setString("coreName", core.getID());
  }

  def findTree(stack: ItemStack): Tree={
    if(stack.hasTagCompound() &&
       stack.getTagCompound.hasKey(ExoskeletonTag.IDENTIFIER)){

      return getByName(ExoskeletonTag.getTag(stack).getString("coreName")).getTree();
    } else{
      return null;
    }
  }
}