package main.java.com.week1;

/* Raj Kumar Boddupally created on 9/2/2021 inside the package - main.java.com.week1 */

/*
Can be performed on a DAG - Digraph acyclic graph.
Implementation
1. Perform DFS on each unmarked vertex
2. Add vertex to the STACK if after performing DFS on adjacent vertices
 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class TopologicalSort {
    private final boolean[] marked;
    private final Stack<Integer> reverseOrder;

    public TopologicalSort(DiGraph diGraph) {
        marked = new boolean[diGraph.V()];
        reverseOrder = new Stack<>();

        //1. Perform DFS on each unmarked vertex
        for (int v = 0; v < diGraph.V(); v++) {
            if (!marked[v])
                dfs(diGraph, v);
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        DiGraph diGraph = new DiGraph(in);
        TopologicalSort sort = new TopologicalSort(diGraph);
        sort.topologicalOrder().forEach((item) -> System.out.print(item + " "));
    }

    private void dfs(DiGraph diGraph, int v) {
        marked[v] = true;
        for (int w : diGraph.adj(v)) {
            if (!marked[w])
                dfs(diGraph, w);
        }
        //2. Add vertex to the STACK if after performing DFS on adjacent vertices
        reverseOrder.push(v);
    }

    public Iterable<Integer> topologicalOrder() {
        return reverseOrder;
    }
}
