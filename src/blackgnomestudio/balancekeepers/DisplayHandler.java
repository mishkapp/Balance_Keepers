package blackgnomestudio.balancekeepers;

import blackgnomestudio.balancekeepers.globalmap.GlobalMap;
import blackgnomestudio.balancekeepers.globalmap.entities.Player;
import blackgnomestudio.balancekeepers.globalmap.tiles.GrassLandTile;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;


/**
 * Created with IntelliJ IDEA.
 * User: mishkapp
 * Date: 01.09.13
 * Time: 1:37
 * To change this template use File | Settings | File Templates.
 */
public class DisplayHandler{
    private int width;
    private int height;
    private GlobalMap globalMap;
    private Player player;

    private float camX = 0.0F;
    private float camY = 0.0F;
    private float camZ = 0.0F;

    private float realCamX = 0.0F;
    private float realCamY = 0.0F;
    private float realCamZ = 0.0F;


    public DisplayHandler(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void run() {

        initGL();
        initTextures();
        //TODO: Remove Map from here
        globalMap = new GlobalMap(64,64);
        player = new Player(0,3,globalMap);
        while(!Display.isCloseRequested()){
            // Clear the screen and depth buffer
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

            logic();
            render();

            Display.update();
            try{
                Thread.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        Display.destroy();

    }

    private void logic(){
        //TODO: Ket Handler
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
            player.moveByX(1,globalMap);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_W)){
            player.moveByY(-1,globalMap);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_A)){
            player.moveByX(-1,globalMap);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            player.moveByY(1,globalMap);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_Q)){
            camZ += 0.01;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_Z)){
            camZ -= 0.01;
        }
    }

    private void render(){
        float deltaCamX = camX-realCamX;
        float deltaCamY = camY-realCamY;
        GL11.glTranslatef(deltaCamX,deltaCamY,0);
        float deltaCamZ = camZ-realCamZ;
        GL11.glScalef(-deltaCamZ+1,-deltaCamZ+1,0.0F);
        realCamZ += deltaCamZ;
        realCamX += deltaCamX;
        realCamY += deltaCamY;
        globalMap.renderMap();

    }

    private void initGL(){

        try{
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.create();
        }catch (LWJGLException e){
            e.printStackTrace();
        }
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0,width,0,height,1,-1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glEnable(GL11.GL_TEXTURE_2D);

        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        // enable alpha blending
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        GL11.glViewport(0,0,width,height);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, width, height, 0, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

    }

    private void initTextures(){
        //Map Tiles
        GrassLandTile.initTexture();

        //Entities
        Player.initTexture();

    }

}
