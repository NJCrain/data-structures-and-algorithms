package radixsort;

import java.util.LinkedList;

public class RadixSort {
    public static void radixSort(int[] nums) {
        int digits = Integer.toString(nums[0]).length();
        int divisor = 1;
        for (int i = 0; i < digits; i++) {
            LinkedList[] llArr = new LinkedList[10];
            if (i > 0) {
                divisor *= 10;
            }
            for (int j = 0; j < nums.length; j++) {
                int val = nums[j] / divisor % 10;
                if (llArr[val] == null) {
                    llArr[val] = new LinkedList();
                }
                llArr[val].add(nums[j]);
            }
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
