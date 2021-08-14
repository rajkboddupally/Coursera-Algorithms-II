package main.java.com.week1;

/* Raj Kumar Boddupally created on 8/8/2021 inside the package - com */

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Stack;

import java.util.NoSuchElementException;

public class DepthFirstPaths {
    private final boolean[] marked;
    private final int[] edgeTo;
    private final int s;
    private final int[] pathLength;
    private int maxPathLength;

    public DepthFirstPaths(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        pathLength = new int[g.V()];
        this.s = s;

        dfs(g, s);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(0, 4);
        graph.addEdge(1, 3);
        graph.addEdge(6, 4);
        graph.addEdge(3, 4);
        graph.addEdge(7, 3);
        graph.addEdge(7, 9);

        DepthFirstPaths dfs = new DepthFirstPaths(graph, 0);

        System.out.println("0 connected to 9 " + dfs.hasEdgeTo(9));
        System.out.println("print 0-9 path ");
        dfs.path(9).forEach(x ->
                System.out.print(x + " => ")
        );
        System.out.println();
        System.out.println("0 connected to 2 " + dfs.hasEdgeTo(2));
        System.out.println("print 0-2 path ");
        dfs.path(2).forEach(x ->
                System.out.print(x + " => ")
        );
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                pathLength[w] = pathLength[v] + 1;
                maxPathLength = Math.max(maxPathLength, pathLength[w]);
                dfs(g, w);
                edgeTo[w] = v;
            }
        }
    }

    public boolean hasEdgeTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> path(int v) {
        if (!marked[v]) throw new NoSuchElementException("No path from source " + s + " to " + v);
        Stack<Integer> path = new Stack<>();
        for (int w = v; w != s; w = edgeTo[w])
            path.push(w);
        path.push(s);
        return path;
    }

    public int getPathLength(int v) {
        return pathLength[v];
    }

    public int getMaxPathLength(int v) {
        return maxPathLength;
    }
}
