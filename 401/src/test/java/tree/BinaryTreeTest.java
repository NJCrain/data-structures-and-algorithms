package tree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BinaryTreeTest {
    BinaryTree<Character> test = new BinaryTree<>();

    @Before
    public void createTree() {
        test.root = new Node<Character>('A', new Node<Character>('B', new Node<Character>('D'), new Node<Character>('E')), new Node<Character>('C', new Node<>('F'), null));
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
}