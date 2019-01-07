package graph;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GraphTest {
    Graph<Integer> g = new Graph<>();

    @Before
    public void setupGraph() {
        List<Node<Integer>> nodes = g.getNodes();
        nodes.add(new Node<>(1));
        nodes.add(new Node<>(2));
        nodes.add(new Node<>(3));
        nodes.add(new Node<>(4));
        nodes.add(new Node<>(5));
    }

    @Test
    public void testGetNodes() {
        List<Node<Integer>> nodes = g.getNodes();

        assertNotNull(nodes);
        assertEquals("the list of nodes should have size of 5", 5, nodes.size());
        assertEquals("The first Node should contain the value 1", (Integer) 1, nodes.get(0).value);
    }

    @Test
    public void testSize() {
        assertEquals(5, g.size());
    }

    @Test
    public void testAddNode() {
        Node<Integer> newNode = g.addNode(6);

        assertEquals("The method should return the new Node", (Integer) 6, newNode.value);
        assertTrue("That new Node should be within the Graph's list of nodes", g.getNodes().contains(newNode));
        assertEquals("The Graph's size should increase to 6", g.getNodes().size(), 6);
    }

    @Test
    public void testAddEdgeNoWeights() {
        Node<Integer> node1 = g.getNodes().get(1);
        Node<Integer> node2 = g.getNodes().get(4);
        g.addEdge(node1, node2);

        assertEquals(1, node1.neighbors.size());
        assertEquals(1, node2.neighbors.size());
        assertEquals(node2, node1.neighbors.get(0).neighbor);
        assertEquals(node1, node2.neighbors.get(0).neighbor);

    }

}