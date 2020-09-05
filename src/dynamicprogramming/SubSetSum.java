package dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;

public class SubSetSum {
    public static void main(String[] args) {
        //Change the inputs below as per the requirement..
        int sum = 8;
        int[] set = {1, 2, 5, 7};

        ArrayList<Integer> row = new ArrayList<>();
        row.add(0);

        for (int i = 0; i < set.length; i++) {
            row.add(set[i]);
        }

        //sort the ArrayList which is defined for row.
        Collections.sort(row);

        //Create ArrayList for column..
        ArrayList<Integer> col = new ArrayList<>();

        for (int i = 0; i < sum + 1; i++) {
            col.add(i);
        }

        //Create memoization matrix.
        boolean[][] arr = new boolean[row.size()][col.size()];

        //print output..
        System.out.println(isSumPresent(row, col, arr));
    }

    private static boolean isSumPresent(ArrayList<Integer> row, ArrayList<Integer> col, boolean[][] arr) {
        for (int i = 0; i < row.size(); i++) {
            for (int j = 0; j < col.size(); j++) {
                if (i == 0){
                    if (row.get(i) == col.get(j)) {
                        arr[i][j] = true;
                    } else {
                        arr[i][j] = false;
                    }
                } else if (row.get(i) > col.get(j)) {
                    arr[i][j] = arr[i-1][j];
                } else {
                    int diff = Math.abs(row.get(i) - col.get(j));
                    boolean res = arr[i - 1][j] | arr[i - 1][diff];
                    arr[i][j] = res;
                }
            }
        }
        return arr[row.size() - 1][col.size() - 1];
    }
}
