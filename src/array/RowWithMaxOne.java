package array;

public class RowWithMaxOne {

    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}
        };

        int m = 4;
        int globalCount = 0;

        //Check from the reverse side in the row as row is sorted..
        for (int i = m - 1; i >= 0; i--) {
            int count = 0;
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    break;
                }
                if (arr[i][j] == 1) {
                    count++;
                }
            }
            if (count > globalCount) {
                globalCount = count;
            }
        }

        System.out.println(globalCount);
    }
}
