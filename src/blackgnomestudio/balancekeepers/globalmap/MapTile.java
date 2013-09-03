package blackgnomestudio.balancekeepers.globalmap;

import blackgnomestudio.balancekeepers.globalmap.entities.Entity;
import blackgnomestudio.balancekeepers.globalmap.tiles.Tile;

/**
 * Created with IntelliJ IDEA.
 * User: mishkapp
 * Date: 01.09.13
 * Time: 12:06
 * To change this template use File | Settings | File Templates.
 */
public class MapTile {

    private Tile tile;
    private Entity entity;
    private int x;
    private int y;

    public MapTile(int x, int y){
        tile = null;
        entity = null;
        this.x = x;
        this.y = y;
    }

    public MapTile(Tile tile, Entity entity, int x, int y){
        this.tile = tile;
        this.entity = entity;
        this.x = x;
        this.y = y;
    }

    public void renderTile(){
        tile.drawTile(x,y);
    }

    public void renderEntity(){
        if (entity != null){
            entity.drawTile(x,y);
        }
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

}
