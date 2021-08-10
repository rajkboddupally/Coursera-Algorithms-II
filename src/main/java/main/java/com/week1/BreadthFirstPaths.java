package main.java.com.week1;

/* Raj Kumar Boddupally created on 8/8/2021 inside the package - main.java.com */

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

import java.util.NoSuchElementException;

public class BreadthFirstPaths {
    private final boolean[] marked;
    private final int[] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph g, int s) {
        this.marked = new boolean[g.V()];
        this.edgeTo = new int[g.V()];
        this.s = s;

        bfs(g);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(0, 4);
        graph.addEdge(1, 3);
        graph.addEdge(6, 4);
        graph.addEdge(3, 4);
        graph.addEdge(7, 3);
        graph.addEdge(7, 9);

        BreadthFirstPaths bfs = new BreadthFirstPaths(graph, 0);

        System.out.println("0 connected to 9 " + bfs.hasEdgeTo(9));
        System.out.println("print 0-9 path ");
        bfs.path(9).forEach(x ->
                System.out.print(x + " => ")
        );
        System.out.println();
        System.out.println("0 connected to 2 " + bfs.hasEdgeTo(2));
        System.out.println("print 0-2 path ");
        bfs.path(2).forEach(x ->
                System.out.print(x + " => ")
        );
    }

    private void bfs(Graph g) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s);
        marked[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    queue.enqueue(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }

    public boolean hasEdgeTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> path(int v) {
        if (!marked[v]) throw new NoSuchElementException("No path from source to " + v);
        Stack<Integer> path = new Stack<>();
        for (int w = v; w != s; w = edgeTo[w])
            path.push(w);
        path.push(s);
        return path;
    }

}
