package fizzbuzztree;

import org.junit.Before;
import org.junit.Test;
import tree.BinaryTree;
import tree.Node;

import static org.junit.Assert.*;

public class FizzBuzzTreeTest {
    BinaryTree<Object> test = new BinaryTree<>();

    @Before
    public void createTree() {
        test.root = new Node<>(3, new Node<>(15, new Node<>(4), new Node<>(10)), new Node<>(6));
    }

    @Test
    public void testFizzBuzzTree() {
        FizzBuzzTree.fizzBuzzTree(test);

        assertEquals("The root value should now be fizz", "fizz", test.root.value);
        assertEquals("The value left of the root should now be fizzbuzz", "fizzbuzz", test.root.left.value);
        assertEquals("The value 2 steps left of the root should stay 4", 4, test.root.left.left.value);
        assertEquals("The value right of the fizzbuzz should now be buzz", "buzz", test.root.left.right.value);
        assertEquals("The value right of the root should now be fizz", "fizz", test.root.right.value);
    }


}