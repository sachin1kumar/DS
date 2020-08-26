package backtracking;

public class Maze {

    public static void main(String[] args) {
        int[][] maze = {{1, 1, 0}, {1, 1, 0}, {0, 1, 1}};
        int n = maze[0].length;
        boolean[][] visited = new boolean[n][n];
        System.out.println(findPath(maze, n, 0, 0, visited));
    }

    static boolean findPath(int[][] maze, int n, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= n || col < 0 || col >= n) {
            return false;
        }

        if (row == n - 1 && col == n-1) {
            return true;
        }

        if (maze[row][col] == 0 || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;

        if (findPath(maze, n, row, col - 1,  visited)) {
            //visited[row][col] = false;
            return true;
        }

        if (findPath(maze, n, row, col + 1,  visited)) {
            //visited[row][col] = false;
            return true;
        }

        if (findPath(maze, n, row - 1, col,  visited)) {
            //visited[row][col] = false;
            return true;
        }

        if (findPath(maze, n, row + 1, col,  visited)) {
            //visited[row][col] = false;
            return true;
        }

        visited[row][col] = false;
        return false;
    }
}
