import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4};
        Integer[] moreNumbers = {7, 8, 5, 2, 10, 3};
        Integer[] evenMoreNumbers = {5, 15, 12, 11, 2, 9, 3, 6};

        System.out.println("Original: " + Arrays.toString(numbers));
        System.out.println("Reversed:" + Arrays.toString(reverseArray(numbers)));
        System.out.println("Original: " + Arrays.toString(moreNumbers));
        System.out.println("Reversed:" + Arrays.toString(reverseArray(moreNumbers)));
        System.out.println("Original: " + Arrays.toString(evenMoreNumbers));
        System.out.println("Reversed:" + Arrays.toString(reverseArray(evenMoreNumbers)));
    }

    public static Integer[] reverseArray(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                int old = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = old;
            }
        }
        return arr;
    }
}
