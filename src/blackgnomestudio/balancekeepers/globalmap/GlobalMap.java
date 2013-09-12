package blackgnomestudio.balancekeepers.globalmap;

import blackgnomestudio.balancekeepers.globalmap.entities.Entity;
import blackgnomestudio.balancekeepers.globalmap.tiles.GrassLandTile;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: mishkapp
 * Date: 01.09.13
 * Time: 11:21
 * To change this template use File | Settings | File Templates.
 */
public class GlobalMap {
    private MapTile[][] globalMap;
    private int mapHeight;
    private int mapWidth;

    public GlobalMap(int mapWidth, int mapHeight){
        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;
        globalMap = new MapTile[mapWidth][mapHeight];
        generateMap();
    }

    private void generateMap(){
        //TODO: Normal generation
        for(int i = 0; i < mapWidth; i++){
            for(int j = 0; j < mapHeight; j++){
                globalMap[i][j] = new MapTile(new GrassLandTile(),null,i,j);
            }
        }
    }

    public void renderMap(){
        for(int i = 0; i < mapWidth; i++){
            for(int j = 0; j < mapHeight; j++){
                globalMap[i][j].renderTile();

            }
        }
        for(int i = 0; i < mapWidth; i++){
            for(int j = 0; j < mapHeight; j++){
                globalMap[i][j].renderEntity();

            }
        }
    }

    public Entity getEntity(int x, int y){
        return globalMap[x][y].getEntity();
    }

    public void setEntity(int x, int y, Entity entity){
        globalMap[x][y].setEntity(entity);
    }

    public static int[] translateToMapCoordinates(int realX, int realY){
        int[] result = new int[2];

        return result;
    }

    public static int[] translateToRealCoordinates(int x, int y){
        int[] result = new int[2];
        result[0] = x * (Drawable.RESOLUTION_X / 2) + y * (Drawable.RESOLUTION_X / 2);
        result[1] = x * (-Drawable.RESOLUTION_Y / 2) + y * (Drawable.RESOLUTION_Y / 2);

        return result;
    }
}
