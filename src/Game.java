import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;

class Game extends JFrame {

    private int gameScore = 0;
    public static int[][] canv = new int[GameSettings.FIELD_HEIGHT + 1][GameSettings.FIELD_WIDTH];
    private Canvas canvas = new Canvas();
    private static Figure figure = new Figure();
    private static boolean gameOver = false;

    /**
     * Return bool value game over
     * @return boolean
     */
    public static boolean isGameOver() {
        return gameOver;
    }

}