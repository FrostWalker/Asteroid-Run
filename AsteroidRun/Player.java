import processing.core.PApplet;

import java.awt.event.KeyEvent;

public class Player {

    public static float x = 0f;
    public static float y = 0f;
    public static float z = 0f;
    public static final float maxX = 700f;
    public static final float maxY = 2000f;
    public static final float minX = -maxX;
    public static final float minY = -maxY;
    public static float speed = 15f;
    private static float maxSpeed = 1 / Camera.step;
    private static float accel = maxSpeed / 5;
    private static float breaking = -maxSpeed;
    private static float decel = -maxSpeed / 5;
    private static float offRoadDecel = -maxSpeed / 2;
    private static float offRoadLimit = maxSpeed / 4;
    private static float width = 200f;
    private static float height = 200f;
    private static PApplet p;

    public static boolean isDead;

    public Player(PApplet pa) {
        p = pa;
        x = 0f;
        y = 0f;
        z = 0f;

        isDead = false;

    }

    public static void update() {



        if(Game.isPlaying() && !Player.isDead) {
            gameControls();
            z+= Camera.step * speed;
        }

        if(x < minX) x = minX;
        if(x > maxX) x = maxX;
        if(y < minY) y = minY;
        if(y > maxY) y = maxY;
    }

    public static void draw() {


//
        if(!isDead) {
            float[] p1 = Camera.calcPos(x-83.5f, y-172f, z);
            float[] p2 = Camera.calcPos(x-83.5f, y+172f, z);
            float[] p3 = Camera.calcPos(x+83.5f, y+172f, z);
            float[] p4 = Camera.calcPos(x+83.5f, y-172f, z);

            p.noStroke();
            p.textureMode(p.IMAGE);
            p.beginShape();
            p.texture(Stage.shipTexture);
            p.vertex(p1[0], p1[1], 0, 0);
            p.vertex(p2[0], p2[1], 0, 271);
            p.vertex(p3[0], p3[1], 220, 271);
            p.vertex(p4[0], p4[1], 220, 0);
            p.endShape();
        }

    }

    public static void collide() {
        isDead = true;
    }

    private static void gameControls() {

        if (Keyboard.press('a') || Keyboard.press((char)37)) x += Camera.step * 150;
        if (Keyboard.press('d') || Keyboard.press((char)39)) x -= Camera.step * 150;
        if (Keyboard.press('w') || Keyboard.press((char)38)) y -= Camera.step * 1000;
        if (Keyboard.press('s') || Keyboard.press((char)40)) y += Camera.step * 1000;
    }


}
