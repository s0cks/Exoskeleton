package exoskeleton.api;

import org.lwjgl.opengl.GL11;

public enum HeatValue {
    VERY_HOT(255, 238, 238),
    HOT(174, 22, 19),
    WARM(213, 195, 0),
    TEPID(41, 255, 63),
    COOL(92, 255, 255),
    COLD(14, 65, 255),
    FREEZING(0, 0, 0);

    public int r;
    public int g;
    public int b;

    private HeatValue(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void bind(){
        GL11.glColor4d(this.r, this.g, this.b, 100);
    }
}