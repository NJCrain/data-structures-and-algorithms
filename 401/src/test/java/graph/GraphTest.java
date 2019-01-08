package graph;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

        assertEquals("Should add 1 Edge to node1's list of neighbors",1, node1.neighbors.size());
        assertEquals("Should also add 1 Edge to node2's list of neighbors",1, node2.neighbors.size());
        assertEquals("The neighbor value of that edge for node1 should be node2", node2, node1.neighbors.get(0).neighbor);
        assertEquals("The neighbor value of node2's edge should be node1", node1, node2.neighbors.get(0).neighbor);
        assertEquals("Since no weight was provided, both edges should have weight 0", 0, node1.neighbors.get(0).weight);
        assertEquals("Since no weight was provided, both edges should have weight 0", 0, node2.neighbors.get(0).weight);

    }

    @Test
    public void testAddEdgeWithWeights() {
        Node<Integer> node1 = g.getNodes().get(1);
        Node<Integer> node2 = g.getNodes().get(4);
        g.addEdge(node1, node2, 5);

        assertEquals("Should add 1 Edge to node1's list of neighbors",1, node1.neighbors.size());
        assertEquals("Should also add 1 Edge to node2's list of neighbors",1, node2.neighbors.size());
        assertEquals("The neighbor value of that edge for node1 should be node2", node2, node1.neighbors.get(0).neighbor);
        assertEquals("The neighbor value of node2's edge should be node1", node1, node2.neighbors.get(0).neighbor);
        assertEquals("The weight should be what was provided in the method call", 5, node1.neighbors.get(0).weight);
        assertEquals("The weight of each edge should be the same", node1.neighbors.get(0).weight, node2.neighbors.get(0).weight);
    }

    @Test
    public void testGetNeighbors() {
        Node<Integer> node1 = g.getNodes().get(1);
        Node<Integer> node2 = g.getNodes().get(2);
        Node<Integer> node3 = g.getNodes().get(3);
        Node<Integer> node4 = g.getNodes().get(4);
        g.addEdge(node1, node2);
        g.addEdge(node2, node3);
        g.addEdge(node1, node3);
        g.addEdge(node3, node4);

        assertEquals("node1 should have 2 neighbors", 2, g.getNeighbors(node1).size());
        assertEquals("node2 should have 2 neighbors", 2, g.getNeighbors(node2).size());
        assertEquals("node3 should have 3 neighbors", 3, g.getNeighbors(node3).size());
        assertEquals("node4 should have 1 neighbor", 1, g.getNeighbors(node4).size());
    }

    @Test
    public void testBreadthFirst() {
        Node<Integer> node1 = g.getNodes().get(1);
        Node<Integer> node2 = g.getNodes().get(2);
        Node<Integer> node3 = g.getNodes().get(3);
        Node<Integer> node4 = g.getNodes().get(4);
        g.addEdge(node1, node2);
        g.addEdge(node2, node3);
        g.addEdge(node1, node3);
        g.addEdge(node3, node4);

        assertEquals(new ArrayList<Node>(Arrays.asList(node1, node2, node3, node4)), Graph.breadthFirst(node1));
        assertEquals(new ArrayList<Node>(Arrays.asList(node2, node1, node3, node4)), Graph.breadthFirst(node2));
        assertEquals(new ArrayList<Node>(Arrays.asList(node3, node2, node1, node4)), Graph.breadthFirst(node3));
        assertEquals(new ArrayList<Node>(Arrays.asList(node4, node3, node2, node1)), Graph.breadthFirst(node4));

        Node<Integer> node5 = g.getNodes().get(0);
        assertEquals(node5, Graph.breadthFirst(node5).get(0));
    }

}