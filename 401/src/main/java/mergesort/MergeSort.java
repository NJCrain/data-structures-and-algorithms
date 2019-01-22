package mergesort;

import java.util.Arrays;

public class MergeSort {

    static int[] mergeSort(int[] nums) {

        if (nums.length < 2) {
            return nums;
        } else {
//            int middle = nums.length % 2 == 0 ?
            return merge(mergeSort(Arrays.copyOfRange(nums, 0, nums.length/2)),
                    mergeSort(Arrays.copyOfRange(nums, nums.length/2, nums.length)));
        }
    }

    static int[] merge(int[] arr1, int[] arr2) {

        int idx1 = 0;
        int idx2 = 0;
        int[] merged = new int[arr1.length + arr2.length];
        for (int i = 0; i < merged.length; i++) {
            if (idx1 < arr1.length && idx2 < arr2.length) {
                if (arr1[idx1] < arr2[idx2]) {
                    merged[i] = arr1[idx1];
                    idx1++;
                } else {
                    merged[i] = arr2[idx2];
                    idx2++;
                }
            } else if (idx1 < arr1.length) {
                merged[i] = arr1[idx1];
                idx1++;
            } else {
                merged[i] = arr2[idx2];
                idx2++;
            }
        }
        return merged;
    }
}
