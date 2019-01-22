package mergesort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static mergesort.MergeSort.mergeSort;
import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void testMergeSort() {
        int[] unsorted = {6, 0, 3, -1};
        int[] sorted = {-1, 0, 3, 6};

        assertArrayEquals(sorted, mergeSort(unsorted));
    }
}