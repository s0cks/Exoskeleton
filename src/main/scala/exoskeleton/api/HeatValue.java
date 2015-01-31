package exoskeleton.api;

import exoskeleton.api.utils.RenderUtils;

public enum HeatValue {
    VERY_HOT(0xCC0000),
    HOT(0xFF3F3F),
    COLD(0x4747FF),
    FREEZING(0x0000CC);

    public int color;

    private HeatValue(int color){
        this.color = color;
    }

    public void bind(){
        RenderUtils.bindColor(this.color, 100);
    }
}