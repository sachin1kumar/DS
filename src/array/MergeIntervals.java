package array;

import java.util.ArrayList;

public class MergeIntervals {

    public static void main(String[] args) {

        int[][] intervals = {{1,3}, {2,6}, {8,10} ,{15,18}};
        ArrayList<Integer> list = new ArrayList<>();
        int temp = 0;

        for (int row = 0; row < intervals.length; row++) {
            for (int col = 0; col < intervals[0].length; col++) {
                    if((row == 0 && col == 0) || (row == intervals.length - 1 && col == intervals[0].length - 1)) {
                        list.add(intervals[row][col]);
                    } else {
                        if(temp >= intervals[row][col]) {
                            list.remove(list.size() - 1);
                        } else {
                            list.add(intervals[row][col]);
                        }
                        temp = intervals[row][col];
                    }
            }
        }

        //print list..
        for (int index = 0; index < list.size(); index++) {
            System.out.print(list.get(index)+" ");
        }
        System.out.println();

        //add to new 2d matrix..
        int noOfRows = list.size() / 2;
        int[][] result = new int[noOfRows][2];
        int counter = 0;

        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < 2; col++) {
                result[row][col] = list.get(counter);
                counter++;
            }
        }

        //final output..
        for (int row = 0; row < noOfRows; row++) {
            for (int col = 0; col < 2; col++) {
                System.out.print(result[row][col]+" ");
            }
            System.out.println();
        }

    }
}
