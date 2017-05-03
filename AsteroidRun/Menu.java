import processing.core.*;



import ddf.minim.*;

public class Menu extends PApplet {
    private PApplet p;
    private int startFrame;
    private int startFrameY;
    private int screen;
    private int screenCount;
    private int lastScreen;
    public static boolean start;
    public static boolean hide;
    public static PImage backgroundTexture;

    private static AudioPlayer player;
    private Minim minim;

    public Menu(PApplet p) {
        this.p = p;
        this.screen = 1;
        this.lastScreen = screen;
        this.screenCount = 2;
        this.startFrame = 0;
        this.startFrameY = 0;
        hide = false;
        start = false;
        backgroundTexture = p.loadImage(Sketch.srcFolder + "background.jpg");



        minim = new Minim(this);
        player = minim.loadFile(Sketch.srcFolder + "menu.mp3", 2048);
        player.loop();
        player.play();
    }

    public float transition() {
        float val = startFrame > 0 ? lerp((float) lastScreen / (float) screenCount, (float) screen / (float) screenCount, ((p.frameCount - startFrame) / p.frameRate)) : (float) screen / (float) screenCount;
        if ((lastScreen > screen && val < ((float) screen / (float) screenCount)) || (lastScreen < screen && val > ((float) screen / (float) screenCount)))
            startFrame = 0;
        return val;
    }

    public void transition(int d) {
        lastScreen = screen;
        screen += d;
        startFrame = p.frameCount;
    }

    private void playGame() {
        start = true;
        startFrameY = 0;
        player.close();
        minim.stop();
        Game.playGame();
    }

    private float playTransition() {
        if (start) {
            float val;
            if (startFrameY == 0) startFrameY = p.frameCount;
            val = (p.frameCount - startFrameY) / p.frameRate;
            if (val > 1) {
                val = 1;
                hide = true;
            }
            return val;
        }
        startFrameY = 0;
        return 0;
    }

    public boolean isHidden() {
        return this.hide;
    }

