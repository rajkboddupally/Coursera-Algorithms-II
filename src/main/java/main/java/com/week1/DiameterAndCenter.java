package main.java.com.week1;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/* Raj Kumar Boddupally created on 8/14/2021 inside the package - main.java.com.week1 */
/*
Diameter and center of a tree. Given a connected graph with no cycles

Diameter: design a linear-time algorithm to find the longest simple path in the graph.

Center: design a linear-time algorithm to find a vertex such that its maximum distance from any other vertex is minimized.
 */
public class DiameterAndCenter {
    private int diameter;
    private int center = Integer.MAX_VALUE;

    public DiameterAndCenter(Graph g) {

        for (int v = 0; v < g.V(); v++) {
            DepthFirstPaths dfs = new DepthFirstPaths(g, v);
            diameter = Math.max(dfs.getMaxPathLength(v), diameter);
            center = Math.min(dfs.getMaxPathLength(v), center);
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        StdOut.println(G);

        DiameterAndCenter d = new DiameterAndCenter(G);
        System.out.println(d.getDiameter());
        System.out.println(d.getCenter());
    }

    public int getDiameter() {
        return this.diameter;
    }

    public int getCenter() {
        return this.center;
    }
}
