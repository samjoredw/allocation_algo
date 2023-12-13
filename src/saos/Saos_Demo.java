//Saos_Demo.java
package saos;
import java.util.Scanner;
/*
This class demonstrates the usage of SAOS.
 */
public class Saos_Demo {

    public static void main(String[] args) throws InterruptedException {

        int loop = 0;

        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("SAOS Algorithm Project");
        System.out.println("-----------------------");

        System.out.println("""
                Hello! Welcome to a demo of my 3D allocation algorithm.
                I personally developed an algorithm called Spacial Arrangement Optimization
                System (SAOS) that optimally arranges shapes onto a grid from bottom to\s
                top.""");
        System.out.println();
        System.out.println("""
                As a Manhattan native, I became curious as to how skyscrapers in downtown
                Manhattan could be represented mathematically before construction. I realized that
                determining a specific lot size and number of units requested in each building is\s
                essential information that should be determined well before any other engineering or
                architecture is considered.""");
        System.out.println();
        System.out.println("""
                Additionally, I found that these lots and units could be represented linearly through
                a set of matrix arrays (3D arrays) which would help bridge the gap between a conceptual and
                physical understanding of how the dimensions of shapes are algorithmically allocated into 
                a specified hyperplane.""");
        System.out.println();
        System.out.println("""
                Thus, I created this algorithm to systematically determine a mathematical
                blueprint to allow for proper allocation of units on a limited lot space like in
                downtown Manhattan.""");
        System.out.println("Please feel free to demo my algorithm and play with some of its components.");
        System.out.println();
        System.out.print("Press enter for demo.");
        scan.nextLine();

        while (loop == 0) {

            System.out.println();
            System.out.println("Spatial Arrangement Optimization System");
            System.out.println("----------------------------------------");

            System.out.println("This program dynamically allocates a set of shapes onto a three" +
                    "\ndimensional grid using vector notation.");

            System.out.println("""
                    Goal: SAOS allows for optimal allocation of each shape starting in the x-axis,
                    y-axis, then z-axis to support a realistic simulation of how shapes would be placed
                    on a specified lot.""");
            System.out.println("""
                    Usage: The arrangement of shape-defined space in a specific lot is useful in
                    the cases of buildings where we need to define the set amount of space, and determine
                    the amount of units that can be placed in a predetermined grid lot.
                    However, its utility far exceeds buildings; it can be utilized for optimizing resource\s
                    allocation, streamlining logistical planning, and enhancing spatial organization in diverse\s
                    mathematical and scientific applications.""");

            System.out.println();
            System.out.print("Press enter to define grid space and set shape dimensions.");
            scan.nextLine();

            Thread.sleep(1);

            System.out.println();
            System.out.println("Defining the Grid");
            System.out.println("------------------");

            System.out.println("""
                    Please enter the dimensions of the grid that you would like to\s
                    allocate a set number of shapes on. Note that the z-axis is set to a default
                    dimension of 20.""");
            System.out.println("Grid dimension examples ('10 10', '20 20', '30 15'): ");


            Grid grid = new Grid(scan.nextInt(), scan.nextInt());
            System.out.println();
            System.out.println("Initial Grid View (XY Plane):");
            // Print out the initial state of the grid in the XY plane
            grid.printGrid(0);
            System.out.println();

            System.out.println("Defining the Unit Size");
            System.out.println("------------------");

            System.out.println("""
                    Now that a grid in three dimensions has been specified, determine the
                    number of, and size of, your individual shapes (units) that you would like to\s
                    place onto the grid.""");
            System.out.println("Shape dimension examples ('4 4 3', '6 7 3', '4 3 5'): ");

            Shape shape = new Shape(scan.nextInt(), scan.nextInt(), scan.nextInt());

            Saos saosShape = new Saos(grid, shape, 1);
            System.out.println();
            System.out.println("Shape Defined Grid View (XY Plane):");
            grid.printGrid(0);
            System.out.println();

            System.out.println("Defining the Number of Units");
            System.out.println("-----------------------------");

            System.out.println("""
                    Finally, lets set the amount of units that you'd like to be placed onto
                    the grid. Please note that if the number of shapes (units) you chose to allocate
                    to the grid exceeds the allotted space of the grid, the algorithm will\s
                    automatically place the maximum number of shapes possible onto the grid space.""");
            System.out.println("Number of units ('5', '10', '50'): ");

            Saos saos = new Saos(grid, shape, scan.nextInt());

            System.out.println();
            System.out.println("These are the first couple grid layers after allocation:");
            System.out.println();
            for (int i = 0; i < shape.height + 2; i++) {
                System.out.println("Layer " + i + ":");
                grid.printGrid(i);
                System.out.println();
            }

            System.out.println("^ Take a look at how your shapes were placed on the grid. ^");

            System.out.println();
            System.out.print("Press enter to continue.");

            Thread.sleep(1);
            scan.nextLine();
            Thread.sleep(1);

            System.out.println();
            System.out.println("Logistics");
            System.out.println("----------");
            System.out.println("""
                    If we were to stack each layer on top of one another, we might see that each
                    shape holds a predetermined volume of which can be described as the 'inside' of each
                    unit. More so, the '■' filled in cells create a border around the shape in three dimensions.""");
            System.out.println();

            System.out.println("Lets take a deep dive into our new allotted grid.");
            System.out.println();
            System.out.print("Press enter to view menu.");
            Thread.sleep(1);
            scan.nextLine(); // Wait for the user to press Enter
            Thread.sleep(1);

            String prompt = """

                    Menu
                    -------
                    Determine max number of shapes (1)\s
                    Show specific grid layer (2)\s
                    Show entire grid (3)\s
                    Define new shape (4)\s
                    Define new grid (4)\s
                    Start over (5)\s
                    Conclude (6)
                    """;

            boolean list = true;
            while (list) {
                System.out.println(prompt);
                System.out.print("Enter a number 1-6: ");

                int menu = scan.nextInt();

                if (menu == 1) {
                    int max = saos.calculateMaxShapes();
                    System.out.println();
                    System.out.println("This grid can hold a maximum of " + max + " shapes.");
                    System.out.println("Both the dimensions of the grid as well as the dimensions of the shapes themselves\n" +
                            "determine the total number of units that can be allocated onto the lot.");
                    System.out.println("Feel free to play around with these dimensions to see how this number changes.");
                    System.out.println();
                    System.out.print("Press enter to return to menu.");
                    scan.nextLine();
                } else if (menu == 2) {
                    System.out.println("Lets take a look at a specific grid layer.");
                    System.out.print("Enter a grid layer from 1 to 20: ");
                    grid.printGrid(scan.nextInt());

                    System.out.println("If you're unable to locate to any of the shapes, try a layer closer to the base of the grid.\n");
                    System.out.println();
                    System.out.print("Press enter to return to menu.");
                    scan.nextLine();

                } else if (menu == 3) {
                    System.out.println("Lets take a look at the entirety of the grid.");
                    System.out.println();

                    for (int i = 0; i < grid.layers + 1; i++) {
                        grid.printGrid(i);
                    }

                    System.out.println("""

                            We can imagine how each layer of the grid would be stacked on top of one another creating a
                            so called 'mega-shape' on our grid. We can also think of this as a building!""");

                    System.out.println();


                } else if (menu == 4) {

                    System.out.println();
                    System.out.print("Press enter to return to menu.");
                    scan.nextLine();
                } else if (menu == 6){
                    list = false;
                    loop = 1;
                }
            }
            System.out.println("Conclusion");
            System.out.println("-------------");
        }
    }
}
