import processing.core.PApplet;

import java.math.BigDecimal;

public class Camera {

    public static final float fieldOfView = 100f;
    public static final float cameraHeight = 1000f;
    public static final float cameraDepth = 0f;
    public static final float drawDistance = 250;
    public static float d;
    public static float fps;
    public static float step;
    public static float fov;
    public static float x, y, z, a = 0f;
    public static float screenWidth;
    public static float screenHeight;
    private static PApplet p;

    public Camera(PApplet pApplet) {
        p = pApplet;
        update();
        x = 0f;
        y = -1.3f;
        z = 0f;
        a = 0;
        fov = 1.5f;
    }

    public static float d(float zw) {
        return zw - z;
    }

    public static void update() {
        screenWidth = p.width;
        screenHeight = p.height;
        d = (float)(1/Math.tan(fieldOfView/2));
        fps = p.frameRate;
        step = (60 / fps) * 0.1f;

        x = p.lerp(-1f, 1f, (Player.x - Player.minX) / (Player.maxX - Player.minX));
        y = p.lerp(-2f, 2f, (Player.y - Player.minY) / (Player.maxY - Player.minY));



        z = Player.z-10;
    }

    public static boolean isVisible(float zw) {
        boolean vis = z < zw;
        return vis;
    }

    public static float[] calcPos(float xw, float yw, float zw) {

        float xc = (xw/200) - x;
        float yc = (yw/500) - y;
        float zc = (zw) - z;

//        p.text(xc + " / " + yc + " / " + zc, 500, 50);

        float xp = xc * (d/zc);
        float yp = yc * (d/zc);

//        p.text(xp + " / " + yp, 500, 75);

        float xs = (screenWidth/2) + ((screenWidth/2)*xp);
        float ys = (screenHeight/2) - ((screenHeight/2)*yp);

//        p.text(xs + " / " + ys, 500, 100);

//        float xs = 0f;
//        float ys = 0f;
//        float xs = (screenWidth / 2) + (screenWidth / 2) * ((xw - x) * ((d / zw) - z));
//        float ys = (screenHeight / 2) + (screenHeight / 2) * ((yw - y) * ((d / zw) - z));
        return new float[]{xs, ys};
    }
}
