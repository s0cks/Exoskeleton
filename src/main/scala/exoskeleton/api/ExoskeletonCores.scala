package exoskeleton.api

import java.util

import cpw.mods.fml.common.registry.GameRegistry
import exoskeleton.common.item.ItemCore
import net.minecraft.item.ItemStack

import scala.collection.JavaConversions._

object ExoskeletonCores{
  private val cores: util.List[Core] = new util.LinkedList[Core]();
  private val items = new util.HashMap[Core, ItemStack]();

  def registerItems(): Unit ={
    for(c: Core <- this.cores){
      val item = new ItemCore(c);
      val stack = new ItemStack(item);

      GameRegistry.registerItem(item, "itemCore_" + c.getID());

      items.put(c, stack);
    }
  }

  def getItemByName(n: String): ItemStack={
    val c = this.getByName(n);
    return this.items.get(c).copy();
  }

  def getItemByCore(c: Core): ItemStack={
    return this.items.get(c).copy();
  }

  def registerCore(c: Core): Unit ={
    this.cores.add(c);
  }

  def getByName(n: String): Core={
    for(c: Core <- this.cores){
      if(c.getID().equalsIgnoreCase(n)){
        return c;
      }
    }

    return null;
  }

  def findCore(stack: ItemStack): Core={
    if(stack.hasTagCompound() &&
       stack.getTagCompound.hasKey(ExoskeletonTag.IDENTIFIER)){

      return getByName(ExoskeletonTag.getTag(stack).getString("coreName"));
    }

    return null;
  }

  def hasCore(stack: ItemStack): Boolean={
    return this.findCore(stack) != null;
  }

  def installCore(stack: ItemStack, core: Core): Unit ={
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