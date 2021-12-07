package recursion;

public class SortedUnsorted {
    public static void main(String[] args) {
        int[] input = {1, 3, 2, 4};
        System.out.println(isSorted(input, 0));
    }

    private static boolean isSorted(int[] arr, int index) {
        if (index >= arr.length) {
            return true;
        }

        if (arr.length == 1) {
            return true;
        }

        if (index > 0 && arr[index - 1] > arr[index]) {
            return false;
        }

        return isSorted(arr, index + 1);
    }
}
