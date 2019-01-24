package radixsort;

import java.util.LinkedList;

public class RadixSort {

    //Takes in an array of ints and sorts them with a radix sort algorithm
    public static void radixSort(int[] nums) {
        //assumes all numbers in the input set are of the same length
        int digits = Integer.toString(nums[0]).length();
        int divisor = 1;
        for (int i = 0; i < digits; i++) {
            LinkedList[] llArr = new LinkedList[10];
            if (i > 0) {
                //To look at the correct digit every time, will need increase the divisor by 10 every time after the 1st iteration
                divisor *= 10;
            }
            //loop to sort the numbers by their value at the current digit location (i)
            for (int j = 0; j < nums.length; j++) {
                int val = nums[j] / divisor % 10;
                if (llArr[val] == null) {
                    llArr[val] = new LinkedList();
                }
                llArr[val].add(nums[j]);
            }
            //Take the sorted set, put them back into the array in order of least to highest
            int idx = 0;
            for (LinkedList list : llArr) {
                while (list != null && list.peek() != null) {
                    nums[idx] = (Integer) list.remove();
                    idx++;
                }
            }
        }
    }
}
