package main.java.com.week1;

/* Raj Kumar Boddupally created on 8/26/2021 inside the package - main.java.com.week1 */

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.util.NoSuchElementException;

public class DiGraph {
    private final int V;
    private final int E;
    private final Bag<Integer>[] adj;

    public DiGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public DiGraph(In in) {
        if (in == null) throw new IllegalArgumentException("argument is null");
        try {
            this.V = in.readInt();
            this.E = in.readInt();
            if (V < 0) throw new IllegalArgumentException("Vertices should be a non negative number");
            adj = (Bag<Integer>[]) new Bag[V];

            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<>();
            }

            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                validateVertex(v);
                validateVertex(w);
                addEdge(v, w);
            }
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
    }

    public static void main(String[] args) {
        In input = new In(args[0]);
        DiGraph diGraph = new DiGraph(input);
        diGraph.print();

    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex should be in between 0 and " + (V - 1));
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int degree(int v) {
        return adj[v].size();
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void print() {
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                System.out.println(v + " => " + w);
            }
        }
    }

}
