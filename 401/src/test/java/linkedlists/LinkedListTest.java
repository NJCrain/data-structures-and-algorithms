package linkedlists;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    LinkedList test = new LinkedList();

    @Test
    public void testLinkedList() {

        assertNull("Should create a list with a head value that is null", test.head);

    }

    @Test
    public void testInsert() {

        test.insert(12);
        assertEquals("The value of the head node should now be 12", 12, test.head.value);
        assertNull("The next value of the head should now be null", test.head.next);
        test.insert(8);
        assertEquals("The value of the head node should now be 8", 8, test.head.value);
        assertEquals("The next value after head should be our previous head value of 12", 12, test.head.next.value);
        assertNull("Calling the value at the end should give null", test.head.next.next);

    }

    @Test
    public void testIncludes() {

        assertFalse("includes should return false for a value that is not contained in the linked list", test.includes(10));
        test.insert(12);
        assertTrue("includes should return true for a value that is contained in the linked list", test.includes(12));

    }

    @Test
    public void testIncludesMoreValues() {

        test.insert(0);
        test.insert(1);
        test.insert(2);
        test.insert(3);
        test.insert(4);
        test.insert(5);
        test.insert(6);
        test.insert(7);
        test.insert(8);
        test.insert(9);
        assertTrue("Will return true even in if the value is the first in the list", test.includes(9));
        assertTrue("Will return true even in if the value is the last in the list", test.includes(0));
        assertFalse("should still return false for a value not in the list", test.includes(10));

    }

    @Test
    public void testPrint() {
    }
}