import processing.core.*;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.ArrayList;

public class Stage extends PApplet {
    public static PImage shipTexture;
    public static PImage backgroundTexture;
    public static PImage[] asteroidTexture = new PImage[10];
    private PApplet p;
    private Camera camera;
    private Track track;
    private Player player;

    public Stage(PApplet p) {
        this.p = p;
        this.camera = new Camera(p);
        this.track = new Track(p);
        this.player = new Player(p);
        for(int i = 0; i < asteroidTexture.length; ++i) {
            asteroidTexture[i] = p.loadImage(Sketch.srcFolder + "ast" + i + ".png");
        }
        System.out.println("HI");
        shipTexture = p.loadImage(Sketch.srcFolder + "spaceship.png");
        backgroundTexture = p.loadImage(Sketch.srcFolder + "background.jpg");

    }

    public void draw() {
        Camera.update();

        drawBackground();


        gameTick();

        Player.update();

        Track.draw();

        p.textSize(18);
        p.textAlign(p.LEFT);
        p.text("Score: " + (int)Player.z, 50, 50);

    }

    private void gameTick() {


    }

    private void drawBackground() {
        int width = p.width;
        int height = p.height;


        float x = p.lerp(width/4, -width/4, (Player.x - Player.minX) / (Player.maxX - Player.minX));
        float y = p.lerp(-height/4, height/4, (Player.y - Player.minY) / (Player.maxY - Player.minY));

        p.image(backgroundTexture, 0-(width/2)+x, 0-(height/2)+y, width*2, height*2);
    }

}
