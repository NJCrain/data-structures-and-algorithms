public class BinarySearch {
    public static int binarySearch(int[] arr, int value) {
        int middle = arr.length/2;
        while (middle >= 0) {
            if (arr[middle] == value) {
                return middle;
            }
            else if (arr[middle] < value) {
                if(middle == arr.length -1) {
                    break;
                }
                else {
                    middle = (middle + arr.length ) / 2;
                }
            }
            else {
                middle = middle / 2;
            }
        }
        return -1;
    }
}
