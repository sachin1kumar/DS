package codingminutes.dp;

public class StairCaseProblem {

    public static void main(String[] args) {
        System.out.println(noOfWays(4, 3));
    }

    /*
    * Time complexity - O(n + k)
    * */
    private static int noOfWays(int n, int k) {
        int[] dp = new int[n + 1]; //create array of size n + 1
        dp[0] = 1;
        dp[1] = 1;

        for (int index = 2; index <= k; index++) {
            dp[index] = 2 * dp[index - 1]; //for index <= k
        }
        for (int index = k + 1; index <= n; index++) {
            dp[index] = 2 * dp[index - 1] - dp[index - k - 1]; //for index > k
        }
        return dp[n];
    }
}
