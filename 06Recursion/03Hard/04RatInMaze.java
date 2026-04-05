import java.util.*;

class Solution {
    public ArrayList<String> ratInMazeI(int[][] maze) {
        ArrayList<String> tracks = new ArrayList<>();
        int n = maze.length;

        if (maze[0][0] == 1) {
            boolean[][] visited = new boolean[n][n];
            backtracking(maze, 0, 0, "", tracks, n, visited);
        }

        return tracks;
    }

    private void backtracking(int[][] maze, int r, int c, String path,
            ArrayList<String> tracks, int n, boolean[][] visited) {

        // Base case
        if (r == n - 1 && c == n - 1) {
            tracks.add(path);
            return;
        }

        // Mark visited
        visited[r][c] = true;

        // Down
        if (r + 1 < n && maze[r + 1][c] == 1 && !visited[r + 1][c]) {
            backtracking(maze, r + 1, c, path + "D", tracks, n, visited);
        }

        // Left
        if (c - 1 >= 0 && maze[r][c - 1] == 1 && !visited[r][c - 1]) {
            backtracking(maze, r, c - 1, path + "L", tracks, n, visited);
        }

        // Right
        if (c + 1 < n && maze[r][c + 1] == 1 && !visited[r][c + 1]) {
            backtracking(maze, r, c + 1, path + "R", tracks, n, visited);
        }

        // Up
        if (r - 1 >= 0 && maze[r - 1][c] == 1 && !visited[r - 1][c]) {
            backtracking(maze, r - 1, c, path + "U", tracks, n, visited);
        }

        // Backtrack
        visited[r][c] = false;
    }

    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> res = new ArrayList<>();
        int n = maze.length;

        if (maze[0][0] == 0)
            return res;

        boolean[][] visited = new boolean[n][n];
        solve(0, 0, maze, n, "", res, visited);

        return res;
    }

    private void solve(int r, int c, int[][] maze, int n, String path,
            ArrayList<String> res, boolean[][] visited) {

        // Destination reached
        if (r == n - 1 && c == n - 1) {
            res.add(path);
            return;
        }

        visited[r][c] = true;

        // Direction arrays (D, L, R, U) → lexicographically sorted output
        int[] dr = { 1, 0, 0, -1 };
        int[] dc = { 0, -1, 1, 0 };
        char[] move = { 'D', 'L', 'R', 'U' };

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 && nr < n && nc < n &&
                    maze[nr][nc] == 1 && !visited[nr][nc]) {

                solve(nr, nc, maze, n, path + move[i], res, visited);
            }
        }

        // Backtrack
        visited[r][c] = false;
    }

}