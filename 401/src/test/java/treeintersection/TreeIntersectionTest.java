package treeintersection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tree.BinaryTree;
import tree.Node;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static treeintersection.TreeIntersection.findCommonValues;

class TreeIntersectionTest {
    BinaryTree<Integer> t1 = new BinaryTree<>();
    BinaryTree<Integer> t2 = new BinaryTree<>();
    BinaryTree<Integer> t3 = new BinaryTree<>();

    @BeforeEach
    void setup() {
        t1.root = new Node<>(1, new Node<>(2, new Node<>(4), new Node<>(5)), new Node<>(3, new Node<>(6), null));
        t2.root = new Node<>(1, new Node<>(3, new Node<>(7), null), new Node<>(5, null, new Node<>(9)));
        t3.root = new Node<>(2, new Node<>(4, new Node<>(8), null), new Node<>(6, null, new Node<>(10)));

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

    @Test
    void testTreeIntersection_NoIntersections() {
        Set results = findCommonValues(t2, t3);
        assertEquals(0, results.size(), "There should be 0 common values in the set");
    }

    @Test
    void  testTreeIntersection_Strings() {
        BinaryTree<String> stringTree1 = new BinaryTree<>();
        BinaryTree<String> stringTree2 = new BinaryTree<>();

        stringTree1.root = new Node<>("one", new Node<>("two", new Node<>("four"), new Node<>("five")), new Node<>("three", new Node<>("six"), null));
        stringTree2.root = new Node<>("one", new Node<>("three", new Node<>("seven"), null), new Node<>("five", null, new Node<>("nine")));

        Set results = findCommonValues(stringTree1, stringTree2);
        assertEquals(3, results.size(), "There should be 3 strings in the results");
        Iterator iterator = results.iterator();
        assertEquals("one", iterator.next());
        assertEquals("five", iterator.next());
        assertEquals("three", iterator.next());
    }

}