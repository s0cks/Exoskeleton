package exoskeleton.common;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public final class EXOConfiguration{
    public static int xray_color = 0xFF3399;

    private static EXOConfiguration instance;
    private Configuration config;

    public static EXOConfiguration instance(){
        return instance == null ? instance = new EXOConfiguration() : instance;
    }

    public void initialize(File file){
        this.config = new Configuration(file);
        this.config.load();
        EXOConfiguration.xray_color = Integer.parseInt(this.config.getString("xray_color", "settings", "#FFFFFF", "Change the XRay line colour").substring(1), 16);
        this.config.save();
    }
}