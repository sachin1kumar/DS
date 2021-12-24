package codingminutes.slidingwindow;

import java.util.Arrays;

public class InversionCount {


    public static void main(String[] args) {
        final int[] input = {0, 5, 2, 3, 1};
        System.out.println(getInversionCount(input, 0, input.length - 1));
        for (int index = 0; index < input.length; index++) {
            System.out.println(input[index]);
        }
    }

    private static int getInversionCount(int[] input, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int firstCount = getInversionCount(input, start, mid);
        int secondCount = getInversionCount(input, mid + 1, end);
        int mergeCount = mergeCount(input, start, end);
        return firstCount + secondCount + mergeCount;
    }

    private static int mergeCount(int[] input, int start, int end) {
        //in input we have two sorted parts separated by mid, let's calculate the mid now.
        int i = start;
        int mid = (start + end) / 2;
        int j = mid + 1;
        //not taking end because it doesn't need to be updated.
        //creating one temp array to store the merged output.
        int k = 0;

        int count = 0;

        int[] output = new int[input.length];

        while (i <= mid && j <= end) {
            if (input[i] < input[j]) {
                output[k++] = input[i];
                i++;
            } else if (input[i] > input[j]) {
                count += (mid - i + 1);
                output[k++] = input[j];
                j++;
            } else {
                output[k++] = input[i];
                output[k++] = input[j];
                i++;
                j++;
            }
        }

        while (i <= mid) {
            output[k++] = input[i];
            i++;
        }

        while (j <= end) {
            output[k++] = input[j];
            j++;
        }

        int m = 0;
        for (int index = start; index <= end; index++) {
            input[index] = output[m++];
        }
        return count;
    }
}
