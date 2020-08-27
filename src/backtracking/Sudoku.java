package backtracking;

//This program will check whether the 4 x 4 sudoku can be solved or not...
//in order to make it work for 9 x 9 just replace 4 with 9 in this code...
public class Sudoku {

    public static void main(String[] args) {
        //Taking 0 for an empty cell.
        int[][] sudoku = {{1, 3, 0, 4}, {2, 0, 3, 1}, {0, 1, 0, 2}, {4, 0, 1, 0}};
        System.out.println(isSudokuValid(sudoku));
    }

    private static boolean isSudokuValid(int[][] sudoku) {
        //Iterate for an empty cell.
        int n = sudoku[0].length;
        int row = 0;
        int col = 0;
        boolean isEmpty = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sudoku[i][j] == 0) {
                    isEmpty = true;
                    row = i;
                    col = j;
                    break;
                }
            }
            if (isEmpty) {
                break;
            }
        }
        //To handle if all the cells are filled or we have solved the sudoku.
        if (!isEmpty) {
            return true;
        }

        //As we have taken 4 x 4 sudoku so we have num from 1 to 4 to fill in the empty cell.
        for (int num = 1; num <= 4; num++) {
            if (canBePlacedOrNot(sudoku, row, col, num)) {
                sudoku[row][col] = num;
                //Now, check if we have solved the sudoku with this num or not, if yes return true.
                if (isSudokuValid(sudoku)) {
                    return true;
                }
                //If not, reset it with 0.
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    //To check if the num can be placed in the given cell.
    private static boolean canBePlacedOrNot(int[][] sudoku, int row, int col, int num) {
        if (isRowValid(sudoku, row, num)) {
            return true;
        }

        if (isColVaild(sudoku, col, num)) {
            return true;
        }

        if (isBoxValid(sudoku, row, col, num)) {
            return true;
        }
        return false;
    }

    private static boolean isBoxValid(int[][] sudoku, int row, int col, int num) {
        //Here, 2 is the square root of 4 which is current dimension of sudoku.
        //In case of 9 x9, it will be 3.
        //We are iterating within the box.
        int rowStart = row - row % 2;
        int colStart = col - col % 2;
        for (int i = rowStart; i < rowStart + 2; i++) {
            for (int j = colStart; j < colStart + 2; j++) {
                if (sudoku[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isColVaild(int[][] sudoku, int col, int num) {
        int n = sudoku[0].length;
        for (int i = 0; i < n; i++) {
            if(sudoku[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    private static boolean isRowValid(int[][] sudoku, int row, int num) {
        int n = sudoku[0].length;
        for (int i = 0; i < n; i++) {
            if(sudoku[row][i] == num) {
                return false;
            }
        }
        return true;
    }


}


