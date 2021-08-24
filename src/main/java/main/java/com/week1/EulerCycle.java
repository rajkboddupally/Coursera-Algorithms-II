package main.java.com.week1;

/* Raj Kumar Boddupally created on 8/23/2021 inside the package - main.java.com.week1 */

public class EulerCycle {

    public static int hasEulerCycle(Graph graph) {

        //Find a non zero degree vertex and perform DFS on it.
        int v = 0;
        int w;
        for (w = 0; w < graph.V(); w++) {
            if (graph.degree(w) > 0) {
                v = w;
                break;
            }
        }

        DFSUtil dfsUtil = new DFSUtil(graph, v);
        for (w = 0; w < graph.V(); w++) {
            if (!dfsUtil.visited(w) && graph.degree(w) > 0) {
                return 0;
            }
        }

        //count the vertices with odd degree
        int odd = 0;
        for (w = 0; w < graph.V(); w++) {
            if (graph.degree(w) % 2 != 0)
                odd++;
        }

        if (odd > 2)
            return 0;

        // If odd count is 2, then semi-eulerian.
        // If odd count is 0, then eulerian
        // Note that odd count can never be 1 for undirected graph
        return (odd == 2) ? 1 : 2;
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        test(g1);

        Graph g2 = new Graph(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
        g2.addEdge(4, 0);
        test(g2);

        Graph g3 = new Graph(5);
        g3.addEdge(1, 0);
        g3.addEdge(0, 2);
        g3.addEdge(2, 1);
        g3.addEdge(0, 3);
        g3.addEdge(3, 4);
        g3.addEdge(1, 3);
        test(g3);

        // Let us create a graph with 3 vertices
        // connected in the form of cycle
        Graph g4 = new Graph(3);
        g4.addEdge(0, 1);
        g4.addEdge(1, 2);
        g4.addEdge(2, 0);
        test(g4);

        // Let us create a graph with all veritces
        // with zero degree
        Graph g5 = new Graph(3);
        test(g5);
    }

    private static void test(Graph g) {
        int res = hasEulerCycle(g);
        if (res == 0)
            System.out.println("graph is not Eulerian");
        else if (res == 1)
            System.out.println("graph has a Euler path");
        else
            System.out.println("graph has a Euler cycle");
    }
}
