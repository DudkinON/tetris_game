import javax.swing.*;
import java.awt.*;

/**
 * Canvas is the main method for rendering game.
 */
class Canvas extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int x = 0; x < GameSettings.FIELD_WIDTH; x++) {
            for (int y = 0; y < GameSettings.FIELD_HEIGHT; y++) {
                if (Game.canv[y][x] > 0) {

                    // Set main color for a block
                    g.setColor(GameSettings.MAIN_COLOR);

                    // define block size
                    int bSize = GameSettings.BLOCK_SIZE;

                    // Paints a highlighted rectangle filled with the current color
                    g.fill3DRect(x * bSize + 1, y * bSize + 1, bSize - 1, bSize - 1, true);
                }
            }
        }

        // Set font for the info panel text
        g.setFont(GameSettings.INFO_FONT);

        // Define color
        g.setColor(Color.darkGray);

        // Display level, lines, and score (game info) in the bottom of window
        g.drawString("Level: " + Game.level, 10, 560);
        g.drawString("Lines: " + Game.rows, 90, 560);
        g.drawString("Score: " + Game.gameScore, 180, 560);


        if (Game.isGameOver()) {

            // Set font for game over writing
            g.setFont(GameSettings.GAME_OVER_FONT);

            // Define color
            g.setColor(Color.red);

            // Display it
            g.drawString("GAME", 30, 160);
            g.drawString("OVER", 30, 250);

        } else {

            // Else continue the game
            Game.getFigure().paint(g);
        }
    }
}