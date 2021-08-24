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
    private final int diameter;
    private int center;

    public DiameterAndCenter(Graph graph) {
        int w;
        int v = 0;
        for (w = 0; w < graph.V(); w++) {
            if (graph.degree(w) > 0) {
                v = w;
                break;
            }
        }
        BreadthFirstPaths bfs = new BreadthFirstPaths(graph, v);
        int farthestDistance = 0;
        int farthestVertex = 0;
        for (w = 0; w < graph.V(); w++) {
            if (farthestDistance < bfs.distanceTo(w)) {
                farthestDistance = bfs.distanceTo(w);
                v = w;
            }
        }
        BreadthFirstPaths bfs1 = new BreadthFirstPaths(graph, v);
        for (w = 0; w < graph.V(); w++) {
            farthestDistance = Math.max(farthestDistance, bfs1.distanceTo(w));
        }
        this.diameter = farthestDistance;

    }


    public int getDiameter() {
        return this.diameter;
    }

    public int getCenter() {
        return this.center;
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(7);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.addEdge(2, 6);
        DiameterAndCenter d = new DiameterAndCenter(g1);
        System.out.println(d.getDiameter());
    }
}
