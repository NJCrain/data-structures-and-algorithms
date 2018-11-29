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
}