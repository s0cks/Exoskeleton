package exoskeleton.api;

import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.LinkedList;
import java.util.List;

public class Tree{
    public final List<Skill> skills = new LinkedList<Skill>();
    public final String name;
    public final ResourceLocation marker;
    public final int color;

    public Tree(String name, ResourceLocation marker, int color){
        this.marker = marker;
        this.name = name;
        this.color = color;
    }

    public Tree addSkill(Skill skill){
        this.skills.add(skill);
        return this;
    }

    public void bindColor(){
        float red = (this.color >> 16 & 255) / 255.0F;
        float green = (this.color >> 8 & 255) / 255.0F;
        float blue = (this.color & 255) / 255.0F;
        GL11.glColor4f(red, green, blue, 1.0F);
    }
}