package quicksort;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static quicksort.QuickSort.pivot;
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
    void testQuickSort_OddLengthArray() {
        int[] unsorted = {3, 4, 2, 1, 0};
        int[] sorted = {0, 1, 2, 3, 4};
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

    @Test
    void testQuickSort_BigArrayOddLength() {
        Random r = new Random();
        int[] unsorted = new int[1001];

        for (int i = 0; i < unsorted.length; i ++) {
            unsorted[i] = r.nextInt();
        }

        quickSort(unsorted);

        for (int i = 1; i < unsorted.length - 1; i++) {
            assertTrue(unsorted[i] >= unsorted[i - 1] && unsorted[i] <= unsorted[i + 1], "All values should be greater than the one before it, and less than the one after it");
        }
    }

    @Test
    void testPivot() {
        int[] noOrder = {3, 4, 1, 2};
        int[] pivotOrder = {2, 1, 3, 4};

        int pivotIdx = pivot(noOrder, 0, noOrder.length - 1);

        assertEquals(2, pivotIdx);
        assertArrayEquals(pivotOrder, noOrder);
    }

    @Test
    void testPivot_OddLength() {
        int[] noOrder = {3, 4, 1, 2, 0};
        int[] pivotOrder = {0, 2, 1, 3, 4};

        int pivotIdx = pivot(noOrder, 0, noOrder.length - 1);

        assertEquals(3, pivotIdx);
        assertArrayEquals(pivotOrder, noOrder);
    }

}