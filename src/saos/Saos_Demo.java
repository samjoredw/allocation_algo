// ============================================================================================
//                                      SAOS DEMO PAGE
//                  Used to demonstrate my algorithm's efficiency and accuracy
// ============================================================================================


//Saos_Demo.java
package saos;
import java.util.Scanner;

/**
 * The Saos_Demo class serves as the main entry point for demonstrating
 * the SAOS (Spatial Arrangement Optimization System) algorithm.
 * SAOS optimally arranges shapes onto a 3D grid using vector notation.
 * This class guides the user through a demo of the SAOS algorithm,
 * allowing them to interactively explore its functionalities.
 */
public class Saos_Demo {

    /**
     * The main method of the Saos_Demo class.
     *
     * @param args Command-line arguments (not used in this application).
     * @throws InterruptedException Thrown if interrupted during thread sleep.
     */
    public static void main(String[] args) throws InterruptedException {

        boolean restart = true;
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("\n\nSAOS Algorithm Project");
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


        while (restart) {

            System.out.println();
            System.out.println("\n\nSpatial Arrangement Optimization System");
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
            System.out.println("\nDefining the Grid");
            System.out.println("------------------");

            System.out.println("""
                    Please enter the dimensions of the grid that you would like to\s
                    allocate a set number of shapes on. Note that the z-axis is set to a default
                    dimension of 20.""");
            System.out.println("Grid dimension examples ('10 10', '20 20', '30 15'): ");

            boolean validInput = false;
            int gridX = 0;
            int gridY = 0;

            while (!validInput) {
                try {
                    gridX = scan.nextInt();
                    gridY = scan.nextInt();
                    scan.nextLine();

                    if (gridX > 0 && gridY > 0) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid dimensions. Please enter valid numbers!");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid dimensions. Please enter valid numbers!");
                    scan.nextLine();
                }
            }

            Grid grid = new Grid(gridX, gridY);
            System.out.println();
            System.out.println("Initial Grid View (XY Plane):");
            // Print out the initial state of the grid in the XY plane
            grid.printGrid(0);
            System.out.println();

            System.out.println("\nDefining the Unit Size");
            System.out.println("------------------");

            System.out.println("""
                    Now that a grid in three dimensions has been specified, determine the
                    number of, and size of, your individual shapes (units) that you would like to\s
                    place onto the grid.""");
            System.out.println("Shape dimension examples ('4 4 3', '6 7 3', '4 3 5'): ");

            boolean validShapeInput = false;
            int shapeLength = 0;
            int shapeWidth = 0;
            int shapeHeight = 0;

            while (!validShapeInput) {
                try {
                    shapeLength = scan.nextInt();
                    shapeWidth = scan.nextInt();
                    shapeHeight = scan.nextInt();
                    scan.nextLine();

                    if (shapeLength > 0 && shapeWidth > 0 && shapeHeight > 0) {
                        validShapeInput = true;
                    } else {
                        System.out.println("Invalid shape. Please enter valid numbers!");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid shape. Please enter valid numbers!.");
                    scan.nextLine();
                }
            }

            Shape shape = new Shape(shapeLength, shapeWidth, shapeHeight);

            Saos saosShape = new Saos(grid, shape, 1);
            System.out.println();
            System.out.println("Shape Defined Grid View (XY Plane):");
            grid.printGrid(0);
            System.out.println();

            System.out.println("\nDefining the Number of Units");
            System.out.println("-----------------------------");

            System.out.println("""
                    Finally, let's set the amount of units that you'd like to be placed onto
                    the grid. Please note that if the number of shapes (units) you chose to allocate
                    to the grid exceeds the allotted space of the grid, the algorithm will\s
                    automatically place the maximum number of shapes possible onto the grid space.""");
            System.out.println("Number of units ('5', '10', '50'): ");

            boolean validNumUnits = false;
            int numUnits = 0;

            while (!validNumUnits) {
                try {
                    numUnits = scan.nextInt();
                    scan.nextLine();

                    if (numUnits > 0) {
                        validNumUnits = true;
                    } else {
                        System.out.println("Please enter a positive value for the number of units!");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Please enter a positive value for the number of units!");
                    scan.nextLine();
                }
            }

            Saos saos = new Saos(grid, shape, numUnits);

            System.out.println();
            System.out.println("These are the first couple grid layers after allocation:");
            System.out.println();
            for (int i = 0; i < shape.height + 2; i++) {
                System.out.println("Layer " + i + ":");
                grid.printGrid(i);
                System.out.println();
            }

            System.out.println("^ Take a look at how your shapes were placed on the grid. ^");

            System.out.print("Press enter to continue.");
            scan.nextLine();


            System.out.println("\nLogistics");
            System.out.println("----------");
            System.out.println("""
                    If we were to stack each layer on top of one another, we might see that each
                    shape holds a predetermined volume of which can be described as the 'inside' of each
                    unit. More so, the '■' filled in cells create a border around the shape in three dimensions.""");
            System.out.println();

            System.out.println("Let's take a deep dive into our new allotted grid.");
            System.out.println();

            Thread.sleep(1);

            String prompt = """
                    \n
                    Menu
                    -------
                    Determine max number of shapes [1]\s
                    Show specific grid layer [2]\s
                    Show entire grid [3]\s
                    Try new metrics (shape and grid dimensions) [4]\s
                    Conclude [5]\s
                    """;

            boolean list = true;
            while (list) {
                System.out.println(prompt);
                System.out.print("Enter a number 1-5: ");

                int menu = scan.nextInt();
                scan.nextLine();

                switch (menu) {
                    case 1:
                        int max = saos.calculateMaxShapes();
                        System.out.println();
                        System.out.println("This grid can hold a maximum of " + max + " shapes.");
                        System.out.println("Both the dimensions of the grid as well as the dimensions of the shapes themselves\n" +
                                "determine the total number of units that can be allocated onto the lot.");
                        System.out.println("Feel free to play around with these dimensions to see how this number changes.");
                        System.out.println();
                        System.out.print("Press enter to return to menu.");
                        scan.nextLine();  // Consume the newline character
                        break;

                    case 2:
                        System.out.println("Let's take a look at a specific grid layer.");
                        System.out.print("Enter a grid layer from 0 to 19: ");
                        int layerNumber = scan.nextInt();
                        scan.nextLine();

                        if (layerNumber >= 0 && layerNumber < grid.layers) {
                            grid.printGrid(layerNumber);
                        } else {
                            System.out.println("Invalid layer number. Please enter a number between 0 and 19.");
                        }
                        System.out.print("Press enter to return to menu.");
                        scan.nextLine();  // Consume the newline character
                        break;

                    case 3:
                        System.out.println("Let's take a look at the entirety of the grid.");
                        System.out.println();

                        for (int i = 0; i < grid.layers; i++) {
                            grid.printGrid(i);
                            System.out.println();
                        }

                        System.out.println("""

                                We can imagine how each layer of the grid would be stacked on top of one another creating a
                                so-called 'mega-shape' on our grid. We can also think of this as a building!""");

                        System.out.println();
                        System.out.print("Press enter to return to menu.");
                        scan.nextLine();
                        break;

                    case 4:
                        System.out.println("\nRestarting Program...\n");
                        list = false;
                        Thread.sleep(1000);
                        break;

                    case 5:
                        System.out.println("\n\nConclusion");
                        System.out.println("-------------");
                        System.out.println("""
                              Thank you for exploring my SAOS Algorithm Project!\s
                              
                              Inspired by the mathematical representation of skyscrapers in Manhattan, SAOS is a\s
                              versatile tool for spatial organization in various applications.

                              Personally developed from scratch, my spacial allocation algorithm bridges the
                              conceptual and physical understanding of spatial organization by representing
                              lots and units linearly through a set of matrix arrays (3D arrays). This project
                              showcases the systematic determination of a mathematical blueprint for optimal
                              allocation of units on a limited lot space, providing a versatile tool for various
                              applications in mathematical and scientific fields.
                  
                              Whether you are simulating building constructions, optimizing resource allocation,
                              or enhancing logistical planning, SAOS provides a systematic approach to
                              determine mathematical blueprints for proper allocation of units on a limited lot space.\s
                  
                  
                              Feel free run this program again to experiment with different grid dimensions, shape\s
                              sizes, and unit numbers to witness how SAOS dynamically allocates shapes in a\s
                              realistic simulation.
                  
                              Thank you for demo-ing my project! Take a look at my github to view the source code:
                              https://github.com/samjoredw/allocation_algo
                            
                              - Sam 😄
                                """);
                        list = false;
                        restart = false;
                        System.exit(0);

                    default:
                        System.out.println("Invalid input. Please enter a number between 1 and 7.");
                }
            }
        }
    }
}

