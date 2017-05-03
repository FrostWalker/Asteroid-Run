import processing.core.*;
import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class Keyboard {
    private static List<Character> keyList = new ArrayList<Character>();
    private static char lastType = (char) 0;
    private static char lastChar = (char) 0;
    private static boolean disengage;
    private static StringBuilder sb = new StringBuilder();

    public Keyboard(PApplet p) {
        p.registerMethod("keyEvent", this);
    }

    public static void disengage() {
        keyList.clear();
    }

    public static boolean press(char c) {
        return keyList.contains(c);
    }

    public static boolean press(int keyCode) {
        return keyList.contains((char) keyCode);
    }

    public static char type() {
        if (lastType != (char) 0 && (!disengage || lastChar != lastType)) {
            disengage = true;
            lastChar = lastType;
            return lastType;
        }
        return (char) 0;
    }

    public static char getLastChar() {
        return lastType;
    }

    public static String textInput() {
//        System.out.println(getLastChar());
//        sb.append(type());
        return "lol";
    }

    public static List<Character> getKeyList() {
        return keyList;
    }

    public void keyEvent(KeyEvent event) {
        switch (event.getAction()) {
            case KeyEvent.PRESS:
                if (!keyList.contains(event.getKey())) keyList.add(event.getKey());
                break;
            case KeyEvent.TYPE:
                lastType = event.getKey();
                break;
            case KeyEvent.RELEASE:
                disengage = false;
                lastType = (char) 0;
                if (keyList.contains(event.getKey())) keyList.remove((Character) event.getKey());
                break;
        }
    }


}
