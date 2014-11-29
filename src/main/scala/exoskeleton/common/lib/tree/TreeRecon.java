package exoskeleton.common.lib.tree;

import exoskeleton.api.Skill;
import exoskeleton.api.Tree;
import net.minecraft.util.ResourceLocation;

public class TreeRecon
extends Tree{
    public TreeRecon(){
        super("Recon", new ResourceLocation("exo", "textures/ulinkRecon.png"), 0x393939);
        this.skills.add(new Skill(0, 0, "jumpBoost"));
        this.skills.add(new Skill(0, 30, "debug"));
        this.skills.add(new Skill(30, 0, "noDrown"));
        this.skills.add(new Skill(30, 30, "nightVision"));
    }
}