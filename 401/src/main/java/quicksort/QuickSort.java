package quicksort;

import stacksandqueues.Stack;

public class QuickSort {
    public static void quickSort(int[] nums) {
        int pivotIdx = pivot(nums, 0, nums.length -1);
        quickSortHelper(nums, 0, pivotIdx - 1);
        quickSortHelper(nums, pivotIdx + 1, nums.length - 1);

    }

    static void quickSortHelper(int[] nums, int start, int end) {
        if (end - start < 1) {
            return;
        } else {
            int pivotIdx = pivot(nums, start, end);
            quickSortHelper(nums, start, pivotIdx - 1);
            quickSortHelper(nums, pivotIdx + 1, end);
        }
    }

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
