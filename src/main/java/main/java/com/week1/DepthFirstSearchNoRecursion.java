package main.java.com.week1;

/* Raj Kumar Boddupally created on 8/10/2021 inside the package - main.java.com.week1 */

import edu.princeton.cs.algs4.Stack;

import java.util.NoSuchElementException;

/*
Nonrecursive depth-first search.
Implement depth-first search in an undirected graph without using recursion.
 */
public class DepthFirstSearchNoRecursion {
    private final boolean[] marked;
    private final int[] edgeTo;
    private final int s;

    public DepthFirstSearchNoRecursion(Graph g, int s) {
        this.marked = new boolean[g.V()];
        this.edgeTo = new int[g.V()];
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

        DepthFirstSearchNoRecursion dfs = new DepthFirstSearchNoRecursion(graph, 0);

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

    private void dfs(Graph g, int s) {
        marked[s] = true;
        edgeTo[s] = s;
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    stack.push(w);
                }
            }
        }
    }

    public Iterable<Integer> path(int v) {
        if (!marked[v]) throw new NoSuchElementException("No path from source to " + v);
        Stack<Integer> path = new Stack<>();
        for (int w = v; w != s; w = edgeTo[w]) {
            path.push(w);
        }
        path.push(s);
        return path;
    }

    public boolean hasEdgeTo(int v) {
        return marked[v];
    }
}
