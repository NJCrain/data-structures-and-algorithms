package linkedlists;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
    public void testAppend() {
        test.insert(1);
        test.append(2);

        assertTrue("Should now contain the value in the linked list", test.includes(2));
        assertEquals("The added value should come after the head in this case", 2, test.head.next.value);

        test.append(3);
        test.print();
        assertEquals("The list should now contain 1 2 3 in order", "<1, 2, 3>\n", outContent.toString());
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

        test.insertAfter(4, 5);
        assertTrue("should have no issue adding another value after adding one", test.includes(5));
    }

    @Test
    public void testFindKFromEnd() {
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

        assertEquals("Searching for the value 1 from the end should return 1", 1, test.findKFromEnd(1));
        assertEquals("Should give the last value if 0 is entered", 0, test.findKFromEnd(0));
        assertEquals("Should also be able to give the value farthest away from the end", 9, test.findKFromEnd(9));
    }

    //information for this test found at https://github.com/junit-team/junit4/wiki/exception-testing
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testExceptionFindKFromEnd() throws IndexOutOfBoundsException {
            test.insert(0);
            test.insert(1);
            test.insert(2);
            test.insert(3);

            thrown.expect(IndexOutOfBoundsException.class);
            test.findKFromEnd(12);
    }

    @Test
    public void testMergeList() {
        LinkedList test2 = new LinkedList();
        test.insert(0);
        test2.insert(1);
        test.insert(2);
        test2.insert(3);
        test.insert(4);
        test2.insert(5);
        test.insert(6);
        test2.insert(7);
        test.insert(8);
        test2.insert(9);

        assertEquals("Should merge the 2nd list into the first and return the head",test.head, LinkedList.mergeLists(test, test2));

        //test should now include various values from both lists
        assertTrue(test.includes(0));
        assertTrue(test.includes(9));
        assertTrue(test.includes(1));
        assertTrue(test.includes(8));

        test.print();
        assertEquals("Printing test should match an alternation of the Nodes from each list now", "<8, 9, 6, 7, 4, 5, 2, 3, 0, 1>\n", outContent.toString());
    }

    @Test
    public void testMergeListFirstIsShorter() {
        LinkedList test2 = new LinkedList();
        test.insert(0);
        test2.insert(1);
        test.insert(2);
        test2.insert(3);
        test.insert(4);
        test2.insert(5);
        test2.insert(7);
        test2.insert(9);

        assertEquals("Should merge the 2nd list into the first and return the head",test.head, LinkedList.mergeLists(test, test2));

        //test should now include various values from both lists
        assertTrue(test.includes(0));
        assertTrue(test.includes(9));
        assertTrue(test.includes(1));
        assertTrue(test.includes(4));

        test.print();
        assertEquals("The output should be alternations until the end of list 1, then just the 2nd lists values", "<4, 9, 2, 7, 0, 5, 3, 1>\n", outContent.toString());
    }

    @Test
    public void testMergeListNullListFirst() {
        LinkedList test2 = new LinkedList();
        test2.insert(1);
        test2.insert(3);
        test2.insert(5);
        test2.insert(7);
        test2.insert(9);

        assertEquals("The head should be the head of the second list if list one is empty", test2.head, LinkedList.mergeLists(test, test2));
    }

    @Test
    public void testMergeListNullListSecond() {
        LinkedList test2 = new LinkedList();
        test2.insert(1);
        test2.insert(3);
        test2.insert(5);
        test2.insert(7);
        test2.insert(9);

        assertEquals("The head should be the head of the first list if list two is empty", test2.head, LinkedList.mergeLists(test2, test));
    }

    @Test
    public void testMergeListTwoNullLists() {
        LinkedList test2 = new LinkedList();

        assertNull("Should give back a null value if both lists are empty",LinkedList.mergeLists(test, test2));
    }
}