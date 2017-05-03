import processing.core.*;
import processing.event.MouseEvent;

public class Mouse {

    private static float x, y;
    private static boolean mousePressed, leftClick, middleClick, rightClick;
    private static int leftButton, middleButton, rightButton;
    private static boolean disengage;

    public Mouse(PApplet p) {
        p.registerMethod("mouseEvent", this);
        leftButton = PApplet.LEFT;
        middleButton = PApplet.CENTER;
        rightButton = PApplet.RIGHT;
    }

    public static void disengage() {
        mousePressed = false;
        leftClick = false;
        middleClick = false;
        rightClick = false;
    }

    public static float x() {
        return x;
    }

    public static float y() {
        return y;
    }

    public static boolean hover(float cx, float cy, float cw, float ch) {
        return x() > cx && x() < cx + cw && y() > cy && y() < cy + ch;
    }

    public static boolean click() {
        return mousePressed;
    }

    public static boolean click(float cx, float cy, float cw, float ch) {
        return mousePressed && x() > cx && x() < cx + cw && y() > cy && y() < cy + ch;
    }

    public static boolean leftClick() {
        return click() && leftClick;
    }

    public static boolean leftClick(float cx, float cy, float cw, float ch) {
        return leftClick() && x() > cx && x() < cx + cw && y() > cy && y() < cy + ch;
    }

    public static boolean middleClick() {
        return click() && middleClick;
    }

    public static boolean middleClick(float cx, float cy, float cw, float ch) {
        return middleClick() && x() > cx && x() < cx + cw && y() > cy && y() < cy + ch;
    }

    public static boolean rightClick() {
        return click() && rightClick;
    }

    public static boolean rightClick(float cx, float cy, float cw, float ch) {
        return rightClick() && x() > cx && x() < cx + cw && y() > cy && y() < cy + ch;
    }

    public static boolean buttonPress() {
        if (leftClick() && !disengage) {
            disengage = true;
            return true;
        }
        return false;
    }

    public static boolean buttonPress(float cx, float cy, float cw, float ch) {
        if (leftClick(cx, cy, cw, ch) && !disengage) {
            disengage = true;
            return true;
        }
        return false;
    }

    public void mouseEvent(MouseEvent event) {
        x = event.getX();
        y = event.getY();
        switch (event.getAction()) {
            case MouseEvent.PRESS:
                mousePressed = true;
                if (event.getButton() == leftButton) {
                    leftClick = true;
                    middleClick = false;
                    rightClick = false;
                }
                if (event.getButton() == middleButton) {
                    leftClick = false;
                    middleClick = true;
                    rightClick = false;
                }
                if (event.getButton() == rightButton) {
                    leftClick = false;
                    middleClick = false;
                    rightClick = true;
                }
                break;
            case MouseEvent.RELEASE:
                disengage = false;
                mousePressed = false;
                leftClick = false;
                middleClick = false;
                rightClick = false;
                break;
            case MouseEvent.CLICK:
//                System.out.println("Mouse Click");
                break;
            case MouseEvent.DRAG:
//                System.out.println("Mouse Dragging");
                break;
            case MouseEvent.MOVE:
//                System.out.println("Mouse Moving");
                break;
        }
    }
}
