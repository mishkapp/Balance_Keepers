package blackgnomestudio.balancekeepers.globalmap.tiles;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: mishkapp
 * Date: 01.09.13
 * Time: 12:41
 * To change this template use File | Settings | File Templates.
 */
public class GrassLandTile extends Tile {

    private static Texture texture[] = new Texture[4];
    private int textureID;

    public GrassLandTile(){
        bindTexture();
    }

    @Override
    protected void bindTexture(){
        Color.white.bind();
        int random = new Random().nextInt(100);
        if(random >= 0 && random < 40){
            textureID = 0;
            return;
        }
        if(random >= 40 && random < 80){
            textureID = 3;
            return;
        }
        if(random >= 80 && random < 90){
            textureID = 2;
            return;
        }
        if(random >= 90 && random < 100){
            textureID = 1;
            return;
        }

    }
    @Override
    public void drawTile(int x, int y){
        texture[textureID].bind();
        textureHeight = texture[textureID].getTextureHeight();
        super.drawTile(x,y);
    }

    public static void initTexture(){
        try{
            texture[0] = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("./res/textures/maptiles/grassLand1.png"));
            texture[1] = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("./res/textures/maptiles/grassLand2.png"));
            texture[2] = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("./res/textures/maptiles/grassLand3.png"));
            texture[3] = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("./res/textures/maptiles/grassLand4.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
