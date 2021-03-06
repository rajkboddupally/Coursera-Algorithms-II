package main.java.com.week1;

/* Raj Kumar Boddupally created on 8/3/2021 inside the package - main.java */

import edu.princeton.cs.algs4.Bag;

/*
Graph API using Adjacency list representation
 */

public class Graph {
    private final int V;
    private final Bag<Integer>[] adj;


    public Graph(int v) {
        this.V = v;
        this.adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return this.V;
    }

    public int degree(int v) {
        return adj[v].size();
    }
}
