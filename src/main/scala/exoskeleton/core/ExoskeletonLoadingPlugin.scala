package exoskeleton.core

import java.util

import cpw.mods.fml.relauncher.IFMLLoadingPlugin

@IFMLLoadingPlugin.Name("Exoskeleton|Core")
@IFMLLoadingPlugin.MCVersion("1.7.10")
@IFMLLoadingPlugin.TransformerExclusions(Array("exoskeleton.core.", "scala."))
class ExoskeletonLoadingPlugin
extends IFMLLoadingPlugin{
  override def getASMTransformerClass: Array[String] = Array("exoskeleton.core.transformer.EndermanTransformer");;
  override def injectData(data: util.Map[String, AnyRef]): Unit ={}
  override def getModContainerClass: String = "exoskeleton.core.EXOModContainer";
  override def getAccessTransformerClass: String = null;
  override def getSetupClass: String = null;
}