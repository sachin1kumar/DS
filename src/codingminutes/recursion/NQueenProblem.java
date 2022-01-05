package codingminutes.recursion;

public class NQueenProblem {

    public static void main(String[] args) {
        final int input = 4;
        final int[][] board = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };
        solve(board, input, 0);
    }

    private static void printBoard(int[][] board, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean canPlace(int[][] board, int n, int i, int j) {
        //top
        for (int index = i; index >= 0; index--) {
            if (board[index][j] == 1) {
                return false;
            }
        }
        //top left
        int x = i;
        int y = j;
        while (x >= 0 && y >= 0) {
            if (board[x][y] == 1) {
                return false;
            }
            x--;
            y--;
        }
        //top right
        x = i;
        y = j;
        while (x >= 0 && y < n) {
            if (board[x][y] == 1) {
                return false;
            }
            x--;
            y++;
        }
        return true;
    }

    private static boolean solve(int[][] board, int n, int index) {
        if (index == n) {
            printBoard(board, n);
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (canPlace(board, n, index, i)) {
                board[index][i] = 1;
                if (solve(board, n, index + 1)) {
                    return true;
                }
                board[index][i] = 0;
            }
        }
        return false;
    }
}
