package exoskeleton.api.utils;

import net.minecraft.util.ResourceLocation;

public class ArmorOverlaySet{
    public final ResourceLocation helm;
    public final ResourceLocation chest;
    public final ResourceLocation legs;
    public final ResourceLocation boots;

    public ArmorOverlaySet(String helm, String chest, String legs, String boots){
        this.helm = new ResourceLocation("exo", helm);
        this.chest = new ResourceLocation("exo", chest);
        this.legs = new ResourceLocation("exo", legs);
        this.boots = new ResourceLocation("exo", boots);
    }
}