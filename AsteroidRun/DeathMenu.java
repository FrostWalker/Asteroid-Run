import processing.core.PApplet;

public class DeathMenu extends PApplet {

    private PApplet p;

    public DeathMenu(PApplet p) {
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
            p.text("YOU ARE DEAD", cx+cw/2, cy+50);
        }

        if (true) { //SCORE
            float cw = pw * 0.4f;
            float ch = ph * 0.1f;
            float cx = px * 1.1f + pw * 0.3f;
            float cy = py + ph * 0.45f;

            p.noStroke();
            p.fill(color(150));
//            p.rect(cx, cy, cw, ch);
//            p.text("SCORE", cx, cy);
            p.textSize(42);
            p.textAlign(p.CENTER);
            p.text("Your score: " + (int)Player.z, cx+cw/2, cy+50);

            if (Mouse.buttonPress(cx, cy, cw, ch)) {
                Game.newGame();
                Game.playGame();
            }
        }

        if (true) { //EASY Button
            float cw = pw * 0.4f;
            float ch = ph * 0.075f;
            float cx = px * 1.1f + pw * 0.3f;
            float cy = py + ph * 0.65f;

            p.noStroke();
            p.fill(Mouse.leftClick(cx, cy, cw, ch) ? color(255) : Mouse.hover(cx, cy, cw, ch) ? color(200) : color(150));
//            p.rect(cx, cy, cw, ch);
//            p.text("RESTART", cx, cy);
            p.textSize(12);
            p.textAlign(p.CENTER);
            p.text("easy mode?", cx + cw / 2, cy + 50);

            if (Mouse.buttonPress(cx, cy, cw, ch)) {
                Game.newGameHard();
                Game.playGame();
            }
        }

        if (true) { //RESTART Button
            float cw = pw * 0.4f;
            float ch = ph * 0.1f;
            float cx = px * 1.1f + pw * 0.3f;
            float cy = py + ph * 0.75f;

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
    }

}
