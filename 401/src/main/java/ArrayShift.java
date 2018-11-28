public class ArrayShift {
    public static int[] insertShiftArray(int[] arr, int value) {
        int[] ans = new int[arr.length + 1];
        for (int i = 0; i < arr.length/2; i++) {
            ans[i] = arr[i];
        }
        ans[arr.length/2] = value;
        for (int i = arr.length / 2 + 1; i < ans.length; i++) {
            ans[i] = arr[i-1];
        }
        return ans;
    }
}
