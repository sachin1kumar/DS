package dynamicprogramming;

public class MinEditDistance {

    public static void main(String[] args) {
        System.out.println(getDistance("cat", "cute"));
    }

    private static int getDistance(String str1, String str2) {
        StringBuffer stringBuffer1 = new StringBuffer(str1);
        StringBuffer stringBuffer2 = new StringBuffer(str2);
        stringBuffer1.setCharAt(0,' ');
        stringBuffer2.setCharAt(0,' ');

        int len1 = stringBuffer1.toString().length();
        int len2 = stringBuffer2.toString().length();

        int[][] arr = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1 + 1; i++) {
            for (int j = 0; j < len2 + 1; j++) {
                if (i == 0 && j == 0) {
                    arr[i][j] = 0;
                } else if (i == 0) {
                    arr[i][j] = arr[i][j - 1] + 1;
                } else if (j == 0) {
                    arr[i][j] = arr[i - 1][j] + 1;
                } else {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        arr[i][j] = arr[i - 1][j - 1];
                    } else {
                        arr[i][j] = Math.min(arr[i][j -1], Math.min(arr[i - 1][j - 1], arr[i - 1][j])) + 1;
                    }
                }
            }
        }
        return arr[len1 - 1][len2 - 1];
    }
}
