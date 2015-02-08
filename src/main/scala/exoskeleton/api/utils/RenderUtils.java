package exoskeleton.api.utils;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.Map;

public class RenderUtils{
    public static final double OFFSET_CONSTANT = 0.001;

    private static final Map<ForgeDirection, Integer> FACE_MAP = new HashMap<ForgeDirection, Integer>(){
        {
            this.put(ForgeDirection.UP, 1);
            this.put(ForgeDirection.DOWN, 0);
        }
    };

    public static void drawColoredQuad(int color, int alpha, double x, double y, double width, double height){
        Tessellator tess = Tessellator.instance;
        tess.startDrawingQuads();

        int r = (color >> 16 & 0xFF);
        int g = (color >> 8 & 0xFF);
        int b = (color & 0xFF);

        GL11.glDisable(GL11.GL_TEXTURE_2D);
        tess.setColorRGBA(r, g, b, alpha);
        tess.addVertex(x, y + height, 1);
        tess.addVertex(x + width, y + height, 1);
        tess.addVertex(x + width, y, 1);
        tess.addVertex(x, y, 1);
        tess.draw();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
    }

    public static void bindColor(int color){
        int r = (color >> 16 & 0xFF);
        int g = (color >> 8 & 0xFF);
        int b = (color & 0xFF);
        GL11.glColor4d(r, g, b, 255);
    }

    public static void bindColor(int color, double alpha){
        int r = (color >> 16 & 0xFF);
        int g = (color >> 8 & 0xFF);
        int b = (color & 0xFF);
        GL11.glColor4d(r, g, b, alpha);
    }

    public static void drawCubeAt(int x, int y, int z, int color, int alpha){
        for (ForgeDirection face : ForgeDirection.VALID_DIRECTIONS) {
            drawQuadOnFace(x, y, z, face, color, alpha);
        }
    }

    public static void drawCubeAt(double offset, int x, int y, int z, Block b, int meta, int brightness){
        for(ForgeDirection face : ForgeDirection.VALID_DIRECTIONS){
            drawQuadOnFace(offset, x, y, z, face, b.getIcon(face.ordinal(), meta), brightness);
        }
    }

