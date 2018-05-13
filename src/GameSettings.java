import java.awt.*;

class GameSettings {
    final static String TITLE = "Tetris";

    // Size of a block
    final static int BLOCK_SIZE = 30;

    // Radius of block
    final static int RADIUS = 6;

    // Width of a block
    final static int FIELD_WIDTH = 10;

    // Height of a block
    final static int FIELD_HEIGHT = 18;

    // Initial position of the window
    final static int WINDOW_X = 300;
    final static int WINDOW_Y = 150;

    // Initial size of the window
    final static int FIELD_X = 3;
    final static int FIELD_Y = 50;

    // Key codes
    final static int KEY_LEFT = 37;
    final static int KEY_RIGHT = 39;
    final static int KEY_UP = 38;
    final static int KEY_DOWN = 40;
    final static int KEY_ENTER = 13;

    // Game speed less faster
    final static int SPEED = 1250;

    // The game score
    final static int[] SCORE = {100, 300, 700, 1500};

    // Color of dropped blocks {R, G, B}
    final static Color MAIN_COLOR = new Color(52, 139, 184);

    // Fonts
    final static Font GAME_OVER_FONT = new Font("Arial", Font.BOLD, 80);
    final static Font INFO_FONT = new Font("Arial", Font.BOLD, 16);
}
