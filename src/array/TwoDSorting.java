package array;

import java.util.Arrays;

public class TwoDSorting {
    public static void main(String[] args) {
        int[][] twoDimArr = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
        printSortedTwoDMatrix(twoDimArr);
    }

    private static void printSortedTwoDMatrix(int[][] arr) {
     /*   Mat=[[10,20,30,40],
            [15,25,35,45]
            [27,29,37,48]
            [32,33,39,50]]

        Output:
        10 15 20 25
        27 29 30 32
        33 35 37 39
        40 45 48 50*/

        int n = arr.length;
        int m = arr.length;
        int[] oneDimArr = new int[n*m];
        int counter = 0;

        //O(n2)
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                oneDimArr[counter++] = arr[i][j];
            }
        }

        Arrays.sort(oneDimArr); //O(nlogn)
        counter = 0;

        //O(n2)
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = oneDimArr[counter++];
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}
