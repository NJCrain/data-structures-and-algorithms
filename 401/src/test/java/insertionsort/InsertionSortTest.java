package insertionsort;

import org.junit.jupiter.api.Test;

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

}