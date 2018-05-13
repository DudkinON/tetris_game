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
    
}