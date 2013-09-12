package blackgnomestudio.balancekeepers.globalmap.tiles;

import blackgnomestudio.balancekeepers.globalmap.Drawable;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

/**
 * Created with IntelliJ IDEA.
 * User: mishkapp
 * Date: 01.09.13
 * Time: 1:49
 * To change this template use File | Settings | File Templates.
 */
public abstract class Tile extends Drawable {

    public void drawTile(int x, int y){
        super.drawTile(x,y);
    }

    protected abstract void bindTexture();

}
