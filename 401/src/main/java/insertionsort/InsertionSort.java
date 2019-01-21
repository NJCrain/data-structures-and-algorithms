package insertionsort;

import java.util.Arrays;

public class InsertionSort {

    //Takes in an array of integers and sorts it lowest to highest via an insertion sort
    public static void insertionSort(int[] array) {

        for (int  i = 1; i < array.length; i++) {
            int j = i -1;
            int temp = array[i];

            while (j >=0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }
}
