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

}