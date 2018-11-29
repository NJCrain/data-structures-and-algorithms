import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void testBinarySearch() {
        int[] numbers = {3, 4, 5, 6, 7};
        assertEquals("The return value should be the index where 4 is located", 1, BinarySearch.binarySearch(numbers, 4));
    }

    @Test public void testBinarySearchNotFound() {
        int[] numbers = {3, 4, 5, 6, 7};
        assertEquals("Should return -1 if it reaches the last index without finding a match", -1, BinarySearch.binarySearch(numbers, 10));
    }

    @Test public void testBinarySearchLeftSide() {
        int[] numbers = {3, 4, 5, 6, 7};
        assertEquals("Should return a value of 0", 0, BinarySearch.binarySearch(numbers, 3));
    }

    @Test public void testBinarySearchRightSide() {
        int[] numbers = {3, 4, 5, 6, 7};
        assertEquals("Should return a value of the last index possible", 4, BinarySearch.binarySearch(numbers, 7));
    }

    @Test public void testBinarySearchReachZero() {
        int[] numbers = {3, 4, 5, 6, 7};
        assertEquals("Should return -1 if it gets to 0 index without finding a match", -1, BinarySearch.binarySearch(numbers, 2));
    }

    @Test public void testBinarySearchEvenLengthRight() {
        int[] numbers = {3, 4, 5, 6, 7, 8};
        assertEquals("Should work getting an item at the last index with even length arrays", 5, BinarySearch.binarySearch(numbers, 8));
    }

    @Test public void testBinarySearchEvenLengthLeft() {
        int[] numbers = {3, 4, 5, 6, 7, 8};
        assertEquals("Should work getting an item at 0 index with even length arrays", 0, BinarySearch.binarySearch(numbers, 3));
    }

    @Test public void testBinarySearchLeftAndRights() {
        int[] numbers = {3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertEquals("Should also work with moving left then right", 3, BinarySearch.binarySearch(numbers, 6));
    }

    @Test public void testBinarySearchRightsAndLefts() {
        int[] numbers = {3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertEquals("Should also work with moving right then left", 5, BinarySearch.binarySearch(numbers, 8));
    }
}