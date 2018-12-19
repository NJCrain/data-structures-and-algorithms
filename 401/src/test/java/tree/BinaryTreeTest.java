package tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BinaryTreeTest {
    BinaryTree<Character> test = new BinaryTree<>();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void createTreeAndSetStreams() {
        test.root = new Node<Character>('A', new Node<Character>('B', new Node<Character>('D'), new Node<Character>('E')), new Node<Character>('C', new Node<>('F'), null));
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    @After
    public void resetStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testPreOrder() {
      ArrayList<Node> preOrdered = BinaryTree.preOrder(test.root);

        assertEquals("The list returned should have size of 6", 6, preOrdered.size());
        assertEquals("The first item in the list should be 'A'", 'A', preOrdered.get(0).value);
        assertEquals("The last item in the list should be 'F'", 'F', preOrdered.get(5).value);
        assertEquals("The fourth item in the list should be 'E'", 'E', preOrdered.get(3).value);
    }

    @Test
    public void testInOrder() {
        ArrayList<Node> inOrdered = BinaryTree.inOrder(test.root);

        assertEquals("The list returned should have size of 6", 6, inOrdered.size());
        assertEquals("The first item in the list should be 'D'", 'D', inOrdered.get(0).value);
        assertEquals("The last item in the list should be 'C'", 'C', inOrdered.get(5).value);
        assertEquals("The fourth item in the list should be 'A'", 'A', inOrdered.get(3).value);
    }

    @Test
    public void testPostOrder() {
        ArrayList<Node> postOrdered = BinaryTree.postOrder(test.root);

        assertEquals("The list returned should have size of 6", 6, postOrdered.size());
        assertEquals("The first item in the list should be 'D'", 'D', postOrdered.get(0).value);
        assertEquals("The last item in the list should be 'A'", 'A', postOrdered.get(5).value);
        assertEquals("The fourth item in the list should be 'F'", 'F', postOrdered.get(3).value);
    }

    @Test
    public void testBreadthTraversal() {
        BinaryTree.breadthTraversal(test);

        assertEquals("The out content should match the following pattern", "A\nB\nC\nD\nE\nF\n", outContent.toString());
    }

    @Test
    public void testBreadthTraversalNullTree() {
        BinaryTree<Integer> test2 = new BinaryTree<>();
        BinaryTree.breadthTraversal(test2);

        assertEquals("The out content should remain empty", "", outContent.toString());
    }

    @Test
    public void testBreadthTraversalLargerTree() {
        BinaryTree<Integer> test2 = new BinaryTree<>();
        test2.root = new Node<Integer>(1, new Node<Integer>(2, new Node<Integer>(4, new Node<Integer>(8, null, new Node<Integer>(11)), null), new Node<Integer>(5)), new Node<Integer>(3, new Node<Integer>(6, new Node<>(9), null), new Node<>(7, null, new Node<>(10, new Node<>(12), null))));
        BinaryTree.breadthTraversal(test2);

        assertEquals("1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n12\n", outContent.toString());
    }
}