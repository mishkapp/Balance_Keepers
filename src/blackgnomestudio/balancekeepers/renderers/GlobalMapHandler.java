package blackgnomestudio.balancekeepers.renderers;

import blackgnomestudio.balancekeepers.globalmap.GlobalMap;
import blackgnomestudio.balancekeepers.globalmap.entities.Player;
import org.lwjgl.input.Keyboard;

/**
 * Created with IntelliJ IDEA.
 * User: mishkapp
 * Date: 04.09.13
 * Time: 13:26
 * To change this template use File | Settings | File Templates.
 */
public class GlobalMapHandler extends Handler {

    private GlobalMap globalMap;
    private Player player;
    private Camera camera;

    private int mapX = 64;
    private int mapY = 64;

    public GlobalMapHandler(int width, int height, Camera camera){
        super(width, height);
        this.camera = camera;
        globalMap = new GlobalMap(mapX,mapY);
        player = new Player(0,0,globalMap);
    }

    @Override
    public void render() {
        globalMap.renderMap();
        int[] temp = GlobalMap.translateToRealCoordinates(player.getX(),player.getY());
        camera.setPosition(temp[0],temp[1],(float)camera.getPosZ(),
                            temp[0],temp[1],0,
                            0,-1,0);
    }

    @Override
    public void logic() {
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
            if(player.getX() < mapX-1){
                player.moveByX(1,globalMap);
            }
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_W)){
            if(player.getY() > 0){
                player.moveByY(-1,globalMap);
            }
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_A)){
            if(player.getX() > 0){
                player.moveByX(-1,globalMap);
            }
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            if(player.getY() < mapY-1){
                player.moveByY(1,globalMap);
            }
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_MINUS)){
            if(camera.getPosZ() > -2000){
                camera.move(-10F);
            }

        }
        if(Keyboard.isKeyDown(Keyboard.KEY_EQUALS)){
            if(camera.getPosZ() < -400){
                camera.move(10F);
            }
        }
    }


}
