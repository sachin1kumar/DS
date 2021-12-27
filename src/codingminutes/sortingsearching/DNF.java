package codingminutes.sortingsearching;

import java.util.Arrays;

public class DNF {

    public static void main(String[] args) {
        final int[] input = {1, 1, 2, 0, 0, 1, 2, 2, 1, 0};
        System.out.println(Arrays.toString(dnfSorted(input)));
    }

    private static int[] dnfSorted(int[] input) {
        int low = 0;
        int mid = 0;
        int high = input.length - 1;

        while (mid <= high) {
            if (input[mid] == 0) {
                //swap low and mid
                int temp = input[mid];
                input[mid] = input[low];
                input[low] = temp;

                low++;
                mid++;
            } else if (input[mid] == 1) {
                mid++;
            } else {
                //swap mid and high
                int temp = input[mid];
                input[mid] = input[high];
                input[high] = temp;

                high--;
            }
        }
        return input;
    }
}