    public static void drawQuadOnFace(double OFFSET_CONSTANT, int x, int y, int z, ForgeDirection face, IIcon icon, int brightness){
        Tessellator tess = Tessellator.instance;
        tess.setBrightness(brightness);
        tess.startDrawingQuads();

        switch(face) {
            case UP: {
                tess.addVertexWithUV(x, y + 1 + OFFSET_CONSTANT, z, icon.getMinU(), icon.getMinV());
                tess.addVertexWithUV(x, y + 1 + OFFSET_CONSTANT, z + 1, icon.getMinU(), icon.getMaxV());
                tess.addVertexWithUV(x + 1, y + 1 + OFFSET_CONSTANT, z + 1, icon.getMaxU(), icon.getMaxV());
                tess.addVertexWithUV(x + 1, y + 1 + OFFSET_CONSTANT, z, icon.getMaxU(), icon.getMinV());
                break;
            }

            case DOWN: {
                tess.addVertexWithUV(x + 1, y - OFFSET_CONSTANT, z, icon.getMinU(), icon.getMinV());
                tess.addVertexWithUV(x + 1, y - OFFSET_CONSTANT, z + 1, icon.getMinU(), icon.getMaxV());
                tess.addVertexWithUV(x, y - OFFSET_CONSTANT, z + 1, icon.getMaxU(), icon.getMaxV());
                tess.addVertexWithUV(x, y - OFFSET_CONSTANT, z, icon.getMaxU(), icon.getMinV());
                break;
            }

            case EAST: {
                tess.addVertexWithUV(x + 1 + OFFSET_CONSTANT, y,     z, icon.getMinU(), icon.getMinV());
                tess.addVertexWithUV(x + 1 + OFFSET_CONSTANT, y + 1, z, icon.getMinU(), icon.getMaxV());
                tess.addVertexWithUV(x + 1 + OFFSET_CONSTANT, y + 1, z + 1, icon.getMaxU(), icon.getMaxV());
                tess.addVertexWithUV(x + 1 + OFFSET_CONSTANT, y,     z + 1, icon.getMaxU(), icon.getMinV());
                break;
            }

            case NORTH: {
                tess.addVertexWithUV(x,     y,     z - OFFSET_CONSTANT, icon.getMinU(), icon.getMinV());
                tess.addVertexWithUV(x,     y + 1, z - OFFSET_CONSTANT, icon.getMinU(), icon.getMaxV());
                tess.addVertexWithUV(x + 1, y + 1, z - OFFSET_CONSTANT, icon.getMaxU(), icon.getMaxV());
                tess.addVertexWithUV(x + 1, y,     z - OFFSET_CONSTANT, icon.getMaxU(), icon.getMinV());
                break;
            }

            case SOUTH: {
                tess.addVertexWithUV(x + 1, y,     z + 1 + OFFSET_CONSTANT, icon.getMinU(), icon.getMinV());
                tess.addVertexWithUV(x + 1, y + 1, z + 1 + OFFSET_CONSTANT, icon.getMinU(), icon.getMaxV());
                tess.addVertexWithUV(x,     y + 1, z + 1 + OFFSET_CONSTANT, icon.getMaxU(), icon.getMaxV());
                tess.addVertexWithUV(x,     y,     z + 1 + OFFSET_CONSTANT, icon.getMaxU(), icon.getMinV());
                break;
            }

            case WEST: {
                tess.addVertexWithUV(x - OFFSET_CONSTANT, y,     z + 1, icon.getMinU(), icon.getMinV());
                tess.addVertexWithUV(x - OFFSET_CONSTANT, y + 1, z + 1, icon.getMinU(), icon.getMaxV());
                tess.addVertexWithUV(x - OFFSET_CONSTANT, y + 1, z, icon.getMaxU(), icon.getMaxV());
                tess.addVertexWithUV(x - OFFSET_CONSTANT, y,     z, icon.getMaxU(), icon.getMinV());
                break;
            }

            default: break;
        }

        tess.draw();
    }

    public static void drawQuadOnFace(int x, int y, int z, ForgeDirection face, int color, int alpha){
        Tessellator tess = Tessellator.instance;
        int r = (color >> 16 & 0xFF);
        int g = (color >> 8 & 0xFF);
        int b = (color & 0xFF);

        tess.startDrawingQuads();
        tess.setColorRGBA(r, g, b, alpha);

        switch(face) {
            case UP: {
                tess.addVertex(x, y + 1 + OFFSET_CONSTANT, z);
                tess.addVertex(x, y + 1 + OFFSET_CONSTANT, z + 1);
                tess.addVertex(x + 1, y + 1 + OFFSET_CONSTANT, z + 1);
                tess.addVertex(x + 1, y + 1 + OFFSET_CONSTANT, z);
                break;
            }

            case DOWN: {
                tess.addVertex(x + 1, y - OFFSET_CONSTANT, z);
                tess.addVertex(x + 1, y - OFFSET_CONSTANT, z + 1);
                tess.addVertex(x,     y - OFFSET_CONSTANT, z + 1);
                tess.addVertex(x,     y - OFFSET_CONSTANT, z);
                break;
            }

            case EAST: {
                tess.addVertex(x + 1 + OFFSET_CONSTANT, y,     z);
                tess.addVertex(x + 1 + OFFSET_CONSTANT, y + 1, z);
                tess.addVertex(x + 1 + OFFSET_CONSTANT, y + 1, z + 1);
                tess.addVertex(x + 1 + OFFSET_CONSTANT, y,     z + 1);
                break;
            }

            case NORTH: {
                tess.addVertex(x,     y,     z - OFFSET_CONSTANT);
                tess.addVertex(x,     y + 1, z - OFFSET_CONSTANT);
                tess.addVertex(x + 1, y + 1, z - OFFSET_CONSTANT);
                tess.addVertex(x + 1, y,     z - OFFSET_CONSTANT);
                break;
            }

            case SOUTH: {
                tess.addVertex(x + 1, y,     z + 1 + OFFSET_CONSTANT);
                tess.addVertex(x + 1, y + 1, z + 1 + OFFSET_CONSTANT);
                tess.addVertex(x,     y + 1, z + 1 + OFFSET_CONSTANT);
                tess.addVertex(x,     y,     z + 1 + OFFSET_CONSTANT);
                break;
            }

            case WEST: {
                tess.addVertex(x - OFFSET_CONSTANT, y,     z + 1);
                tess.addVertex(x - OFFSET_CONSTANT, y + 1, z + 1);
                tess.addVertex(x - OFFSET_CONSTANT, y + 1, z);
                tess.addVertex(x - OFFSET_CONSTANT, y,     z);
                break;
            }

            default: break;
        }

        tess.draw();
    }

