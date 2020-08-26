package backtracking;

public class MazeAllPath {

    public static void main(String[] args) {
        int[][] maze = {{1, 1, 0}, {1, 1, 0}, {0, 1, 1}};
        int n = maze[0].length;
        boolean[][] visited = new boolean[n][n];
        findPath(maze, n, 0, 0, visited);
    }

    static void findPath(int[][] maze, int n, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= n || col < 0 || col >= n) {
            return;
        }

        if (row == n - 1 && col == n - 1) {
            visited[row][col] = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(visited[i][j]+ " ");
                }
                System.out.println();
            }
            System.out.println("------------------------");
            return;
        }

        if (maze[row][col] == 0 || visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        findPath(maze, n, row, col - 1, visited);

        findPath(maze, n, row, col + 1, visited);

        findPath(maze, n, row - 1, col, visited);

        findPath(maze, n, row + 1, col, visited);

        visited[row][col] = false;
    }
}


