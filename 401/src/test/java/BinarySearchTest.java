import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void testBinarySearch() {
        int[] numbers = {3, 4, 5, 6, 7};
        //should return the index of the value searched
        assertEquals("The return value should be 4", 4, BinarySearch.binarySearch(numbers, 7));
    }

    @Test public void testBinarySearchNotFound() {
        int[] numbers = {3, 4, 5, 6, 7};
        assertEquals("Should return a value of -1", -1, BinarySearch.binarySearch(numbers, 10));
    }

    @Test public void testBinarySearchLeftSide() {
        int[] numbers = {3, 4, 5, 6, 7};
        assertEquals("Should return a value of 0", 0, BinarySearch.binarySearch(numbers, 3));
    }

    @Test public void testBinarySearchReachZero() {
        int[] numbers = {3, 4, 5, 6, 7};
        assertEquals("Should return a value of -1", -1, BinarySearch.binarySearch(numbers, 2));
    }

    @Test public void testBinarySearchEvenLengthRight() {
        int[] numbers = {3, 4, 5, 6, 7, 8};
        assertEquals("Should return a value of 5", 5, BinarySearch.binarySearch(numbers, 8));
    }

    @Test public void testBinarySearchEvenLengthLeft() {
        int[] numbers = {3, 4, 5, 6, 7, 8};
        assertEquals("Should return a value of 0", 0, BinarySearch.binarySearch(numbers, 3));
    }
    
}