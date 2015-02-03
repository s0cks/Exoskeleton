package exoskeleton.api;

public enum LightIntensity{
    DIM(0xFFFFCC),
    BRIGHT(0xFFFF99);

    public final int color;

    private LightIntensity(int color){
        this.color = color;
    }
}
