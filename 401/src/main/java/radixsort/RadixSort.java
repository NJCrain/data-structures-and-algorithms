package radixsort;

import java.util.LinkedList;

import static java.lang.Integer.valueOf;

public class RadixSort {
    public static void radixSort(Integer[] nums) {
        int digits = nums[0].toString().length();
        for (int i = 0; i < digits; i++) {
            LinkedList[] llArr = new LinkedList[10];
            for (int j = 0; j < nums.length; j++) {
                int val = valueOf(nums[j].toString().charAt(i));
                llArr[val].add(nums[j]);
            }
            int idx = 0;
            for (LinkedList list : llArr) {
                while (list.peek() != null);
                nums[i] = (Integer) list.remove();
                idx++;
            }
        }
    }
}
