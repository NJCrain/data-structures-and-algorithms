package quicksort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static quicksort.QuickSort.quickSort;

class QuickSortTest {

    @Test
    void testQuickSort() {
        int[] unsorted = {3, 4, 2, 1};
        int[] sorted = {1, 2, 3, 4};
        quickSort(unsorted);

        assertArrayEquals(sorted, unsorted);
    }

    @Test
    void testQuickSort_BigArray() {
        Random r = new Random();
        int[] unsorted = new int[1000];

        for (int i = 0; i < unsorted.length; i ++) {
            unsorted[i] = r.nextInt();
        }

        quickSort(unsorted);

        for (int i = 1; i < unsorted.length - 1; i++) {
            assertTrue(unsorted[i] >= unsorted[i - 1] && unsorted[i] <= unsorted[i + 1], "All values should be greater than the one before it, and less than the one after it");
        }
    }

}