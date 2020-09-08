package dynamicprogramming;

public class LongestPathMatrix {

    public static void main(String[] args) {
        System.out.println(findLongest());
    }

    private static int findLongest() {
        int[][] matrix = {{1, 2, 9}, {5, 3, 8}, {4, 6, 7}};

        if (matrix.length == 0) return 0;

        int max = 0;

        //memoization matrix to improve time complexity so that dfs will not be called repeatedly.
        int[][] dp = new int[matrix.length][matrix[0].length];
        //Iterate each individual element so that dfs will be called for each element in matrix.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //call only when dp contains element 0..
                //starting from 0,0 so taking prev element MIN..
                if (dp[i][j] == 0) {
                    int res = dfs(matrix, i, j, Integer.MIN_VALUE, dp);
                    max = Math.max(max, res);
                }
            }
        }
        return max;
    }

    private static int dfs(int[][] matrix, int i, int j, int prev, int[][] dp) {
        if (i < 0 || j < 0 || j > matrix[0].length - 1 || i > matrix.length - 1) {
            return 0;
        }
        if (prev >= matrix[i][j]) {
            //bcoz we are interested in increasing path..
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int count4 = dfs(matrix, i + 1, j, matrix[i][j], dp);
        int count3 = dfs(matrix, i - 1, j, matrix[i][j], dp);
        int count2 = dfs(matrix, i, j + 1, matrix[i][j], dp);
        int count1 = dfs(matrix,  i, j - 1, matrix[i][j], dp);

        int max1 = Math.max(count1, count2);
        int max2 = Math.max(count3, count4);

        dp[i][j] = Math.max(max1, max2) + 1;

        return dp[i][j];
    }
}
