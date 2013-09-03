package blackgnomestudio.balancekeepers;

/**
 * Created with IntelliJ IDEA.
 * User: mishkapp
 * Date: 01.09.13
 * Time: 0:40
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    final int RESOLUTION_X = 800;
    final int RESOLUTION_Y = 600;

    public static void main(String[] args){
        new Main();
    }

    private Main(){
        init();
    }

    private void init(){
        initDisplay();
    }

    private void initDisplay(){
        Thread thread = new Thread(new DisplayHandler(RESOLUTION_X,RESOLUTION_Y));
        thread.start();
    }
}
