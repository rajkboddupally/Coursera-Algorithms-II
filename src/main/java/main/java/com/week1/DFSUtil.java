package main.java.com.week1;

/* Raj Kumar Boddupally created on 8/23/2021 inside the package - main.java.com.week1 */
/*
V - Number of vertices in a graph
v - given vertex
*/

import java.util.Arrays;

public class DFSUtil {
    private final boolean[] visited;

    public DFSUtil(Graph graph, int v) {
        visited = new boolean[graph.V()];
        Arrays.fill(visited, false);
        dfs(graph, v);
    }

    private void dfs(Graph graph, int v) {
        visited[v] = true;
        for (int w : graph.adj(v)) {
            if (!visited[w]) {
                dfs(graph, w);
            }
        }
    }

    public boolean visited(int v) {
        return visited[v];
    }
}
