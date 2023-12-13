//Grid.java
package saos;

public class Grid {
    int rows, columns, layers = 20;

    boolean[][][] arr;
    public Grid(int numRows, int numColumns) {
        this.rows = numRows;
        this.columns = numColumns;

        arr = new boolean[layers][this.rows][this.columns];
    }

    //prints the grid in two dimensions
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