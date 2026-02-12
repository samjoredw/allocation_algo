// ============================================================================================
//                            SPACIAL OPTIMIZATION ALLOCATION ALGO PAGE
//                      Allocates a set of shapes onto a three dimensional grid.
// ============================================================================================
package saos;

/**
 * The Saos class represents the Spacial Arrangement Optimization System
 * (SAOS) in the SAOS algorithm project. It provides methods for allocating
 * shapes onto a 3D grid using vector notation.
 * This class takes care of the spatial arrangement of shapes within a
 * specified grid, optimizing the allocation process. The allocation is
 * performed in a 3D space, considering the dimensions of both the grid
 * and the individual shapes. The SAOS algorithm efficiently determines
 * the placement of shapes to achieve optimal spatial organization.
 *
 * @version 4
 * @since 2023-12-13
 */
public class Saos {
    Grid grid;
    int numUnits;
    int unitsLeft;
    int shapeLength, shapeWidth, shapeHeight;
    int gridColumns, gridRows, gridLayers;

    /**
     * Constructs a Saos object with the specified grid, shape, and number of units.
     *
     * @param grid     The 3D grid to allocate shapes onto.
     * @param shape    The shape to be allocated onto the grid.
     * @param numUnits The number of units (shapes) to be placed on the grid.
     */
    Saos(Grid grid, Shape shape, int numUnits) {
        this.grid = grid;
        this.gridLayers = grid.layers;
        this.gridRows = grid.rows;
        this.gridColumns = grid.columns;

        this.shapeLength = shape.length;
        this.shapeWidth = shape.width;
        this.shapeHeight = shape.height;

        this.numUnits = numUnits;
        if (this.numUnits > calculateMaxShapes()) {
            this. numUnits = calculateMaxShapes();
        }
        this.unitsLeft = numUnits;

        allocateShape(grid.arr);
    }

    /**
     * Allocates the specified shape onto the 3D grid.
     *
     * This is where the majority of the multidimensional calculation occurs.
     * Its optimization complexity is O(n^3 * m)
     * Where n represents each dimension and m represents the number of shapes.
     *
     * I am always editing this and looking to improve it. A  set of recursive calls seem to perform
     *  similarly in the context of this application. If you have questions/comments, please reach out!
     *
     * @param array The 3D boolean array representing the grid.
     */
    public void allocateShape(boolean[][][] array) {

        int curX = 0;
        int curY = 0;
        int curZ = 0;

        // Complexity: O(n^4*m)
        while (unitsLeft > 0) {

            for (int i = 0; i < shapeHeight; i++,curZ++) {

                for (int j = 0; j < shapeWidth; j++,curY++) {

                    for (int k = 0; k < shapeLength; k++,curX++) {
                        if (i == 0 || i == shapeHeight - 1 || j == 0 || j == shapeWidth - 1
                                || k == 0 || k == shapeLength - 1) {
                            array[curZ][curY][curX] = true;
                        } else {
                            // Check if it is the bottom layer
                            if (curZ == 0) {
                                array[curZ][curY][curX] = false; // Set inner cells to false
                            }
                        }
                    }
                    curX -= shapeLength;
                }
                curY -= shapeWidth;
            }
            curZ -= shapeHeight;

            //Increment the start locations of each axis for the next
            curX += shapeLength;
            curY += shapeWidth;
            curZ += shapeHeight;


            if (curZ + shapeHeight > gridLayers && curY + shapeWidth > gridRows && curX + shapeLength > gridColumns) {
                return;
            }
            else if (curY + shapeWidth > gridRows && curX + shapeLength > gridColumns) {
                curX = 0;
                curY = 0;
            }
            else if (curX + shapeLength > gridColumns) {
                curX = 0;
                curZ -= shapeHeight;
            }
            else {
                curY -= shapeWidth;
                curZ -= shapeHeight;
            }
            unitsLeft--;
        }
    }

    /**
     * Calculates the maximum number of shapes that can fit on the grid.
     *
     * @return The maximum number of shapes that can be allocated on the grid.
     */
    public int calculateMaxShapes() {
        int maxShapesX = gridColumns / shapeLength;
        int maxShapesY = gridRows / shapeWidth;
        int maxShapesZ = gridLayers / shapeHeight;

        return maxShapesX * maxShapesY * maxShapesZ;
    }

    /**
     * Gets the number of units (shapes) left to be placed on the grid.
     *
     * @return The number of units left to be allocated.
     */
    public int getUnitsLeft() {

        return unitsLeft;
    }

}
