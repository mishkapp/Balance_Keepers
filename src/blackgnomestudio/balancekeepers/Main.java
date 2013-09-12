package blackgnomestudio.balancekeepers;

import blackgnomestudio.balancekeepers.globalmap.entities.Player;
import blackgnomestudio.balancekeepers.globalmap.tiles.GrassLandTile;
import blackgnomestudio.balancekeepers.renderers.Camera;
import blackgnomestudio.balancekeepers.renderers.GlobalMapHandler;
import blackgnomestudio.balancekeepers.renderers.Handler;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mishkapp
 * Date: 01.09.13
 * Time: 0:40
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    final int RESOLUTION_X = 1024;
    final int RESOLUTION_Y = 768;

    private Handler[] handlers = new Handler[5];
    private int rendererID = 0;
    /*
    0 - Global Map
    1 - Menu
    2 - Squad
    3 - City
    4 - Battle
     */
    private Camera camera = new Camera();


    //DisplayHandler displayHandler;

    public static void main(String[] args){
        new Main();
//        Yaml yaml  = new Yaml();
//        try{
//            String file = readFile(new File("./configs/units/lizards/lizardmen.yaml"),Charset.defaultCharset());
//            Map map = (Map) yaml.load(file);
//            System.out.println(map);
//            System.out.println(map.get("type"));
//        }catch (Exception e){
//            e.printStackTrace();
//        }


    }



    private Main(){
        init();
        run();
    }

    private void init(){
        initGL();
        initTextures();
        //TODO: Camera stub
        camera.setPosition(
                0, 0, -400,
                0, 0, 0,
                0, -1, 0);
        //TODO: All screens initialization
        handlers[0] = new GlobalMapHandler(RESOLUTION_X,RESOLUTION_Y,camera);
    }

    private void run(){

//        int x = 0;
//        int y =0;
//        float rotation = 0.01F;
        while(!Display.isCloseRequested()){

            handlers[rendererID].logic();

            GL11.glMatrixMode(GL11.GL_PROJECTION);
            GL11.glLoadIdentity();
            GLU.gluPerspective(60,(float)RESOLUTION_X/RESOLUTION_Y,200,2000);
//            GL11.glFrustum(-1,1,-1,1,200,2000);

            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);


            camera.render();
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            handlers[rendererID].render();
            Display.update();
            try{
                Thread.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        Display.destroy();

        }


    private void initGL(){
        try{
            Display.setDisplayMode(new DisplayMode(RESOLUTION_X, RESOLUTION_Y));
            Display.create();
            GL11.glMatrixMode(GL11.GL_PROJECTION);
            GL11.glLoadIdentity();
            GL11.glOrtho(0, RESOLUTION_X, 0, RESOLUTION_Y, 1, -1);
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
        }catch (LWJGLException e){
            e.printStackTrace();
        }
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0,RESOLUTION_X,0,RESOLUTION_Y,1,-1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glEnable(GL11.GL_TEXTURE_2D);

        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

//        enable alpha blending
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        GL11.glViewport(0,0,RESOLUTION_X,RESOLUTION_Y);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, RESOLUTION_X, RESOLUTION_Y, 0, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
//        GL11.glViewport(0,0,RESOLUTION_X,RESOLUTION_Y);
    }

    private void initTextures(){
        //Map Tiles
        GrassLandTile.initTexture();

        //Entities
        Player.initTexture();

    }
}
