public class BinarySearch {
    public static int binarySearch(int[] arr, int value) {
        int middle = arr.length/2;
        int rightBound = arr.length;
        while (middle >= 0) {
            if (arr[middle] == value) {
                return middle;
            }
            else if (arr[middle] < value) {
                if(middle == arr.length -1) {
                    break;
                }
                else {
                    middle = (middle + rightBound) / 2;
                }
            }
            else {
                if (middle == 0) {
                    break;
                }
                else {
                    rightBound = middle;
                    middle = middle / 2;
                }
            }
        }
        return -1;
    }
}
