package mergesort;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static mergesort.MergeSort.merge;
import static mergesort.MergeSort.mergeSort;
import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void testMergeSort() {
        int[] unsorted = {6, 0, 3, -1};
        int[] sorted = {-1, 0, 3, 6};

        assertArrayEquals(sorted, mergeSort(unsorted));
    }

    @Test
    void testMergeSort_OddLengthArray() {
        int[] unsorted = {5, 0, 10, 2, 1};
        int[] sorted = {0, 1, 2, 5, 10};

        assertArrayEquals(sorted, mergeSort(unsorted));
    }

    @Test
    void testMergeSort_BigArray() {
        Random r = new Random();
        int[] unsorted = new int[1000];

        for (int i = 0; i < unsorted.length; i ++) {
            unsorted[i] = r.nextInt();
        }

        int[] sorted = mergeSort(unsorted);

        for (int i = 1; i < sorted.length - 1; i++) {
            assertTrue(sorted[i] > sorted[i - 1] && sorted[i] < sorted[i + 1], "All values should be greater than the one before it, and less than the one after it");
        }
    }

    @Test
    void testMergeSort_BigArray_OddLength() {
        Random r = new Random();
        int[] unsorted = new int[1001];

        for (int i = 0; i < unsorted.length; i ++) {
            unsorted[i] = r.nextInt();
        }

        int[] sorted = mergeSort(unsorted);

        for (int i = 1; i < sorted.length - 1; i++) {
            assertTrue(sorted[i] > sorted[i - 1] && sorted[i] < sorted[i + 1], "All values should be greater than the one before it, and less than the one after it");
        }
    }

    @Test
    void testMerge() {
        int[] arr1 = {2};
        int[] arr2 = {1};

        int[] expected = {1, 2};

        assertArrayEquals(expected, merge(arr1, arr2));
    }

    @Test
    void testMerge_MoreNumbers() {
        int[] arr1 = {2, 4};
        int[] arr2 = {1, 5};

        int[] expected = {1, 2, 4, 5};

        assertArrayEquals(expected, merge(arr1, arr2));
    }

    @Test
    void testMerge_EvenMoreNumbers() {
        int[] arr1 = {2, 4, 6, 8, 10};
        int[] arr2 = {1, 3, 5, 7, 9, 11};

        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        assertArrayEquals(expected, merge(arr1, arr2));
    }

}