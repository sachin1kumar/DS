package dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;

public class MinPartitionSum {

    //Create memoization matrix.
    private static  boolean[][] arr;

    public static void main(String[] args) {
        //Change the inputs below as per the requirement..
        int[] set = {1, 2, 3, 5, 13};
        System.out.println(minSum(set));
    }

    private static boolean isSumPresent(ArrayList<Integer> row, ArrayList<Integer> col, int sum) {
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
        return arr[row.size() - 1][sum];
    }

    private static int checkForNextTrue(ArrayList<Integer> row, ArrayList<Integer> col) {
        int res = 0;
        boolean isBreak = false;
        for (int i = row.size() - 1; i >= 0 ; i--) {
            for (int j = col.size() - 1; j >= 0; j--) {
                if (arr[i][j]) {
                    res = col.get(j);
                    isBreak = true;
                    break;
                }
            }
            if (isBreak) {
                break;
            }
        }
        return res;
    }

    private static int minSum(int[] set) {
        //calculate total sum..
        int sum = 0;
        for (int i = 0; i < set.length; i++) {
            sum += set[i];
        }

        ArrayList<Integer> row = new ArrayList<>();
        row.add(0);

        for (int i = 0; i < set.length; i++) {
            row.add(set[i]);
        }

        //sort the ArrayList which is defined for row.
        Collections.sort(row);

        //calculate first part sum..
        int firstPartSum =  sum / 2;

        //Create ArrayList for column..
        ArrayList<Integer> col = new ArrayList<>();

        for (int i = 0; i < firstPartSum + 1; i++) {
            col.add(i);
        }

        arr = new boolean[row.size()][col.size()];

        //check firstPartSum existence in memoization matrix using subset sum problem..
        if (!isSumPresent(row, col, firstPartSum)) {
            firstPartSum = checkForNextTrue(row, col);
        }
        //calculate second part sum..
        int secondPartSum = sum - firstPartSum;
        return Math.abs(firstPartSum - secondPartSum);
    }
}
