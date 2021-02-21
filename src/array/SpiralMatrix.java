package array;

public class SpiralMatrix {

    public static void main(String[] args) {

        int input[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        //int input[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};

        int l = 0, m = 0, max_col = input[0].length - 1, max_row = input[0].length - 1;

        for (int i = 0; i <= max_col; i++) {
            System.out.print(input[l][i]+" ");
        }
        l++;

        for (int i = l; i <= max_col; i++) {
            System.out.print(input[i][max_col]+" ");
        }
        max_col--;

        for (int i= max_col; i >= 0; i--) {
            System.out.print(input[max_row][i]+" ");
        }

        for (int i = max_row - 1; i >= l; i--) {
            System.out.print(input[i][m]+" ");
        }
        m++;
        max_row--;

        for (int i = m; i <= max_col; i++) {
            System.out.print(input[m][i]+" ");
        }
        m++;
        max_row--;

        for (int i = max_col; i >= max_row; i--) {
            System.out.print(input[m][i]+" ");
        }
    }
}
