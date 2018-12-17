package tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    BinarySearchTree test = new BinarySearchTree();

    @Before
    public void setupTree() {
        test.root = new Node<>(100, new Node<>(50), new Node<>(200));
    }

    @Test
    public void testAdd() {
        test.add(25);
        test.add(75);
        test.add(200);
        test.add(300);

        assertEquals("The left most node should have a value of 25", 25, test.root.left.left.value);
        assertEquals("The node next to that should have a value of 75", 75, test.root.left.right.value);
        assertEquals("The far right node should have a value of 300", 300, test.root.right.right.value);
        assertEquals("The node before that should have a value of 200", 200, test.root.right.value);
    }

    @Test
    public void testSearch() {
        assertEquals("Searching for 100 should return the root node", test.root, test.search(100));
        assertEquals("Searching for 50 should give the node whose value is 50", 50, (int) test.search(50).value);
        assertNull("Searching for a value not in the tree should give back null", test.search(101));
    }
}