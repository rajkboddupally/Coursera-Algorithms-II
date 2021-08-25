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
    private int center;
    private final Graph graph;
    BreadthFirstPaths bfs1;

    public DiameterAndCenter(Graph graph) {
        this.graph = graph;


    }

    public static void main(String[] args) {
        Graph g1 = new Graph(7);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.addEdge(2, 6);
        DiameterAndCenter d = new DiameterAndCenter(g1);
        for (Integer w : d.getDiameter()) {
            System.out.print(w + " ");
        }
        System.out.println();

        Graph g2 = new Graph(15);
        g2.addEdge(1, 3);
        g2.addEdge(12, 3);
        g2.addEdge(12, 9);
        g2.addEdge(12, 8);
        g2.addEdge(6, 8);
        g2.addEdge(4, 8);
        g2.addEdge(2, 8);
        g2.addEdge(8, 7);
        g2.addEdge(7, 11);
        g2.addEdge(10, 7);
        g2.addEdge(13, 11);
        g2.addEdge(11, 14);
        g2.addEdge(5, 11);
        g2.addEdge(0, 11);
        DiameterAndCenter d2 = new DiameterAndCenter(g2);
        for (Integer w : d2.getDiameter()) {
            System.out.print(w + " ");
        }
    }

    public int getCenter() {
        return this.center;
    }

    public Iterable<Integer> getDiameter() {
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
        bfs1 = new BreadthFirstPaths(graph, v);
        for (w = 0; w < graph.V(); w++) {
            farthestDistance = Math.max(farthestDistance, bfs1.distanceTo(w));
            if (farthestDistance < bfs1.distanceTo(w)) {
                farthestDistance = bfs1.distanceTo(w);
                farthestVertex = w;
            }
        }
        return bfs1.path(farthestVertex);
    }
}
