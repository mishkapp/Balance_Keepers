package blackgnomestudio.balancekeepers.globalmap.entities;

import blackgnomestudio.balancekeepers.globalmap.GlobalMap;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

/**
 * Created with IntelliJ IDEA.
 * User: mishkapp
 * Date: 02.09.13
 * Time: 21:24
 * To change this template use File | Settings | File Templates.
 */
public class Player extends Squad {

    protected static Texture[] texture = new Texture[1];

    public Player(int x, int y, GlobalMap globalMap){
        globalMap.setEntity(x,y,this);
    }

    @Override
    public void drawTile(int x, int y){
        texture[textureID].bind();
        textureHeight = texture[textureID].getTextureHeight();
        super.drawTile(x,y);
    }

    public static void initTexture(){
        try{
            texture[0] = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("./res/textures/entities/knight.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
