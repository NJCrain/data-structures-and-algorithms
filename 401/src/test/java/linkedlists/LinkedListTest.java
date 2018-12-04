package linkedlists;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class LinkedListTest {

    //Stuff to setup testing System.out.println() results for print method
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    //instantiate a test LinkedList to be used throughout the test assertions
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
    public void testIncludesMoreNodes() {
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
        test.print();

        assertEquals("Should print empty angle brackets for an empty list", "<>\n", outContent.toString());
    }

    @Test
    public void testPrintOneNode() {
        test.insert(0);
        test.print();

        assertEquals("Should give a proper formatted list even with just 1 node in the list", "<0>\n", outContent.toString());
    }

    @Test
    public void testPrintMoreNodes() {
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
        test.print();

        assertEquals("Should print the list between angle brackets, each value separated with a comma", "<9, 8, 7, 6, 5, 4, 3, 2, 1, 0>\n", outContent.toString());
    }

    @Test
    public void testInsertBefore() {
        test.insert(3);
        test.insert(2);
        test.insert(1);

        test.insertBefore(3, 4);
        assertTrue("The list should now include the newly added Node somewhere", test.includes(4));

        test.print();
        assertEquals("The new node should appear in the list before 3", "<1, 2, 4, 3>\n", outContent.toString());

        test.insertBefore(1, 0);
        assertTrue("The list should now include the newly added Node somewhere, even if the value to insert before is at the head", test.includes(0));

        test.print();
        assertEquals("The 0 should also end up in the correct location", "<1, 2, 4, 3>\n<0, 1, 2, 4, 3>\n", outContent.toString());

    }

    @Test
    public void testInsertAfter() {
        test.insert(3);
        test.insert(2);
        test.insert(1);

        test.insertAfter(3, 4);
        assertTrue("The list should now contain the value", test.includes(4));

        test.print();
        assertEquals("The list should contain the new value in the correct location", "<1, 2, 3, 4>\n", outContent.toString());
    }
}