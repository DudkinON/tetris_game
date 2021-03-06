import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;

class Game extends JFrame {

    static int gameScore = 0;
    static int rows = 0;
    static int level = 0;
    static int[][] canv = new int[GameSettings.FIELD_HEIGHT + 1][GameSettings.FIELD_WIDTH];
    private Canvas canvas = new Canvas();
    private static Figure figure = new Figure();
    private static boolean gameOver = false;

    /**
     * Return bool value game over
     *
     * @return boolean
     */
    static boolean isGameOver() {
        return gameOver;
    }

    /**
     * Return figure
     *
     * @return object
     */
    static Figure getFigure() {
        return figure;
    }

    /**
     * Constructor of Game class. Create a window and set it
     */
    Game() {

        // Get block size
        int bSize = GameSettings.BLOCK_SIZE;

        // Set title of game
        setTitle(GameSettings.TITLE);

        // Set default close button and action
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Configure the window
        setBounds(
                GameSettings.WINDOW_X,
                GameSettings.WINDOW_Y,
                GameSettings.FIELD_WIDTH * bSize + GameSettings.FIELD_X,
                GameSettings.FIELD_HEIGHT * bSize + GameSettings.FIELD_Y);

        // Turn off resizable of window
        setResizable(false);

        // Set background color
        canvas.setBackground(Color.white);

        // Add keyboard listener
        addKeyListener(new KeyAdapter() {
            /**
             * Create a listener of keyboard
             * @param e: Key event
             */
            public void keyPressed(KeyEvent e) {
                if (!gameOver) {
                    if (e.getKeyCode() == GameSettings.KEY_DOWN) figure.drop();
                    if (e.getKeyCode() == GameSettings.KEY_UP) figure.rotate();
                    if (e.getKeyCode() == GameSettings.KEY_LEFT || e.getKeyCode() == GameSettings.KEY_RIGHT) {
                        figure.move(e.getKeyCode());
                    }
                }
                canvas.repaint();
            }
        });

        // Add canvas
        add(BorderLayout.CENTER, canvas);

        // Turn on visible
        setVisible(true);

        // Add border of canvas
        Arrays.fill(canv[GameSettings.FIELD_HEIGHT], 1);
    }

    /**
     * Runner of the game
     */
    void run() {
        while (!gameOver) {
            try {
                Thread.sleep(GameSettings.SPEED - (level * 100));
            } catch (Exception e) {
                e.printStackTrace();
            }

            canvas.repaint();

            // Check rows
            checkRows();

            // Update level
            updateLevel();

            if (figure.isTouch()) {

                // Leave figure on the flore
                figure.leaveOn();

                // Create a figure
                figure = new Figure();

                // Check that figure is fit
                gameOver = figure.isOn();
            } else {

                // Move the figure down
                figure.moveDown();
            }
        }
    }

    /**
     * Check rows for the filling if row/rows is full remove row/rows and increase the score
     */
    private void checkRows() {

        // Amount of rows
        int row = GameSettings.FIELD_HEIGHT - 1;

        // Amount of removed rows - once
        int countFillRows = 0;

        while (row > 0) {

            int filled = 1;

            for (int col = 0; col < GameSettings.FIELD_WIDTH; col++) filled *= Integer.signum(canv[row][col]);

            if (filled > 0) {

                countFillRows++;

                // Update amount of rows deleted
                rows++;
                for (int i = row; i > 0; i--) {
                    // If line is full remove it
                    System.arraycopy(canv[i - 1], 0, canv[i], 0, GameSettings.FIELD_WIDTH);
                }
            } else {
                row--;
            }
        }
        if (countFillRows > 0) {

            // Increase the score
            gameScore += GameSettings.SCORE[countFillRows - 1];

            // Display new score
            setTitle(GameSettings.TITLE);
        }
    }

    /**
     * Check score and update level
     */
    private void updateLevel() {
        if (gameScore >= 200000) level = 10;
        else if (gameScore >= 100000) level = 9;
        else if (gameScore >= 60000) level = 8;
        else if (gameScore >= 30000) level = 7;
        else if (gameScore >= 15000) level = 6;
        else if (gameScore >= 8000) level = 5;
        else if (gameScore >= 4000) level = 4;
        else if (gameScore >= 2000) level = 3;
        else if (gameScore >= 1000) level = 2;
        else if (gameScore >= 500) level = 1;
    }
}