package exoskeleton.client.gui;

import exoskeleton.api.Skill;
import exoskeleton.api.Tree;
import exoskeleton.common.lib.skills.SkillsManager;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;

public class GuiTest
extends GuiScreen{
    public final Tree tree;
    public final EntityPlayer player;

    public GuiTest(EntityPlayer player, Tree tree){
        this.tree = tree;
        this.player = player;
    }

    @Override
    public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_){
        this.drawDefaultBackground();
        this.drawString(this.mc.fontRenderer, this.tree.name, (this.width / 2) - this.tree.name.length(), 0, 0xFFFFFF);
        for(Skill skill : this.tree.skills){
            this.mc.renderEngine.bindTexture(tree.marker);
            this.tree.bindColor();

            if(SkillsManager.unlocked(player, tree, skill)){
                tree.bindColor();
            } else{
                GL11.glColor4f(1.0F, 0.0F, 0.0F, 1.0F);
            }

            this.drawPoint(skill.x + 100, skill.y + 100);
        }
    }

    private void drawPoint(int x, int y){
        Tessellator tess = Tessellator.instance;
        tess.startDrawingQuads();
        tess.addVertexWithUV(x, y + 16, this.zLevel, 0.0D, 1.0D);
        tess.addVertexWithUV(x + 16, y + 16, this.zLevel, 1.0D, 1.0D);
        tess.addVertexWithUV(x + 16, y, this.zLevel, 1.0D, 0.0D);
        tess.addVertexWithUV(x, y, this.zLevel, 0.0D, 0.0D);
        tess.draw();
    }
}