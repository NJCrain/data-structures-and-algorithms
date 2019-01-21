package insertionsort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static insertionsort.InsertionSort.insertionSort;
import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void testInsertionSort() {
        int[] unsorted = new int[]{4, 3, 1, 8, 5, 7, 2};
        int[] sorted= new int[]{1, 2, 3, 4, 5, 7, 8};

        insertionSort(unsorted);

        for (int i = 0; i < sorted.length; i++) {
            assertEquals(sorted[i], unsorted[i], "The array should be modified in place, sorted lowest to highest");
        }
    }

    @Test
    void testInsertionSort_EmptyArray() {
        int[] unsorted = new int[3];
        int val1 = unsorted[0];
        int val2 = unsorted[1];
        int val3 = unsorted[2];

        insertionSort(unsorted);

        assertEquals(val1, unsorted[0]);
        assertEquals(val2, unsorted[1]);
        assertEquals(val3, unsorted[2]);
    }

    @Test
    void testInsertionSort_AllSameValues() {
        int[] unsorted = new int[]{1, 1, 1, 1, 1, 1, 1};

        insertionSort(unsorted);

        assertEquals(7, unsorted.length);
        for (int i = 0; i < unsorted.length; i++) {
            assertEquals(1, unsorted[i], "All the values should still be 1");
        }

    }

    @Test
    void testInsertionSort_AlreadySorted() {
        int[] sorted = new int[]{1, 2, 3, 4, 5, 7, 8};
        int[] sortedCopy = Arrays.copyOf(sorted, 7);

        insertionSort(sorted);

        for (int i = 0; i < sortedCopy.length; i++) {
            assertEquals(sortedCopy[i], sorted[i], "None of the values should have changed");
        }
    }

    @Test
    void testInsertionSort_BigArray() {
        Random r = new Random();
        int[] unsorted = new int[1000];

        for (int i = 0; i < unsorted.length; i ++) {
            unsorted[i] = r.nextInt();
        }

        insertionSort(unsorted);

        for (int i = 1; i < unsorted.length - 1; i++) {
            assertTrue(unsorted[i] > unsorted[i - 1] && unsorted[i] < unsorted[i + 1], "All values should be greater than the one before it, and less than the one after it");
        }
    }

    @Test
    void testInsertionSort_ReversedToStart() {
        int[] unsorted = new int[]{8, 7, 5, 4, 3, 2, 1};
        int[] sorted= new int[]{1, 2, 3, 4, 5, 7, 8};

        insertionSort(unsorted);

        for (int i = 0; i < sorted.length; i++) {
            assertEquals(sorted[i], unsorted[i], "The array should be modified in place, sorted lowest to highest");
        }
    }

}