    public void draw() {

        if (!this.hide) {
            p.textSize(12);
            p.background(50);

            int width = p.width;
            int height = p.height;
            p.image(backgroundTexture, 0-(width/2), 0-(height/2), width*2, height*2);

            p.fill(color(0, 150));
            p.rect(25, 25, p.width-50, p.height-50);

            p.fill(150, 100);
            p.text("ASTEROID RUN v0.004a", 5, p.height - 5);

            p.text(playTransition(), 50, 50);

            float pw = p.width;
            float ph = p.height;
            float py = lerp(0, -ph, playTransition());
            if (true) { //Credits Page
                float px = lerp(0, -(pw * screenCount), transition());


                if (true) { //LOGO
                    float cw = pw * 0.8f;
                    float ch = ph * 0.2f;
                    float cx = px * 1.6f + pw * 0.1f;
                    float cy = py + ph * 0.1f;

                    p.noStroke();
                    p.fill(color(150));
//                    p.rect(cx, cy, cw, ch);
//                    p.text("CREDITS LOGO", cx, cy);
                    p.textSize(72);
                    p.textAlign(p.CENTER);
                    p.text("CREDITS", cx+cw/2, cy+50);
                }

                if (true) { //CREDITS
                    float cw = pw * 0.6f;
                    float ch = ph * 0.45f;
                    float cx = px * 1.35f + pw * 0.2f;
                    float cy = py + ph * 0.25f;

                    p.noStroke();
                    p.fill(color(255));
//                    p.text("ACTUAL TUTORIAL", cx, cy);
                    p.textSize(16);
                    p.textAlign(p.LEFT);

                    p.text("Game Code: Sam Pappafloratos", cx+25, cy+25);
                    p.text("Game Design: Sam Pappafloratos", cx+25, cy+50);

                    p.text("Menu Music: Prologue by Eric Skiff", cx+25, cy+100);
                    p.text("Background Music: Come and Find Me by Eric Skiff", cx+25, cy+125);

                    p.text("Asteroid Sprites: phaelax @ opengameart.org (http://opengameart.org/content/asteroids)", cx+25, cy+175);

                    p.text("Asteroid run is a simple obstacle racing game with a simple goal: get as far as possible without crashing into an asteroid! It was inspired by the classic 2D racing games of the 80's such as F-Zero, as well as Code inComplete's HTML5 adapation of the classic sega game Out Run", cx+25, cy+225, cw - 50, ch - 200);


                }

                if (true) { //RETURN Button
                    float cw = pw * 0.4f;
                    float ch = ph * 0.1f;
                    float cx = px * 1.1f + pw * 0.3f;
                    float cy = py + ph * 0.75f;

                    p.noStroke();
                    p.fill(Mouse.leftClick(cx, cy, cw, ch) ? color(255) : Mouse.hover(cx, cy, cw, ch) ? color(200) : color(150));
//                    p.rect(cx, cy, cw, ch);
//                    p.text("BACK TO MENU", cx, cy);
                    p.textSize(28);
                    p.textAlign(p.CENTER);
                    p.text("RETURN", cx+cw/2, cy+50);

                    if (Mouse.buttonPress(cx, cy, cw, ch)) {
                        transition(1);
                    }
                }
            }

            if (true) { //Start Page
                float px = lerp(p.width, -(pw * (screenCount - 1)), transition());


                if (true) { //LOGO
                    float cw = pw * 0.8f;
                    float ch = ph * 0.2f;
                    float cx = px * 1.6f + pw * 0.1f;
                    float cy = py + ph * 0.1f;

                    p.noStroke();
                    p.fill(color(150));
//                    p.rect(cx, cy, cw, ch);
//                    p.text("LOGO", cx, cy);
                    p.textSize(72);
                    p.textAlign(p.CENTER);
                    p.text("ASTEROID RUN", cx+cw/2, cy+50);
                }

                if (true) { //PLAY Button
                    float cw = pw * 0.4f;
                    float ch = ph * 0.1f;
                    float cx = px * 1.5f + pw * 0.3f;
                    float cy = py + ph * 0.45f;

                    p.noStroke();
                    p.fill(Mouse.leftClick(cx, cy, cw, ch) ? color(255) : Mouse.hover(cx, cy, cw, ch) ? color(200) : color(150));
//                    p.rect(cx, cy, cw, ch);
//                    p.text("PLAY", cx, cy);
                    p.textSize(28);
                    p.textAlign(p.CENTER);
                    p.text("PLAY", cx+cw/2, cy+50);

                    if (Mouse.buttonPress(cx, cy, cw, ch)) {
                        playGame();
                    }
                }

                if (true) { //TUTORIAL Button
                    float cw = pw * 0.4f;
                    float ch = ph * 0.1f;
                    float cx = px * 1.3f + pw * 0.3f;
                    float cy = py + ph * 0.6f;

                    p.noStroke();
                    p.fill(Mouse.leftClick(cx, cy, cw, ch) ? color(255) : Mouse.hover(cx, cy, cw, ch) ? color(200) : color(150));
//                    p.rect(cx, cy, cw, ch);
//                    p.text("TUTORIAL", cx, cy);
                    p.textSize(28);
                    p.textAlign(p.CENTER);
                    p.text("TUTORIAL", cx+cw/2, cy+50);

                    if (Mouse.buttonPress(cx, cy, cw, ch)) {
                        transition(1);
                    }
                }

                if (true) { //CREDITS Button
                    float cw = pw * 0.4f;
                    float ch = ph * 0.1f;
                    float cx = px * 1.1f + pw * 0.3f;
                    float cy = py + ph * 0.75f;

                    p.noStroke();
                    p.fill(Mouse.leftClick(cx, cy, cw, ch) ? color(255) : Mouse.hover(cx, cy, cw, ch) ? color(200) : color(150));
//                    p.rect(cx, cy, cw, ch);
//                    p.text("CREDITS", cx, cy);
                    p.textSize(28);
                    p.textAlign(p.CENTER);
                    p.text("CREDITS", cx+cw/2, cy+50);

                    if (Mouse.buttonPress(cx, cy, cw, ch)) {
                        transition(-1);
                    }
                }
            }

            if (true) { //Tutorial Page
                float px = lerp(pw * screenCount, 0, transition());


                if (true) { //LOGO
                    float cw = pw * 0.8f;
                    float ch = ph * 0.2f;
                    float cx = px * 1.6f + pw * 0.1f;
                    float cy = py + ph * 0.1f;

                    p.noStroke();
                    p.fill(color(150));
//                    p.rect(cx, cy, cw, ch);
//                    p.text("TUTORIAL LOGO", cx, cy);
                    p.textSize(72);
                    p.textAlign(p.CENTER);
                    p.text("TUTORIAL", cx+cw/2, cy+50);
                }

                if (true) { //TUTORIAL
                    float cw = pw * 0.6f;
                    float ch = ph * 0.45f;
                    float cx = px * 1.35f + pw * 0.2f;
                    float cy = py + ph * 0.25f;

                    p.noStroke();
                    p.fill(color(250));
//                    p.text("ACTUAL TUTORIAL", cx, cy);
                    p.textSize(16);
                    p.textAlign(p.LEFT);
                    p.text("The controls for Asteroid Run follow a basic WASD layout: \n Press the W key to go up \n Press the S key to go down \n Press the A key to go left \n Press the D key to go right \n\n You can pause the game at any time by pressing the ESC Escape key \n\n Use the mouse to control and navigate the menus", cx+25, cy+25, cw - 50, ch - 50);
                }

                if (true) { //RETURN Button
                    float cw = pw * 0.4f;
                    float ch = ph * 0.1f;
                    float cx = px * 1.1f + pw * 0.3f;
                    float cy = py + ph * 0.75f;

                    p.noStroke();
                    p.fill(Mouse.leftClick(cx, cy, cw, ch) ? color(255) : Mouse.hover(cx, cy, cw, ch) ? color(200) : color(150));
//                    p.rect(cx, cy, cw, ch);
//                    p.text("BACK TO MENU", cx, cy);
                    p.textSize(28);
                    p.textAlign(p.CENTER);
                    p.text("RETURN", cx+cw/2, cy+50);

                    if (Mouse.buttonPress(cx, cy, cw, ch)) {
                        transition(-1);
                    }
                }
            }

            p.fill(0, lerp(0, 255, playTransition()));
            p.rect(0, 0, pw, ph);

            p.textSize(12);
        }
    }
}
