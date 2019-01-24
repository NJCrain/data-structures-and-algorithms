package radixsort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

}