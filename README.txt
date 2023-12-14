SAOS (Spatial Arrangement Optimization System)
-------------------------------------------------------------------------------------
Sam Edwards
2023

SAOS is a 3D allocation algorithm designed to optimize the arrangement of shapes onto a grid. The algorithm was developed with a focus on spatial organization, inspired by the challenges of allocating units in a limited lot space, as exemplified in downtown Manhattan's skyscrapers. The project includes both the SAOS algorithm (Saos.java) and a demonstration application (Saos_Demo.java).

INTRODUCTION:
-------------------------------------------------------------------------------------
SAOS utilizes a mathematical approach to represent the arrangement of shapes in a specified hyperplane through the use of 3D arrays. The algorithm systematically determines a blueprint for optimal allocation, applicable not only to buildings but also for resource allocation, logistical planning, and spatial organization in various mathematical and scientific applications.

FEATURES:
-------------------------------------------------------------------------------------
Dynamic Allocation: SAOS dynamically allocates shapes onto a three-dimensional grid using vector notation.
User Interaction: The demo application (Saos_Demo.java) allows users to interactively define grid space, set shape dimensions, and determine the number of units to be placed on the grid.
Visualization: The algorithm provides visual representations of the allocated grid layers in the XY plane.

USAGE:
-------------------------------------------------------------------------------------
Compile the project using a Java compiler.
Run the Saos_Demo.java file to interactively demo the SAOS algorithm.
Follow the prompts to define grid space, set shape dimensions, and allocate units.

DEMO:
-------------------------------------------------------------------------------------
The demo provides a step-by-step walkthrough of the SAOS algorithm, allowing users to visualize the grid allocation process and explore various functionalities. The output includes information about grid dimensions, initial grid views, shape-defined grid views, and the final grid layers after allocation.

INSTALL/EXECUTE:
-------------------------------------------------------------------------------------
Open up a terminal window and simply do the following.
Perform the following commands in a bash/zsh shell session (copy and paste without "$"):

    $ git clone https://github.com/samjoredw/allocation_algo.git
    $ cd allocation_algo
    $ ls
    [confirm files in output here]
    $ javac src/saos/*.java
    $ java -cp src saos.Saos_Demo
    [program will run here]

For visualization purposes, make sure your terminal window is open at its maximum length and width.

