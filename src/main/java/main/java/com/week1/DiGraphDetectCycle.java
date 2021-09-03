package main.java.com.week1;

/* Raj Kumar Boddupally created on 9/3/2021 inside the package - main.java.com.week1 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiGraphDetectCycle {
    private final int V;
    private final List<List<Integer>> adj;


    public DiGraphDetectCycle(int V) {
        this.V = V;
        adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
/*
        DiGraphDetectCycle graph = new DiGraphDetectCycle(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
*/

        DiGraphDetectCycle graph = new DiGraphDetectCycle(8);
        graph.addEdge(6, 0);
        graph.addEdge(6, 4);
        graph.addEdge(3, 6);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 2);
        graph.addEdge(3, 5);
        graph.addEdge(5, 2);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(0, 1);
        graph.addEdge(4, 7);
        graph.addEdge(7, 0);

/*
        if (graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
 */
        graph.cycles().stream().filter((count) -> count > 0).forEach(System.out::println);
    }

    private int cyclicUtil(int v, boolean[] visited,
                           boolean[] recArr, int cycleLength) {
        if (recArr[v])
            return cycleLength;

        if (visited[v])
            return Integer.MAX_VALUE;

        recArr[v] = true;
        cycleLength++;
        List<Integer> neighbours = adj.get(v);
        for (Integer neighbour : neighbours) {
            cycleLength = cyclicUtil(neighbour, visited, recArr, cycleLength);
            return cycleLength;
        }
        return Integer.MAX_VALUE;
    }

    private void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    // Returns true if the graph contains a
    // cycle, else false.
    private List<Integer> cycles() {
        boolean[] visited = new boolean[V];
        boolean[] recArr = new boolean[V];
        int cycleLength = 0;
        List<Integer> cycles = new ArrayList<>();

        for (int v = 0; v < V; v++) {
            cycles.add(cyclicUtil(v, visited, recArr, cycleLength));
        }
        Collections.sort(cycles);
        return cycles;
    }
}
