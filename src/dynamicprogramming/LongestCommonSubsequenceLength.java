package dynamicprogramming;

public class LongestCommonSubsequenceLength {
    public static void main(String[] args) {
        System.out.println(length("abcde", "ace"));
    }

    private static int length(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] arr = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
                } else if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
                }
            }
        }
        return arr[m][n];
    }
}
