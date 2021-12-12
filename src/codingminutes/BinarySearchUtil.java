package codingminutes;

public class BinarySearchUtil {

    public static int getElementIndex(int[] arr, int start, int end, int element) {
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == element) {
                return mid;
            } else if (element > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
