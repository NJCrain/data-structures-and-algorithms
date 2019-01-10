package depthfirst;

import graph.Graph;
import graph.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static depthfirst.DepthFirst.depthFirst;
import static org.junit.Assert.*;

public class DepthFirstTest {
    Graph<Character> g = new Graph<>();

    @Before
    public void setupGraph() {
        Node<Character> nodeA = g.addNode('A');
        Node<Character> nodeB = g.addNode('B');
        Node<Character> nodeC = g.addNode('C');
        Node<Character> nodeD = g.addNode('D');
        Node<Character> nodeE = g.addNode('E');
        Node<Character> nodeF = g.addNode('F');
        Node<Character> nodeG = g.addNode('G');
        Node<Character> nodeH = g.addNode('H');

        g.addEdge(nodeA, nodeD);
        g.addEdge(nodeA, nodeB);
        g.addEdge(nodeB, nodeD);
        g.addEdge(nodeB, nodeC);
        g.addEdge(nodeC, nodeG);
        g.addEdge(nodeD, nodeF);
        g.addEdge(nodeD, nodeH);
        g.addEdge(nodeD, nodeE);
        g.addEdge(nodeF, nodeH);

    }

    @Test
    public void testDepthFirst() {
        List<Node<Character>> nodes = g.getNodes();
        List<Node> result = depthFirst(g);
        int[] order = {0, 1, 2, 6, 3, 4, 7, 5};

        assertEquals("The returned list should have as many nodes as are in the graph", nodes.size(), result.size());
        for (Node node : nodes) {
            assertTrue("The result should contain every node in the graph", result.contains(node));
        }
        for (int i =0; i < order.length; i++) {
            assertEquals("The Nodes should come back in a depth-first preordered list", nodes.get(order[i]), result.get(i));
        }


    }
}