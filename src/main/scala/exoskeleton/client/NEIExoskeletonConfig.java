package exoskeleton.client;

import codechicken.nei.api.IConfigureNEI;

public final class NEIExoskeletonConfig
implements IConfigureNEI{
    @Override
    public void loadConfig(){

    }

    @Override
    public String getName(){
        return "Exoskeleton NEI Plugin";
    }

    @Override
    public String getVersion(){
        return "1.0.0.0";
    }
}