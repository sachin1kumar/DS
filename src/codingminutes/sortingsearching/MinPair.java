package codingminutes.sortingsearching;

import java.util.Arrays;

public class MinPair {

    public static void main(String[] args) {
        final int[] firstInput = {-1, 5, 10, 20, 3};
        final int[] secondInput = {26, 134, 135, 15, 17}; // 20 17
        //final int[] secondInput = {-1, 5, 10, 20, 3};
        //final int[] firstInput = {26, 134, 135, 15, 17}; // 17 20
        int diff = Integer.MAX_VALUE;
        int firstPair = -1, secondPair = -1;
        int lowerBound;

        //Sorting secondInput. O(NlogN)
        Arrays.sort(secondInput);

        //Iterate firstInput and pass each element to get lowerbound in O(NlogN)
        for (int index = 0; index < firstInput.length; index++) {
            lowerBound = getLowerBound(secondInput, firstInput[index]);
            int currentDiff = Math.abs(lowerBound - firstInput[index]);
            if (currentDiff < diff) {
                diff = currentDiff;
                firstPair = firstInput[index];
                secondPair = lowerBound;
            }
        }

        System.out.println(firstPair+":"+secondPair);
    }

    private static int getLowerBound(int[] input, int element) {
        int start = 0;
        int end = input.length - 1;
        int lowerBound = -1;
        int diff = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;
            int currentDiff = Math.abs(input[mid] - element);
            if (currentDiff < diff) {
                diff = currentDiff;
                lowerBound = input[mid];
            }
            if (input[mid] == element) {
                return lowerBound;
            } else if (element < input[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return lowerBound;
    }
}
