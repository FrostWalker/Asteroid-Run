import processing.core.*;

public class PauseMenu extends PApplet {

    private PApplet p;

    public PauseMenu(PApplet p) {
        this.p = p;
    }

    public void draw() {




        p.fill(color(0, 150));
        p.rect(25, 25, p.width-50, p.height-50);

        float pw = p.width;
        float ph = p.height;
        float px = 0;
        float py = 0;


        if (true) { //LOGO
            float cw = pw * 0.8f;
            float ch = ph * 0.2f;
            float cx = px * 1.6f + pw * 0.1f;
            float cy = py + ph * 0.1f;

            p.noStroke();
            p.fill(color(150));
//            p.rect(cx, cy, cw, ch);
//            p.text("PAUSE LOGO", cx, cy);
            p.textSize(72);
            p.textAlign(p.CENTER);
            p.text("PAUSE", cx+cw/2, cy+50);
        }

        if (true) { //RESTART Button
            float cw = pw * 0.4f;
            float ch = ph * 0.1f;
            float cx = px * 1.3f + pw * 0.3f;
            float cy = py + ph * 0.6f;

            p.noStroke();
            p.fill(Mouse.leftClick(cx, cy, cw, ch) ? color(255) : Mouse.hover(cx, cy, cw, ch) ? color(200) : color(150));
//            p.rect(cx, cy, cw, ch);
//            p.text("RESTART", cx, cy);
            p.textSize(28);
            p.textAlign(p.CENTER);
            p.text("RESTART GAME", cx+cw/2, cy+50);

            if (Mouse.buttonPress(cx, cy, cw, ch)) {
                Game.newGame();
                Game.playGame();
            }
        }

        if (true) { //RETURN Button
            float cw = pw * 0.4f;
            float ch = ph * 0.1f;
            float cx = px * 1.1f + pw * 0.3f;
            float cy = py + ph * 0.75f;

            p.noStroke();
            p.fill(Mouse.leftClick(cx, cy, cw, ch) ? color(255) : Mouse.hover(cx, cy, cw, ch) ? color(200) : color(150));
//            p.rect(cx, cy, cw, ch);
//            p.text("RETURN TO GAME", cx, cy);
            p.textSize(28);
            p.textAlign(p.CENTER);
            p.text("RESUME GAME", cx+cw/2, cy+50);

            if (Mouse.buttonPress(cx, cy, cw, ch)) {
                if (Game.isPlaying()) Game.pauseGame();
                else Game.playGame();
            }
        }
    }

}
