package main.java.com.week1;

/* Raj Kumar Boddupally created on 8/26/2021 inside the package - main.java.com.week1 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

import java.util.Arrays;

public class DiGraphDFS {
    private final boolean[] visited;
    private final int[] edgeTo;
    private final int s;
    private final int[] pathLength;

    public DiGraphDFS(DiGraph diGraph, int s) {
        visited = new boolean[diGraph.V()];
        edgeTo = new int[diGraph.V()];
        pathLength = new int[diGraph.V()];
        Arrays.fill(visited, false);
        Arrays.fill(pathLength, 0);
        this.s = s;
        dfs(diGraph, s);
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        DiGraph diGraph = new DiGraph(in);
        int s = 6;
        int t = 1;
        DiGraphDFS diGraphDFS = new DiGraphDFS(diGraph, s);
        System.out.println(s + " connected to " + t + " : " + diGraphDFS.visited(t));
        System.out.println("path length " + diGraphDFS.pathLength(t));
        diGraphDFS.path(t).forEach(x -> System.out.print(x + " => "));
    }

    private void dfs(DiGraph diGraph, int v) {
        visited[v] = true;
        for (int w : diGraph.adj(v)) {
            if (!visited[w]) {
                pathLength[w] = pathLength[v] + 1;
                dfs(diGraph, w);
                edgeTo[w] = v;
            }
        }
    }

    public boolean visited(int v) {
        return visited[v];
    }

    public Iterable<Integer> path(int w) {
        if (!visited(w)) throw new IllegalArgumentException("Vertex " + w + " not visited");
        Stack<Integer> path = new Stack<>();
        for (int x = w; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public int pathLength(int v) {
        return pathLength[v];
    }
}
