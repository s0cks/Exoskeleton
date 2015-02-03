package exoskeleton.client;

import codechicken.nei.api.IConfigureNEI;
import exoskeleton.common.Exoskeleton;

public final class NEIExoskeletonConfig
implements IConfigureNEI{
    @Override
    public void loadConfig(){
        Exoskeleton.logger().info("Loading NEI Configuration");
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