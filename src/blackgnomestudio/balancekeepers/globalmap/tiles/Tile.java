package blackgnomestudio.balancekeepers.globalmap.tiles;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

/**
 * Created with IntelliJ IDEA.
 * User: mishkapp
 * Date: 01.09.13
 * Time: 1:49
 * To change this template use File | Settings | File Templates.
 */
public abstract class Tile {
    protected static final int RESOLUTION_X = 128;
    protected static final int RESOLUTION_Y = 64;
    protected int textureHeight;

    public void drawTile(int x, int y){
        int delta = textureHeight - RESOLUTION_Y;
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0,0);
        GL11.glVertex2f(x*(RESOLUTION_X/2)+y*((RESOLUTION_X/2)), x*(-RESOLUTION_Y/2)+y*(RESOLUTION_Y/2)+delta);
        GL11.glTexCoord2f(1,0);
        GL11.glVertex2f(x*(RESOLUTION_X/2)+y*((RESOLUTION_X/2))+RESOLUTION_X, x*(-RESOLUTION_Y/2)+y*(RESOLUTION_Y/2)+delta);
        GL11.glTexCoord2f(1,1);
        GL11.glVertex2f(x*(RESOLUTION_X/2)+y*((RESOLUTION_X/2))+RESOLUTION_X, x*(-RESOLUTION_Y/2)+y*(RESOLUTION_Y/2)+RESOLUTION_Y+delta);
        GL11.glTexCoord2f(0,1);
        GL11.glVertex2f(x*(RESOLUTION_X/2)+y*((RESOLUTION_X/2)), x*(-RESOLUTION_Y/2)+y*(RESOLUTION_Y/2)+RESOLUTION_Y+delta);
        GL11.glEnd();
    }

    protected abstract void bindTexture();

}
