import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

public class Segment {

    private PApplet p;

    private float x, y, z;
    private List<GameObject> gameObjects = new ArrayList<GameObject>();


    public Segment(float x, float y, float z,  PApplet p) {
        this.p = p;

        this.x = x;
        this.y = y;
        this.z = z;

        int ranNum = (int)p.random(0f, 20f);
        if(ranNum <= 1) {
            for(int i = 0; i < ranNum; ++i) {
                gameObjects.add(new GameObject(z, p));
            }
        }

    }
    
    public void unload() {
      gameObjects = new ArrayList<GameObject>();
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void draw() {
        if (Camera.isVisible(z)) {

            for(GameObject gO : gameObjects) {
                gO.draw();
            }

            if(Math.floor(Player.z) == Math.floor(this.z)) {
                Player.draw();
            }


//            if(true) {
//                float[] p1 = Camera.calcPos(Track.roadWidth, 0f, z + 1);
//                float[] p2 = Camera.calcPos(Track.roadWidth, 0f, z);
//                float[] p3 = Camera.calcPos(-Track.roadWidth, 0f, z);
//                float[] p4 = Camera.calcPos(-Track.roadWidth, 0f, z + 1);
//
//                p.noStroke();
//                p.textureMode(p.IMAGE);
//                p.beginShape();
//                p.texture(Stage.roadTexture);
//                p.vertex(p1[0], p1[1], 100, 100);
//                p.vertex(p2[0], p2[1], 0, 100);
//                p.vertex(p3[0], p3[1], 0, 0);
//                p.vertex(p4[0], p4[1], 100, 0);
//                p.endShape();
//
//                p.line(p2[0], p2[1], p3[0], p3[1]);
//            }
        }
    }
}
