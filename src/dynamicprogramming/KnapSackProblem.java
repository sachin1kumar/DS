package dynamicprogramming;

import java.util.Arrays;

public class KnapSackProblem {

    public static void main(String[] args) {
        int[] values = {1, 4, 4, 5, 7};
        int[] weights = {1, 2, 3, 4, 5};

        //Sort values and weights..
        Arrays.sort(values);
        Arrays.sort(weights);

        //Sum of weights..
        int N = 9;

        //Sum of weights array..
        int[] sow = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            sow[i] = i;
        }

        System.out.println(getResult(values, weights, sow));
    }

    private static int getResult(int[] values, int[] weights, int[] sow) {
        int rowLength = weights.length;
        int colLength = sow.length;

        int[][] arr = new int[rowLength][colLength];

        //memoization matrix...
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (j == 0) {
                    arr[i][j] = 0;
                } else if (i == 0 && j != 0) {
                    arr[i][j] = 1;
                } else if (weights[i] > sow[j]) {
                    arr[i][j] = arr[i - 1][j];
                } else if (weights[i] <= sow[j]) {
                    int res = Math.max(arr[i - 1][j], values[i] + arr[i - 1][sow[j] - weights[i]]);
                    arr[i][j] = res;
                }
            }
        }
        return arr[rowLength - 1][colLength - 1];
    }
}
