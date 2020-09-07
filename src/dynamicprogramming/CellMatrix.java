package dynamicprogramming;

//total no. of ways to reach a cell in the matrix..
public class CellMatrix {
    public static void main(String[] args) {
        System.out.println(getNoOfWays());
    }

    private static int getNoOfWays() {
        //calculating distance from 0,0 to the last cell.
        int[][] arr = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(i == 0 || j == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
                }
            }
        }
        return arr[3][3];
    }
}
