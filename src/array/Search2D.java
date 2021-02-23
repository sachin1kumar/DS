package array;

import java.util.ArrayList;

public class Search2D {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int search = 60;

        System.out.println(isExist(matrix, search));
    }

    private static boolean isExist(int[][] matrix, int search) {
        ArrayList<Integer> list = new ArrayList<>();
        int s = -1;

        for (int index = 0; index < matrix.length; index++) {
            int element = matrix[index][0];
            if (search == element) {
                return true;
            }
            list.add(element);
        }

        for (int index = 0; index < list.size() - 1; index++) {
            if (search > list.get(index) && search < list.get(index + 1)) {
                s = index;
                if (checkHorizontally(matrix, search, matrix[s])) return true;
            }
            if (search > list.get(index) && search > list.get(index + 1)) {
                s = index + 1;
                if (checkHorizontally(matrix, search, matrix[s])) return true;
            }
        }
        return false;
    }

    private static boolean checkHorizontally(int[][] matrix, int search, int[] matrix1) {
        for (int index2 = 1; index2 < matrix[0].length; index2++) {
            if (matrix1[index2] == search) {
                return true;
            }
        }
        return false;
    }
}
