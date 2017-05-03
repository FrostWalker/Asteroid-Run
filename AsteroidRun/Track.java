import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Track {
    public static final float roadWidth = 200;
    public static final int lanes = 3;
    public static float trackLength = 0f;
    private static PApplet p;
    private static List<Segment> segments = new ArrayList<Segment>();

    public Track(PApplet pApplet) {
        p = pApplet;
        initiateRoad();
    }

    public static List<Segment> getSegments() {
        return segments;
    }

    public static void draw() {
        while(segments.size() <= Camera.z + Camera.drawDistance) {
            segments.add(new Segment(Player.x, Player.y, segments.size(), p));
            segments.get((int)Camera.z - 1).unload();
//            segments.set((int)Camera.z - 1, null);
            segments.remove(Camera.z - 1);
        }

        for (int i = (((int) (Camera.z + Camera.drawDistance) >= segments.size()) ? (segments.size() - 1) : ((int) (Camera.z + Camera.drawDistance))); i >= (((int) Camera.z < 0) ? (0) : ((int) Camera.z)); --i) {
            segments.get(i).draw();
        }
    }

    public static void initiateRoad() {
        segments = new ArrayList<Segment>();
        for (int i = 0; i < Camera.drawDistance*2; ++i) {
            segments.add(new Segment(Player.x, Player.y, i, p));
        }

        trackLength = segments.size();
    }

}
