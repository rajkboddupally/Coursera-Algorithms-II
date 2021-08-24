package main.java.com.week1;

/* Raj Kumar Boddupally created on 8/14/2021 inside the package - main.java.com.week1 */
/*
Diameter and center of a tree. Given a connected graph with no cycles

Diameter: design a linear-time algorithm to find the longest simple path in the graph.

Center: design a linear-time algorithm to find a vertex such that its maximum distance from any other vertex is minimized.

 Solution : Diameter -> Run BFS on a vertex v, and run the BFS on the farthest vertex from v.

 TODO

 */
public class DiameterAndCenter {
    private int diameter;
    private final int center = Integer.MAX_VALUE;


    public int getDiameter() {
        return this.diameter;
    }

    public int getCenter() {
        return this.center;
    }
}
