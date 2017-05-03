import processing.core.PApplet;
import processing.core.PImage;

public class GameObject {
    private PApplet p;

    private float x = 0f;
    private float y = 0f;
    private float z = 0f;

    private int ind;

    public GameObject(float z, PApplet pa) {
        this.p = pa;

        ind = (int)p.random(0, 9);

        this.x = p.random(Player.minX*5, Player.maxX*5);
        this.y = p.random(Player.minY*5, Player.maxY*5);
        this.z = z;
    }

    public void draw() {

        if((Math.ceil(Player.z) == this.z) && (Player.z >= 250) && (Player.x > x-1000f && Player.x < x+1000f) && (Player.y > y-3000f && Player.y < y+3000f)) {
            Player.collide();
        }


        if(true) {
            float[] p1 = Camera.calcPos(x-1500f, y-3500f, z);
            float[] p2 = Camera.calcPos(x-1500f, y+3500f, z);
            float[] p3 = Camera.calcPos(x+1500f, y+3500f, z);
            float[] p4 = Camera.calcPos(x+1500f, y-3500f, z);

            p.noStroke();
            p.textureMode(p.IMAGE);
            p.beginShape();
            p.texture(Stage.asteroidTexture[ind]);
            p.tint(255, p.lerp(255, 0, (z - (Camera.drawDistance/2) - Camera.z) / (Camera.drawDistance - (Camera.drawDistance/2))));
            p.vertex(p1[0], p1[1], 0, 0);
            p.vertex(p2[0], p2[1], 0, 240);
            p.vertex(p3[0], p3[1], 320, 240);
            p.vertex(p4[0], p4[1], 320, 0);
            p.endShape();
        }

        p.tint(255, 255);
    }
}
