package exoskeleton.common.lib.tree;

import exoskeleton.api.Skill;
import exoskeleton.api.Tree;
import net.minecraft.util.ResourceLocation;

public class TreeRecon
extends Tree{
    public static final Skill JUMPBOOST = new Skill(0, 0, "jumpBoost");
    public static final Skill DEBUG = new Skill(0, 30, "debug");
    public static final Skill NO_DROWN = new Skill(30, 0, "noDrown");
    public static final Skill NIGHT_VISION = new Skill(30, 30, "nightVision", new Skill[]{JUMPBOOST, NO_DROWN});

    public TreeRecon(){
        super("Recon", new ResourceLocation("exo", "textures/ulinkRecon.png"), 0x393939);
        this.skills.add(JUMPBOOST);
        this.skills.add(DEBUG);
        this.skills.add(NO_DROWN);
        this.skills.add(NIGHT_VISION);
    }
}