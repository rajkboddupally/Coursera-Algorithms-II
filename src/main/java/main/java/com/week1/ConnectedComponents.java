package main.java.com.week1;

/* Raj Kumar Boddupally created on 8/9/2021 inside the package - main.java.com.week1 */

public class ConnectedComponents {
    boolean[] marked;
    int[] id;
    int count;

    public ConnectedComponents(Graph g) {
        this.marked = new boolean[g.V()];
        this.id = new int[g.V()];
        this.count = 0;

        for (int v = 0; v < g.V(); v++) {
            if (!marked[v]) {
                dfs(g, v);
                count++;
            }
        }
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : g.adj(v)) {
            if (!marked[w])
                dfs(g, w);
        }
    }

    public int count() {
        return this.count;
    }

    public int id(int v) {
        return id[v];
    }

    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(0, 4);
        graph.addEdge(1, 3);
        graph.addEdge(6, 4);
        graph.addEdge(3, 4);
        graph.addEdge(7, 3);
        graph.addEdge(7, 9);

        ConnectedComponents cc = new ConnectedComponents(graph);
        System.out.println("0 connected to 9 " + (cc.id(0) == cc.id(9)));
        System.out.println("0 connected to 2 " + (cc.id(0) == cc.id(2)));
        System.out.println("3 connected to 8 " + (cc.id(3) == cc.id(8)));
        System.out.println("6 connected to 7 " + (cc.id(7) == cc.id(6)));


        System.out.println("Total connected components " + cc.count());
    }


}
