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

}