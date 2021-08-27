package main.java.com.week1;

/* Raj Kumar Boddupally created on 8/27/2021 inside the package - main.java.com.week1 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

import java.util.HashSet;
import java.util.Set;

public class DiGraphBFS {
    private final Set<Integer> visited;
    private final int[] pathTo;
    private final int[] edgeTo;
    private final int s;

    public DiGraphBFS(DiGraph diGraph, int s) {
        visited = new HashSet<>();
        pathTo = new int[diGraph.V()];
        edgeTo = new int[diGraph.V()];
        this.s = s;
        bfs(diGraph, s);
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        DiGraph diGraph = new DiGraph(in);
        int s = 6;
        int t = 3;
        DiGraphBFS diGraphBFS = new DiGraphBFS(diGraph, s);
        System.out.println(s + " connected to " + t + " : " + diGraphBFS.visited(t));
        System.out.println(s + " path length to " + t + " : " + diGraphBFS.pathTo(t));
        diGraphBFS.path(t).forEach(x -> System.out.print(x + " => "));
    }

    private void bfs(DiGraph diGraph, int s) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(s);
        edgeTo[s] = s;
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            visited.add(v);
            for (int w : diGraph.adj(v)) {
                if (!visited.contains(w)) {
                    queue.enqueue(w);
                    edgeTo[w] = v;
                    pathTo[w] = pathTo[v] + 1;
                }
            }
        }
    }

    public boolean visited(int v) {
        return visited.contains(v);
    }

    public int edgeTo(int v) {
        return edgeTo[v];
    }

    public int pathTo(int v) {
        return pathTo[v];
    }

    public Iterable<Integer> path(int v) {
        Stack<Integer> path = new Stack<>();
        for (int w = v; w != s; w = edgeTo[w]) {
            path.push(w);
        }
        path.push(s);
        return path;
    }
}
