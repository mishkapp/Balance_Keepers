package blackgnomestudio.balancekeepers.renderers;

/**
 * Created with IntelliJ IDEA.
 * User: mishkapp
 * Date: 04.09.13
 * Time: 13:28
 * To change this template use File | Settings | File Templates.
 */
public abstract class Handler {

    protected int width;
    protected int height;

    protected Handler(int width, int height){
        this.width = width;
        this.height = height;
    }

    public abstract void render();

    public abstract void logic();


}
