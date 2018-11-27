import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        int[] moreNumbers = {7, 8, 2, 10, 3};
        int[] evenMoreNumbers = {5, 15, 12, 11, 2, 9, 3, 6};

        System.out.println("Original: " + Arrays.toString(numbers));
        System.out.println("Reversed:" + Arrays.toString(reverseArray(numbers)));
        System.out.println("Original: " + Arrays.toString(moreNumbers));
        System.out.println("Reversed:" + Arrays.toString(reverseArray(moreNumbers)));
        System.out.println("Original: " + Arrays.toString(evenMoreNumbers));
        System.out.println("Reversed:" + Arrays.toString(reverseArray(evenMoreNumbers)));
    }

    public static int[] reverseArray(int[] arr) {
        int j = arr.length -1;
        for (int i = 0; i < Math.floor(arr.length/2); i++) {
            int old = arr[j];
            arr[j] = arr[i];
            arr[i] = old;
            j--;
//            for (int j = arr.length - 1; j > i; j--) {
//                int old = arr[j];
//                arr[j] = arr[j-1];
//                arr[j-1] = old;
//            }
        }
        return arr;
    }
}
