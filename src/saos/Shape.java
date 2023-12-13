//Shape.java
package saos;

public class Shape {
int length, width, height;
    public Shape(int length, int width, int height) {
        this. length = length;
        this.width = width;
        this.height = height;
    }

    public String getShapeType() {
        if (length == width && length == height) return "Cube";
        return "Cuboid";
    }
}
