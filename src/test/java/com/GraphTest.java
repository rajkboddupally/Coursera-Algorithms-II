package com;

import main.java.com.week1.Graph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.StreamSupport;

/* Raj Kumar Boddupally created on 8/4/2021 inside the package - com */
class GraphTest {
    Graph graph;

    @BeforeEach
    void setup() {
        graph = new Graph(5);
        graph.addEdge(0, 4);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
    }

    @Test
    void addEdge() {
    }

    @Test
    void adj() {
    }

    @Test
    void createGraph() {


        long count2 = StreamSupport.stream(graph.adj(2).spliterator(), false).count();

        Assertions.assertEquals(2, count2);

        Assertions.assertEquals(3, StreamSupport.stream(graph.adj(4).spliterator(), false).count());
    }

    @Test
    void validateV() {
        Assertions.assertEquals(5, graph.V());
    }

}
