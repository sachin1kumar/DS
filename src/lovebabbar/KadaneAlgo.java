package lovebabbar;

public class KadaneAlgo {

    public static void main(String[] args) {
        //Given an integer array, find a contiguous subarray within it that has the largest sum.
        //Maximum Sum Subarray Problem (Kadane’s Algorithm)
        //int[] A = {-8, -3, -6, -2, -5, -4}; //-2
        int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };//6
        System.out.println(kadaneNeg(A));
    }

    private static int kadaneNeg(int[] A) {
        // stores the maximum sum subarray found so far
        int maxSoFar = Integer.MIN_VALUE;

        // stores the maximum sum of subarray ending at the current position
        int maxEndingHere = 0;

        // traverse the given array
        for (int index = 0; index < A.length; index++) {
            // update the maximum sum of subarray "ending" at index `i` (by adding the
            // current element to maximum sum ending at previous index)
            maxEndingHere = maxEndingHere + A[index];

            // maximum sum should be more than the current element
            maxEndingHere = Integer.max(maxEndingHere, A[index]);

            // update the result if the current subarray sum is found to be greater
            maxSoFar = Integer.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
