import processing.core.*;

import ddf.minim.*;

public class Game extends PApplet {
    private static boolean play = false;
    private static PApplet p;
    private static Stage stage;
    private static PauseMenu pauseMenu;
    private static DeathMenu deathMenu;

    private static AudioPlayer player;
    private static Minim minim;

    public Game(PApplet pa) {
        p = pa;
        minim = new Minim(this);

        newGame();
    }

    public static void newGame() {
        stage = new Stage(p);
        pauseMenu = new PauseMenu(p);
        deathMenu = new DeathMenu(p);

        Player.speed = 15f;
//        playGame();
        if(player != null) player.close();
        player = minim.loadFile(Sketch.srcFolder + "game.mp3", 2048);

        player.loop();
        player.pause();
    }

    public static void newGameHard() {
        stage = new Stage(p);
        pauseMenu = new PauseMenu(p);
        deathMenu = new DeathMenu(p);

        Player.speed = 250f;
//        playGame();
        if(player != null) player.close();
        player = minim.loadFile(Sketch.srcFolder + "far.mp3", 2048);

        player.loop();
        player.pause();
    }

    public static void playGame() {
        play = true;
        player.play(0);

    }

    public static void pauseGame() {
        play = false;
        player.pause();
    }

    public static boolean isPlaying() {
        return play;
    }

    public void draw() {
        menuControls();
        stage.draw();

        if (!isPlaying() && !Player.isDead) pauseMenu.draw();

        if(Player.isDead) deathMenu.draw();
    }

    public void stop()
    {
        player.close();
        minim.stop();
        super.stop();
    }

    public void menuControls() {
        if (Keyboard.type() == (char) 27) {
            if (Game.isPlaying()) Game.pauseGame();
            else Game.playGame();
        }
    }
}
