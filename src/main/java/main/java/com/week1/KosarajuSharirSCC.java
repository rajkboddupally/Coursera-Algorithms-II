package main.java.com.week1;

/* Raj Kumar Boddupally created on 9/2/2021 inside the package - main.java.com.week1 */
/*
1. Run TopologicalSort on reverse graph
2. Run DFS from step#1
 */

import edu.princeton.cs.algs4.In;

public class KosarajuSharirSCC {
    private final boolean[] marked;
    private final int[] id;
    private int count;

    public KosarajuSharirSCC(DiGraph diGraph) {
        marked = new boolean[diGraph.V()];
        id = new int[diGraph.V()];
        count = 0;
        TopologicalSort sort = new TopologicalSort(diGraph.reverse());
        for (Integer v : sort.topologicalOrder()) {
            if (!marked[v]) {
                dfs(diGraph, v);
                count++;
            }
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        DiGraph graph = new DiGraph(in);

        KosarajuSharirSCC cc = new KosarajuSharirSCC(graph);

        System.out.println("Total connected components " + cc.getCCCount());
    }

    private void dfs(DiGraph diGraph, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : diGraph.adj(v))
            if (!marked[w])
                dfs(diGraph, w);
    }

    public boolean stronglyConnected(int v, int w) {
        return id[w] == id[v];
    }

    public int getCCCount() {
        return count;
    }
}
