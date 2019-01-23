package quicksort;

import stacksandqueues.Stack;

public class QuickSort {

    // Method to be called, simply takes the array, calls pivot on it once, then uses the helper
    public static void quickSort(int[] nums) {
        int pivotIdx = pivot(nums, 0, nums.length -1);
        quickSortHelper(nums, 0, pivotIdx - 1);
        quickSortHelper(nums, pivotIdx + 1, nums.length - 1);

    }

    //Helper for the quickSort method. Takes in the original array, and what indexes within that array to work with
    //Will pivot the entire sub-array if it has more than 1 value, and then break it up again
    static void quickSortHelper(int[] nums, int start, int end) {
        if (end - start < 1) {
            return;
        } else {
            int pivotIdx = pivot(nums, start, end);
            quickSortHelper(nums, start, pivotIdx - 1);
            quickSortHelper(nums, pivotIdx + 1, end);
        }
    }

    //Takes in the entire array, and what indexes to perform the pivoting on. The pivot value is always the element at start
    //Will sort numbers into stacks based on if they are lower or higher, and then re-arrange the array in that range
    //Returns the index that the pivot value was placed at
    static int pivot(int[] nums, int start, int end) {
        int pivot = nums[start];
        int pivotIdx = start;
        Stack<Integer> lows = new Stack<>();
        Stack<Integer> highs = new Stack<>();

        for (int i = start + 1; i <= end; i++) {
            if (pivot > nums[i]) {
                lows.push(nums[i]);
            } else {
                highs.push(nums[i]);
            }
        }

        for (int i = start; i < end; i++) {
            if (lows.peek() != null) {
                nums[i] = lows.pop();
                pivotIdx++;
            } else {
                nums[i + 1] = highs.pop();
            }
        }
        nums[pivotIdx] = pivot;
        return pivotIdx;
    }
}
