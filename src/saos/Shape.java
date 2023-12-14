// ============================================================================================
//                                            SHAPE PAGE
//                                      Creates a shape object.
// ============================================================================================
package saos;

/**
 * Represents an individual shape with dimensions and a method to determine its type.
 *
 * This class encapsulates the properties of a shape, including length, width, and height.
 * It provides a method to categorize the shape as a "Cube" or "Cuboid" based on its dimensions.
 *
 */
public class Shape {
    int length, width, height;

    /**
     * Constructs a Shape object with the specified dimensions.
     *
     * @param length The length of the shape.
     * @param width  The width of the shape.
     * @param height The height of the shape.
     */
    public Shape(int length, int width, int height) {
        this. length = length;
        this.width = width;
        this.height = height;
    }

    /**
     * Gets the type of the shape based on its dimensions.
     *
     * @return The type of the shape, either "Cube" or "Cuboid".
     */
    public String getShapeType() {
        if (length == width && length == height) return "Cube";
        return "Cuboid";
    }
}
