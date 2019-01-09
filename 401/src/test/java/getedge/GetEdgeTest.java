package getedge;

import graph.Graph;
import graph.Node;
import org.junit.Before;
import org.junit.Test;

import static getedge.GetEdge.getEdge;
import static org.junit.Assert.*;

public class GetEdgeTest {
    Graph<String> g = new Graph<>();

    @Before
    public void setupGraph() {
       Node<String> node1 = g.addNode("A");
       Node<String> node2 = g.addNode("B");
       Node<String> node3 = g.addNode("C");
       Node<String> node4 = g.addNode("D");
       Node<String> node5 = g.addNode("E");

        g.addEdge(node1, node2, 42);
        g.addEdge(node1, node3, 63);
        g.addEdge(node2, node4, 113);
        g.addEdge(node3, node4, 90);
        g.addEdge(node3, node5, 71);
    }

    @Test
    public void testGetEdge() {
        String[] cities = {"A", "C", "E"};
        assertEquals(134, getEdge(cities, g));

        String[] notPossible = {"A", "B", "C"};
        assertEquals(0, getEdge(notPossible, g));

        String[] noStart = {"7", "potato", "Lemons"};
        assertEquals(0, getEdge(noStart, g));
    }
}