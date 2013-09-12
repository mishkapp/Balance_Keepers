package blackgnomestudio.balancekeepers.globalmap.entities;

import blackgnomestudio.balancekeepers.globalmap.Drawable;
import blackgnomestudio.balancekeepers.globalmap.GlobalMap;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

/**
 * Created with IntelliJ IDEA.
 * User: mishkapp
 * Date: 01.09.13
 * Time: 12:34
 * To change this template use File | Settings | File Templates.
 */
public abstract class Entity extends Drawable {

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    protected int x;
    protected int y;

    protected int textureID;

    public static void render(){

    }

    public void drawTile(int x, int y){
        super.drawTile(x,y);
    }

    public void moveTo(int x, int y, GlobalMap globalMap){
        //TODO: Collision
        globalMap.setEntity(this.x,this.y,null);
        this.x = x;
        this.y = y;
        globalMap.setEntity(this.x,this.y,this);
    }

    public void moveByX(int x, GlobalMap globalMap){
        //TODO: Collision
        globalMap.setEntity(this.x,this.y,null);
        this.x += x;
        globalMap.setEntity(this.x,this.y,this);
    }

    public void moveByY(int y, GlobalMap globalMap){
        //TODO: Collision
        globalMap.setEntity(this.x,this.y,null);
        this.y += y;
        globalMap.setEntity(this.x,this.y,this);
    }


}
