package test.java.com;

/* Raj Kumar Boddupally created on 8/3/2021 inside the package - test.java.com */

import main.java.com.Graph;

import java.util.stream.StreamSupport;

public class GraphApiTest {

    @Test
    public void createGraph() {
        Graph graph = new Graph(5);
        graph.addEdge(0, 4);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        long count2 = StreamSupport.stream(graph.adj(2).spliterator(), false).count();

        Assertions.assertEquals(2, count2);

        //Assert.assertEquals(3, StreamSupport.stream(graph.adj(4).spliterator(), false).count());
    }


}
