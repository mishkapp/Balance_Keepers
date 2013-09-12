package blackgnomestudio.balancekeepers.globalmap;

import org.lwjgl.opengl.GL11;

/**
 * Created with IntelliJ IDEA.
 * User: mishkapp
 * Date: 12.09.13
 * Time: 23:46
 * To change this template use File | Settings | File Templates.
 */
public abstract class Drawable {
    public static final int RESOLUTION_X = 128;
    public static final int RESOLUTION_Y = 64;
    protected int textureHeight;

    public void drawTile(int x, int y){
        int delta = textureHeight - RESOLUTION_Y;
        int tileX = x * (RESOLUTION_X / 2) + y * (RESOLUTION_X / 2);
        int tileY = x * (-RESOLUTION_Y / 2) + y * (RESOLUTION_Y / 2)-delta;


        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0,0);
        GL11.glVertex2f(tileX, tileY);
        GL11.glTexCoord2f(1,0);
        GL11.glVertex2f(tileX+RESOLUTION_X, tileY);
        GL11.glTexCoord2f(1,1);
        GL11.glVertex2f(tileX + RESOLUTION_X, tileY+(RESOLUTION_Y+delta));
        GL11.glTexCoord2f(0,1);
        GL11.glVertex2f(tileX, tileY+(RESOLUTION_Y+delta));
        GL11.glEnd();
    }
}
