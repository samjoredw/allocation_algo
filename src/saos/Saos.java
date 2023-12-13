//Saos.java
package saos;

public class Saos {
    Grid grid;
    Shape shape;
    int numUnits;
    int unitsLeft;
    int unallocUnits;
    int shapeLength, shapeWidth, shapeHeight;
    int gridColumns, gridRows, gridLayers;

    private CellNode columnHead, layerHead;

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

    public void allocateShape(boolean[][][] array) {

        int curX = 0;
        int curY = 0;
        int curZ = 0;

        // Complexity: O(unitesLeft * shapeHeight * shapeWidth * shapeLength)
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
                            } else {
                                array[curZ][curY][curX] = false;
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

    public int calculateMaxShapes() {
        int maxShapesX = gridColumns / shapeLength;
        int maxShapesY = gridRows / shapeWidth;
        int maxShapesZ = gridLayers / shapeHeight;

        return Math.min(Math.min(maxShapesX, maxShapesY), maxShapesZ);
    }

    public int getUnitsLeft() {
        return unitsLeft;
    }

}
