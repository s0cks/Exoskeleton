package exoskeleton.core;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;

import com.google.common.eventbus.EventBus;

import java.util.Arrays;

public final class EXOModContainer
extends DummyModContainer{
    public EXOModContainer(){
        super(new ModMetadata());
        ModMetadata meta = super.getMetadata();
        meta.modId = "EXOCore";
        meta.name = "ExoskeletonCore";
        meta.version = "1.0.0.0";
        meta.credits = "Asyncronous";
        meta.authorList = Arrays.asList("Asyncronous", "CyanideX");
        meta.description = "";
        meta.url = "";
        meta.updateUrl = "";
        meta.screenshots = new String[0];
        meta.logoFile = "";
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController loadController){
        bus.register(this);
        return true;
    }
}