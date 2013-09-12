package blackgnomestudio.balancekeepers.renderers;

import blackgnomestudio.balancekeepers.globalmap.entities.Squad;

/**
 * Created with IntelliJ IDEA.
 * User: mishkapp
 * Date: 07.09.13
 * Time: 0:09
 * To change this template use File | Settings | File Templates.
 */
public class CombatScreenHandler extends Handler {

    private Squad playerSquad;
    private Squad oppositeSquad;

    public CombatScreenHandler(int width, int height, Squad playerSquad, Squad oppositeSquad){
        super(width,height);
        this.oppositeSquad = oppositeSquad;
        this.playerSquad = playerSquad;
    }

    @Override
    public void render() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void logic() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
