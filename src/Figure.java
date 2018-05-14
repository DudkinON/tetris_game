import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

class Figure {

    private ArrayList<Block> figure = new ArrayList<>();
    private int[][] shape = new int[4][4];
    private int size;
    private int color;
    private int x = 3, y = 0;

    // Create constructor
    Figure() {

        // Create random object
        Random random = new Random();

        // Define random integer in shapes array length range
        int type = random.nextInt(Shape.SHAPES.length);

        // Get size
        size = Shape.SHAPES[type][4][0];

        // Get a shape
        color = Shape.SHAPES[type][4][1];

        // If size 4 change start coordinate
        if (size == 4) y = -1;

        for (int i = 0; i < size; i++) {
            System.arraycopy(Shape.SHAPES[type][i], 0, shape[i], 0, Shape.SHAPES[type][i].length);
        }

        createFromShape();
    }

    /**
     * Generates a figure
     */
    private void createFromShape() {
        for (int x = 0; x < size; x++)
            for (int y = 0; y < size; y++)
                if (shape[y][x] == 1) figure.add(new Block(x + this.x, y + this.y));
    }

    /**
     * Checks the figure has touched the floor
     *
     * @return Boolean
     */
    boolean isTouch() {
        for (Block block : figure) if (Game.canv[block.getY() + 1][block.getX()] > 0) return true;
        return false;
    }

    /**
     * Checks the figure is on the floor
     *
     * @return Boolean
     */
    boolean isOn() {
        for (Block block : figure) if (Game.canv[block.getY()][block.getX()] > 0) return true;
        return false;
    }

    /**
     * Adds to the array index color
     */
    void leaveOn() {
        for (Block block : figure) Game.canv[block.getY()][block.getX()] = color;
    }

    /**
     * Checks the figure has touched edge of window
     *
     * @param direction: Direction an integer positive (right), negative (left)
     * @return Boolean
     */
    private boolean isTouchWall(int direction) {
        for (Block block : figure) {
            if (direction == GameSettings.KEY_LEFT &&
                    (block.getX() == 0 || Game.canv[block.getY()][block.getX() - 1] > 0)) return true;
            if (direction == GameSettings.KEY_RIGHT &&
                    (block.getX() == GameSettings.FIELD_WIDTH - 1 || Game.canv[block.getY()][block.getX() + 1] > 0))
                return true;
        }
        return false;
    }

    /**
     * Moves the figure by x on the left or on the right
     *
     * @param direction: An integer positive is right negative is left direction
     */
    void move(int direction) {
        if (!isTouchWall(direction)) {
            int dx = direction - 38;
            for (Block block : figure) block.setX(block.getX() + dx);
            x += dx;
        }
    }

    /**
     * Moves the figure down
     */
    void moveDown() {
        for (Block block : figure) block.setY(block.getY() + 1);
        y++;
    }
    
    void drop() {
        while (!isTouch()) moveDown();
    }

}