    public static void drawCubeAt(int x, int y, int z) {
        for (ForgeDirection face : ForgeDirection.VALID_DIRECTIONS) {
            drawQuadOnFace(x, y, z, face);
        }
    }

    public static void drawQuadOnFace(int x, int y, int z, ForgeDirection face) {
        Tessellator tess = Tessellator.instance;
        tess.startDrawingQuads();

        switch(face) {
            case UP: {
                tess.addVertex(x, y + 1 + OFFSET_CONSTANT, z);
                tess.addVertex(x, y + 1 + OFFSET_CONSTANT, z + 1);
                tess.addVertex(x + 1, y + 1 + OFFSET_CONSTANT, z + 1);
                tess.addVertex(x + 1, y + 1 + OFFSET_CONSTANT, z);
                break;
            }

            case DOWN: {
                tess.addVertex(x + 1, y - OFFSET_CONSTANT, z);
                tess.addVertex(x + 1, y - OFFSET_CONSTANT, z + 1);
                tess.addVertex(x,     y - OFFSET_CONSTANT, z + 1);
                tess.addVertex(x,     y - OFFSET_CONSTANT, z);
                break;
            }

            case EAST: {
                tess.addVertex(x + 1 + OFFSET_CONSTANT, y,     z);
                tess.addVertex(x + 1 + OFFSET_CONSTANT, y + 1, z);
                tess.addVertex(x + 1 + OFFSET_CONSTANT, y + 1, z + 1);
                tess.addVertex(x + 1 + OFFSET_CONSTANT, y,     z + 1);
                break;
            }

            case NORTH: {
                tess.addVertex(x,     y,     z - OFFSET_CONSTANT);
                tess.addVertex(x,     y + 1, z - OFFSET_CONSTANT);
                tess.addVertex(x + 1, y + 1, z - OFFSET_CONSTANT);
                tess.addVertex(x + 1, y,     z - OFFSET_CONSTANT);
                break;
            }

            case SOUTH: {
                tess.addVertex(x + 1, y,     z + 1 + OFFSET_CONSTANT);
                tess.addVertex(x + 1, y + 1, z + 1 + OFFSET_CONSTANT);
                tess.addVertex(x,     y + 1, z + 1 + OFFSET_CONSTANT);
                tess.addVertex(x,     y,     z + 1 + OFFSET_CONSTANT);
                break;
            }

            case WEST: {
                tess.addVertex(x - OFFSET_CONSTANT, y,     z + 1);
                tess.addVertex(x - OFFSET_CONSTANT, y + 1, z + 1);
                tess.addVertex(x - OFFSET_CONSTANT, y + 1, z);
                tess.addVertex(x - OFFSET_CONSTANT, y,     z);
                break;
            }

            default: break;
        }

        tess.draw();
    }

    public static void translateToWorldCoords(Entity e, float partialTicks){
        double x = e.lastTickPosX + (e.posX - e.lastTickPosX) * partialTicks;
        double y = e.lastTickPosY + (e.posY - e.lastTickPosY) * partialTicks;
        double z = e.lastTickPosZ + (e.posZ - e.lastTickPosZ) * partialTicks;
        GL11.glTranslated(-x, -y, -z);
    }

