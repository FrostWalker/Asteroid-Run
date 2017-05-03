import processing.core.*;

public class Sketch extends PApplet {

    private Mouse mouse = new Mouse(this);
    private Keyboard keyboard;
    private Menu menu;
    private Game game;
    
    public static String srcFolder;

    public void setup() {
      srcFolder = args[0] + "data/";
        size(1280, 720, P3D);
        mouse = new Mouse(this);
        keyboard = new Keyboard(this);
//        size(displayWidth, displayHeight);
//        frameRate(24);
        registerMethod("pre", this);
        menu = new Menu(this);
        game = new Game(this);
    }
    
    public void pre() {
//      if(frameCount <= 1) {
//
//      System.out.println("hi");
//        menu = new Menu(this);
//      }
    }

    public void draw() {

//        if(frameCount % (frameRate * 1) < 1) System.gc();
//System.out.println("ho");
        background(0);


        PFont font = createFont("Arial", 72);
        textFont(font);


        if(menu.start) game.draw();

        menu.draw();

//        debug();
    }

    public void keyPressed() {
        if (key == ESC) key = 0; //Capture escape key
    }

    public void debug() {
        textSize(12);
        stroke(Mouse.rightClick() ? 0 : 255, Mouse.middleClick() ? 0 : 255, Mouse.leftClick() ? 0 : 255, Mouse.click() ? 255 : 100);
        strokeWeight(Mouse.click() ? 3 : 2);
        noFill();
        ellipse(Mouse.x(), Mouse.y(), 50, 50);

        StringBuilder sb = new StringBuilder();
        for (int i : Keyboard.getKeyList()) {
            sb.append((char) i);
            sb.append("\t ");
        }

        fill(Mouse.rightClick() ? 0 : 255, Mouse.middleClick() ? 0 : 255, Mouse.leftClick() ? 0 : 255, Mouse.click() ? 255 : 100);
        noStroke();
        text(Mouse.x() + "," + Mouse.y(), Mouse.x() + 32, Mouse.y() + 32);
        text(sb.toString(), Mouse.x() + 32, Mouse.y() + 52);
        text(Keyboard.getLastChar(), Mouse.x() + 32, Mouse.y() + 72);
    }

//    public boolean sketchFullScreen() {
//        return true;
//    }
}
