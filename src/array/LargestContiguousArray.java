package array;

public class LargestContiguousArray {
    public static void main(String[] args) {
        bruteForceSolution();
        optimalSolution();
    }

    private static void optimalSolution() {
        //with time complexity O(n)..  using DP.
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int prev = -1;
        int[] arrB = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                prev = arr[0];
                arrB[0] = arr[0];
            } else {
                prev = Math.max(arr[i], arr[i] + prev);
                arrB[i] = prev;
            }
        }
        //Get max. in array..
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < arrB.length; j++) {
            if (arrB[j] >  max) {
                max = arrB[j];
            }
        }
        //print output.
        System.out.println(max);
    }

    private static void bruteForceSolution() {
        //with time complexity O(n2)..
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int output = -1;
        for (int i = 0; i < arr.length; i++) {
            int res = arr[i];
            int sum = 0;
            for (int j = i + 1; j < arr.length; j++) {
                sum = res + arr[j];
                if (sum >= output) {
                    output = sum;
                }
                res = sum;
            }
        }
        System.out.println(output);
    }
}
