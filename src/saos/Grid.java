// ============================================================================================
//                                      GRID INITIALIZATION PAGE
//                            Used to create a grid and output grid visuals
// ============================================================================================
package saos;

/**
 * The Grid class represents a 3D grid used in the SAOS algorithm for
 * spatial arrangement optimization. It provides methods to initialize
 * the grid and print its contents in two dimensions.
 */
public class Grid {
    int rows, columns, layers = 20;

    boolean[][][] arr;

    /**
     * Constructs a Grid object with the specified number of rows and columns.
     *
     * @param numRows    The number of rows in the grid.
     * @param numColumns The number of columns in the grid.
     */
    public Grid(int numRows, int numColumns) {
        this.rows = numRows;
        this.columns = numColumns;

        arr = new boolean[layers][this.rows][this.columns];
    }

    /**
     * Prints the contents of the grid for a specific layer in two dimensions.
     *
     * @param layer The layer to be printed.
     */
    public void printGrid(int layer) {
        System.out.println("Grid layer: " + layer + ":");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print((arr[layer][i][j] ? "■ " : "□ ") + " ");
            }
            System.out.println();
        }
    }
}