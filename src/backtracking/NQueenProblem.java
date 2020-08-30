package backtracking;

public class NQueenProblem {
    public static void main(String[] args) {
        //4 x 4 board
        int[][] board = new int[4][4];
        //here 0 is the starting row index..
        System.out.println(isNQueenValid(board, 0, 4));
    }

    private static boolean isNQueenValid(int[][] board, int row, int totalCols) {
        //base case
        if (row == totalCols) {
            //print board
            for (int i = 0; i < totalCols; i++) {
                for (int j = 0; j < totalCols; j++) {
                    if (board[i][j] == 1) {
                        System.out.print("Q ");
                    } else {
                        System.out.print("_ ");
                    }
                }
                System.out.println();
            }
            //to print all valid combination just return false...
            return true;
        }

        //Iterate over cols..
        for (int i = 0; i < totalCols; i++) {
            //Check if the place is safe to keep Queen at position i,j..
            if(isSafePlace(board, row, i, totalCols)) {
                board[row][i] = 1;
                //Call recursion on the next row and see if we our decision was correct. If yes return true...
                if (isNQueenValid(board, row + 1, totalCols)) {
                    return true;
                }
                //else backtrack and the remove the queen from the last row..
                board[row][i] = 0;
            }
        }
        return false;
    }

    private static boolean isSafePlace(int[][] board, int row, int col, int totalCols) {
        //Check upper vertical column wise..
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        //Check for left diagonal..
        int x = row;
        int y = col;
        while (x >= 0 && y >= 0) {
            if (board[x][y] == 1) {
                return false;
            }
            x--;
            y--;
        }

        x = row;
        y = col;

        //check for right diagonal..
        while (x >= 0 && y < totalCols) {
            if (board[x][y] == 1) {
                return false;
            }
            x--;
            y++;
        }
        return true;
    }
}
