package codingminutes.util;

import java.util.Arrays;

public class Sort0And1Optimally {

    public static void main(String[] args) {
        final int[] arr = {0, 1, 1, 0, 0, 1};
        System.out.print(Arrays.toString(sortedArray(arr, arr.length)));
    }

    /*
     * use two pointer approach.
     * */
    private static int[] sortedArray(int[] arr, int size) {
        int i = 0;
        int j = size - 1;

        while (i < j) {
            if (arr[i] == 0 && arr[j] == 0) {
                i++;
            } else if (arr[i] == 1 && arr[j] == 1) {
                j--;
            } else if (arr[i] == 0 && arr[j] == 1) {
                i++;
                j--;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return arr;
    }
}
