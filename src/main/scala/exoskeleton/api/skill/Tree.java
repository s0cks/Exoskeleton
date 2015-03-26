package exoskeleton.api.skill;

import exoskeleton.api.utils.RenderUtils;
import net.minecraft.util.ResourceLocation;

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
        RenderUtils.bindColor(this.color);
    }
}