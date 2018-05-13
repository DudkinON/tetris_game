import java.awt.*;

/**
 * Create a block for a figure
 */
class Block {

    private int x, y;

    // Create constructor
    Block(int x, int y) {
        setX(x);
        setY(y);
    }

    // Setters
    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    // Getters
    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    /**
     * Render a block for a figure
     *
     * @param g:     Object
     * @param color: Object
     */
    void paint(Graphics g, int color) {

        // Set color
        g.setColor(new Color(color));

        // Define block size and radius
        int bSize = GameSettings.BLOCK_SIZE;
        int radius = GameSettings.RADIUS;

        // Render
        g.fillRoundRect(x * bSize + 1, y * bSize + 1, bSize - 2, bSize - 2, radius, radius);

    }
}