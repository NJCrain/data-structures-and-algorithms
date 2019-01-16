package treeintersection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tree.BinaryTree;
import tree.Node;

import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static treeintersection.TreeIntersection.findCommonValues;

class TreeIntersectionTest {
    BinaryTree<Integer> t1 = new BinaryTree<>();
    BinaryTree<Integer> t2 = new BinaryTree<>();

    @BeforeEach
    void setup() {
        t1.root = new Node<Integer>(1, new Node<>(2, new Node<>(4), new Node<>(5)), new Node<>(3, new Node<>(6), null));
        t2.root = new Node<Integer>(1, new Node<>(3, new Node<>(7), null), new Node<>(5, null, new Node<>(9)));
    }

    @Test
    void testTreeIntersection() {
        Set results = findCommonValues(t1, t2);
        assertEquals(3, results.size(), "There should be 3 common values in the set");
        Iterator iterator = results.iterator();
        assertEquals(1, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(5, iterator.next());
    }
}