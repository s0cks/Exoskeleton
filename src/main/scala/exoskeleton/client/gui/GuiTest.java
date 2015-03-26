package exoskeleton.client.gui;

import exoskeleton.api.skill.Skill;
import exoskeleton.api.skill.Tree;
import exoskeleton.api.utils.RenderUtils;
import exoskeleton.common.gui.ContainerModifier;
import exoskeleton.common.tile.TileEntityModifier;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiTest
extends GuiContainer{
    public final Tree tree;
    public final EntityPlayer player;

    public static final ResourceLocation texture = new ResourceLocation("exo", "textures/gui/modifier.png");

    public static final int XSIZE = 208;
    public static final int YSIZE = 180;
    public int guiLeft;
    public int guiTop;

    public GuiTest(EntityPlayer player, TileEntityModifier modifier, Tree tree){
        super(new ContainerModifier(modifier, player));
        this.tree = tree;
        this.player = player;
    }

    @Override
    public void initGui(){
        this.guiLeft = (this.width - XSIZE) / 2;
        this.guiTop = (this.height - YSIZE) / 2;
    }

    @Override
    public void drawScreen(int x, int y, float par3){
        super.drawScreen(x, y, par3);
        this.drawString(this.mc.fontRenderer, this.tree.name, (this.width - this.fontRendererObj.getStringWidth(this.tree.name)) / 2, 0, 0xFFFFFF);

        for(Skill skill : this.tree.skills){
            if(skill.parents != null){
                for(Skill s : skill.parents){
                    this.drawLine(s.x, s.y, skill.x, skill.y);
                }
            }
        }

        for(Skill skill : this.tree.skills){
            this.mc.renderEngine.bindTexture(tree.marker);

                RenderUtils.bindColor(0xFF0000);

            this.drawPoint(skill.x + this.guiLeft + 9, skill.y + this.guiTop + 80);
        }

        Skill skill = this.find(x, y);
        if(skill != null){
            String str = StatCollector.translateToLocal("exoskeleton.skill." + skill.tag);
            int width = this.fontRendererObj.getStringWidth(str);
            this.drawColoredQuad(0xFFFFFF, 255, x + 9, y, width + 11, this.fontRendererObj.FONT_HEIGHT);
            this.drawColoredQuad(0x000000, 255, x + 10, y, width + 10, this.fontRendererObj.FONT_HEIGHT);
            this.fontRendererObj.drawString(str, x + 15, y, 0xFFFFFF);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_){
        this.mc.renderEngine.bindTexture(texture);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, XSIZE, YSIZE);
    }

    private boolean canUnlock(Skill s){
        if(s.parents != null){

        }

        return true;
    }

    private void drawLine(int x1, int y1, int x2, int y2) {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glLineWidth(3);

        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex3f(this.guiLeft + 17 + x1, this.guiTop + 88 + y1, this.zLevel);
        GL11.glVertex3f(this.guiLeft + 17 + x2, this.guiTop + 88 + y2, this.zLevel);
        GL11.glEnd();

        GL11.glColor4f(1F, 1F, 1F, 1F);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glPopMatrix();
    }

    private void drawColoredQuad(int color, int alpha, double x, double y, double width, double height){
        Tessellator tess = Tessellator.instance;
        tess.startDrawingQuads();

        int r = (color >> 16 & 0xFF);
        int g = (color >> 8 & 0xFF);
        int b = (color & 0xFF);

        GL11.glDisable(GL11.GL_TEXTURE_2D);
        tess.setColorRGBA(r, g, b, alpha);
        tess.addVertex(x, y + height, this.zLevel);
        tess.addVertex(x + width, y + height, this.zLevel);
        tess.addVertex(x + width, y, this.zLevel);
        tess.addVertex(x, y, this.zLevel);
        tess.draw();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
    }

    @Override
    public void mouseClicked(int x, int y, int button){
        super.mouseClicked(x, y, button);
        Skill skill = this.find(x, y);
        if(skill != null && button == 0){
        }
    }

    private Skill find(int x, int y){
        for(Skill skill : this.tree.skills){
            if(inBounds(skill.x + this.guiLeft, skill.y + this.guiTop, 16, 16, x, y)){
                return skill;
            }
        }

        return null;
    }

    private boolean inBounds(int x, int y, int width, int height, int mX, int mY){
        return x <= mX && mX <= x + width &&
               y <= mY && mY <= y + height;
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