    public static void drawWireframe(double x, double y, double z, int color){
        int r = (color >> 16 & 0xFF);
        int g = (color >> 8 & 0xFF);
        int b = (color & 0xFF);

        double minX = 0;
        double minY = 0;
        double minZ = 0;
        double maxX = 1;
        double maxY = 1;
        double maxZ = 1;

        GL11.glPushMatrix();
        GL11.glDepthMask(false);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glLineWidth(1.0F);
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);

        Tessellator tess = Tessellator.instance;
        tess.startDrawing(GL11.GL_LINES);
        tess.setColorRGBA(r, g, b, 255);
        tess.addVertex(minX, minY, minZ);
        tess.addVertex(minX, maxY, minZ);
        tess.addVertex(minX, minY, maxZ);
        tess.addVertex(minX, maxY, maxZ);

        tess.addVertex(maxX, minY, minZ);
        tess.addVertex(maxX, maxY, minZ);
        tess.addVertex(maxX, minY, maxZ);
        tess.addVertex(maxX, maxY, maxZ);

        tess.addVertex(minX, minY, minZ);
        tess.addVertex(maxX, minY, minZ);
        tess.addVertex(minX, minY, maxZ);
        tess.addVertex(maxX, minY, maxZ);

        tess.addVertex(minX, maxY, minZ);
        tess.addVertex(maxX, maxY, minZ);
        tess.addVertex(minX, maxY, maxZ);
        tess.addVertex(maxX, maxY, maxZ);

        tess.addVertex(minX, minY, minZ);
        tess.addVertex(minX, minY, maxZ);
        tess.addVertex(maxX, minY, minZ);
        tess.addVertex(maxX, minY, maxZ);

        tess.addVertex(minX, maxY, minZ);
        tess.addVertex(minX, maxY, maxZ);
        tess.addVertex(maxX, maxY, minZ);
        tess.addVertex(maxX, maxY, maxZ);
        tess.draw();

        GL11.glPopMatrix();
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glPopMatrix();
    }

    public static void drawWireframe(double x, double y, double z){
        double minX = 0;
        double minY = 0;
        double minZ = 0;
        double maxX = 1;
        double maxY = 1;
        double maxZ = 1;

        GL11.glPushMatrix();
        GL11.glDepthMask(false);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glLineWidth(1.0F);
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);

        Tessellator tess = Tessellator.instance;
        tess.startDrawing(GL11.GL_LINES);
        tess.addVertex(minX, minY, minZ);
        tess.addVertex(minX, maxY, minZ);
        tess.addVertex(minX, minY, maxZ);
        tess.addVertex(minX, maxY, maxZ);

        tess.addVertex(maxX, minY, minZ);
        tess.addVertex(maxX, maxY, minZ);
        tess.addVertex(maxX, minY, maxZ);
        tess.addVertex(maxX, maxY, maxZ);

        tess.addVertex(minX, minY, minZ);
        tess.addVertex(maxX, minY, minZ);
        tess.addVertex(minX, minY, maxZ);
        tess.addVertex(maxX, minY, maxZ);

        tess.addVertex(minX, maxY, minZ);
        tess.addVertex(maxX, maxY, minZ);
        tess.addVertex(minX, maxY, maxZ);
        tess.addVertex(maxX, maxY, maxZ);

        tess.addVertex(minX, minY, minZ);
        tess.addVertex(minX, minY, maxZ);
        tess.addVertex(maxX, minY, minZ);
        tess.addVertex(maxX, minY, maxZ);

        tess.addVertex(minX, maxY, minZ);
        tess.addVertex(minX, maxY, maxZ);
        tess.addVertex(maxX, maxY, minZ);
        tess.addVertex(maxX, maxY, maxZ);
        tess.draw();

        GL11.glPopMatrix();
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glPopMatrix();
    }
}