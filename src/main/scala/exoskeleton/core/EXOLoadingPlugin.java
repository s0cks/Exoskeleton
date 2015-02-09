package exoskeleton.core;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.Name;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;

import java.util.Map;

@Name("Exoskeleton|Core")
@MCVersion("1.7.10")
@TransformerExclusions({
        "exoskeleton.core",
        "scala."
})
public final class EXOLoadingPlugin
implements IFMLLoadingPlugin{
    @Override
    public String[] getASMTransformerClass(){
        return new String[]{
                "exoskeleton.core.transformer.EntityPlayerTransformer",
                "exoskeleton.core.transformer.EndermanTransformer"
        };
    }

    @Override
    public String getModContainerClass(){
        return "exoskeleton.core.EXOModContainer";
    }

    @Override
    public String getSetupClass(){
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data){

    }

    @Override
    public String getAccessTransformerClass(){
        return null;
    }
}