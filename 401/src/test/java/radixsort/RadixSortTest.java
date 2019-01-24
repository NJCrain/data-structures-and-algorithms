package radixsort;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static radixsort.RadixSort.radixSort;

class RadixSortTest {

    @Test
    void testRadixSort() {
        int[] unsorted = {121, 324, 431, 315};
        int[] sorted = {121, 315, 324, 431};

        radixSort(unsorted);

        assertArrayEquals(sorted, unsorted);
    }

    @Test
    void testRadixSort_OddLength() {
        int[] unsorted = {121, 324, 431, 315, 134};
        int[] sorted = {121, 134, 315, 324, 431};

        radixSort(unsorted);

        assertArrayEquals(sorted, unsorted);
    }

    @Test
    void testRadixSort_BigArray() {
        int[] unsorted = new Random().ints(1000, 1000, 9999).toArray();
        radixSort(unsorted);

        for (int i = 1; i < unsorted.length - 1; i++) {
            assertTrue(unsorted[i] >= unsorted[i - 1] && unsorted[i] <= unsorted[i + 1], "All values should be greater than the one before it, and less than the one after it");
        }
    }

    @Test
    void testRadixSort_BigArrayOddLength() {
        int[] unsorted = new Random().ints(1001, 1000, 9999).toArray();
        radixSort(unsorted);

        for (int i = 1; i < unsorted.length - 1; i++) {
            assertTrue(unsorted[i] >= unsorted[i - 1] && unsorted[i] <= unsorted[i + 1], "All values should be greater than the one before it, and less than the one after it");
        }
    }

}